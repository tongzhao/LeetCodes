/**
 * H-Index I:
 * given citations = [3, 0, 6, 1, 5],
 * which means the researcher has 5 papers in total and
 * each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and
 * the remaining two with no more than 3 citations each, his h-index is 3.

 Note: If there are several possible values for h, the maximum one is taken as the h-index
 */
public class SolutionCCLXXIV {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] res = new int[n+1];
        for (int citation: citations) {
            if (citation >= n) res[n]++;
            else res[citation]++;
        }
        for (int citation = n; citation > 0; citation--) {
            if (res[citation] >= citation) return citation;
            res[citation-1] += res[citation];
        }
        return 0;
    }
}
