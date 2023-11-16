package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 단순 구현 - 0,1이 변경되는 횟수
 */
class SW_1289 {
    public static int[] memory;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = br.readLine();

            int result = 0;

            memory = new int[str.length()];

            for(int i = 0; i < str.length(); i++) {
                memory[i] = str.charAt(i) - '0';
            }

            if(memory[0] == 1) result++;

            for(int i = 1; i < memory.length; i++) {
                if(memory[i - 1] != memory[i]) result++;
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
