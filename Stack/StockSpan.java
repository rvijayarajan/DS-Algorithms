public class StockSpan {
        public static void main(String[] args) {
                // int[] prices = {100, 80, 60, 70, 60, 75, 85};
                int[] prices = {10, 4, 5, 90, 120, 80};
                int [] stockSpan = new int[prices.length];
                solveStockSpanProblem(prices,stockSpan);
                for (int i=0; i<stockSpan.length; i++) {
                        System.out.println(stockSpan[i]);
                }
        }

        private static void solveStockSpanProblem(int[] prices, int[] stockSpan) {
                StackAsLinkedList stack = new StackAsLinkedList();
                for (int i=0; i<prices.length; i++) {
                        int j = 1;
                        while(!stack.isEmpty() && prices[stack.peek()] < prices[i]) {
                                j = j + stockSpan[stack.peek()];
                                stack.pop();
                        }
                        stack.push(i);
                        stockSpan[i] = j;
                }
        }
}