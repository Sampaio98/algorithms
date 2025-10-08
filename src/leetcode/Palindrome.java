package leetcode;

public class Palindrome {

    public static void main(String[] args) {
        var isPalindrome = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(isPalindrome);
    }

    private static boolean isPalindrome(String s) {
        var str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase().split("");
        var l = 0;
        var r = str.length - 1;
        while(l < r) {
            if(!str[l].equals(str[r])) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private static String reversedWord(String s) {
        var l = 0;
        var r = s.length() - 1;
        var str = s.split("");
        while (l < r) {
            var tmp = str[l];
            str[l] = str[r];
            str[r] = tmp;
            l++;
            r--;
        }
        StringBuilder builder = new StringBuilder();
        for (String w : str) {
            builder.append(w);
        }
        return builder.toString();
    }
}
