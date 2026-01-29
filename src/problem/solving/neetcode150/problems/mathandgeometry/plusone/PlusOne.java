package problem.solving.neetcode150.problems.mathandgeometry.plusone;

import java.util.Arrays;

public class PlusOne
{
    public static void main(String[] args)
    {
        int[] digits = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(new PlusOne().plusOne(digits)));
    }

    public int[] plusOne(int[] digits)
    {
        boolean isCarryForward = false;
        for (int i = digits.length - 1; i >= 0; i --)
        {
            int val = digits[i];
            if (isCarryForward || i == digits.length-1)
            {
                val += 1;
                isCarryForward = false;
            }
            if (val > 9)
            {
                digits[i] = 0;
                isCarryForward = true;
            }
            else
            {
                digits[i] = val;
            }
        }
        int[] output = digits;
        if (isCarryForward)
        {
            output = createOutputFromDigits(digits);
            output[0] = 1;
        }

        return output;
    }

    private int[] createOutputFromDigits(int[] digits)
    {
        int[] output = new int[digits.length + 1];
        if (digits.length - 1 >= 0) System.arraycopy(digits, 1, output, 1, digits.length - 1);
        return output;
    }
}
