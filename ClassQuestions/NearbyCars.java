import java.util.*;
public class NearbyCars{

    public static class cars implements Comparable<cars>{
        int idx;
        int dist;

        public cars(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(cars c2){
            return this.dist - c2.dist; // min distance will come first
        }
    }

    public static void kNearestCars(int points[][], int k){
        PriorityQueue<cars> pq = new PriorityQueue<>();

        for (int i = 0; i < points.length; i++) {
            // calculate distance
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1] ; // As I'm standing at origin, so I don't need to minus 0
            pq.add(new cars(i, dist));
        }

        // print
        while (k!=0) {
            System.out.println("C"+ pq.remove().idx);
            k--;
        }
    }
    public static void main(String[] args) {
        int points[][] = {{3,3},{5,-1},{-2,4}}, k=2;
        kNearestCars(points, k);
    }
}