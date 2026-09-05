/**
 * A1. Product of Array Except Self
 * 
 * Problem: Return an array where each element is the product of all other elements
 * without using division and in O(n) time.
 */
public class ProductOfArrayExceptSelf {
    
    /**
     * Solves using two passes: left products and right products
     * Time Complexity: O(n)
     * Space Complexity: O(n) for output array
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // First pass: calculate product of all elements to the left
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Second pass: multiply with product of all elements to the right
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        System.out.println("=== A1. Product of Array Except Self ===\n");
        
        // Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = productExceptSelf(nums1);
        System.out.println("Input: [1, 2, 3, 4]");
        System.out.print("Output: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [24, 12, 8, 6]\n");
        
        // Test Case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = productExceptSelf(nums2);
        System.out.println("Input: [-1, 1, 0, -3, 3]");
        System.out.print("Output: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [0, 0, 9, 0, 0]\n");
        
        // Test Case 3 (with zero price for promotional item)
        int[] nums3 = {2, 3, 0, 5};
        int[] result3 = productExceptSelf(nums3);
        System.out.println("Input: [2, 3, 0, 5] (free promotional item)");
        System.out.print("Output: [");
        for (int i = 0; i < result3.length; i++) {
            System.out.print(result3[i]);
            if (i < result3.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Expected: [0, 0, 30, 0]\n");
    }
}
