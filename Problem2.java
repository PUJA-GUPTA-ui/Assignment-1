import java.util.*;
public class Problem2 {
    public static int minOperations(int[] arr, int k) {
        int n = arr.length;
        int rem = arr[0] % k;
        for (int num : arr) {
            if (num % k != rem) {
                return -1;
            }
        }
        Arrays.sort(arr);
        int median = arr[n / 2];
        int operations = 0;
        for (int num : arr) {
            operations += Math.abs(num - median) / k;
        }
        return operations;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(minOperations(arr, k));
    }
}
