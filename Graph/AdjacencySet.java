import java.util.*;

public class AdjacencySet {

	public Object[] matrix;
	public boolean directed = false;
	public List<Node> nodes;

	AdjacencySet(int vertices) {
		this.matrix = new Object[vertices];
		this.nodes = new ArrayList<Node>(vertices);
		this.initializeMatrix();
	}

	AdjacencySet(int vertices, boolean directed) {
		this.matrix = new Object[vertices];
		this.directed = directed;
		this.nodes = new ArrayList<Node>(vertices);
		this.initializeMatrix();
	}

	private void initializeMatrix() {
		for(int i=0; i< this.matrix.length; i++) {
			this.matrix[i] = new HashSet<Integer>();
			this.nodes.add(new Node(i));
		}
	}

	public void addEdge(int n1, int n2, int weight) {
		if(n1 > -1 && n2 > -1) {
			Node node1 = this.nodes.get(n1);
			Node node2 = this.nodes.get(n2);
			HashSet<Integer> set1 = (HashSet<Integer>)this.matrix[node1.vertex];
			HashSet<Integer> set2 = (HashSet<Integer>)this.matrix[node2.vertex];
			set1.add(node2.vertex);
			node1.adjacentVertices.add(node2.vertex);
			if(!this.directed) {
				set2.add(node1.vertex);
				node2.adjacentVertices.add(node1.vertex);
			}
		}
	} 

	public Integer[] getAdjacentVertices(Node node) {
		return (node != null && node.adjacentVertices.size() > 0) ? (Integer[])node.adjacentVertices.toArray(new Integer[node.adjacentVertices.size()]) : null;
	}

	// public int getInDegree(int vertex) {
	// 	int indegree = 0;
	// 	// i != vertex
	// 	for(int i=0; i<this.matrix.length; i++) {
	// 		if(this.matrix[i][vertex] > 0) {
	// 			indegree++;
	// 		}
	// 	}
	// 	return indegree;
	// }

	// public int getWeight(int vertex1, int vertex2) {
	// 	if(vertex1 > -1 && vertex2 > -1) {
	// 		return this.matrix[vertex1][vertex2];
	// 	}
	// 	return -1;
	// }

	public void displayGraph() {
		for(int i=0; i<this.matrix.length; i++) {
			Integer[] adjacentVertices = this.getAdjacentVertices(this.nodes.get(i));
			if(adjacentVertices != null) {
				for(int j=0; j<adjacentVertices.length;j++) {
					System.out.println(i+" ---> "+adjacentVertices[j]);
				}	
			}
		}
	}
}

// public class AdjacencySet {
// 	public static void main(String[] args) throws Exception {
// 		List<Node> nodes = new ArrayList<Node>();
// 		Node node0 = new Node(0);
// 		Node node1 = new Node(1);
// 		Node node2 = new Node(2);
// 		nodes.add(node0);
// 		nodes.add(node1);
// 		nodes.add(node2);
// 		SetTest set = new SetTest(3, nodes, true);
// 		set.addEdge(node0,node1,1);
// 		set.addEdge(node1,node2,1);
// 		set.displayGraph();
// 	}
// }