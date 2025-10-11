package interview;

import java.util.HashMap;

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

public class Brackets {

    public static void main(String[] args) {
//        System.out.println(bracketResult("{([])}"));
//        System.out.println(bracketResult("{}[][()]{([])}"));
//
//        System.out.println(bracketResult("{{([])}"));
        System.out.println(bracketResult("{{[[])}}"));
        System.out.println(bracketResult("{][}"));
    }

    public static boolean bracketResult(String brackets) {
        var b = brackets.split("");

        if (b.length % 2 != 0) {
            return false;
        }

        var result = false;

        HashMap<String, Integer> mapOpenBrackets = new HashMap<>();
        for (int i = 0; i < b.length; i++) {
            if (b[i].equals("{") || b[i].equals("(") || b[i].equals("[")) {
                mapOpenBrackets.put(b[i], i);
            }
        }

        for (int i = 0; i < b.length; i++) {
            if (!mapOpenBrackets.containsKey(b[i])) {
                if (b[i].equals("}") && mapOpenBrackets.containsKey("{")) {
                    result = validateBrackets(mapOpenBrackets, "{", i);
                }
                if (b[i].equals(")") && mapOpenBrackets.containsKey("(")) {
                    result = validateBrackets(mapOpenBrackets, "(", i);
                }
                if (b[i].equals("]") && mapOpenBrackets.containsKey("[")) {
                    result = validateBrackets(mapOpenBrackets, "[", i);
                }
            }
        }

        return result;
    }

    private static boolean validateBrackets(HashMap<String, Integer> mapOpenBrackets, String bracket, int i) {
        Integer idx = mapOpenBrackets.get(bracket);
        mapOpenBrackets.remove(bracket);
        return i > idx;
    }

}
