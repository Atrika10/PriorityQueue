import java.util.*;
public class ConnectNRopes {

    // Time complexity of this code is O(nlogn), where n is the number of ropes
    public static int minCost(int ropes[]){
        int cost =0;
        // add all element in a pq, as I want to peek smallest element each time
        PriorityQueue<Integer> pq = new PriorityQueue<>();

         // O(n*logn)
        for (int i = 0; i < ropes.length; i++) {   // O(n)
            pq.add(ropes[i]);                       // O(logn)
        }

        // O((n-1)*logn)
        while (pq.size()>1) {
            int min1 = pq.remove();         // O(logn)
            int min2 = pq.remove();         // O(logn)
            int sum = min1+min2;
            cost+= sum;
            pq.add(sum);                    // O(logn)
        }
        return cost;
    }

    public static void main(String[] args) {
        int ropes[] = {4,3,2,6};
        System.out.println(minCost(ropes));
    }
    
}
