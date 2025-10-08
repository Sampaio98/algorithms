package leetcode;

public class isSubsequence {

    public static void main(String[] args) {
        var isPalindrome = isSubsequence("abc", "ahbgdc");
        System.out.println(isPalindrome);
    }

    private static boolean isSubsequence(String s, String t) {
        var aux = 0;
        for(int i = 0; i < t.length(); i++) {
            if(aux < s.length() && s.charAt(aux) == t.charAt(i)) {
                aux++;
            }
        }
        return s.length() == aux;
    }
}
