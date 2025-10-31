package leetcode;

import java.util.List;

public class IntegerToRoman {

    public static void main(String[] args) {
//        System.out.println(intToRoman(743));//DCCXLIII
//        System.out.println(intToRoman(3749));//MMMDCCXLIX

        System.out.println(intToRomanV2(743));//DCCXLIII
        System.out.println(intToRomanV2(3749));//MMMDCCXLIX
    }

    public static String intToRomanV2(int num) {
        var values = new int[]{1000, 900, 500, 400, 100, 50, 40, 10, 9, 5, 4, 1};
        var symbols = List.of("M", "CM", "D", "CD", "C", "L", "XL", "X", "IX", "V", "IV", "I");
        var roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols.get(i));
                num -= values[i];
            }
        }

        return roman.toString();
    }

    public static String intToRoman(int num) {
        var length = String.valueOf(num).length();
        var roman = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int r;
            if (num >= 1000) {
                r = (num / 1000) * 1000;
            } else if (num >= 100) {
                r = (num / 100) * 100;
            } else if (num >= 10) {
                r = (num / 10) * 10;
            } else {
                r = num;
            }
            roman.append(getRoman(r));
            num = num - r;
        }
        return roman.toString();
    }

    private static StringBuilder getRoman(int num) {
        var values = new int[]{1000, 500, 100, 50, 10, 5, 1};
        var symbols = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I' };
        int firstDigit = (int) (num / Math.pow(10, (int) Math.log10(num)));
        var word = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            if (num == 0) continue;
            while (num >= values[i]) {
                if (firstDigit == 4) {
                    return word.append(symbols[i]).append(symbols[i - 1]);
                } else if (firstDigit == 9) {
                    return word.append(symbols[i + 1]).append(symbols[i - 1]);
                }
                word.append(symbols[i]);
                num = num - values[i];
            }
        }
        return word;
    }
}
