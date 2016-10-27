import java.util.ArrayList;
import java.util.List;

/**
 * 401. Binary Watch
 *
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

 Each LED represents a zero or one, with the least significant bit on the right.

 Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

 Example:

 Input: n = 1
 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 */
public class SolutionCDI {

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<String>();
        if (num < 0 || num > 10) return result; // invalid input number
        int on = 0;
        int index = 0;
        int[] led = new int[10]; // assume first 4 for hour, last 6 for minutes
        helper(num, result, on, index, led);
        return result;
    }
    public void helper(int num, List<String> result, int on, int i, int[] led) {
        if (num == on) {
            String res = getTime(led);
            if (res != null) result.add(res); // can be some valid output values
            return;
        }
        if (i == led.length) return; // hit the end already

        // recursive
        // if i-th off
        led[i] = 0;
        helper(num, result, on, i+1, led);
        // if i-th on
        led[i] = 1;
        helper(num, result, on+1, i+1, led);

        led[i] = 0; // back to previous state
    }
    public String getTime(int[] led) {
        // find hour
        int hour = 0;
        for (int i = 0; i < 4; i++) {
            if (led[i]==1) hour = hour + (int)Math.pow(2, i);
        }
        // find minute
        int minute = 0;
        for (int i = 4; i < 10; i++) {
            if (led[i]==1) minute = minute + (int)Math.pow(2, i-4);
        }
        String m = (minute < 10) ? "0"+minute : String.valueOf(minute);
        String res = hour + ":" + m;
        if (hour >= 12 || minute >= 60) return null;
        return res;
    }
}
