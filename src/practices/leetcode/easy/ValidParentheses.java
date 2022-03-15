package practices.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class ValidParentheses {
    static Map<String, String> pairs = new HashMap<>();
    static {
        pairs.put("(", ")");
        pairs.put("[", "]");
        pairs.put("{", "}");
    }

    public boolean isValid(String s) {
        String[] arrS = s.split("");

        Stack<String> stack = new Stack<>();
        for (String str : arrS) {
            if (str.equals("(") || str.equals("[") || str.equals("{")) {
                stack.add(str);
            } else {
                if (stack.isEmpty() || !pairs.get(stack.pop()).equals(str)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
