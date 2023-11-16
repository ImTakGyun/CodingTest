package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 시뮬레이션 문제 -> 주어진 조건에 따라 구현하면 된다.
 *                             핵심은 오목이 될 방향을 설정하는 것이었다.
 */
public class SW_11315 {

    public static char[][] arr;
    public static int n;
    public static String result;

    public static int[] dx = {0, 1 ,1, 1};
    public static int[] dy = {1, -1, 0, 1};

    public static void dfs(int x, int y, int count, int dr) {

        if(count == 5) {
            result = "YES";
            return;
        }

        int nx = x + dx[dr];
        int ny = y + dy[dr];

        if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
            if(arr[nx][ny] == 'o'){
                int c = count + 1;
                dfs(nx, ny, c, dr);
                if(result == "YES") return;
            }
            else return;
        }
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            result = "NO";

            arr = new char[n][n];

            for(int i = 0; i < n; i++) {
                String str = br.readLine();
                for(int j = 0; j < n; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] == 'o'){
                        for(int k = 0; k < 4; k++) {
                            dfs(i, j, 1, k);
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
