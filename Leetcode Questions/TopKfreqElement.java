import java.util.*;
public class TopKfreqElement {

    public static class pair implements Comparable<pair> {
        int value;
        int freq;
        public pair(int value, int freq){
            this.value = value;
            this.freq = freq;
        }
        @Override
        public int compareTo(pair p2){
            return p2.freq - this.freq;
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // edge case
        if (nums.length < k || k==0) {
            return new int[0];  // return empty
        }

        int ans[] = new int[k];
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1 ); 
        }

        PriorityQueue<pair> pq = new PriorityQueue<>();

        for (Integer mykey : hm.keySet()) {   // O(n)
            pq.add(new pair(mykey, hm.get(mykey)));
        }

        while (k!=0) {
            pair p = pq.remove();
            ans[k-1] = p.value;
            k--;
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3}; int k=2;
        topKFrequent(nums, k);
    }
}
