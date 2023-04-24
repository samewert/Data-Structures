package PA7;

import java.io.FileNotFoundException;
import java.util.PriorityQueue;

public class Dijkstra extends Graph {

	public int distance[], parent[];
	private boolean closed[];

	public Dijkstra(String filePath) throws FileNotFoundException {
		readWeightedGraph(filePath);
		distance = new int[numVertices];
		parent = new int[numVertices];
		closed = new boolean[numVertices];
	}

	public void executeDijkstra(int source) { // complete this function
		for(int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
			parent[i] = -1;
			closed[i] = false;
		}
		distance[source] = 0;
		PriorityQueue<Element> open = new PriorityQueue<Element>(new ElementComparator());
		open.add(new Element(source, 0));
		while(open.size() != 0) {
			Element minElement = open.remove();
			int minVertex = minElement.item;
			if(!closed[minVertex]) {
				closed[minVertex] = true;
				for(Edge adjEdge: adjList.get(minVertex)) {
					int adjVertex = adjEdge.dest;
					if(!closed[adjVertex]) {
						int newDist = distance[minVertex] + adjEdge.weight;
						if(newDist < distance[adjVertex]) {
							distance[adjVertex] = newDist;
							parent[adjVertex] = minVertex;
							open.add(new Element(adjVertex, newDist));
						}
					}
				}
			}
		}
	}
}
