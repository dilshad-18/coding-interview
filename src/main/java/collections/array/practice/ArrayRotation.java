package collections.array.practice;

public class ArrayRotation {
    public static void rotate1(int[] arr, int d, int n)
    {
        int p = 1;
        while (p <= d) {
            int last = arr[0];
            if (n - 1 >= 0) System.arraycopy(arr, 1, arr, 0, n - 1);
            arr[n - 1] = last;
            p++;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void rotate2(int[] arr, int d, int n)
    {
        int p = 1;
        while (p <= d) {
            int last = arr[0];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[n - 1] = last;
            p++;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int N = arr.length;
        // Rotate 2 times
        int d = 2;

        // Function call
        rotate1(arr, d, N);
        rotate2(arr, d, N);
    }
}
