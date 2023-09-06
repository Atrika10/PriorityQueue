import java.util.*;
public class KthLargest {

    // Time complexity of this code is O(nlogn)
    public static int findKthLargest(int[] nums, int k) {
        if (nums.length < k || k==0) {
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int value =0;

        // O(nlogn)
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);  //O(logn)
        }

        // O(nlogn)
        while (k!=0) {
            value = pq.remove(); // O(logn)
            k--;
        }
        return value;
    }
    public static void main(String[] args) {
        int nusm[] = {3,2,3,1,2,4,5,5,6}; int k=4;
        System.out.println(findKthLargest(nusm, k));
    }
}
