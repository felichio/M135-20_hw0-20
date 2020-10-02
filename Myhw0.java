import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
class Myhw0 {
    public static HashMap<Integer, HashMap<Integer, Integer>> s = new HashMap<>();
    public static ArrayList<Map.Entry<Integer, Integer>> v = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] q = in.next().split("[|]"); // Regex use literal |, bracket use or backslash escaping
            int k1 = Integer.parseInt(q[0]);
            if (!s.containsKey(k1)) {
                HashMap<Integer, Integer> w = new HashMap<>();
                s.put(k1, w);
            }
            int k2 = Integer.parseInt(q[1]);
            if (!s.get(k1).containsKey(k2)) {
                s.get(k1).put(k2, s.get(k1).size() + 1); // Same logic as in cpp, the values of the inner keys give us X in [X of Y]
            }
            v.add(Map.entry(k1, k2)); // List storage for linear processing (printing in insertion order) afterwards 
        }
        v.forEach(p -> { // use of a lambda expression, utilizing a functional interface
            int key = p.getKey();
            int val = p.getValue();
            System.out.println(key + "|" + val + "[" + s.get(key).get(val) + " of " + s.get(key).size() + "]");
        });
    }
}
