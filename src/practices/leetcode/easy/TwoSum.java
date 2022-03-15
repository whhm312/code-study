package practices.leetcode.easy;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] answerArray = new int[2];
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    answerArray[0] = i;
                    answerArray[1] = j;
                    break;
                }
            }
        }
        return answerArray;
    }
}
