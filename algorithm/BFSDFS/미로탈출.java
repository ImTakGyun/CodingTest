package algorithm.BFSDFS;

import java.util.*;
import java.io.*;

/**
 * 동빈이는 N x M 크기의 직사각형 형태의 미로에 갇혀 있다. 미로에는 여러 마리의 괴물이 있어 이 를 피해 탈출해야 한다.
 * 동빈이의 위치는 (1,1)이고 미로의 출구는 (N, M)의 위치에 존재하며 한 번에 한 칸씩 이동할 수 있다.
 * 이때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있 다. 미로는 반드시 탈출할 수 있는 형태로 제시된다.
 * 이때 동빈이가 탈출하기 위해 움직여야 하는 최 소 칸의 개수를 구하시오. 칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산한다.
 *
 * 입력 조건) • 첫째 줄에 두 정수 N, M(4 ≤ N, M ≤ 200)이 주어집니다.다음 N개의 줄에는 각각M개의 정수(0 혹은 1)로 미로의 정보가 주어진다.
 * 각각의 수들은 공백 없이 붙어서 입력으로 제시된다. 또한 시작 칸 과 마지막 칸은 항상 1이다.
 * 출력 조건) • 첫째 줄에 최소 이동 칸의 개수를 출력한다.
 */

class Node{
    private int x;
    private int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}

public class 미로탈출 {

    public int n = 0, m = 0;
    public int[][] map = new int[200][200];

    //BFS에서의 이동할 네가지 방향 정의 (상, 하 ,좌, 우) -> 넓이 우선 탐색이기 때문에 방향에 크게 구애받지 않는다.
    public int bfs_dx[] = {-1, 1, 0, 0};
    public int bfs_dy[] = {0, 0, -1, 1};

    //DFS에서의 이동할 네가지 방향 정의 (시계 방향(우, 하, 좌, 상)) -> 깊이 우선 탐색이기 때문에 시작 방향 선택이 중요하다.
    public int dfs_dx[] = {0, 1, 0, -1};
    public int dfs_dy[] = {1, 0, -1, 0};

    public int bfs(int x, int y){

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        //큐가 빌 때까지 반복하기
        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            //현재 위치에서 4가지 방향으로의 위치 확인
            for(int i = 0; i < 4; i++){
                int nx = x + bfs_dx[i];
                int ny = y + bfs_dy[i];

                //지도의 범위를 벗어나는 경우
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                //벽인 경우
                if(map[nx][ny] == 0) continue;
                //해당 노드를 처음 방문하는 경우
                if(map[nx][ny] == 1){
                    map[nx][ny] = map[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return map[n-1][m-1];
    }

    public int dfs(int x, int y){

        for(int i = 0; i < 4; i++){
            int nx = x + dfs_dx[i];
            int ny = y + dfs_dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(map[nx][ny] == 0) continue;
            if(map[nx][ny] == 1){
                map[nx][ny] = map[x][y] + 1;

//                for(int a = 0; a < n; a++){
//                    for(int b = 0; b < m; b++){
//                        System.out.print(map[a][b]);
//                    }
//                    System.out.println();
//                }
                dfs(nx, ny);
            }
        }
        return map[n-1][m-1];
    }

    public void solution() throws IOException{

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i =0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

//      System.out.print(bfs(0,0));
        System.out.print(dfs(0,0));
    }

    public static void main(String[] args) throws IOException {
        new 미로탈출().solution();
    }
}
