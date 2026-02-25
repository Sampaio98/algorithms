package leetcode;

import java.util.LinkedList;

public class RemovingStarsFromString {

    void main() {
        // Input: leet**cod*e
        // Output: lecoe

        IO.println(removeStars("leet**cod*e")); // 45ms on leetcode
        IO.println(removeStarsV2("leet**cod*e")); // 28ms on leetcode
        IO.println(removeStarsV3("leet**cod*e")); // 10ms on leetcode
    }

    public String removeStars(String s) {
        var stack = new LinkedList<Character>();
        var stars = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' && !stack.isEmpty()) {
                stack.pop();
                stars++;
            } else {
                stack.push(s.charAt(i));
            }
        }

        Object[] array = stack.toArray();
        var result = new StringBuilder(stars);
        for (int i = array.length - 1; i >= 0; i--) {
            result.append(array[i]);
        }
        return result.toString();
    }

    public String removeStarsV2(String s) {
        var result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                result.deleteCharAt(result.length() - 1);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public String removeStarsV3(String s) {
        var chars = s.toCharArray();
        var index = -1;
        for (char ch : chars) {
            if (ch != '*') {
                chars[++index] = ch;
            } else if (index != -1) {
                index--;
            }
        }
        return new String(chars, 0, index + 1);
    }
}
