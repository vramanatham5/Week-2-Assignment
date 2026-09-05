/**
 * L4. Merge Two Sorted Arrays
 * Merge two sorted arrays without using extra sorting
 */
public class L4MergeTwoSortedArrays {
    
    /**
     * Merge two sorted arrays into one sorted array
     * @param arr1 first sorted array
     * @param arr2 second sorted array
     * @return merged sorted array
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;  // Pointer for arr1
        int j = 0;  // Pointer for arr2
        int k = 0;  // Pointer for result
        
        // Compare elements from both arrays and copy smaller one
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        
        // Copy remaining elements from arr1
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        
        // Copy remaining elements from arr2
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        
        return result;
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
        // Test case 1
        int[] arr1_1 = {1, 3, 5};
        int[] arr2_1 = {2, 4, 6};
        int[] result1 = mergeSortedArrays(arr1_1, arr2_1);
        System.out.println("Test 1:");
        System.out.print("arr1 = ");
        printArray(arr1_1);
        System.out.print("arr2 = ");
        printArray(arr2_1);
        System.out.print("Merged = ");
        printArray(result1);
        
        System.out.println();
        
        // Test case 2
        int[] arr1_2 = {1, 2, 3};
        int[] arr2_2 = {4, 5, 6};
        int[] result2 = mergeSortedArrays(arr1_2, arr2_2);
        System.out.println("Test 2:");
        System.out.print("arr1 = ");
        printArray(arr1_2);
        System.out.print("arr2 = ");
        printArray(arr2_2);
        System.out.print("Merged = ");
        printArray(result2);
        
        System.out.println();
        
        // Test case 3: Different lengths
        int[] arr1_3 = {1, 5, 9, 10, 15, 20};
        int[] arr2_3 = {2, 3, 8, 13};
        int[] result3 = mergeSortedArrays(arr1_3, arr2_3);
        System.out.println("Test 3:");
        System.out.print("arr1 = ");
        printArray(arr1_3);
        System.out.print("arr2 = ");
        printArray(arr2_3);
        System.out.print("Merged = ");
        printArray(result3);
    }
}
