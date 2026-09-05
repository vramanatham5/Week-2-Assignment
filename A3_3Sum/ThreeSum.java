import java.util.*;

/**
 * A3. 3Sum
 * 
 * Problem: Find all unique triplets that sum to zero
 */
public class ThreeSum {
    
    /**
     * Solves using sorted array with two-pointer technique
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) excluding output
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length < 3) {
            return result;
        }
        
        // Sort the array first
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // If number is positive, no triplet can sum to zero
            if (nums[i] > 0) {
                break;
            }
            
            // Skip duplicate values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Two pointer approach for remaining array
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicate values on left
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    
                    // Skip duplicate values on right
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=== A3. 3Sum ===\n");
        
        // Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result1 = threeSum(nums1);
        System.out.println("Input: [-1, 0, 1, 2, -1, -4]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: [[-1, -1, 2], [-1, 0, 1]]\n");
        
        // Test Case 2
        int[] nums2 = {0, 0, 0, 0};
        List<List<Integer>> result2 = threeSum(nums2);
        System.out.println("Input: [0, 0, 0, 0]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: [[0, 0, 0]]\n");
        
        // Test Case 3
        int[] nums3 = {-2, 0, 1, 1, 2};
        List<List<Integer>> result3 = threeSum(nums3);
        System.out.println("Input: [-2, 0, 1, 1, 2]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: [[-2, 0, 2], [-2, 1, 1]]\n");
        
        // Test Case 4 (impossible)
        int[] nums4 = {1, 2, 3};
        List<List<Integer>> result4 = threeSum(nums4);
        System.out.println("Input: [1, 2, 3]");
        System.out.println("Output: " + result4);
        System.out.println("Expected: [] (no triplets sum to zero)\n");
    }
}
