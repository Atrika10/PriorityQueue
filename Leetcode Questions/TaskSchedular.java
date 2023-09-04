import java.util.*;
public class TaskSchedular {

    // Time complexity => O(nlogn)
    /* Space complexity => O(1) [The space used by the pq & hm is proportional to the number of unique characters, which is at most 26 (for lowercase English letters).
       So, the space used here is O(26), which simplifies to O(1) since it's a constant.] */

    public static class pair implements Comparable<pair>{
        char ch;
        int freq;

        public pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
        @Override
        public int compareTo(pair p2){
            return p2.freq - this.freq;
        }
    }

    
    public static int leastInterval(char[] tasks, int n) {
        // step -1 calculate freq of each char
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) { // O(n)
            hm.put(tasks[i], hm.getOrDefault(tasks[i], 0)+1); // O(1)
        }

        // step -2 
        // add all char with their occurence in a pq
        PriorityQueue<pair> pq = new PriorityQueue<>();

        Set<Character> keys = hm.keySet();
        for (Character ch : keys) {                  // O(nlogn)
            pq.add(new pair(ch, hm.get(ch)));       // add in pq will take O(logn)
        }

        // step -3
        // I've to pick highest freq
        int maxFreq = pq.remove().freq;
        int noOfCycle = maxFreq-1;
        int idealSpace = noOfCycle*n;   // n = cool down period (I've divide each no of cycle by n to get total idealSpace)

        // step -4 pick each char from pq & subtract freq of each char from idealSpace
        while (!pq.isEmpty()) {                   //O(nlogn)
            pair p = pq.remove();               // O(logn)
            int min = Math.min(p.freq, noOfCycle);
            idealSpace -= min;
        }

        // step -5
        /* If my idealSpace becomes negative or zero means I don't have to wait a single unit of time
         * I can return the length of the tasks array, else I have to return idealSpace + length of tasks arr
          */
        return (idealSpace <=0) ? tasks.length : idealSpace + tasks.length;
    }
    public static void main(String[] args) {
        char tasks[] = {'A','A','A','B','B','B'}, n = 2;
        System.out.println(leastInterval(tasks, n));
    }
}
