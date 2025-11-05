public class program3 {

	// recursive method to check if first n elements of array are sorted in ascending order
	// returns true if a[0..n-1] is sorted (non-decreasing)
	public static boolean isSorted(int[] a, int n) {
		if (a == null) {
			throw new IllegalArgumentException("Array must be non-null");
		}
		// empty or single-element array is considered sorted
		if (n <= 1) {
			return true;
		}
		// check last pair and recurse for the rest
		if (a[n - 2] > a[n - 1]) {
			return false;
		}
		return isSorted(a, n - 1);
	}

	public static void main(String[] args) {
		int[] arr;

		if (args.length == 0) {
			// sample array when no command-line arguments are provided
			arr = new int[] { 1, 2, 2, 5, 9 };
			System.out.println("No command-line ints provided. Using sample array.");
		} else {
			// parse command-line args as integers
			arr = new int[args.length];
			try {
				for (int i = 0; i < args.length; i++) {
					arr[i] = Integer.parseInt(args[i]);
				}
			} catch (NumberFormatException e) {
				System.err.println("All command-line arguments must be integers.");
				return;
			}
		}

		System.out.print("Array: ");
		for (int v : arr) System.out.print(v + " ");
		System.out.println();

		boolean sorted = isSorted(arr, arr.length);
		System.out.println("Array is sorted (ascending): " + sorted);
	}
}
