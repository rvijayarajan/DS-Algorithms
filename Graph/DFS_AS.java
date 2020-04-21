import java.util.*;
import java.io.*;

class DFSASTest extends AdjacencySet {

	private int distance;
	private int shortDistance;

	DFSASTest(int vertices) {
		super(vertices);
		this.shortDistance = -1;
		this.distance = -1;
	}

	DFSASTest(int vertices, boolean directed) {
		super(vertices, directed);
		this.shortDistance = -1;
		this.distance = -1;
	}

	public int dfs(int startNode, long[] colors, int val) {
		if(startNode > -1) {
			Node node = this.nodes.get(startNode);
			if(node !=null && !node.visited) {
				node.visited = true;
				this.distance++;
				if(colors[startNode] == val) {
					if(this.distance > 0) {
						if(this.shortDistance < 0 || this.distance < this.shortDistance) {
							this.shortDistance = this.distance;
						}
						this.distance = 0;
					}
				}
				Integer[] adjacentNodes = this.getAdjacentVertices(node);
				if(adjacentNodes != null) {
					for(int i=0; i<adjacentNodes.length;i++) {
						dfs(adjacentNodes[i],colors,val);
					}
				}
			}	
		}
		return this.shortDistance;
	}
} 

public class DFS_AS {
	public static void main(String[] args) throws Exception {
		long[] colors = new long[4];
		File file1 = new File("D:\\Vijay\\Learnings\\DataStructure\\DS-Algorithms\\Graph\\testFile.txt");
		BufferedReader br1 = new BufferedReader(new FileReader(file1)); 
		  String st1; 
		  int i=0;
		  while ((st1 = br1.readLine()) != null) {
		  	if(st1 != null && st1.trim().length() > 0) {
		  		System.out.println(st1);
			    long idsItem = Long.parseLong(st1.trim());
	            colors[i] = idsItem;
	            i++;	
		  	}
		  }
		
		DFSASTest set = new DFSASTest(4);
		File file = new File("D:\\Vijay\\Learnings\\DataStructure\\DS-Algorithms\\Graph\\input.txt");
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		  String st; 
		  while ((st = br.readLine()) != null) { 
		    String[] s = st.split(" ");
		    if(s.length == 2){	
		    	System.out.println(Integer.parseInt(s[0])+" "+Integer.parseInt(s[1]));
		        set.addEdge(Integer.parseInt(s[0])-1,Integer.parseInt(s[1])-1,1);
		    }
		  } 
		// set.displayGraph();
		int result = set.dfs(1, colors,2);
		System.out.println(result);
	}
}

