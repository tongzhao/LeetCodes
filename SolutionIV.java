public class SolutionIV {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aLen = nums1.length;
        int bLen = nums2.length;
        if ((aLen+bLen)%2==0) return 0.5*(find(nums1, nums2, (aLen+bLen)/2, 0, aLen-1, 0, bLen-1)+
                                          find(nums1, nums2, (aLen+bLen)/2-1, 0, aLen-1, 0, bLen-1));
        return find(nums1, nums2, (aLen+bLen)/2, 0, aLen-1, 0, bLen-1);
    }
    public double find(int[] a, int[] b, int k, int as, int ae, int bs, int be) {
        int aLen = ae-as+1;
        int bLen = be-bs+1;
        if (aLen==0) return b[bs+k];
        if (bLen==0) return a[as+k];
        if (k==0) return Math.min(a[as], b[bs]);
        int ak = k * aLen/(aLen+bLen);
        int bk = k - 1 - ak;
        ak = ak + as;
        bk = bk + bs;
        if (a[ak]>b[bk]) {
            // remove left part of b and right part of a, keep track of top-k
            k = k - (bk-bs+1);
            ae = ak;
            bs = bk + 1;
        } else {
            k = k-(ak-as+1);
            as = ak+1;
            be = bk;
        }
        return find(a, b, k, as, ae, bs, be);
    }
}
