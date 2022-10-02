package graph.classical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationGeneral {
    public static void main(String[] args) {
        Cnm(5, 3);
    }

    public static void Cnm(int n, int m) {
        if (n < m) return;
        int[] A = new int[n];
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
//        A = new int[]{2, 2, 1, 1};
        Arrays.sort(A);

        List<List<Integer>> res = new ArrayList<>();
        int[] available = new int[A.length];
        for(int i = 0; i < available.length; i++) {
            available[i] = 1;
        }
        dfs(0, A, available, new ArrayList<>(), res, m);
        System.out.println("CombinationGeneral");
        System.out.println(res);
        System.out.println(String.format("Cm/n=n!/m!*(n-m)!"));
        System.out.println(String.format("C%s/%s=%s", m, A.length, res.size()));
    }

    public static void dfs(int start, int[] A, int[] available, List<Integer> list, List<List<Integer>> res, int m) {
        if (list.size() == m) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < A.length; i++) {
            if (i > start && A[i] == A[i - 1] && available[i - 1] > 0) {
                continue;
            }
            
            if (available[i] > 0) {
                list.add(A[i]);
                available[i]--;
                dfs(i + 1, A, available, list, res, m);
                available[i]++;
                list.remove(list.size() - 1);
            }
        }
    }
}
