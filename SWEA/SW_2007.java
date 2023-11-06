package SWEA;

import java.util.*;
import java.io.*;

public class SW_2007 {
    public static void main(String args[]) throws Exception
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int  T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = br.readLine();

            String[] arr = new String[30];
            Arrays.fill(arr, "");

            char s = str.charAt(0);
            int start = 0;
            int end = 0;
            int num = 0;

            for(int i = 1; i < str.length(); i++){

                if(str.charAt(i) == s){
                    end = i;
                    arr[num] = str.substring(start, end);
                    start = end;
                    num++;
                }
            }

            StringBuilder result = new StringBuilder(arr[0]);

            for(int i = 1; i < arr.length; i++){
                if(arr[0].equals(arr[i])) break;
                else if(arr[i].equals(" "))break;
                else result.append(arr[i]);
            }

            System.out.println("#" + test_case + " " + result.length());
        }
    }
}
