public class program9 {
    
    public static void reverseArray(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        
        // swap elements at start and end
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        
        // recursive call for remaining elements
        reverseArray(arr, start + 1, end - 1);
    }
    
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        
        System.out.print("Original array: ");
        printArray(arr);
        
        reverseArray(arr, 0, arr.length - 1);
        
        System.out.print("Reversed array: ");
        printArray(arr);
    }
}
