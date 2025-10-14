package interview;

//A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

//Two brackets are considered to be a matched pair if an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

//A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

//By this logic, we say a sequence of brackets is balanced if the following conditions are met:

//It contains no unmatched brackets.
//The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
//Given a strings of brackets, determine whether the sequence of brackets is balanced. If it is balanced, return YES. Otherwise, return NO.

// Example
// Positive results.
// {([])}
// {}[][()]{([])}
// Negative results.
// {{([])}
// {{[[])}}
// {][}
//

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {
        System.out.println(bracketResult("{([])}"));
        System.out.println(bracketResult("{}[][()]{([])}"));
        System.out.println(bracketResult("{(})"));

        System.out.println(bracketResult("{{([])}"));
        System.out.println(bracketResult("{{[[])}}"));
        System.out.println(bracketResult("{][}"));

        /*---------------------------------------------------------*/

        System.out.println(bracketResultWithMap("{([])}"));
        System.out.println(bracketResultWithMap("{}[][()]{([])}"));
        System.out.println(bracketResultWithMap("{(})"));

        System.out.println(bracketResultWithMap("{{([])}"));
        System.out.println(bracketResultWithMap("{{[[])}}"));
        System.out.println(bracketResultWithMap("{][}"));
    }

    public static boolean bracketResult(String bracket) {
        if (bracket == null || bracket.length() % 2 != 0) {
            return false;
        }
        var stack = new Stack<Character>();

        for (char s : bracket.toCharArray()) {
            switch (s) {
                case '{', '(', '[':
                    stack.push(s);
                    break;

                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                default:
            }
        }
        return stack.isEmpty();
    }

    public static boolean bracketResultWithMap(String bracket) {
        var pairs = Map.of(
                '}', '{',
                ')', '(',
                ']', '['
        );
        var stack = new ArrayDeque<Character>();

        for (char s : bracket.toCharArray()) {
            if (pairs.containsValue(s)) {
                stack.push(s);
            } else if (pairs.containsKey(s)) {
                if (stack.isEmpty() || stack.pop() != pairs.get(s)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
