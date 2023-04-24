package PA5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MutantLanguage extends Graph {

	private String words[];
	private int numWords;
	private int inDegree[];

	public MutantLanguage(String filePath) throws FileNotFoundException {
		readLanguage(filePath);
		makeGraph();
	}

	private void readLanguage(String filePath) throws FileNotFoundException { // complete this method
		Scanner fileReader = new Scanner(new FileInputStream(filePath));
		numVertices = fileReader.nextInt();
		numWords = fileReader.nextInt();
		words = new String[numWords];
		for(int i = 0; i < numWords; i++) {
			words[i] = fileReader.next();
//			words[i] = fileReader.nextLine();
		}
		fileReader.close();
	}

	private void makeGraph() { // complete this method
		outDegree = new int[numVertices];
		inDegree = new int[numVertices];
		adjList = new ArrayList<ArrayList<Edge>>(numVertices);
		for(int i = 0; i < numVertices; i++) {
			outDegree[i] = 0;
			adjList.add(new ArrayList<Edge>());
		}
		for(int i = 0; i < numWords - 1; i++) {
			String currentWord = words[i];
			String nextWord = words[i + 1];
			int minLength = Math.min(currentWord.length(), nextWord.length());
			for(int j = 0; j < minLength; j++) {
				char x = currentWord.charAt(j);
				char y = nextWord.charAt(j);
				if(x != y) {
					int src = x - 97;
					int dest = y - 97;
					Edge e = new Edge(src, dest);
					adjList.get(src).add(e);
//					adjList.get(src).add(new Edge(src, dest));
					outDegree[src]++;
					break;
				}
			}
		}	
	}

	public char[] getOrder() throws Exception { // complete this method
		for(int i = 0; i < numVertices; i++) {
			inDegree[i] = 0;
		}
		char[] topoOrder = new char[numVertices];
		for(int i = 0; i < numVertices; i++) {
			for(int j = 0; j < outDegree[i]; j++) {
				Edge adjEdge = adjList.get(i).get(j);
				inDegree[adjEdge.dest]++;
			}
		}
		LinkedList<Integer> vertexQ = new LinkedList<Integer>();
		int topoLevel = 0;
		for(int i = 0; i < numVertices; i++) {
			if(inDegree[i] == 0) {
				vertexQ.addLast(i);
			}
		}
		while(vertexQ.size() > 0) {
			int v = vertexQ.removeFirst();
			topoOrder[topoLevel] = (char) (v + 97);
			topoLevel++;
			for(int j = 0; j < outDegree[v]; j++) {
				int adjVertex = adjList.get(v).get(j).dest;
				inDegree[adjVertex]--;
				if(inDegree[adjVertex] == 0) {
					vertexQ.addLast(adjVertex);
				}
			}
		}
		if(topoLevel != numVertices) {
			return null;
		}
		return topoOrder;
	}
}
