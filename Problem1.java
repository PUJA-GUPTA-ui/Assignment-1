import java.util.*;

public class Problem1 {
    public static int maxCyclicSubstringSum(String s) {
        int n = s.length();
        String doubled = s + s;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;
        for (int right = 0; right < doubled.length(); right++) {
            char ch = doubled.charAt(right);
            while (set.contains(ch) || (right - left + 1) > n) {
                char leftChar = doubled.charAt(left);
                set.remove(leftChar);
                currentSum -= (leftChar - 'a' + 1);
                left++;
            }
            set.add(ch);
            currentSum += (ch - 'a' + 1);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(maxCyclicSubstringSum(s));
    }
}
