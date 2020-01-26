import java.io.*;
import java.util.*;

public class PreOrderTraversal {
	public static void main(String[] args) throws IOException {
		Node root = new Node();
		root.data = 1;
		Node row1Right = new Node();
		row1Right.data = 2;
		Node row2Right = new Node();
		row2Right.data = 5;
		Node row3Left  = new Node();
		row3Left.data = 3;
		Node row3Right = new Node();
		row3Right.data = 6;
		Node row4LeftRight = new Node();
		row4LeftRight.data = 4;
		root.right = row1Right;
		row1Right.right = row2Right;
		row2Right.left = row3Left;
		row2Right.right = row3Right;
		row3Left.right = row4LeftRight;
		Stack<Node> preOrderNodes = new Stack<Node>();
		Node nextNode = root;
		while(nextNode!=null) {
			System.out.print(nextNode.data+" ");
			if(nextNode.left !=null && nextNode.right != null) {
				preOrderNodes.push(nextNode.right);
				nextNode = nextNode.left;
			}
			else if (nextNode.left != null) {
				nextNode = nextNode.left;
			}
			else if (nextNode.right != null) {
				nextNode = nextNode.right;
			} else {
				nextNode = preOrderNodes.empty() ? null : preOrderNodes.pop();
			}
		}
	}
}

class Node {
    int data;
    Node left;
    Node right;
}