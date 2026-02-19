package problem.solving.neetcode150.problems.stack.dailytemperatures;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures
{
    public static void main(String[] args)
    {
        int[] temperatures = new int[]{30, 38, 30, 36, 35, 40, 28};
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(temperatures)));
    }

    public int[] dailyTemperatures(int[] temperatures)
    {
        if (temperatures == null) return temperatures;
        else if (temperatures.length == 1) return new int[]{0};

        Stack<Integer[]> cache = new Stack<>();
        Integer[] data;

        for (int i = 0; i < temperatures.length; i++)
        {
            while (! cache.isEmpty() && temperatures[i] > cache.peek()[0])
            {
                int cachedTemperatureIndex = cache.peek()[1];
                temperatures[cachedTemperatureIndex] = i - cachedTemperatureIndex;
                cache.pop();
            }

            data = new Integer[]{temperatures[i], i};
            cache.add(data);
        }

        while (! cache.isEmpty())
        {
            data = cache.pop();
            temperatures[data[1]] = 0;
        }
        temperatures[temperatures.length - 1] = 0;
        return temperatures;
    }
}
