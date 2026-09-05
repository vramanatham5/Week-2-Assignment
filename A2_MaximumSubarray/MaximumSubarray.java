/**
 * A2. Maximum Subarray
 * 
 * Problem: Find the contiguous subarray with the largest sum (Kadane's Algorithm)
 */
public class MaximumSubarray {
    
    /**
     * Solves using Kadane's Algorithm
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maxSubArray(int[] nums) {
        int maxCurrent = nums[0];  // Max sum ending at current position
        int maxGlobal = nums[0];   // Maximum sum found so far
        
        for (int i = 1; i < nums.length; i++) {
            // Either extend the subarray or start fresh from current element
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }
        
        return maxGlobal;
    }
    
    public static void main(String[] args) {
        System.out.println("=== A2. Maximum Subarray (Kadane's Algorithm) ===\n");
        
        // Test Case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = maxSubArray(nums1);
        System.out.println("Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 6 (subarray [4, -1, 2, 1])\n");
        
        // Test Case 2
        int[] nums2 = {5, 4, -1, 7, 8};
        int result2 = maxSubArray(nums2);
        System.out.println("Input: [5, 4, -1, 7, 8]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 23 (entire array)\n");
        
        // Test Case 3 (all negative)
        int[] nums3 = {-2, -3, -1, -4};
        int result3 = maxSubArray(nums3);
        System.out.println("Input: [-2, -3, -1, -4]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: -1 (single largest element)\n");
        
        // Test Case 4 (single element)
        int[] nums4 = {-1};
        int result4 = maxSubArray(nums4);
        System.out.println("Input: [-1]");
        System.out.println("Output: " + result4);
        System.out.println("Expected: -1\n");
    }
}
