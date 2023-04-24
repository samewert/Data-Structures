package PA5;

public class DFS extends Graph {

	public int level[];
	private boolean closed[];

	public DFS(String filePath) throws Exception {
		readUnweightedGraph(filePath);
	}

	private void helpDFS(int v) { // complete this method; this is the DFS helper function
		closed[v] = true;
		for(int i = 0; i < outDegree[v]; i++) {
			Edge adjEdge = adjList.get(v).get(i);
			int w = adjEdge.dest;
			if(!closed[w]) {
				level[w] = level[v] + 1;
				helpDFS(w);
			}
		}
	}
    
    public void executeDFS(int s) { // complete this method; this is the main DFS function
    	level = new int[numVertices];
    	closed = new boolean[numVertices];
    	for(int i = 0; i < level.length; i++) {
    		closed[i] = false;
    		level[i] = Integer.MAX_VALUE; 
    	}
    	level[s] = 0;
    	helpDFS(s);
    }
    
    public boolean[][] computeTransitiveClosure() { // complete this method
    	boolean[][] M = new boolean[numVertices][];
    	for(int i = 0; i < numVertices; i++) {
    		executeDFS(i);
    		M[i] = closed;
    	}
    	return M;
    }
}
