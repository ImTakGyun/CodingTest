package algorithm.Sort.Practice;

import java.io.*;
import java.util.*;

public class Q24_안테나 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        System.out.println(list.get((n-1)/2));
    }

    public static void main(String[] args) throws IOException{
        new Q24_안테나().solution();
    }
}
