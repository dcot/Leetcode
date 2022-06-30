package DFSAndStack;

public class FindTargetSumWays {
    int cnt = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,target,0,0);
        return cnt;
    }
    public void dfs(int[] nums, int target, int sum, int index) {
        if (index == nums.length) {
            if(sum == target) {
                cnt++;
            }
            return;
        }
        dfs(nums, target, sum - nums[index], index+1);
        dfs(nums, target, sum + nums[index], index+1);
    }
}
