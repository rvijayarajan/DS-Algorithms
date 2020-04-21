import java.util.*;
import java.io.*;

class DFSTest extends AdjacencyMatrix {

	private int[] visited;
	private int distance;
	private int shortDistance;
	private int longDistance;
	private Stack<String> pendingCells;

	DFSTest(int vertices) {
		super(vertices);
		this.visited = new int[vertices];
		this.shortDistance = -1;
		this.longDistance = -1;
		this.distance = -1;
		this.pendingCells = new Stack<String>();
	}

	DFSTest(int vertices, boolean directed) {
		super(vertices, directed);
		this.visited = new int[vertices];
		this.shortDistance = -1;
		this.longDistance = -1;
		this.distance = -1;
		this.pendingCells = new Stack<String>();
	}

	DFSTest(int[][] matrix) {
		super(matrix);
		this.visited = new int[matrix.length];
		this.shortDistance = -1;
		this.longDistance = -1;
		this.distance = -1;
		this.pendingCells = new Stack<String>();
	}

	DFSTest(int[][] matrix, boolean directed) {
		super(matrix, directed);
		this.visited = new int[matrix.length];
		this.shortDistance = -1;
		this.longDistance = -1;
		this.distance = -1;
		this.pendingCells = new Stack<String>();
	}

	public int dfs_connectedCells(int v1, int v2) {
		int current = 0;
		if(this.matrix[v1][v2] == 1) {
			this.distance++;
			String[] clearNodes = this.getAdjacentVertices(v1,v2);
			for(String s : clearNodes) {
				int pos = this.pendingCells.indexOf(s);
				if(pos > -1) {
					this.pendingCells.remove(s);
				}
			}
		}
		current = this.matrix[v1][v2];
		this.matrix[v1][v2] = -1;
		String[] adjacentNodes = this.getAdjacentVertices(v1,v2);
		if(adjacentNodes != null) {
			int adjacentNodeLength = 0;
			for(int i=0; i<adjacentNodes.length;i++) {
				String[] arr = adjacentNodes[i].split(",");
				int a1 = Integer.parseInt(arr[0]);
				int a2 = Integer.parseInt(arr[1]);
				if(a1 < this.rowLength && a1 > -1 && a2 < this.colLength && a2 > -1) {
					if(this.matrix[a1][a2] != -1) {
						if(this.matrix[a1][a2] == 1) {
							if(current==1)
								dfs_connectedCells(a1,a2);		
							else 
								this.pendingCells.push(adjacentNodes[i]);		
						} else {
							int pos1 = this.pendingCells.indexOf(adjacentNodes[i]);
							if(pos1 > -1) {
								this.pendingCells.remove(adjacentNodes[i]);
							}
							String[] freeNodes = this.getAdjacentVertices(a1,a2);
							for(String s : freeNodes) {
								if(this.pendingCells.search(s)==-1) {
									String[] arr1 = s.split(",");
									int a3 = Integer.parseInt(arr1[0]);
									int a4 = Integer.parseInt(arr1[1]);
									if(a3 < this.rowLength && a3 > -1 && a4 < this.colLength && a4 > -1 &&
										this.matrix[a3][a4] == 0) {
										this.pendingCells.push(s);	
									}
								}
							}
							this.matrix[a1][a2] = -1;
						}
					}	
				}
			}
		}
		return this.distance;
	}

	public int dfs_cells() {
		this.distance = 0;
		this.pendingCells.add(0+","+0);
		while(pendingCells.size() >0) {
			String cell = pendingCells.pop();
			String[] arr = cell.split(",");
			int a1 = Integer.parseInt(arr[0]);
			int a2 = Integer.parseInt(arr[1]);
			if(a1 < this.rowLength && a1 > -1 && a2 < this.colLength && a2 > -1) {
				int result = dfs_connectedCells(a1,a2);
				this.longDistance = result > this.longDistance ? result : this.longDistance;
				this.distance = 0;
			}
		}
		return this.longDistance;
	}

	public int dfs(int startNode, long[] colors, int val) {
		if(this.visited[startNode]==0) {
			this.visited[startNode] = 1;
			this.distance++;
			if(colors[startNode] == val) {
				if(this.distance > 0) {
					if(this.shortDistance < 0 || this.distance < this.shortDistance) {
						this.shortDistance = this.distance;
					}
					this.distance = 0;
				}
			}
			Integer[] adjacentNodes = this.getAdjacentVertices(startNode);
			if(adjacentNodes != null) {
				for(int i=0; i<adjacentNodes.length;i++) {
					dfs(adjacentNodes[i],colors,val);
				}
			}
		}
		return this.shortDistance;
	}
} 

public class DFS {
	public static void main(String[] args) throws Exception {
		int array[][] = {
			{1,0,0,1,0,1,0,0},
			{0,0,0,0,0,0,0,1},
			{1,0,1,0,1,0,0,0},
			{0,0,0,0,0,0,1,0},
			{1,0,0,1,0,0,0,0},
			{0,0,0,0,0,0,0,1},
			{0,1,0,0,0,1,0,0}
		};
		DFSTest matrix = new DFSTest (array);
		int result = matrix.dfs_cells();
		System.out.println(result);
		matrix.displayMatrix();
	}
}

