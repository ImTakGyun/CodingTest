package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 단순 구현 -> 박스를 0으로 초기화하고 각 작업의 시작-끝을 저장후 해당 범위에 해당 작업이 몇 번째 작업인지에 대한 값으로 update 해준다.
 */
public class SW_5789 {

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[] boxes = new int[n+1];
            int[][] arr = new int[q][2];

            for(int i = 0; i < q; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < q; i++){
                int start = arr[i][0];
                int end = arr[i][1];

                for(int j = start; j < end + 1; j++){
                    boxes[j] = i+1;
                }
            }

            System.out.print("#" + test_case + " ");
            for(int i = 1; i < n+1; i++){
                System.out.print(boxes[i] + " ");
            }
            System.out.println();
        }
    }

}
