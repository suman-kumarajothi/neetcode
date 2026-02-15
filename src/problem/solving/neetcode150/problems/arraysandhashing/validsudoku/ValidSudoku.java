package problem.solving.neetcode150.problems.arraysandhashing.validsudoku;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku
{
    public static void main(String[] args)
    {
        char[][] valid_sudoku = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] invalid_sudoku = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] board = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        System.out.println(new ValidSudoku().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board)
    {

        boolean isRowValidationSuccess = false, isColumnValidationSuccess = false, isSubBoxValidationSuccess = false;
        for (int i = 0; i < board.length; i++)
        {
            isRowValidationSuccess = validateRow(i, board);
            isColumnValidationSuccess = validateColumn(i, board);
            if (! isRowValidationSuccess || ! isColumnValidationSuccess) break;
        }

        for (int j = 0; j < board.length; j += 3)
        {
            isSubBoxValidationSuccess = validateSubBox(j, board);
            if (! isSubBoxValidationSuccess) break;
        }
        return isRowValidationSuccess && isColumnValidationSuccess && isSubBoxValidationSuccess;
    }

    private boolean validateRow(int rowValidationIndex, char[][] board)
    {
        try
        {
            Set<Character> validationCache = new HashSet<>();
            for (int x = 0; x < board.length; x++)
            {
                Character curr = board[rowValidationIndex][x];
                if (! curr.equals('.')) checkOrAddElementInCache(validationCache, curr);
            }
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    private boolean validateColumn(int columnValidationIndex, char[][] board)
    {
        try
        {
            Set<Character> validationCache = new HashSet<>();
            for (int x = 0; x < board.length; x++)
            {
                Character curr = board[x][columnValidationIndex];
                if (! curr.equals('.')) checkOrAddElementInCache(validationCache, curr);
            }
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    private boolean validateSubBox(int subBoxValidationIndex, char[][] board)
    {
        try
        {
            Set<Character> validationCache = new HashSet<>();
            for (int x = subBoxValidationIndex; x < subBoxValidationIndex + 3; x++)
            {
                Character a = board[x][0];
                Character b = board[x][1];
                Character c = board[x][2];
                if (! a.equals('.')) checkOrAddElementInCache(validationCache, a);
                if (! b.equals('.')) checkOrAddElementInCache(validationCache, b);
                if (! c.equals('.')) checkOrAddElementInCache(validationCache, c);
            }

            validationCache = new HashSet<>();
            for (int x = subBoxValidationIndex; x < subBoxValidationIndex + 3; x++)
            {
                Character d = board[x][3];
                Character e = board[x][4];
                Character f = board[x][5];
                if (! d.equals('.')) checkOrAddElementInCache(validationCache, d);
                if (! e.equals('.')) checkOrAddElementInCache(validationCache, e);
                if (! f.equals('.')) checkOrAddElementInCache(validationCache, f);
            }

            validationCache = new HashSet<>();
            for (int x = subBoxValidationIndex; x < subBoxValidationIndex + 3; x++)
            {
                Character g = board[x][6];
                Character h = board[x][7];
                Character i = board[x][8];
                if (! g.equals('.')) checkOrAddElementInCache(validationCache, g);
                if (! h.equals('.')) checkOrAddElementInCache(validationCache, h);
                if (! i.equals('.')) checkOrAddElementInCache(validationCache, i);
            }
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    private void checkOrAddElementInCache(Set<Character> validationCache, char curr)
    {
        if (validationCache.contains(curr))
        {
            throw new RuntimeException();
        } else
        {
            validationCache.add(curr);
        }
    }
}
