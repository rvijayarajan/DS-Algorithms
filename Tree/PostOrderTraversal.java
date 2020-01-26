import java.io.*;
import java.util.*;

public class PostOrderTraversal {
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

		Node root2 = new Node();
		root2.data = 1;
		Node left1 = new Node();
		left1.data = 2;
		Node right1 = new Node();
		right1.data = 3;
		Node left2 = new Node();
		left2.data = 4;
		Node right2 = new Node();
		right2.data = 5;
		Node left3 = new Node();
		left3.data = 6;
		Node right3 = new Node();
		right3.data = 7;
		root2.left = left1;
		root2.right = right1;
		left1.left = left2;
		left1.right = right2;
		right1.left = left3;
		right1.right = right3;
		Stack<Node> preOrderNodes = new Stack<Node>();
		Node nextNode = root2;
		// Node node = root2;
		// Node nextNode = root2;
		// for(;nextNode!=null;node=nextNode) {
		// 	if(nextNode.left !=null && nextNode.right != null) {
		// 		preOrderNodes.push(nextNode);
		// 		preOrderNodes.push(nextNode.right);
		// 		nextNode = nextNode.left;	
		// 	}
		// 	else if (nextNode.left != null) {
		// 		preOrderNodes.push(nextNode);
		// 		nextNode = nextNode.left;	
		// 	}
		// 	else if (nextNode.right != null) {
		// 		preOrderNodes.push(nextNode);
		// 		nextNode = nextNode.right;	
		// 	}
		// 	else {
		// 		System.out.print(nextNode.data+" ");
		// 		nextNode = preOrderNodes.empty() ? null : preOrderNodes.pop();
		// 		node = null;
		// 	}
		// }
	// 	while(nextNode!=null) {
	// 		if(nextNode.left !=null && nextNode.right != null) {
	// 			if(!preOrderNodes.empty() && nextNode == preOrderNodes.peek()) {
	// 				System.out.print(nextNode.data+" ");	
	// 				preOrderNodes.pop();
	// 				nextNode = preOrderNodes.empty() ? null : preOrderNodes.peek();
	// 			} else {
	// 				preOrderNodes.push(nextNode);
	// 				preOrderNodes.push(nextNode.right);
	// 				nextNode = nextNode.left;	
	// 			}
	// 		}
	// 		else if (nextNode.left != null) {
	// 			if(!preOrderNodes.empty() && nextNode == preOrderNodes.peek()) {
	// 				System.out.print(nextNode.data+" ");	
	// 				preOrderNodes.pop();
	// 				nextNode = preOrderNodes.empty() ? null : preOrderNodes.peek();
	// 			} else {
	// 				preOrderNodes.push(nextNode);
	// 				nextNode = nextNode.left;	
	// 			}
	// 		}
	// 		else if (nextNode.right != null) {
	// 			if(!preOrderNodes.empty() && nextNode == preOrderNodes.peek()) {
	// 				System.out.print(nextNode.data+" ");	
	// 				preOrderNodes.pop();
	// 				nextNode = preOrderNodes.empty() ? null : preOrderNodes.peek();
	// 			} else {
	// 				preOrderNodes.push(nextNode);
	// 				nextNode = nextNode.right;	
	// 			}
	// 		} else {
	// 			System.out.print(nextNode.data+" ");
	// 			if(!preOrderNodes.empty() && nextNode == preOrderNodes.peek()) {
	// 				preOrderNodes.pop();
	// 			}
	// 			nextNode = preOrderNodes.empty() ? null : preOrderNodes.peek();
	// 		}
	// 	}
	// }

	while(nextNode!=null) {
			if(nextNode.left !=null && nextNode.right != null) {
				if(!preOrderNodes.empty() && preOrderNodes.peek() == nextNode.right) {
					Node swapNode = preOrderNodes.pop();
					preOrderNodes.push(nextNode);
					nextNode = swapNode;
				} else {
					preOrderNodes.push(nextNode.right);
					preOrderNodes.push(nextNode);
					nextNode = nextNode.left;	
				}
			}
			else if (nextNode.left != null) {
				preOrderNodes.push(nextNode);
				nextNode = nextNode.left;
			}
			else if (nextNode.right != null) {
				preOrderNodes.push(nextNode);
				nextNode = nextNode.right;
			} else {
				System.out.print(nextNode.data+" ");
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