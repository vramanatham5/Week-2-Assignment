/**
 * L1. Two Sum
 * Find two different indices where nums[i] + nums[j] equals target
 */
public class L1TwoSum {
    
    /**
     * Find two numbers that add up to target
     * @param nums integer array
     * @param target target sum
     * @return array of two indices [i, j]
     */
    public static int[] twoSum(int[] nums, int target) {
        // Check every pair of different positions using two nested loops
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // If the sum equals target, return immediately
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        // Should not reach here based on problem constraints
        return new int[] {};
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Test 1: nums = [2, 7, 11, 15], target = 9");
        System.out.println("Result: [" + result1[0] + ", " + result1[1] + "]");
        System.out.println("Explanation: nums[" + result1[0] + "] + nums[" + result1[1] + "] = " + 
                           nums1[result1[0]] + " + " + nums1[result1[1]] + " = " + target1);
        
        System.out.println();
        
        // Test case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Test 2: nums = [3, 2, 4], target = 6");
        System.out.println("Result: [" + result2[0] + ", " + result2[1] + "]");
        System.out.println("Explanation: nums[" + result2[0] + "] + nums[" + result2[1] + "] = " + 
                           nums2[result2[0]] + " + " + nums2[result2[1]] + " = " + target2);
    }
}
