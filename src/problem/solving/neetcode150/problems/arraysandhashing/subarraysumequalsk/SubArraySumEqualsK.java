package problem.solving.neetcode150.problems.arraysandhashing.subarraysumequalsk;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{2, -1, 1, 2};
        int k = 2;
        System.out.println(new SubArraySumEqualsK().subarraySum(nums, k));
    }
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        int count = 0;
        int sum = 0;

        cache.put(0, 1);
        for(int num: nums)
        {
            sum += num;

            int required = sum - k;
            if(cache.containsKey(required))
            {
               count += cache.get(required);
            }
            cache.put(sum, cache.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
