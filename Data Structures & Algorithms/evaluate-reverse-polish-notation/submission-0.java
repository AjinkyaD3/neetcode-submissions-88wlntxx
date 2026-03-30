class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String c : tokens) {
            
            if (c.equals("+") || c.equals("-") || 
                c.equals("*") || c.equals("/")) {
                
                int op1 = stack.pop();   // second operand
                int op2 = stack.pop();   // first operand
                
                switch (c) {
                    case "+":
                        stack.push(op2 + op1);
                        break;
                    case "-":
                        stack.push(op2 - op1);
                        break;
                    case "*":
                        stack.push(op2 * op1);
                        break;
                    case "/":
                        stack.push(op2 / op1);  // Java truncates toward 0
                        break;
                }
                
            } else {
                // it's a number
                stack.push(Integer.parseInt(c));
            }
        }
        
        return stack.pop();
    }
}