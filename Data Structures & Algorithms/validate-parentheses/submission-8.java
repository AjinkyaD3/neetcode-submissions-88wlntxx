//     class Solution {
//         public boolean isValid(String s) {
//             Deque<Character> stack = new ArrayDeque<>();
// for(char c : s.toCharArray()){
//     if(c == '(' || c == '[' || c == '{'){
//         stack.push(c);
//     } else { // closing
//         if(stack.isEmpty()) return false;

//         char top = stack.peek();
//         if((c == ')' && top != '(') ||
//            (c == ']' && top != '[') ||
//            (c == '}' && top != '{')) {
//             return false;
//         }
//         stack.pop();
//     }
// }
// return stack.isEmpty();
            
//         }
//     }

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        // Map of closing -> opening brackets
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) { // closing bracket
                // If stack empty, or top doesn't match -> false
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            } else { // opening bracket
                stack.push(c);
            }
        }

        return stack.isEmpty(); // all brackets matched
    }
}