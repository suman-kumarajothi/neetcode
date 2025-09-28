package problem.solving.neetcode150.problems.twopointers.validpalindrome;

public class ValidPalindrome
{
    public static void main(String[] args)
    {
        System.out.println(new ValidPalindrome().isPalindrome("Was it a car or a cat I saw?"));
    }

    public boolean isPalindrome(final String s)
    {
        StringBuilder input = new StringBuilder();
        for (Character ch : s.toLowerCase().toCharArray())
        {
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
            {
                input.append(ch);
            }
        }
        String inputStr = input.toString();
        for (int i = 0, j = inputStr.length() - 1; i < j; i++, j--)
        {
            if (inputStr.charAt(i) != inputStr.charAt(j)) return false;
        }
        return true;
    }
}
