public class NextGreaterNumber {
        public static void main(String[] args) {
                NodeObj<String> node;
                int[] numbers = {4,5,2,25};
                printNextGreaterNumber(numbers);
        }

        private static void printNextGreaterNumber(int[] numbers) {
                StackAsLinkedList stack = new StackAsLinkedList();
                for (int i=0; i<numbers.length; i++) {
                        int recent = stack.peek();
                        if(numbers[i] > recent) {
                                while(stack.peek() > 0 && stack.peek() < numbers[i]) {
                                        System.out.println(stack.pop() + "-->" + numbers[i]);
                                }
                                stack.push(numbers[i]);
                        } else {
                                stack.push(numbers[i]);
                        }
                }
                while(!stack.isEmpty()) {
                        System.out.println(stack.pop() + "-->" + -1);        
                }
        }
}