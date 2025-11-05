public class program2 {
	// recursive method to find maximum in first n elements of array
	// returns the maximum among a[0..n-1]
	public static int findMax(int[] a, int n) {
		if (a == null || n <= 0) {
			throw new IllegalArgumentException("Array must be non-null and n must be > 0");
		}
		if (n == 1) {
			return a[0];
		}
		int maxOfRest = findMax(a, n - 1);
		return Math.max(a[n - 1], maxOfRest);
	}

	public static void main(String[] args) {
		int[] arr;

		if (args.length == 0) {
			// sample array when no command-line arguments are provided
			arr = new int[] { 3, 5, -2, 17, 0, 17, 9 };
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

		int max = findMax(arr, arr.length);
		System.out.println("Array: ");
		for (int v : arr) System.out.print(v + " ");
		System.out.println();
		System.out.println("Maximum element (found recursively): " + max);
	}
}
