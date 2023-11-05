package SWEA;

import java.util.*;
import java.io.*;

/**
 *  <핵심 Point> : <기존 DFS 방식에서 방향만 따로 정해서 반복하기.>
 *                  (1) 기존의 DFS 방식을 이용하면 네 방향을 모두 체크하기 때문에 방향을 정하는 것은 독립적으로 작성해준다.
 *                  (2) 우선 방향은 동, 남, 서, 북으로 지정해주고 방향을 지정해주는 dr을 생성해준다.
 *                  (3) 처음에는 동쪽을 기준으로 숫자를 쌓아나가고 위치가 범위를 벗어나게 되면 dr을 +1 하여 남쪽으로 진행되도록 한다.
 *                  (4) 이렇게 일정 방향으로 진행하다가 범위를 벗어나거나 해당 위치에 이미 숫자가 기록되어 있다면 방향을 바꿔서 반복하는 로직으로 문제를 해결한다.
 */

public class SW_1954 {

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int dr = 0;
    public static int[][] arr;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        arr[0][0] = 1;
        int x = 0;
        int y = 0;
        int cnt = 1;
        int nx = 0, ny = 0;
        while(cnt < n*n) {
            nx = x + dx[dr];
            ny = y + dy[dr];

            if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr.length && arr[nx][ny] == 0) {
                arr[nx][ny] = arr[x][y] + 1;
                cnt++;
                x = nx;
                y = ny;
            } else {
                dr = (dr + 1) % 4;
            }
        }
//        dfs(0, 0);

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
