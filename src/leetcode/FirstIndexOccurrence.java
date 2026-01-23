package leetcode;

public class FirstIndexOccurrence {

    void main() {
        System.out.println(strStr("asdfasad", "sad"));
        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("abc", "c"));
    }

    public int strStr(String haystack, String needle) {
        int j = needle.length();
        for (int i = 0; j <= haystack.length(); i++) {
            if(haystack.substring(i, j).equals(needle)) {
                return i;
            }
            j++;
        }
        return -1;
    }
}
