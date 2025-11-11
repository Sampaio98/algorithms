package leetcode;

public class FirstIndexOccurence {

    public static void main(String[] args) {
        System.out.println(strStr("asdfasad", "sad"));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
