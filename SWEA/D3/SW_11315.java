package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 시뮬레이션 문제 -> 주어진 조건에 따라 구현하면 된다.
 *                             핵심은 오목이 될 방향을 설정하는 것이었다.
 */
public class SW_11315 {

    public static int[][] arr;

    // 동, 남, 남동, 남서
    public static int[] dx = {0, 1, 1, 1};
    public static int[] dy = {1, 0, 1, -1};

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            arr = new int[n][n];

            for(int i = 0; i < n; i++){
                String str = br.readLine();

                for(int j = 0; j < n; j++){
                    if(str.charAt(j) == '.') arr[i][j] = 0;
                    else arr[i][j] = 1;
                }
            }

            String result = "NO";

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] == 0) continue;
                    for(int dr = 0; dr < 4; dr++){
                        int check = 1;
                        int x = i;
                        int y = j;

                        for(int k = 0; k < 4; k++){
                            int nx = x + dx[dr];
                            int ny = y + dy[dr];
                            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if (arr[nx][ny] == 1) {
                                    x = nx;
                                    y = ny;
                                    check++;
                                } else break;
                            }
                            else break;
                        }

                        if(check == 5) {
                            result = "YES";
                            break;
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + result);

        }
    }

}
