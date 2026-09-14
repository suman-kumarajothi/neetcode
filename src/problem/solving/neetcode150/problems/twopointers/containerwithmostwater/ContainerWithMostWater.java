package problem.solving.neetcode150.problems.twopointers.containerwithmostwater;

public class ContainerWithMostWater
{

    public static void main(String[] args)
    {
        int[] testcase1 = new int[]{1,7,2,5,4,7,3,6};
        int[] testcase2= new int[]{1,7,2,5,12,3,500,500,7,8,4,7,3,6};
        System.out.println(new ContainerWithMostWater().maxArea(testcase1));
    }
    public int maxArea(int[] heights)
    {
        int maxArea = 0;
        if (heights == null || heights.length == 0) return maxArea;

        for (int i = 0, j = heights.length - 1; i < j; )
        {
            int containerArea = (j - i) * Math.min(heights[i], heights[j]);
            if (maxArea < containerArea)
            {
                maxArea = containerArea;
            }
            if (heights[i] <= heights[j]) i++;
            else j--;
        }
        return maxArea;
    }
}
