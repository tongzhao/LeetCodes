/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

 Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 */
public class SolutionCCXXIII {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C < E || G < A) return (C-A)*(D-B) + (G-E)*(H-F);
        if (D < F || H < B) return (C-A)*(D-B) + (G-E)*(H-F);
        int right = Math.min(C, G);
        int left = Math.max(A, E);
        int top = Math.min(H, D);
        int bottom = Math.max(F, B);
        return (C-A)*(D-B) + (G-E)*(H-F) - (right-left)*(top-bottom);
    }
}
