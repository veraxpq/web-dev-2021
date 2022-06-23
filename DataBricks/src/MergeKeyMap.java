import java.util.ArrayList;
import java.util.List;

public class MergeKeyMap {
    public static void main(String[] args) {
        List<Pair> f1 = new ArrayList<>();
        f1.add(new Pair("aaa", 1));
        f1.add(new Pair("bbb", 5));
        f1.add(new Pair("bbb", 3));
        f1.add(new Pair("ccc", 2));
        List<Pair> f2 = new ArrayList<>();
        f2.add(new Pair("bbb", 9));
        f2.add(new Pair("ccc", 10));
        f2.add(new Pair("ddd", 11));

        List<Pair> res = mergePair(f1, f2);
        for (Pair p : res) {
            System.out.println("key: " + p.key + ", value: " + p.value);
        }

    }
    private static List<Pair> mergePair(List<Pair> p1, List<Pair> p2) {
        int i = 0;
        int j = 0;
        List<Pair> res = new ArrayList<>();
        int len1 = p1.size();
        int len2 = p2.size();
        if (p1.get(i).key.compareTo(p2.get(j).key) <= 0) {
            res.add(new Pair(p1.get(i).key, p1.get(i).value));
            i++;
        } else {
            res.add(new Pair(p2.get(j).key, p2.get(j).value));
            j++;
        }
        while (i < len1 || j < len2) {
            System.out.println(i);
            System.out.println(j);
            if (i == len1) {
                helper(p2, j++, res);
            } else if (j == len2) {
                helper(p1, i++, res);
            } else if (p1.get(i).key.compareTo(p2.get(j).key) <= 0) {
                helper(p1, i++, res);
            } else {
                helper(p2, j++, res);
            }
        }
        return res;
    }
    private static void helper(List<Pair> p2, int j, List<Pair> res) {
        if (p2.get(j).key.equals(res.get(res.size() - 1).key)) {
            res.get(res.size() - 1).value += p2.get(j).value;
        } else {
            res.add(new Pair(p2.get(j).key, p2.get(j).value));
        }
    }
    static class Pair {
        String key;
        int value;
        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

