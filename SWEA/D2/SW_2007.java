package SWEA.D2;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 반복되는 문자열을 구하기 위해서는 처음 등장하는 문자를 구하고 그 이후에 같은 문자가 나온다면 그전까지를 끊어내는 것을 반복해서 각각의 문자열로 나눈다.
 *              result 문자열에는 첫 번째 문자열을 넣어둔다.
 *              그리고 첫 번째 문자열과 두 번째 문자열을 비교하여 다르다면 result에 이어붙인 문자열을 저장하고 같다면 temp에 이어붙인 값을 이어붙인다.
 *              이후 3,4번째 문자열의 합과 result가 같다면 result를 반환하고 다르다면
 *              첫 번째 문자열과 세 번쨰 문자열을 비교하여 다르다면 result에 이어붙이고 같다면 temp에 이어붙이고 temp2에 result에 이어붙인건 저장한다.
 */
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
