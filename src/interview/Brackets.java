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

import java.util.ArrayList;

public class Brackets {

    public static void main(String[] args) {
        System.out.println(bracketResult("{([])}"));
        System.out.println(bracketResult("{}[][()]{([])}"));

        System.out.println(bracketResult("{{([])}"));
        System.out.println(bracketResult("{{[[])}}"));
        System.out.println(bracketResult("{][}"));
    }

    public static boolean bracketResult(String bracket) {
        if (bracket == null || bracket.length() % 2 != 0 || bracket.length() < 2) {
            return false;
        }
        var b = bracket.split("");
        var cbIdx = new ArrayList<Integer>();

        var ob = 0;
        var cb = 1;
        var result = false;

        while (ob < bracket.length()) {
            String l = b[ob];
            if (cb >= b.length) {
                ob++;
                continue;
            }
            String r = b[cb];
            if (isClosingBracket(l) && !cbIdx.contains(ob)) {
                return false;
            }
            if (l.equals("{") && r.equals("}") || l.equals("(") && r.equals(")") || l.equals("[") && r.equals("]")) {
                cbIdx.add(cb);
                if (cb - ob == 1) {
                    ob += 2;
                    cb += 2;
                } else {
                    ob++;
                    cb = ob + 1;
                }
                result = true;
            } else {
                cb++;
            }

            if (ob == b.length - 1 && !result) {
                return false;
            }
        }

        return result;
    }

    private static boolean isClosingBracket(String l) {
        return l.equals("}") || l.equals(")") || l.equals("]");
    }


}
