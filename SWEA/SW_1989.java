package SWEA;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : <앞에서부터, 뒤에서부터 비교한다.>
 */
public class SW_1989 {

    public static String str = "";
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            str = br.readLine();

            int check = 1;

            for(int i = 0; i < (str.length() + 1) / 2; i++){
                if(str.charAt(i) == str.charAt(str.length() - 1 - i)) continue;
                else check = 0;
            }

            System.out.println("#" + test_case + " " + check);
        }
    }

}
