package SWEA.D2;

import java.util.*;
import java.io.*;

public class SW_1983 {

    public static int[] score;
    public static String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            score = new int[n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                score[i] = a * 35 + b * 45 + c * 20;
            }

            int k_score = score[k - 1];

            int rank = 1;

            for(int i = 0; i < n; i++){
                if(k_score < score[i]) rank++;
            }

            int g = ((rank - 1) / (n/10));

            System.out.println("#" + test_case + " " + grade[g]);


        }
    }
}
