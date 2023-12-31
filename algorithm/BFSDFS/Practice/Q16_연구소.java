package algorithm.BFSDFS.Practice;

import java.util.*;
import java.io.*;

/**
 *  어려움 : 2차원 배열에서 조합(Combination)으로 3개의 점을 구하는데 어려움을 겪었다.
 *              -> 2중 for문으로 하나의 점을 잡고 count를 세는 로직과 dfs의 재귀를 통해 해결할 수 있었다.
 *              -> 위의 함수로 하나의 점을 구했다면 재귀를 통해서 그 이후의 점들을 구해나감으로써 콤비네이션을 구현할 수 있었다(if문을 통해서 count를 확인함으로써 동작 시킬지 결정).
 *
 *  얻어갈 아이디어 : 1. 0의 개수를 세는 것이기 때문에 바이러스를 dfs로 퍼트린 후에 전체에서 0의 개수를 세면 됨
 *
 *                2. 콤비네이션을 이용하여 초기 맵에서 3개의 점을 벽(1)으로 만들고 바이러스를 퍼트리기 때문에 0의 개수를 세고 원상태로 되돌리는 로직이 필요함
 *                   하지만 temp라는 임시 맵을 만들어서 사용하면 이러한 불필요한 제거 과정을 삭제할 수 있음
 *                   -> 제거해야 하는 로직이 필요하다면 그냥 임시값을 저장하는 변수를 선언해보는 건 어떨지 고민해보자!
 *
 *                3. 콤비네이션으로 3개의 점을 뽑을 경우 dfs 를 이용하여 count 변수로 현재 몇 개의 점을 뽑았는지 알리고
 *                   count 가 3이라면 로직을 실행하고 아니라면 하나의 점을 더 뽑고 재귀하는 방식으로 구현할 수 있다.
 */

public class Q16_연구소 {

    public static int n, m, result;
    public static int[][] arr = new int[8][8]; // 초기 맵 배열
    public static int[][] temp = new int[8][8]; // 벽을 설치한 뒤의 맵 배열

    // 4가지 이동 방향에 대한 배열
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    // 깊이 우선 탐색(DFS)을 이용해 각 바이러스가 사방으로 퍼지도록 하기
    public void virus(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 상, 하, 좌, 우 중에서 바이러스가 퍼질 수 있는 경우
            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (temp[nx][ny] == 0) {
                    // 해당 위치에 바이러스 배치하고, 다시 재귀적으로 수행
                    temp[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }
    }

    // 현재 맵에서 안전 영역의 크기 계산하는 메서드
    public int getScore(){

        int score = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(temp[i][j] == 0)
                    score++;
            }
        }
        return score;
    }

    public void dfs(int count){

        if(count == 3){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = arr[i][j];
                }
            }

            // 각 바이러스의 위치에서 전파 진행
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 2) {
                        virus(i, j);
                    }
                }
            }

            int score = getScore();
            result = Integer.max(result, score);

            // 중요 -> return이 없으면 아랫부분이 끝까지 실행됨
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j =0; j < m; j++){
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    count++;
                    dfs(count);
                    arr[i][j] = 0;
                    count--;
                }
            }
        }

        return;
    }
    public void solution() throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        new Q16_연구소().solution();
    }

}
