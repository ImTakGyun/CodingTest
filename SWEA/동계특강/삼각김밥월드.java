package SWEA.동계특강;

import java.util.*;
import java.io.*;
public class 삼각김밥월드 {

    public static int s;
    public static int e;
    public static int s_x;
    public static int s_y;
    public static int e_x;
    public static int e_y;

    public static int[][] arr = new int[151][151];

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T  = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());


            int value = 1;

            for(int i = 1; i < 151; i++){
                for(int j = 1; j <= i; j++){
                    arr[i][j] = value++;

                    if(arr[i][j] == s) {
                        s_x = i;
                        s_y = j;
                    }

                    if(arr[i][j] == e) {
                        e_x = i;
                        e_y = j;
                    }
                }
            }

            int row = 0;
            int column = 0;
            int result = 0;

            if((s_x < e_x && s_y > e_y) || (s_x > e_x && s_y < e_y)){
                row = Math.abs(s_x - e_x);
                column = Math.abs(s_y - e_y);
                result = row + column;
            } else {
                row = Math.abs(s_x - e_x);
                column = Math.abs(s_y - e_y);
                result = Math.min(row, column) + Math.abs(row - column);
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
