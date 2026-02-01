package problem.solving.neetcode150.problems.twopointers.twointegersum2;

import java.util.Arrays;

public class TwoIntegerSum2
{
    public static void main(String[] args)
    {
        int[] numbers = new int[]{1,2,3,4};
        int target = 4;
        System.out.println(Arrays.toString(new TwoIntegerSum2().twoSum(numbers, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length-1;

        while(numbers[low] + numbers[high] != target)
        {
            if(numbers[low] + numbers[high] > target)
            {
                high--;
            }
            else
            {
                low++;
            }
        }
        return new int[]{low+1, high+1};
    }
}
