import java.util.*;
public class RemovingStone {

    public static int maximumScore(int a, int b, int c) {
        // Edge cases
        if ((a==0 && b==0) || (a==0 && c==0) || (c==0 && b==0)) {
            return 0; // I can't play the game as I would have to pick 2 stones in each turn
        }
        int score =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // decending order
        pq.add(a);
        pq.add(b);
        pq.add(c);

        while (pq.size()>1) {
            int firstStone = pq.remove();
            firstStone--;
            int secondStone = pq.remove();
            secondStone--;

            score++;
            if (firstStone != 0) {  // as it's not become zero, still I can pick stone in the next time
                pq.add(firstStone); 
            }
            if (secondStone != 0) {
                pq.add(secondStone);
            }
        }
        return score;
    }
    public static void main(String[] args) {
        int a = 0, b = 0, c = 6;
        System.out.println(maximumScore(a, b, c));
    }
}
