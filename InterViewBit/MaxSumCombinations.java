import java.util.*;
public class MaxSumCombinations {

    public static int[] solve(int[] A, int[] B, int C) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                pq.add(sum);
            }
        }
        int ans[] = new int[C]; int i=0;
        while (!pq.isEmpty() && C != 0) {
            ans[i] = pq.remove();
            i++;
            C--;
        }
        for (int j = 0; j < ans.length; j++) {
            System.out.print(ans[j]  + " ");
        }
        System.out.println();
        return ans;
    }

    public static void main(String[] args) {
        int A[] = {  59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83};
        int B[] = { 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83 };
        int c =10;
        solve(A, B, c);
    }

}
