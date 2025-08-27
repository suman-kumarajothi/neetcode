package problem.solving.neetcode150.problems.arraysandhashing.validanagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidAnagram
{

    public static void main(String[] args)
    {
        System.out.println(new ValidAnagram().isAnagram("bbcc", "ccbc"));
    }

    public boolean isAnagram(final String s, final String t)
    {
        if ((s == null || s.isEmpty()) || (t == null || t.isEmpty()) || s.length() != t.length())
        {
            return false;
        }

        Map<Character, Integer> sCharCountMap = new HashMap<>();
        Map<Character, Integer> tCharCountMap = new HashMap<>();

        mapCharCount(sCharCountMap, s.toCharArray());
        mapCharCount(tCharCountMap, t.toCharArray());
        return compareCharCountMap(sCharCountMap, tCharCountMap);
    }

    private void mapCharCount(final Map<Character, Integer> charCountMap, char[] charArray)
    {
        for (char character : charArray)
        {
            int charCountInCache = charCountMap.getOrDefault(character, 0);
            if (charCountInCache > 0)
            {
                charCountMap.put(character, charCountInCache + 1);
            } else
            {
                charCountMap.put(character, 1);
            }
        }
    }

    private boolean compareCharCountMap(Map<Character, Integer> sCharCountMap, Map<Character, Integer> tCharCountMap)
    {
        for (char character : sCharCountMap.keySet())
        {
            if (! Objects.equals(tCharCountMap.get(character), sCharCountMap.get(character)))
            {
                return false;
            }
        }
        return true;
    }
}
