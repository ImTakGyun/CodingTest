package Bakjoon.DFSBFS;

import java.util.*;
import java.io.*;

/**
 * 회고 : 처음에는 감이 잡히지 않았다.
 *       하지만 끈질기게 생각해본 결과, bfs를 통해 특정 국가와 연합을 이루는 국가들을 뽑아내고 인구를 이동시키면 된다는 생각이 들었다.
 *       따라서 연합을 이루고 인구 이동을 진행하였고,
 *       다른 연합이 존재하는 경우와 같은 연합에서도 bfs에 의해 연합으로의 특정 국가의 중복 참여를 막기 위해 방문한 국가는 방문 표시를 위한 visited 배열을 생성하였다.
 *       가장 고민했던 부분은, 인구 인동이 언제 종료되는지에 대한 종료 조건 설정이었다.
 *       인구 이동은 특정 횟수가 정해져 있지 않았기에 while문을 사용하였는데 종료 조건이 난감했던 것이다.
 *       따라서 종료 설정을 위해, 인구 이동이 진행되는 로직에 인구 이동이 진행되었는지에 대한 check point를 설정함으로써
 *       check point의 값을 보고 인구 이동이 있었는지 없었는지를 판단한 후, 없었다면 종료시키는 조건을 설정하였다.
 *
 * 핵심 Point : <종료 조건이 난감하다면 check point를 두고 종료의 여부를 확인할 수 있다.>
 *             <중복 방지와 구분을 위해 visited 배열을 사용할 수 있다.>
 */
class Country{
    private int x;
    private int y;
    private int p;

    Country(int x, int y, int p){
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getP() {
        return p;
    }
}

public class B_16234 {
    // 땅의 크기(N), L, R 값을 입력받기
    public int n, l, r;
    // 인구 이동에 걸린 일수를 저장
    public int days = 0;
    // 전체 나라의 정보(N x N)를 입력받기
    public int[][] A;
    // 각 나라의 방문 여부 저장
    public int[][] visited;
    // 인구 이동이 있었는지 확인
    public int check;
    // 방향
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0, -1};

    // 특정 국가의 위치에서 출발하여 연합을 체크한 뒤에 데이터 갱신
    public void bfs(Country country){
        // 국가의 위치
        int x = country.getX();
        int y = country.getY();

        // 방문 기록이 있다면 종료
        if(visited[x][y] == 1) return;

        // 방문하지 않은 국가라면(해당 나라가 아직 처리되지 않았다면) 연합 형성한 후 연합에 참가시키고 방문 기록
        ArrayList<Country> united= new ArrayList<>();
        united.add(country);
        visited[x][y] = 1;
        // 연합의 전체 인구 수 저장
        int summary = country.getP();

        // 너비 우선 탐색 (BFS)을 위한 큐 라이브러리 사용
        Queue<Country> q = new LinkedList<>();
        q.offer(country);

        // 큐가 빌 때까지 반복(BFS)
        while(!q.isEmpty()){
            Country c = q.poll();

            int cx = c.getX();
            int cy = c.getY();
            int cp = c.getP();
            int nx, ny;

            // 현재 위치에서 4가지 방향을 확인하며
            for(int i = 0; i < 4; i++){
                nx = cx + dx[i];
                ny = cy + dy[i];
                // 바로 옆에 있는 나라를 확인하여 방문 기록이 없다면
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] == 0){
                    int num = Math.abs(cp - A[nx][ny]);
                    // 옆에 있는 나라와 인구 차이가 L명 이상, R명 이하라면
                    if (num >= l && num <= r) {
                        // 연합에 추가하기
                        q.offer(new Country(nx, ny, A[nx][ny]));
                        united.add(new Country(nx, ny, A[nx][ny]));
                        // 연합의 총 인구수 업데이트
                        summary += A[nx][ny];
                        // 방문 기록 설정
                        visited[nx][ny] = 1;
                        // 인구 이동 여부 설정
                        check = 1;
                    }
                }
            }
        }

        // 연합 국가끼리 인구를 분배
        int avg = summary / united.size();
        for(Country country1 : united){
            int cx = country1.getX();
            int cy = country1.getY();

            A[cx][cy] = avg;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        A = new int[n][n];
        visited = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = 0;

        // 더 이상 인구 이동을 할 수 없을 때까지 반복
        while(true){
            // 인구 이동을 진행하기 위해 각 국가별로 bfs() 실행
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    bfs(new Country(i, j , A[i][j]));
                }
            }

            // 모든 국가에 대해서 진행했음에도 인구 이동이 없었다면 종료
            if(check == 0) break;

            // 인구 이동이 있었고 완료되었다면 - 방문 여부와 인구 이동 check 포인트 초기화,
            for (int i = 0; i < n; i++) Arrays.fill(visited[i], 0);
            check = 0;
            // 인구 이동에 걸린 시간 증가
            days++;
        }

        System.out.println(days);
    }

    public static void main(String[] args) throws Exception{
        new B_16234().solution();
    }
}
