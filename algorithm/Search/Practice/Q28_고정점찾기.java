package algorithm.Search.Practice;

import java.util.*;
import java.io.*;

public class Q28_고정점찾기 {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n -1;
        int result = -1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == mid) result = arr[mid];
            if(arr[mid] < mid) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException{
        new Q28_고정점찾기().solution();
    }
}
