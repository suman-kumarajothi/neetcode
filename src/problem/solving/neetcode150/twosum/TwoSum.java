package problem.solving.neetcode150.twosum;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,6};
        int target = 7;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] resultantIndices = new int[2];

        for (int i = 0; i<nums.length -1; i++)
        {
            for (int j = i+1; j<nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    resultantIndices[0] = i;
                    resultantIndices[1] = j;
                }
            }
        }
        return resultantIndices;
    }
}
