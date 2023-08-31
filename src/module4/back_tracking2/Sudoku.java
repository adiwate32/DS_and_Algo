package module4.back_tracking2;

/**
 Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
 A sudoku puzzle,
 and its solution numbers marked in red.

 Problem Constraints
 N = 9

 Input Format
 First argument is an array of array of characters representing the Sudoku puzzle.

 Output Format
 Modify the given input to the required answer.

 Example Input
 Input 1:
 A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]

 Example Output
 Output 1:
 [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]

 Example Explanation
 Explanation 1:
 Look at the diagrams given in the question.
 */
public class Sudoku {
    public void solveSudoku(char[][] A) {

        sudoku(A, 0, 0);
    }

    private boolean sudoku(char[][] a, int r, int c)
    {

        if(c == 9)
        {
            r += 1;
            c = 0;
        }

        if(r == 9) return true;

        if(a[r][c] != '.')
        {
            return sudoku(a, r, c + 1);
        }
        else
        {
            for(int i=1; i<=9; i++)
            {
                char x = (char) (i + '0');
                if(isvalid(a, x, r, c))
                {
                    a[r][c] = x;
                    if(sudoku(a, r, c+1)) return true;
                    a[r][c] = '.';
                }
            }
        }
        return false;
    }

    private boolean isvalid(char[][] a, char x, int r, int c)
    {
        for(int i=0; i<9; i++)
        {
            if(a[r][i] == x) return false;
            if(a[i][c] == x) return false;
        }

        r = r-r%3;
        c = c-c%3;

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(a[i+r][j+c] == x) return false;
            }
        }
        return true;
    }
}
