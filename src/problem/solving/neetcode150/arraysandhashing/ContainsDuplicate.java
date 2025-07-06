package problem.solving.neetcode150.arraysandhashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3};
        System.out.println(new ContainsDuplicate().hasDuplicate(nums));
    }

    public boolean hasDuplicate(int[] nums) {

        if (nums == null || nums.length <= 1)
        {
            return false;
        }

        Set<Integer> cache = new HashSet<>();

        for (int num: nums)
        {
            if (cache.contains(num))
            {
                return true;
            }
            else
            {
                cache.add(num);
            }
        }
        return false;
    }
}




