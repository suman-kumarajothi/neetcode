package problem.solving.neetcode150.problems.stack.validparenthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis
{
    public static void main(String[] args)
    {
        String input = "([{}])";
        System.out.println(new ValidParenthesis().isValid(input));
    }

    public boolean isValid(String s) {
        Map<Character, Character> parathesisMap = new HashMap<>();
        parathesisMap.put(')', '(');
        parathesisMap.put('}', '{');
        parathesisMap.put(']', '[' );

        Stack<Character> parethesisContainer = new Stack<>();
        char[] characters = s.toCharArray();

        for (char c: characters)
        {
            Character invertedParenthesis = parathesisMap.get(c);
            if (!parethesisContainer.isEmpty())
            {
                if(invertedParenthesis != null && parethesisContainer.peek().equals(invertedParenthesis))
                {
                    parethesisContainer.pop();
                }
                else
                {
                    parethesisContainer.push(c);
                }
            }
            else
            {
                parethesisContainer.push(c);
            }
        }

        return parethesisContainer.isEmpty();
    }
}
