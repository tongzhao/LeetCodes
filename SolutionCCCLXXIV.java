/**
 * 374. Guess Number Higher or Lower
 *
 * We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 */
public class SolutionCCCLXXIV {
    public int guessNumber(int n) {
        int l = 1;
        int h = n;
        while (l < h) {
            int m = l + (h-l) / 2;
            if (guess(m) == 0) return m;
            else if (guess(m) == 1) l = m+1;
            else if (guess(m) == -1) h = m-1;
            else h = m;
        }
        return l;
    }
    public int guess(int num) {
        // not overriden
        return 0;
    }
}
