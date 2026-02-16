package problem.solving.neetcode150.problems.arraysandhashing.longestconsecutivesequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequence
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{0, 3, 2, 5, 4, 6, 1, 1};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums)
    {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> cache = new HashSet<>();
        Set<Integer> sequenceStarters = new HashSet<>();

        for (int num : nums)
        {
            if (! cache.contains(num - 1))
            {
                sequenceStarters.add(num);
            } else
            {
                sequenceStarters.remove(num);
            }
            cache.add(num);
        }

        List<List<Integer>> sequences = new ArrayList<>();
        int longestSequenceIndex = 0;
        for (int sequenceStarter : sequenceStarters)
        {
            List<Integer> sequence = new ArrayList<>();
            sequence.add(sequenceStarter);
            int sequenceElement = sequenceStarter + 1;
            while (cache.contains(sequenceElement))
            {
                sequence.add(sequenceElement);
                sequenceElement++;
            }
            sequences.add(sequence);
            if (sequence.size() > sequences.get(longestSequenceIndex).size())
                longestSequenceIndex = sequences.size() - 1;
        }
        return sequences.get(longestSequenceIndex).size();
    }
}
