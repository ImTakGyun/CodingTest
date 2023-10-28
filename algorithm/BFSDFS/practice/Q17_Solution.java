package algorithm.BFSDFS.practice;

import java.util.*;
import java.io.*;

class Virus implements Comparable<Virus> {

    private int index;
    private int second;
    private int x;
    private int y;

    public Virus(int index, int second, int x, int y){
        this.index = index;
        this.second = second;
        this.x = x;
        this.y = y;
    }

    public int getIndex(){
        return this.index;
    }

    public int getSecond() {
        return this.second;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // 정렬 기준은 '번호가 낮은 순서'
    @Override
    public int compareTo(Virus other){

        //if (this.index < other.index) {
        //            return -1;
        //        }
        //        return 1;

        return this.index - other.index;
    }
}

public class Q17_Solution {

    public static int n, k, s;
    public static int x, y;
    public static int[][] arr;

    // 4가지 이동 방향에 대한 배열
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public void solution() throws IOException{

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        ArrayList<Virus> viruses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0) {
                    viruses.add(new Virus(arr[i][j], 0, i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        Collections.sort(viruses);

        Queue<Virus> q = new LinkedList<>();

        for(int i = 0; i < viruses.size(); i++){
            q.offer(viruses.get(i));
        }

        while(!q.isEmpty()){

            Virus virus = q.poll();

            if(virus.getSecond() == s) break;

            for(int i = 0; i < 4; i++) {

                int nx = virus.getX() + dx[i];
                int ny = virus.getY() + dy[i];
                int ns = virus.getSecond() + 1;

                if( nx >= 0 && nx < n && ny >= 0 && ny < n){
                    if(arr[nx][ny] == 0){
                        arr[nx][ny] = virus.getIndex();
                        q.offer(new Virus(virus.getIndex(), ns, nx, ny));
                    }
                }
            }
        }

        System.out.println(arr[x-1][y-1]);
    }

    public static void main(String[] args) throws IOException{
        new Q17_Solution().solution();
    }
}
