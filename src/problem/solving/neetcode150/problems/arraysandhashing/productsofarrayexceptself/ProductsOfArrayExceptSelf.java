package problem.solving.neetcode150.problems.arraysandhashing.productsofarrayexceptself;


import java.util.Arrays;

public class ProductsOfArrayExceptSelf
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{-1,0,1,2,3};
        //-1,0,1,2,3
        // -1,1,0,-3,3
        int[] output = new ProductsOfArrayExceptSelf().productExceptSelf(nums);

        assert Arrays.equals(nums, output): "Expected " + Arrays.toString(nums) +
                " but got " + Arrays.toString(output);
        System.out.println(Arrays.toString(output));
    }
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroOccurenceCount = 0;
        for (int num: nums)
        {
            if (num != 0)
            {
                product *= num;
            }
            else
            {
                zeroOccurenceCount++;
            }
        }

        int[] output = new int[nums.length];
        for (int i = 0; i < output.length; i++)
        {
            if (nums[i] == 0)
            {
                if (zeroOccurenceCount > 1)
                {
                    output[i] = 0;
                }
                else
                {
                    output[i] = product;
                }
            }
            else
            {
                if (zeroOccurenceCount > 0)
                {
                    output[i] = 0;
                }
                else
                {
                    output[i] = product/nums[i];
                }
            }
        }
        return output;
    }
}
