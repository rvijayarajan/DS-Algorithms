import java.util.*;
import java.util.stream.IntStream;

class BFSTest extends AdjacencyMatrix {

	BFSTest(int vertices) {
		super(vertices);
	}

	BFSTest(int vertices, boolean directed) {
		super(vertices, directed);
	}

	BFSTest(int[][] matrix) {
		super(matrix);
	}

	BFSTest(int[][] matrix, boolean directed) {
		super(matrix, directed);
	}
	
	public int[] bfs(int startNode) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] path = new int[this.getMatrix().length];
		int[] visited = new int[this.getMatrix().length];
		for(int i=0; i<path.length;i++) {
			path[i] = -1;
		}
		queue.offer(startNode);
		while(queue.peek() != null) {
			int node = queue.poll();
			if(visited[node] == 0) {
				visited[node]=1;
				Integer[] adjacentNodes = this.getAdjacentVertices(node);
				if(adjacentNodes != null) {
					for(int i=0; i<adjacentNodes.length;i++) {
						queue.offer(adjacentNodes[i]);
						if(adjacentNodes[i]!=startNode) {
							if(path[adjacentNodes[i]] == -1) {
								if(node != startNode) {
									path[adjacentNodes[i]] = this.getWeight(node,adjacentNodes[i]) + path[node];
								} else {
									path[adjacentNodes[i]] = this.getWeight(node,adjacentNodes[i]);
								}	
							}	
						}
					}
				}
			}
		}
		return IntStream.range(0, path.length) 
            .filter(i -> i != startNode) 
            .map(i -> path[i]) 
            .toArray();
	}
}

public class BFS {
	public static void main(String[] args) throws Exception {
		BFSTest matrix = new BFSTest (7);
		matrix.addEdge(0,1,6);
		matrix.addEdge(0,2,6);
		matrix.addEdge(2,3,6);
		matrix.addEdge(1,4,6);
		// matrix.displayGraph();
		int[] result = matrix.bfs(1);
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}
}

