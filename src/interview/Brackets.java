package interview;

import java.util.ArrayList;

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
    }

    public boolean bracketResult(String brackets) {
        var b = brackets.split("");

        if (b.length % 2 == 0) {
            return false;
        }

        var l = 0;
        var r = b.length - 1;
        var list = new ArrayList<String>();

        while (l < r) {
            if (b[l] == "{" && !list.contains(b[l])) {
                list.add(b[l]);
            }
        }
        return false;
    }

}
