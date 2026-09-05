import java.util.*;

/**
 * A4. Subarray Sum Equals K
 * 
 * Problem: Count the total number of contiguous subarrays whose sum equals k
 */
public class SubarraySumEqualsK {
    
    /**
     * Solves using prefix sum with HashMap
     * The sum of subarray [i+1, j] = prefixSum[j] - prefixSum[i]
     * So we need to find how many times (currentSum - k) appeared before
     * 
     * Why sliding window doesn't work: array contains negative numbers,
     * so we cannot shrink the window when sum exceeds k
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) for hashmap
     */
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);  // Base case: empty prefix has sum 0
        
        int count = 0;
        int currentSum = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if (currentSum - k) exists in map
            // This means we found a subarray with sum = k
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }
            
            // Add current prefix sum to map
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println("=== A4. Subarray Sum Equals K ===\n");
        
        // Test Case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        int result1 = subarraySum(nums1, k1);
        System.out.println("Input: [1, 1, 1], k = 2");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 2 (subarrays [1,1] at indices (0,1) and (1,2))\n");
        
        // Test Case 2
        int[] nums2 = {1, 2, 1, 2, 1};
        int k2 = 3;
        int result2 = subarraySum(nums2, k2);
        System.out.println("Input: [1, 2, 1, 2, 1], k = 3");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 2 (subarrays [1,2] and [2,1])\n");
        
        // Test Case 3 (with negative numbers)
        int[] nums3 = {1, -1, 1, 1};
        int k3 = 1;
        int result3 = subarraySum(nums3, k3);
        System.out.println("Input: [1, -1, 1, 1], k = 1");
        System.out.println("Output: " + result3);
        System.out.println("Expected: 3 (subarrays [1], [1,1], [1])\n");
        
        // Test Case 4
        int[] nums4 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k4 = 7;
        int result4 = subarraySum(nums4, k4);
        System.out.println("Input: [3, 4, 7, 2, -3, 1, 4, 2], k = 7");
        System.out.println("Output: " + result4);
        System.out.println("Expected: 4\n");
    }
}
