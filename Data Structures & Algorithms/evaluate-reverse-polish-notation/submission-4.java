class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String c : tokens) {
            switch (c) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int d = stack.pop();
                    int c1 = stack.pop();
                    stack.push(c1 / d);
                    break;
                default:
                    stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}