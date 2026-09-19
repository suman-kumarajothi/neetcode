package problem.solving.neetcode150.problems.mathandgeometry.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix
{
    public static void main(String[] args)
    {
        int[][] matrix1 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix2 = new int[][]{{2,5,8},{4,0,-1}};
        System.out.println(new SpiralMatrix().spiralOrder(matrix2));
    }

    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return result;
        }

        int i = 0, j = 0;

        int rowStart = 0, rowEnd = matrix.length;
        int columnStart = 0, columnEnd = matrix[0].length;

        boolean right = true;
        boolean down = false;
        boolean left = false;
        boolean up = false;

        while (rowStart < rowEnd && columnStart < columnEnd)
        {
            result.add(matrix[i][j]);

            if (i == rowStart && j < columnEnd - 1 && right)
            {
                j++;
            } else if (j == columnEnd - 1 && i == rowStart && right)
            {
                rowStart++;
                right = false;
                down = true;
                i++;
            } else if (j == columnEnd - 1 && i < rowEnd - 1 && down)
            {
                i++;
            } else if (i == rowEnd - 1 && j == columnEnd - 1 && down)
            {
                columnEnd--;
                down = false;
                left = true;
                j--;
            } else if (i == rowEnd - 1 && j > columnStart && left)
            {
                j--;
            } else if (j == columnStart && i == rowEnd - 1 && left)
            {
                rowEnd--;
                left = false;
                up = true;
                i--;
            } else if (j == columnStart && i > rowStart && up)
            {
                i--;
            } else if (i == rowStart && j == columnStart && up)
            {
                columnStart++;
                up = false;
                right = true;
                j++;
            }
        }
        return result;
    }
}
