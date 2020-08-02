public class StackAsObject {
	public static void main(String[] args) {
        	NodeObj<String> node;
        	StackObject<String> stack = new StackObject<String>();
        	stack.push("10"); 
                stack.push("20"); 
                stack.push("30"); 

                System.out.println("-------------------------------------");
                node = stack.head;
                while(node != null) {
                        System.out.println(node.data);
                        node = node.next;
                }
                System.out.println("-------------------------------------");

                stack.reverse();

		
                System.out.println("-------------------------------------");
                node = stack.head;
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println("-------------------------------------");
	}
}