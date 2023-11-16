package SWEA.D2;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 단순 구현 - 홀수 짝수 판별하기
 */
public class SW_1986 {

    public static void main(String args[]) throws Exception
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int result = 0;

            for(int i = 1; i <= n; i++){
                if(i % 2 == 1) result += i;
                else result -= i;
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
