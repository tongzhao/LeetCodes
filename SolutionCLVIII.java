/**
 * Similar to Question [Read N Characters Given Read4],
 * but the read function may be called multiple times.
 */
public class SolutionCLVIII {
    private char[] buffer = new char[4];
    int offset = 0, bufsize = 0;
    public int read(char[] buf, int n) {
        int readBytes = 0;
        boolean eof = false;
        while (!eof && readBytes < n) {
            int sz = (bufsize > 0) ? bufsize : read4(buffer);
            if (bufsize == 0 && sz < 4) eof = true;
            int bytes = Math.min(n - readBytes, sz);
            System.arraycopy(buffer /* src */, offset /* srcPos */, buf /* dest */,
                             readBytes /* destPos */, bytes /* length */);
            offset = (offset + bytes) % 4;
            bufsize = sz - bytes;
            readBytes += bytes;
        }
        return readBytes;
    }
    public int read4(char[] buf) {
        return buf.length;
    }
}
