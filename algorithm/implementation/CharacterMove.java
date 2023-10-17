package algorithm.implementation;

import java.util.*;
import java.io.*;

public class CharacterMove {

    static int n,m;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int x,y, dirc;

    public static void turn_left(){
        dirc -= 1;
        if(dirc == -1) dirc = 3;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        dirc = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];
        visited[x][y] = 1;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(r.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int nx = 0, ny = 0;
        int count = 0;

        while(true) {
            // 네 방향을 관측하며 이동이 가능한지 확인후 이동 가능하다면 해당 지역으로 이동한다.
            for (int i = 0; i < 4; i++) {
                turn_left();
                nx = x + dx[dirc];
                ny = y + dy[dirc];

                if(map[nx][ny] == 0 && visited[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    visited[x][y] = 1;
                    count++;
                    break;
                }
            }

            // 이동 완료 했다면 반복한다.
            if(x == nx && y == ny) continue;

            // 이동이 불가능하다면 뒤로 한 칸 이동한다.
            int back = (dirc + 2) % 4;

            nx = x + dx[back];
            ny = y + dy[back];

            // 뒤로 한 칸 이동시에 해당 지역이 바다라면 움직임을 멈춘다.
            if(map[nx][ny] == 1) break;
            // 바다가 아니라면 뒤로 한 칸 이동 후 움직임을 카운트한다.
            else {
                x = nx;
                y = ny;
                count++;
            }
        }

        System.out.println(count);
    }
}
