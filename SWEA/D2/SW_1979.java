package SWEA.D2;

import java.io.*;
import java.util.*;

/**
 *  핵심 Point : <1이 등장하면 cnt를 올리고 0이나 범위 밖이라면 쌓여있는 cnt를 확인하여 k라면 result를 +1해준다.>
 */
public class SW_1979 {

    public static int[][] arr;

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

            arr = new int[n][n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;

            for(int i = 0; i < arr.length; i++){
                int cnt_x = 0;  // 각각의 행에서 K길이의 문자가 들어갈 공간이 있는지 확인하기 위한 저장공간
                int cnt_y = 0;  // 각각의 열에서 K길이의 문자가 들어갈 공간이 있는지 확인하기 위한 저장공간
                for(int j = 0; j < arr.length; j++){

                    // <각각의 행>을 살피면서 1이 등장하면 k에 대한 만족을 확인하기 위한 cnt_x를 +1,
                    // 0이 등장하면 cnt_x == k 인지 확인하고 맞다면 result++ 하고 cnt_x를 0으로 보낸다, 아니라면 그냥 cnt_x를 0으로 보낸다.
                    // 또 마지막 칸에 대한 조사가 이루어지면 위의 과정을 진행한다.
                    if(arr[i][j] == 1){
                        cnt_x++;
                    }
                    if(arr[i][j] == 0 || j == (arr.length - 1)){
                        if(cnt_x == k) result++;
                        cnt_x = 0;
                    }

                    // <각각의 열>을 살피면서 1이 등장하면 k에 대한 만족을 확인하기 위한 cnt_x를 +1,
                    // 0이 등장하면 cnt_x == k 인지 확인하고 맞다면 result++ 하고 cnt_x를 0으로 보낸다, 아니라면 그냥 cnt_x를 0으로 보낸다.
                    // 또 마지막 칸에 대한 조사가 이루어지면 위의 과정을 진행한다.
                    if(arr[j][i] == 1){
                        cnt_y++;
                    }
                    if(arr[j][i] == 0 || j == (arr.length - 1)){
                        if(cnt_y == k) result++;
                        cnt_y = 0;
                    }
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }

}
