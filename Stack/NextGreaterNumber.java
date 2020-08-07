public class NextGreaterNumber {
        public static void main(String[] args) {
                int[] numbers = {4,5,2,25};
                printNextGreaterNumber(numbers);
        }

        private static void printNextGreaterNumber(int[] numbers) {
                StackAsLinkedList stack = new StackAsLinkedList();
                for (int i=0; i<numbers.length; i++) {
                        while(!stack.isEmpty() && stack.peek() < numbers[i]) {
                                System.out.println(stack.pop() + "-->" + numbers[i]);
                        }
                        stack.push(numbers[i]);
                }
                while(!stack.isEmpty()) {
                        System.out.println(stack.pop() + "-->" + -1);        
                }
        }
}