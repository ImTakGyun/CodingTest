package algorithm.BFSDFS;

import java.util.*;
import java.io.*;

public class IceCream {
    /**
     * DFS를 활용하는 알고리즘
     * 1. 특정한 지점의 주변 상,하,좌,우를 살펴본 뒤에 주변 지점 중에서 값이 '0'이면서 아직 방문하지 않은 지점이 있다면 해당 지점을 방문.
     * 2. 방문한 지점에서 다시 상,하,좌,우를 살펴보면서 방문을 진행하는 과정을 반복하면, 연결된 모든 지점을 방문할 수 있음.
     * 3. 모든 노드에 대하여 1~2번의 과정을 반복하며, 방문하지 않은 지점의 수를 카운트한다.
     *
     * 오답: DFS를 사용한다는 점을 잘 유추하였지만, 방문한 점들을 그룹지어 하나의 아이스크림으로 count 하는 점에서 어려움을 겪었음
     * 해결: DFS함수를 통하여 방문지점이 유효하다면 count를 증가시키고 연결된 점들은 모두 방문했음을 표시한다.
     *      DFS함수에서 방문지점이 유효하다면 위의 로직을 진행하지만, 유효하지 않다면 False를 반환하여 재귀를 멈춤으로써 count 하지 않음으로 해결 가능하였다.
    */

    public static int n = 0, m = 0;
    public static int[][] graph = new int[1000][1000];

    public static ArrayList<ArrayList<Integer>> MyGraph = new ArrayList<>();

    public static boolean my_dfs(int x, int y){
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }

        if(MyGraph.get(x).get(y) == 0){
            //해당 노드 방문 처리
            MyGraph.get(x).set(y, 1);
            // 상, 하 ,좌, 우의 위치들도 모두 재귀적을 호출
            my_dfs(x - 1, y);
            my_dfs(x, y - 1);
            my_dfs(x + 1, y);
            my_dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public void my_solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 2차원 리스트의 맵 정보 입력 받기
        for(int i = 0; i < n; i++){
            /**
             * 하나의 이어진 문자열에서 숫자를 각각 저장하기 위해서는 charAt으로 하나의 숫자를 뽑아 형변환해야한다.
             */
            MyGraph.add(new ArrayList<>());
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                MyGraph.get(i).add(str.charAt(j) - '0');
            }
        }

        // 모든 노드(위치)에 대하여 음료수 채우기
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //현재 위치에서 DFS 수행
                if(my_dfs(i,j))
                    result += 1;
            }
        }

        System.out.println(result);
    }

    // DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문한다.
    public static boolean regular_dfs(int x, int y){
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }

        // 현재 노드를 아직 방문하지 않았다면
        if(graph[x][y] == 0) {
            //해당 노드 방문 처리
            graph[x][y] = 1;
            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            regular_dfs(x - 1, y);
            regular_dfs(x, y - 1);
            regular_dfs(x + 1, y);
            regular_dfs(x, y + 1);
            return true;
        }
        return false;
    }

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

    public boolean regular_bfs(int x, int y){

        if(x <= -1 || x >= n || y <= -1 || y >= m){
            return false;
        }

        if(graph[x][y] == 1) return false;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));

        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            // 현재 노드를 아직 방문하지 않았다면
            if(graph[x][y] == 0) {
                //해당 노드 방문 처리
                graph[x][y] = 1;
                // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
                q.offer(new Node(x - 1, y));
                q.offer(new Node(x, y - 1));
                q.offer(new Node(x + 1, y));
                q.offer(new Node(x, y + 1));
            }
        }
        return true;
    }

    public void regular_solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 2차원 리스트의 맵 정보 입력 받기
        for(int i = 0; i < n; i++){
            /**
             * 하나의 이어진 문자열에서 숫자를 각각 저장하기 위해서는 charAt으로 하나의 숫자를 뽑아 형변환해야한다.
             */
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // 모든 노드(위치)에 대하여 음료수 채우기
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //현재 위치에서 DFS 수행
                if(regular_bfs(i,j))
                    result += 1;
            }
        }

        // 정답 출력
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        new IceCream().my_solution();
    }
}
