import java.util.*;

public class ReduceArray {

    public static class pair implements Comparable<pair> {
        int key;
        int value; // no of occurences

        pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        // I want highest value first, So that I can remove hishest occurences from the
        // array to get minset size
        @Override
        public int compareTo(pair p2) {
            return p2.value - this.value;
        }
    }

    public static int minSetSize(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>(); // create Hashmap to store each unique element with their
                                                        // occurences

        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1); // getOrDefault means, if I have the key in hm I'll pick
                                                            // that value & add 1 with it otherwise, will add 0+1 (For
                                                            // the first time of any ekement )
            System.out.println("hm");
        }

        PriorityQueue<pair> pq = new PriorityQueue<>();

        // Iterate on Hashmap
        Set<Integer> keys = hm.keySet();
        for (Integer k : keys) {
            // k is my key each time
            pq.add(new pair(k, hm.get(k)));
            System.out.println("keyset");
        }
        // Now I've to reduce the size atleast half by removing min set of integers
        int n = arr.length;
        int count = 0;
        while (!pq.isEmpty()) {
            System.out.println("pq");
            if (n > arr.length / 2) {
                pair p = pq.remove();
                n -= p.value; // removing occurences from length of the arr
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 };
        System.out.println(minSetSize(arr));
    }

}
