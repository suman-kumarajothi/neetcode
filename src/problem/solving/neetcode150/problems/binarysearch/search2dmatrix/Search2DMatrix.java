package problem.solving.neetcode150.problems.binarysearch.search2dmatrix;

public class Search2DMatrix
{
    public static void main(String[] args)
    {
        int[][] matrix = new int[][]{{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}};
        int target = 10;
        System.out.println(new Search2DMatrix().searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target)
    {
        if (matrix == null || matrix.length == 0) return false;
        for (int[] row : matrix)
        {
            int lastElementOfRow = row[row.length - 1];
            if (target == lastElementOfRow) return true;
            else if (target < lastElementOfRow) return (search(row, target) >= 0);
        }
        return false;
    }

    private int search(int[] nums, int target)
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
