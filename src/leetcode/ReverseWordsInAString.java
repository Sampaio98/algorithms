package leetcode;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverseWordsV2("a good   example"));
        System.out.println(reverseWordsV2("the sky is blue"));
    }

    public static String reverseWords(String s) {
        var words = s.split("\\s+");
        var result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.println(words[i]);
            result.append(words[i]);
            result.append(" ");
        }
        return result.toString().trim();
    }

    public static String reverseWordsV2(String s) {
        var result = new StringBuilder();
        var l = s.length() - 1;
        int r;

        while (l >= 0) {
            while (l >= 0 && s.charAt(l) == ' ') l--;
            r = l;

            while (l >= 0 && s.charAt(l) != ' ') l--;
            result.append(s, l + 1, r + 1).append(" ");
        }
        return result.toString().trim();
    }

}
