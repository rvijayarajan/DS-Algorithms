public class InfixPostfixEvaluation {
	public static void main(String[] args) {
        	Node node;
        	String[] infix = {"5+8*2+3","2+(3*1)-9"};
                for (int i=0; i< infix.length; i++) {
                        System.out.println(convertInfixToPostfix(infix[i]));
                        String postFix = convertInfixToPostfix(infix[i]);
                        System.out.println(postfixEvaluation(postFix));
                }
	}

        private static int postfixEvaluation(String postFixExpression) {
                String[] postfixExp = postFixExpression.split("");
                StackObject<String> stack = new StackObject<String>();
                for (int i=0; i<postfixExp.length; i++) {
                        if(postfixExp[i].matches("[\\d]")) {
                                stack.push(postfixExp[i]);
                        } else {
                                if(Operators.ADD.symbol.equals(postfixExp[i])) {
                                        int num2 = Integer.parseInt(stack.pop());
                                        int num1 = Integer.parseInt(stack.pop());
                                        int num3 = num1+num2;
                                        stack.push(num3+"");
                                } else if(Operators.SUB.symbol.equals(postfixExp[i])) {
                                        int num2 = Integer.parseInt(stack.pop());
                                        int num1 = Integer.parseInt(stack.pop());
                                        int num3 = num1-num2;
                                        stack.push(num3+"");
                                } else if(Operators.MUL.symbol.equals(postfixExp[i])) {
                                        int num2 = Integer.parseInt(stack.pop());
                                        int num1 = Integer.parseInt(stack.pop());
                                        int num3 = num1*num2;
                                        stack.push(num3+"");
                                } else if(Operators.DIV.symbol.equals(postfixExp[i])) {
                                        int num2 = Integer.parseInt(stack.pop());
                                        int num1 = Integer.parseInt(stack.pop());
                                        int num3 = num1/num2;
                                        stack.push(num3+"");
                                } else if(Operators.POW.symbol.equals(postfixExp[i])) {
                                        int num2 = Integer.parseInt(stack.pop());
                                        int num1 = Integer.parseInt(stack.pop());
                                        int num3 = num1^num2;
                                        stack.push(num3+"");
                                }
                        }
                }
                return !stack.isEmpty() ? Integer.parseInt(stack.pop()) : -999999;
        }

        private static String convertInfixToPostfix(String infix) {
                String postFix = "";
                String[] infixExp = infix.split("");
                StackObject<String> stack = new StackObject<String>();
                for (int i=0; i<infixExp.length; i++) {
                        if(infixExp[i].matches("[\\da-z]")) {
                                postFix += infixExp[i];
                        } else if(infixExp[i].equals("(")) {
                                stack.push(infixExp[i]);
                        } else if(infixExp[i].equals(")")) {
                                while(!stack.isEmpty() && !stack.peek().equals("(")) {
                                        postFix += stack.pop();
                                }
                                if(!stack.isEmpty()) {
                                        stack.pop();        
                                }
                        } else {
                                Operators currentOperator = Operators.get(infixExp[i]);
                                while(!stack.isEmpty()) {
                                        Operators peekOperator = Operators.get(stack.peek());
                                        if(peekOperator!=null && currentOperator.priority <= peekOperator.priority) {
                                                postFix += stack.pop();               
                                        } else {
                                                stack.push(infixExp[i]);
                                                break;
                                        }
                                }
                                if(stack.isEmpty()) {
                                        stack.push(infixExp[i]);
                                }
                        }
                }
                while(!stack.isEmpty()) {
                        postFix += stack.pop();
                }
                return postFix;
        }

        enum Operators {
                POW(3, "^"),
                MUL(2, "*"),
                DIV(2, "/"),
                ADD(1, "+"),
                SUB(1, "-");

                public int priority;        
                public String symbol;

                Operators(int priority, String symbol) {
                        this.priority = priority;
                        this.symbol = symbol;
                }

                public static Operators get(String symbol) {
                        for(Operators operator : Operators.values()) {
                                if(operator.symbol.equals(symbol)) {
                                        return operator;
                                }
                        }
                        return null;
                }
        }
}