package leetcode.easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        var result = longestCommonPrefix(new String[]{"flower", "flow", "flight"});

        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strings) {
        String result = strings[0]; // flower

        for (int i = 1; i < strings.length; i++) {
            String str = strings[i]; // flow

            while (str.indexOf(result) != 0) {
                // remove result's last ch (flower -> flowe -> flow -> flo -> fl)
                result = result.substring(0, result.length() - 1);
            }
        }

        return result;
    }

}
