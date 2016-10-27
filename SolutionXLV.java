public class SolutionXLV {
    public int jump(int[] nums) {
        int steps = 0;
        int last_jump_max = 0;
        int current_jump_max = 0;
        for (int i = 0; i < nums.length-1; i++) {
            current_jump_max = Math.max(last_jump_max, nums[i]+i); // global farthest
            if (i==last_jump_max) {
                steps++;
                last_jump_max = current_jump_max;
            }
        }
        return steps;
    }
}
