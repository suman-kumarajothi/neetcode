package problem.solving.neetcode150.problems.bitmanipulation.singlenumber;

public class SingleNumber
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{7,6,6,7,8};
        System.out.println(new SingleNumber().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num: nums)
        {
            result ^= num;
        }
        return result;
    }
}
