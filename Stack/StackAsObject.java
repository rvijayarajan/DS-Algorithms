public class StackAsObject {
	public static void main(String[] args) {
        	NodeObj<String> node;
        	StackObject<String> stack = new StackObject<String>();
        	stack.push("20"); 
                stack.push("30"); 
                stack.push("10"); 
                stack.push("90"); 
                stack.push("60"); 
                stack.push("50"); 
                stack.push("5"); 

                System.out.println("-------------------------------------");
                node = stack.head;
                while(node != null) {
                        System.out.print(node.data + " ");
                        node = node.next;
                }
                System.out.println();
                System.out.println("-------------------------------------");

                stack.reverse();

                System.out.println("-------------------------------------");
                node = stack.head;
                while(node != null) {
                        System.out.print(node.data + " ");
                        node = node.next;
                }
                System.out.println();
                System.out.println("-------------------------------------");

                stack.sort();

		
                System.out.println("-------------------------------------");
                node = stack.head;
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
                System.out.println();
		System.out.println("-------------------------------------");
	}
}