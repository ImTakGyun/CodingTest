package Bakjoon.Implementation;

import java.util.*;
import java.io.*;

class Node{

    private int time;
    private char dir;

    public Node(int time, char dir){
        this.time = time;
        this.dir = dir;
    }

    public int getTime(){
        return this.time;
    }

    public char getDir(){
        return this.dir;
    }
}

class Position{

    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class B_3190 {

    public static int n, k, l;
    public static int[][] arr;  // 맵 정보
    public static ArrayList<Node> turn = new ArrayList<>(); // 방향 회전 정보

    // 처음에는 오른쪽을 보고 있으므로(동, 남, 서, 북)
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int simulate(){

        // 뱀이 차지하고 있는 위치 정보(꼬리가 앞쪽)
        Queue<Position> locate = new LinkedList<>();

        int x = 1, y = 1;   // 뱀의 머리 위치
        arr[x][y] = 2;      // 뱀이 존재하는 위치는 2로 표시
        locate.offer(new Position(x, y));

        int dr = 0;         // 처음에는 동쪽을 보고 있음
        int time = 0;       // 시작한 뒤에 지난 '초' 시간
        int index = 0;      // 다음에 회전할 정보

        while(true){
            int nx = x + dx[dr];
            int ny = y + dy[dr];

            // 맵 범위 안에 있고, 뱀의 몸통이 없는 위치라면
            if(1 <= nx && nx <= n && 1 <= ny && ny <= n && arr[nx][ny] != 2){
                // 사과가 있다면 이동 후에 꼬리 그대로 두기
                if(arr[nx][ny] == 1){
                    arr[nx][ny] = 2;
                }
                // 사과가 없다면 이동 후에 꼬리 제거
                else{
                    arr[nx][ny] = 2;
                    Position prev = locate.poll();
                    arr[prev.getX()][prev.getY()] = 0;
                }

                // 움직인 위치 저장
                locate.offer(new Position(nx, ny));
            }
            // 벽이나 뱀의 몸통과 부딪혔다면
            else{
                time++;
                break;
            }

            // 다음 위치로 머리를 이동
            x = nx;
            y = ny;
            time++;

            // 회전할 시간인 경우 회전
            if(index < l && time == turn.get(index).getTime()){
                if (turn.get(index).getDir() == 'L') dr = (dr == 0) ? 3 : dr - 1;
                else dr = (dr + 1) % 4;
                index++;
            }
        }
        return time;
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];

        st= new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        // 맵 정보(사과 있는 곳은 1로 표시)
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
        }

        // 방향 회전 정보 입력
        st= new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());

        for(int i = 0; i < l; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            turn.add(new Node(time, dir));
        }

        System.out.println(simulate());
    }

    public static void main(String[] args) throws Exception{
        new B_3190().solution();
    }
}
