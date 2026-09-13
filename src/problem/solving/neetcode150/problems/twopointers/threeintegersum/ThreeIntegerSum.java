package problem.solving.neetcode150.problems.twopointers.threeintegersum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeIntegerSum
{
    public static void main(String[] args)
    {
        int[] testcase1 = new int[]{-1,0,1,2,-1,-4};
        int[] testcase2 = new int[]{0,0,0};
        System.out.println(new ThreeIntegerSum().threeSum(testcase1));
    }

    public List<List<Integer>> threeSum(int[] nums)
    {
        Set<String> distinctTripletCache = new HashSet<>();
        Arrays.sort(nums);
        List<List<Integer>> tripletList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++)
        {
            for (int j = i + 1; j < nums.length - 1; j++)
            {
                int searchItem = -(nums[i] + nums[j]);
                int tripletSearchIndex = searchArray(searchItem, j + 1, nums);
                if (tripletSearchIndex != - 1)
                {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[tripletSearchIndex]);

                    Collections.sort(triplet);
                    String tripletCacheKey = triplet.toString();
                    if (!distinctTripletCache.contains(tripletCacheKey))
                    {
                        tripletList.add(triplet);
                        distinctTripletCache.add(tripletCacheKey);
                    }

                }
            }
        }
        return tripletList;
    }

    private int searchArray(int searchItem, int startIndex, int[] nums)
    {
        int low = startIndex;
        int high = nums.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;

            if (searchItem == nums[mid])
            {
                return mid;
            } else if (searchItem < nums[mid])
            {
                high = mid - 1;
            } else if (searchItem > nums[mid])
            {
                low = mid + 1;
            }
        }
        return - 1;
    }
}
