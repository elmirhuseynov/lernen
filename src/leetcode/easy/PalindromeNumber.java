package leetcode.easy;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
        // 1221
        // 122 1
        // 12 2
        // 1 2
        System.out.println(isPalindromeWithString(1221));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        var original = x;
        var reversed = 0;
        while (x > 0) {
            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }

        return original == reversed;
    }

    public static boolean isPalindromeWithString(int x) {
        if (x < 0) {
            return false;
        }

        String original = String.valueOf(x);

        StringBuilder reversed = new StringBuilder();
        var originalChars = original.toCharArray();
        for (int i = originalChars.length - 1; i >= 0; i--) {
            reversed.append(originalChars[i]);
        }

        return original.equals(reversed.toString());
    }
}
