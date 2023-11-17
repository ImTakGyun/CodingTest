package SWEA.D4;

import java.util.*;
import java.io.*;

public class SW_1486 {
    public static int n;
    public static int b;
    public static int[] arr;
    public static ArrayList<Integer> height;

    public static void dfs(int index, int sum){

        if(index == n){
            if(sum >= b){
                height.add(sum);
            }
            return;
        }

        dfs(index + 1, sum + arr[index]);
        dfs(index + 1, sum);
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T  = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr = new int[n];
            height = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            Collections.sort(height);

            System.out.println("#" + test_case + " " + (height.get(0) - b));
        }
    }
}
