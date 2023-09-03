import java.util.*;
public class WeekestSoldiers {

    public static class Soldiers implements Comparable<Soldiers>{
        int row;
        int noOfSoldiers;

        public Soldiers(int i, int noOfSoldiers){
            this.row = i;
            this.noOfSoldiers = noOfSoldiers;
        }

        // sorting logic
        @Override
        public int compareTo(Soldiers s2){
            if (this.noOfSoldiers == s2.noOfSoldiers) {
                return this.row - s2.row;   // return on the basis of idx
            }else{
                return this.noOfSoldiers - s2.noOfSoldiers;   // return that row which is having lesser no of soldiers
            }
        }
    }

    public static void findKWeekestRow(int matrix[][], int k){
        PriorityQueue<Soldiers> pq = new PriorityQueue<>();
        // add index & no of soldiers in pq
        for (int i = 0; i < matrix.length; i++) {
            int count =0;
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1){
                    count++;
                }
            }
            pq.add(new Soldiers(i, count));
        }

        while (k!=0) {
            System.out.println("row" + pq.remove().row); k--;
        }

    }

    public static void main(String[] args) {
        int matrix[][] = {{1,0,0,0}, {1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k =2;
        findKWeekestRow(matrix, k);
    }
    
}
