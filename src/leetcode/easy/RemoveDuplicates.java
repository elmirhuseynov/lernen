package leetcode.easy;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        int k = rd.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});

        System.out.println(k);
    }

    public int removeDuplicates(int[] nums) {
        int[] newArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (newArr[i] == nums[i]) {
                newArr[i] = '_';
            } else {
                newArr[i] = nums[i];
            }
        }
        System.out.println(Arrays.toString(newArr));

        return 0;
    }

}
