package Bakjoon.Implementation;

import java.util.*;
import java.io.*;

/**
 * 회고 : 밖에서 안으로 말려들어오는 달팽이 문제의 경우 방향 전환을 일으키는 트리거가 명확하여 쉬웠다.
 *       하지만, 이 문제와 같이 안에서 밖으로 나가는 달팽이 문제는 방향 전환을 위한 트리거가 없어서 많이 헤맸다.
 *       방향 전화을 해야하지만, 마땅한 트리거가 생각이 나지 않는다면 이 문제처럼
 *       <수학적 규칙성> 을 찾아보면 좋을 것 같다.
 *       이 문제의 경우 언제나 이동이 2번씩 반복된다.(북과 동, 남과 서로 1,2,3 ... n-1칸 움직이는 것이 반복)
 *       그리고 마지막 n-1칸 이동시에 북쪽을 향한 움직임을 추가하면 된다.
 *
 *       수학적 규칙성을 찾기 이전에 움직인 후 정면과 양 옆이 비어있다면 방향을 전환한다는 조건도 생각해보았지만, 오히려 복잡한 방법인 것 같다.
 *       수학적 규칙성을 찾을 수 있다면 보다 쉬운 구현이 가능하기에 이를 찾기 위한 노력을 진행하고 구현을 위한 노력을 하면 될 것 같다.
 */

public class B_1913 {

    public static int[][] arr;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        int x = n/2;
        int y = n/2;

        arr[x][y] = 1;
        int dr = 0;
        int nx = x;
        int ny = y;

        for(int i = 1; i < n; i++){
            for(int k = 0; k < 2; k++) {
                for (int j = 0; j < i; j++) {
                    nx += dx[dr];
                    ny += dy[dr];
                    arr[nx][ny] = arr[x][y] + 1;
                    x = nx;
                    y = ny;
                }

                dr = (dr + 1) % 4;
            }

            if(i == n-1){
                for(int j = 0; j < i; j++){
                    nx += dx[dr];
                    ny += dy[dr];
                    arr[nx][ny] = arr[x][y] + 1;
                    x = nx;
                    y = ny;
                }
            }
        }

        int result_x = -1;
        int result_y = -1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == num){
                    result_x = i;
                    result_y = j;
                }
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append((result_x + 1) + " " + (result_y + 1));
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new B_1913().solution();
    }
}
