package problem.solving.neetcode150.problems.slidingwindow.longestsubstringwithoutrepeatingcharacters;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters
{
    public static void main(String[] args)
    {
        String s = "au";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;

        Set<Character> cache = new HashSet<>();

        for (int right = 0; right < s.length(); right++)
        {
            Character ch = s.charAt(right);
            while (cache.contains(ch))
            {
                cache.remove(s.charAt(left));
                left++;
            }
            cache.add(ch);

            maxLength = Math.max(maxLength, right-left + 1);
        }
        return maxLength;
    }
}
