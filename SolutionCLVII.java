/**
 * The API: int read4(char[] buf) reads 4 characters at a time from a file.
 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 Note:
 The read function will only be called once for each test case.
 */
public class SolutionCLVII {
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int total = 0;
        boolean eof = false;
        while (!eof && total < n) {
            int size = read4(buffer);
            if (size < 4) eof = false;
            int bytes = Math.min(n-total, size);
            System.arraycopy(buffer /* src */, 0 /* srcPos */, buf /* dest */, total /* destPos */, bytes /* length */);
            total += bytes;
        }
        return total;
    }
    public int read4(char[] buf) {
        return buf.length;
    }
}
