import java.util.*;

public class Node {
	int vertex = -1;
	List<Integer> adjacentVertices;
	boolean visited = false;

	Node(int vertex) {
		this.adjacentVertices = new ArrayList<Integer>();
		this.vertex = vertex;
	}
}