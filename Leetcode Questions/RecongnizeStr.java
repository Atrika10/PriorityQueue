import java.util.*;

public class RecongnizeStr {

    public static class pair implements Comparable<pair> {
        char ch;
        int freq;

        pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        @Override
        public int compareTo(pair p2) {
            return p2.freq - this.freq;
        }
    }

    public static String reorganizeString(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<pair> pq = new PriorityQueue<>();
        Set<Character> keys = hm.keySet();
        for (Character c : keys) {
            pq.add(new pair(c, hm.get(c)));
        }

        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while (!pq.isEmpty()) {
            pair p = pq.remove();
            if (i == 0) {
                sb.append(p.ch);
                i++;
                p.freq--;
            } else {
                if (sb.charAt(i - 1) != p.ch) { // I can append this char
                    sb.append(p.ch);
                    i++;
                    p.freq--;
                } else if (pq.isEmpty()) { // if 2 char are same & we have no more char, so we can return ""
                    return "";
                } else {
                    pair p1 = pq.remove();
                    sb.append(p1.ch);
                    i++;
                    p1.freq--;
                    if (p1.freq > 0) {
                        pq.add(new pair(p1.ch, p1.freq));
                    }
                }
            }
            if (p.freq > 0) {
                pq.add(new pair(p.ch, p.freq));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaab"; // aba
        System.out.println(reorganizeString(s));
    }
}
