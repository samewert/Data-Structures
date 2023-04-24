package PA7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {

	public int numVertices;
	public int numEdges;
	public List<ArrayList<Edge>> adjList;

	public void readWeightedGraph(String filePath) throws FileNotFoundException { // complete this function
		Scanner fileReader = new Scanner(new FileReader(filePath));
		numVertices = fileReader.nextInt();
		adjList = new ArrayList<ArrayList<Edge>>();
		for(int i = 0; i < numVertices; i++) {
			adjList.add(new ArrayList<Edge>());
		}
		while(fileReader.hasNext()) {
			int src = fileReader.nextInt();
			int dest = fileReader.nextInt();
			int weight = fileReader.nextInt();
			Edge e = new Edge(src, dest, weight);
			adjList.get(src).add(e);
		}
		fileReader.close();
	}
}
