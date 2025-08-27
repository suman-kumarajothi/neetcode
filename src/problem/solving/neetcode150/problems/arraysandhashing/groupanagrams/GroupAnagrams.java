package problem.solving.neetcode150.problems.arraysandhashing.groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GroupAnagrams
{
    public static void main(String[] args)
    {
        String[] strs = new String[]{"act", "pots", "tops", "cat", "stop", "hat"};
        new GroupAnagrams().groupAnagrams(strs).forEach(groups -> System.out.println(String.join(", ", groups)));

    }

    public List<List<String>> groupAnagrams(final String[] strs)
    {
        List<String> anagrams = Arrays.stream(strs).toList();

        Map<String, String> anagramCharCountMap = new HashMap<>();
        for (String anagram : anagrams)
        {
            anagramCharCountMap.put(anagram, getCharCountMap(anagram));
        }
        return groupAnagrams(strs, anagramCharCountMap);
    }

    private String getCharCountMap(final String input)
    {
        Map<Character, Integer> charCountMap = new TreeMap<>();

        for (Character character : input.toCharArray())
        {
            int charCount = charCountMap.getOrDefault(character, 0);
            charCountMap.put(character, charCount + 1);
        }
        return charCountMap.toString();
    }

    private List<List<String>> groupAnagrams(final String[] anagrams, final Map<String, String> anagramCharCountMap)
    {
        List<List<String>> groups = new ArrayList<>();
        List<String> processedAnagrams = new ArrayList<>();

        for (int i = 0; i < anagrams.length; i++)
        {
            if (processedAnagrams.contains(anagrams[i]))
            {
                continue;
            }

            List<String> subGroups = new ArrayList<>();
            subGroups.add(anagrams[i]);
            for (int j = i + 1; j <= anagrams.length - 1; j++)
            {
                if (anagramCharCountMap.get(anagrams[i]).equals(anagramCharCountMap.get(anagrams[j])))
                {
                    subGroups.add(anagrams[j]);
                    processedAnagrams.add(anagrams[j]);
                }
            }
            groups.add(subGroups);
        }

        return groups.stream().sorted(Comparator.comparingInt(List::size)).toList();
    }
}

