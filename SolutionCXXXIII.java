/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 You begin the journey with an empty tank at one of the gas stations.
 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 */
public class SolutionCXXXIII {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // guranteed to have one solution, and only one
        if (gas.length==0 || cost.length==0) return -1;
        int[] diff = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
        }
        int start = 0;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            left += diff[i];
            sum += diff[i];
            if (sum<0) {
                sum = 0;
                start = i+1;
            }
        }
        return left < 0 ? -1 :  start;
    }
}
