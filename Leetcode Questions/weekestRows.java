import java.util.*;
public class weekestRows {

    static class pair implements Comparable<pair>{
        int idx;
        int ones;
        pair(int i, int ones){
            this.idx = i;
            this.ones = ones;
        }
        @Override
        public int compareTo(pair p2) {
            
            if(p2.ones == this.ones){
                return this.idx - p2.idx; // if soldiers are same then return on the basis of index
            }
            else{
                return this.ones - p2.ones;     // else return whose soldiers are less
            }
        }
        
    }
    public static int[] kWeakestRowsLC(int[][] mat, int k) {
        // create a pq & add 1's of each rows
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1){
                    count++;
                }
            }
            pq.add(new pair(i, count));
        }

        int arr[] = new int[k];
        for(int i=0; i<k; i++){
            arr[i] = pq.remove().idx; 
        }
        return arr;
    }

    public static ArrayList<Integer> kWeakestRows(int[][] mat, int k) {
        // create a pq & add 1's of each rows
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1){
                    count++;
                }
            }
            pq.add(new pair(i, count));
        }

        // Comparing weekest row
        ArrayList<Integer> al = new ArrayList<>();
        while (pq.size() > 1 && k > 0) {
            pair min1 = pq.remove();
            pair min2 = pq.remove();

            if(min1.ones < min2.ones || min1.idx < min2.idx){
                al.add(min1.idx);
                pq.add(min2);
            }
            else {      
                al.add(min2.idx);
                pq.add(min1);
            }
            k--;
            
        }
        if(k > 0){  // if still k left
            al.add(pq.remove().idx);
            k--;
        }
        return al;

    }
    public static void main(String[] args) {
        int mat[][] = {{1,1,0,0,0},
                       {1,1,1,1,0},
                       {1,0,0,0,0},
                       {1,1,0,0,0},
                       {1,1,1,1,1}};
        int k = 3;
        ArrayList<Integer> al =  new ArrayList<>();
        al = kWeakestRows(mat, k);
         System.out.println(al);

        int arr[] = new int[k];
        arr = kWeakestRowsLC(mat, k);

        // print
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ->");
        }
    }
}
