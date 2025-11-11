package leetcode;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int space = s.lastIndexOf(" ");
        return s.length() - space - 1;
    }
}