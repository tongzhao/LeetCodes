/**
 * Smallest Rectangle Enclosing Black Pixels:
 *
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 * The black pixels are connected, i.e., there is only one black region.
 * Pixels are connected horizontally and vertically.
 * Given the location (x, y) of one of the black pixels,
 * return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

 For example, given the following image:
 [
 "0010",
 "0110",
 "0100"
 ]
 and x = 0, y = 2,
 Return 6.
 */
public class SolutionCCCII {
    static int left, right, top, bottom;
    static boolean[][] visited;
    public static int minArea(char[][] image, int x, int y) {
        int res = 0;
        if (image==null || image.length==0) return res;
        left = y;
        right = y;
        top = x;
        bottom = x;
        visited = new boolean[image.length][image[0].length];
        findMinArea(image, x, y, visited);
        return (bottom-top+1)*(right-left+1);
    }
    // DFS method to trace
    public static void findMinArea(char[][] image, int x, int y, boolean[][] viisted) {
        visited[x][y] = true;
        if (image[x][y]!='1') return;
        updateBorder(x, y);
        if (x-1>=0 && !visited[x-1][y]) findMinArea(image, x-1, y, visited);
        if (x+1<image.length && !visited[x+1][y]) findMinArea(image, x+1, y, visited);
        if (y-1>=0 && !visited[x][y-1]) findMinArea(image, x, y-1, visited);
        if (y+1<image[0].length && !visited[x][y+1]) findMinArea(image, x, y+1, visited);
    }
    public static void updateBorder(int x, int y) {
        top = (x < top) ? x : top;
        bottom = (x > bottom) ? x : bottom;
        left = (y < left) ? y : left;
        right = (y > right) ? y : right;
    }

    public static void main(String[] args) {
        char[][] image = {{'0','0','1','0'},
                          {'0','1','1','0'},
                          {'0','1','0','0'}};
        System.out.print(minArea(image, 0, 2));
    }
}
