package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        int val = romanToInt("IX");

        System.out.println(val);
    }

    public static int romanToInt(String roman) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // II = 1 + 1
        // IX = if I < X > 10 - 1

        var result = 0;
        for (int i = 0; i < roman.length(); i++) {
            if (i < roman.length() - 1 && map.get(roman.charAt(i)) < map.get(roman.charAt(i + 1))) {
                result -= map.get(roman.charAt(i));
            } else {
                result += map.get(roman.charAt(i));
            }
        }

        return result;
    }

}
