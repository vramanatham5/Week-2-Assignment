/**
 * L3. Contains Duplicate
 * Check if any element appears twice in the array
 */
public class L3ContainsDuplicate {
    
    /**
     * Check if array contains duplicate elements
     * @param nums integer array
     * @return true if duplicate found, false otherwise
     */
    public static boolean containsDuplicate(int[] nums) {
        // Compare every element at position i against every other position j
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // If two different positions hold the same value, return true immediately
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        // No matching pair found after checking all pairs
        return false;
    }
    
    public static void main(String[] args) {
        // Test case 1: Contains duplicate
        int[] nums1 = {1, 2, 3, 1};
        boolean result1 = containsDuplicate(nums1);
        System.out.println("Test 1: nums = [1, 2, 3, 1]");
        System.out.println("Contains Duplicate: " + result1);
        System.out.println("Explanation: The element 1 appears at index 0 and index 3");
        
        System.out.println();
        
        // Test case 2: No duplicate
        int[] nums2 = {1, 2, 3, 4};
        boolean result2 = containsDuplicate(nums2);
        System.out.println("Test 2: nums = [1, 2, 3, 4]");
        System.out.println("Contains Duplicate: " + result2);
        System.out.println("Explanation: All elements are unique");
        
        System.out.println();
        
        // Test case 3: Multiple duplicates
        int[] nums3 = {99, 99};
        boolean result3 = containsDuplicate(nums3);
        System.out.println("Test 3: nums = [99, 99]");
        System.out.println("Contains Duplicate: " + result3);
        System.out.println("Explanation: The element 99 appears twice");
        
        System.out.println();
        
        // Test case 4: No duplicate with mixed numbers
        int[] nums4 = {1, 5, 7, 3, 8, 2};
        boolean result4 = containsDuplicate(nums4);
        System.out.println("Test 4: nums = [1, 5, 7, 3, 8, 2]");
        System.out.println("Contains Duplicate: " + result4);
        System.out.println("Explanation: All elements are unique");
    }
}
