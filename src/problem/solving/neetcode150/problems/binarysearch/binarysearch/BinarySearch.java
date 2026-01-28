package problem.solving.neetcode150.problems.binarysearch.binarysearch;

public class BinarySearch
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{- 1, 0, 5};
        int target = 5;
        System.out.println(new BinarySearch().search(nums, target));
    }

    public int search(int[] nums, int target)
    {

        int searchElementIndex = - 1;

        if (nums.length == 0) return searchElementIndex;
        else if (nums.length == 1)
        {
            if (nums[0] == target) return 0;
            else return searchElementIndex;
        } else if (nums.length == 2)
        {
            if (nums[0] == target) return 0;
            else if (nums[1] == target) return 1;
            else return searchElementIndex;
        }

        int low = 0, high = nums.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;

            if (target == nums[mid])
            {
                searchElementIndex = mid;
                break;
            } else if (target < nums[mid])
            {
                high = mid - 1;
            } else if (target > nums[mid])
            {
                low = mid + 1;
            }
        }
        return searchElementIndex;
    }
}
