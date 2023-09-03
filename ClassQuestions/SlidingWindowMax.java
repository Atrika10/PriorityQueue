import java.util.*;
public class SlidingWindowMax {

    // TC = >  O(N * K * log K)
    // maximum of all subarrays of size k
    public static void maxSubArrOfSizeK(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // will get max
        ArrayList<Integer> Al = new ArrayList<>();

        int j =0; int temp = k;
        for (int i = 0; i < arr.length; i++) {
            if (j != arr.length) {
                j =i; temp = k;

                while (temp!=0) {           // O(k) => constant time
                    pq.add(arr[j]); j++; temp--;
                }
                Al.add(pq.remove()); // add max element of pq
                // do empty pq
                while (!pq.isEmpty()) {     // O(K * log K) time, where K is the maximum value of k.
                    pq.remove();
                }
            }
        }
        for (int i = 0; i < Al.size(); i++) {
            System.out.print(Al.get(i) + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7}; // 3,3, 5, 5,6,7
        int k=3;
        maxSubArrOfSizeK(arr, k);
    }
}
