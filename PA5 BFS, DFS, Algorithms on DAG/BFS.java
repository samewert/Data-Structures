package PA5;

import java.util.LinkedList;

public class BFS extends Graph {

	public int level[];

	public BFS(String filePath) throws Exception {
		readUnweightedGraph(filePath);
	}

	private void helpBFS(int s) throws Exception { // complete this method
		LinkedList<Integer> vertexQ = new LinkedList<Integer>();
		vertexQ.addLast(s);
		level[s] = 0;
		while(vertexQ.size() > 0) {
			int v = vertexQ.removeFirst();
			for(int i = 0; i < outDegree[v]; i++) {
				Edge adjEdge = adjList.get(v).get(i);
				int w = adjEdge.dest;
				if(level[w] == Integer.MAX_VALUE) { 
					level[w] = level[v] + 1;
					vertexQ.addLast(w);
				}
			}
		}
	}
    
    public void executeBFS(int s) throws Exception { // complete this method
    	level = new int[numVertices];
    	for(int i = 0; i < level.length; i++) {
    		level[i] = Integer.MAX_VALUE; 
    	}
    	helpBFS(s);
    }

	public int countComponents() throws Exception { // complete this method
		level = new int[numVertices];
		for(int i = 0; i < level.length; i++) {
    		level[i] = Integer.MAX_VALUE; 
    	}
		int counter = 0;
		for(int i = 0; i < numVertices; i++) {
			if(level[i] == Integer.MAX_VALUE) {
				helpBFS(i);
				counter++;
			}
		}
		return counter;
	}
}
