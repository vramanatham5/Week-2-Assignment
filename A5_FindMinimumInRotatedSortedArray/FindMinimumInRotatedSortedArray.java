/**
 * A5. Find Minimum in Rotated Sorted Array
 * 
 * Problem: Find the minimum element in a rotated sorted array using binary search
 */
public class FindMinimumInRotatedSortedArray {
    
    /**
     * Solves using modified binary search
     * Compare middle element with rightmost element to determine which half contains minimum
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // If array is not rotated
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If mid element is greater than right element,
            // minimum must be in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Otherwise minimum is in left half (including mid)
            else {
                right = mid;
            }
        }
        
        return nums[left];
    }
    
    public static void main(String[] args) {
        System.out.println("=== A5. Find Minimum in Rotated Sorted Array ===\n");
        
        // Test Case 1: Rotated at pivot
        int[] nums1 = {3, 4, 5, 1, 2};
        int result1 = findMin(nums1);
        System.out.println("Input: [3, 4, 5, 1, 2]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 1\n");
        
        // Test Case 2: Rotated but different pivot
        int[] nums2 = {2, 1};
        int result2 = findMin(nums2);
        System.out.println("Input: [2, 1]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 1\n");
        
        // Test Case 3: Not rotated (already sorted)
        int[] nums3 = {1, 2, 3, 4, 5};
        int result3 = findMin(nums3);
        System.out.println("Input: [1, 2, 3, 4, 5]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: 1\n");
        
        // Test Case 4: Single element
        int[] nums4 = {5};
        int result4 = findMin(nums4);
        System.out.println("Input: [5]");
        System.out.println("Output: " + result4);
        System.out.println("Expected: 5\n");
        
        // Test Case 5: Rotated with larger array
        int[] nums5 = {4, 5, 6, 7, 0, 1, 2};
        int result5 = findMin(nums5);
        System.out.println("Input: [4, 5, 6, 7, 0, 1, 2]");
        System.out.println("Output: " + result5);
        System.out.println("Expected: 0\n");
    }
}
