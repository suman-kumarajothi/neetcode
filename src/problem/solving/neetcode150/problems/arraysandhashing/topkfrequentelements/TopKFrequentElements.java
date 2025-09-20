package problem.solving.neetcode150.problems.arraysandhashing.topkfrequentelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentElements
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 2, 3, 3, 3};
        int k = 2;
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(nums, k)));
    }

    public int[] topKFrequent(int[] nums, int k)
    {
        int[] topKFrequentElements = new int[k];
        Map<Integer, Integer> elementFrequencytMap = new HashMap<>();
        Map<Integer, List<Integer>> frequencySortedElementsMap = new TreeMap<>(Collections.reverseOrder());

        populateElementsFrequencyMap(nums, elementFrequencytMap);
        populateFrequencySortedElementsMap(elementFrequencytMap, frequencySortedElementsMap);
        populateTopKFrequentElements(frequencySortedElementsMap, topKFrequentElements);
        return topKFrequentElements;
    }

    private void populateTopKFrequentElements(Map<Integer, List<Integer>> frequencySortedElementsMap, int[] topKFrequentElements)
    {
        int index = 0;

        frequencies:
        for (Integer frequency : frequencySortedElementsMap.keySet())
        {
            List<Integer> elements = frequencySortedElementsMap.get(frequency);

            for (Integer element : elements)
            {
                if (index < topKFrequentElements.length)
                {
                    topKFrequentElements[index] = element;
                    index++;
                }
                else
                {
                    break frequencies;
                }
            }
        }
    }

    private void populateElementsFrequencyMap(final int[] nums, final Map<Integer, Integer> elementFrequencytMap)
    {
        for (int num : nums)
        {
            int frequency = elementFrequencytMap.getOrDefault(num, 0) + 1;
            elementFrequencytMap.put(num, frequency);
        }
    }

    private void populateFrequencySortedElementsMap(final Map<Integer, Integer> elementFrequencyMap, final Map<Integer, List<Integer>> frequencySortedElementsMap)
    {
        for (Integer element : elementFrequencyMap.keySet())
        {
            List<Integer> elements = frequencySortedElementsMap.getOrDefault(elementFrequencyMap.get(element), new ArrayList<>());
            elements.add(element);
            frequencySortedElementsMap.put(elementFrequencyMap.get(element), elements);
        }
    }
}
