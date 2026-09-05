/**
 * L5. Rotate Array
 * Rotate array to the right by k positions
 */
public class L5RotateArray {
    
    /**
     * Rotate array to the right by k positions
     * @param nums array to rotate
     * @param k number of positions to rotate
     * @return rotated array
     */
    public static int[] rotateArray(int[] nums, int k) {
        // Reduce k to handle cases where k > nums.length
        k = k % nums.length;
        
        // Create new array of the same size
        int[] newArray = new int[nums.length];
        
        // For every index i, calculate new position and place element there
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }
        
        // Copy values from new array back to nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
        
        return nums;
    }
    
    /**
     * Helper method to print array
     */
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        // Test case 1: Basic rotation
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Test 1:");
        System.out.print("Original: ");
        printArray(nums1);
        System.out.println("Rotate right by " + k1 + " positions:");
        int[] result1 = rotateArray(nums1.clone(), k1);
        System.out.print("Result: ");
        printArray(result1);
        System.out.println("Explanation: [1,2,3,4,5,6,7] -> [5,6,7,1,2,3,4]");
        
        System.out.println();
        
        // Test case 2: Rotation by 1
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 1;
        System.out.println("Test 2:");
        System.out.print("Original: ");
        printArray(nums2);
        System.out.println("Rotate right by " + k2 + " position:");
        int[] result2 = rotateArray(nums2.clone(), k2);
        System.out.print("Result: ");
        printArray(result2);
        System.out.println("Explanation: [-1,-100,3,99] -> [99,-1,-100,3]");
        
        System.out.println();
        
        // Test case 3: k > array length
        int[] nums3 = {1, 2, 3};
        int k3 = 5;
        System.out.println("Test 3:");
        System.out.print("Original: ");
        printArray(nums3);
        System.out.println("Rotate right by " + k3 + " positions (k > length):");
        int[] result3 = rotateArray(nums3.clone(), k3);
        System.out.print("Result: ");
        printArray(result3);
        System.out.println("Explanation: k=5 is reduced to k=5%3=2, so [1,2,3] -> [2,3,1]");
        
        System.out.println();
        
        // Test case 4: k = 0 (no rotation)
        int[] nums4 = {1, 2, 3};
        int k4 = 0;
        System.out.println("Test 4:");
        System.out.print("Original: ");
        printArray(nums4);
        System.out.println("Rotate right by " + k4 + " positions:");
        int[] result4 = rotateArray(nums4.clone(), k4);
        System.out.print("Result: ");
        printArray(result4);
        System.out.println("Explanation: No rotation needed");
    }
}
