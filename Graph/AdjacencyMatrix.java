import java.util.*;

public class AdjacencyMatrix {

	public int[][] matrix;
	private boolean directed = false;
	public int rowLength = 0;
	public int colLength = 0;

	AdjacencyMatrix(int vertices) {
		this.matrix = new int[vertices][vertices];
		this.rowLength = this.matrix.length;
		this.colLength = this.matrix[0].length;
	}

	AdjacencyMatrix(int vertices, boolean directed) {
		this.matrix = new int[vertices][vertices];
		this.directed = directed;
		this.rowLength = this.matrix.length;
		this.colLength = this.matrix[0].length;
	}

	AdjacencyMatrix(int[][] matrix) {
		this.matrix = matrix;
		this.rowLength = this.matrix.length;
		this.colLength = this.matrix[0].length;
	}

	AdjacencyMatrix(int[][] matrix, boolean directed) {
		this.matrix = matrix;
		this.directed = directed;
		this.rowLength = this.matrix.length;
		this.colLength = this.matrix[0].length;
	}

	public void addEdge(int vertex1, int vertex2, int weight) {
		if(vertex1 > -1 && vertex2 > -1) {
			this.matrix[vertex1][vertex2] = weight > 0 ? weight : 1;
			if(!this.directed) {
				this.matrix[vertex2][vertex1] = weight > 0 ? weight : 1;
			}
		}
	} 

	public Integer[] getAdjacentVertices(int vertex) {
		List<Integer> vertices = new ArrayList<Integer>();
		// i != vertex
		for(int i=0; i<this.matrix.length; i++) {
			if(this.matrix[vertex][i] > 0) {
				vertices.add(i);
			}
		}
		return (Integer[])vertices.toArray(new Integer[vertices.size()]);
	}

	public String[] getAdjacentVertices(int vertex1, int vertex2) {
		List<String> vertices = new ArrayList<String>();
		vertices.add((vertex1-1)+","+(vertex2-1));
		vertices.add((vertex1-1)+","+(vertex2));
		vertices.add((vertex1-1)+","+(vertex2+1));
		vertices.add((vertex1)+","+(vertex2-1));
		vertices.add((vertex1)+","+(vertex2+1));
		vertices.add((vertex1+1)+","+(vertex2-1));
		vertices.add((vertex1+1)+","+(vertex2));
		vertices.add((vertex1+1)+","+(vertex2+1));
		return (String[])vertices.toArray(new String[vertices.size()]);
	}

	public int getInDegree(int vertex) {
		int indegree = 0;
		// i != vertex
		for(int i=0; i<this.matrix.length; i++) {
			if(this.matrix[i][vertex] > 0) {
				indegree++;
			}
		}
		return indegree;
	}

	public int getWeight(int vertex1, int vertex2) {
		if(vertex1 > -1 && vertex2 > -1) {
			return this.matrix[vertex1][vertex2];
		}
		return -1;
	}

	public void displayGraph() {
		for(int i=0; i<this.matrix.length; i++) {
			Integer[] adjacentVertices = this.getAdjacentVertices(i);
			for(int j=0; j<adjacentVertices.length;j++) {
				System.out.println(i+" ---> "+adjacentVertices[j]);
			}
		}
	}

	public void displayMatrix() {
		for(int i=0; i<this.matrix.length; i++) {
			for(int j=0; j<this.matrix[0].length; j++) {
				System.out.print(this.matrix[i][j]+" ");
			}
			System.out.println();
		}	
	}

	public int[][] getMatrix() {
		return this.matrix;
	}
}
