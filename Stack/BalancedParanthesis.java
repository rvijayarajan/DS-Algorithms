public class BalancedParanthesis {
        public static void main(String[] args) {
                NodeObj<String> node;
                String[] expressions = {"}][}}(}][))]","[](){()}","()","({}([][]))[]()","{)[](}]}]}))}(())(","([[)"};
                for (int i=0; i< expressions.length; i++) {
                        System.out.println(isParanthesisBalanced(expressions[i]));
                }
        }

        private static boolean isParanthesisBalanced(String expression) {
                String[] expressionArray = expression.split("");
                StackObject<String> stack = new StackObject<String>();
                for (int i=0; i<expressionArray.length; i++) {
                        if(expressionArray[i].equals("(") || 
                                expressionArray[i].equals("{") || 
                                expressionArray[i].equals("[")) {
                                stack.push(expressionArray[i]);
                        } else {
                                String symbol = stack.peek();
                                String current = expressionArray[i];
                                if(stack.isEmpty()) {
                                        return false;
                                }
                                else if(symbol.equals("(") && current.equals(")")) {
                                        stack.pop();
                                } else if(symbol.equals("{") && current.equals("}")) {
                                        stack.pop();
                                } else if(symbol.equals("[") && current.equals("]")) {
                                        stack.pop();
                                } else {
                                        break;
                                }
                        }
                }
                return stack.isEmpty();
        }
}