package algorithm.BFSDFS.practice;

import java.util.*;
import java.io.*;

/**
 *  어려운점 : 처음 로직을 작성할 때, 시간초과가 났다.
 *           원인을 찾으니, 거리 정보(시작 도시, 도착 도시)를 하나의 배열로 road ArrayList에 담아두고 for문으로 전체를 훑으며 출발점에 해당 하는 시작 도시를 찾았던 것이다.
 *           이렇게 진행하니 당연히 도시(최대 300,000) 와 거리(최대 1000,000)의 곱인 3000억번의 연산이 진행된 것이다.
 *           이를 해결하기 위해서는 거리 정보를 road에 담는 것이 아니라, 2차원 ArrayList를 형성하여 1번 인데스에는 1번 도시에 대한 거리 정보, 2번에는 2번 과 같이 저장해야했다.
 *           이렇게 진행하니 시간 복잡도는 거리 정보의 개수인 최대 1000,000 으로 해결할 수 있었다.
 *
 *  배운점 : 1. (시작, 도착)의 나열의 경우, 2차원 ArrayList를 통해서 시작점을 index로 두고 도착점만을 저장하는 것이다.(출발점의 거리 정보를 찾는 시간 복잡도 최소화)
 *            (시작, 도착, 비용)의 경우, Node class를 선언하여 해결하면 될 것 같다.
 *
 *         2. 출발점에서 특정 목적점까지의 거리의 경우, 출발점을 시작점으로 하는 거리를 통한 목적지의 거리비용을 1로 두고 그 이후의 BFS를 통해서 거리비용을 +1씩 늘리면 된다.
 *
 *         3. 특정 조건의 반복문을 통해 반환되는 값들이 있다면 출력하고 없다면 -1만을 출력하는 경우, boolean check point를 형성하여 반환값을 만들어내는 곳에 true로 바꾸는 로직을 두면 된다.
 */
public class Q15_특정거리도시찾기 {

    static ArrayList<ArrayList<Integer>> road = new ArrayList<>();

    public int[] bfs(boolean[] visited, int start){

        int[] distances = new int[visited.length + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        //현재 노드를 방문 처리
        visited[start] = true;
        distances[start] = 0;

        //큐가 빌 때까지 반복
        while(!q.isEmpty()){
            //큐에서 원소를 반환 후 삭제
            int prev = q.poll();

            //해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입하고 거리 측정
            for(int i = 0; i < road.get(prev).size(); i++){
                int y = road.get(prev).get(i);
                if (!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                    distances[y] = distances[prev] + 1;
                }
            }
        }

        return distances;
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n_cities = Integer.parseInt(st.nextToken());
        int n_roads = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());


        boolean[] visited = new boolean[n_cities+1];

        for(int i = 0; i < n_cities + 1; i++)
            road.add(new ArrayList<>());

        for(int i = 0; i < n_roads; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            road.get(a).add(b);
        }

        // start 부터 각 도시들의 최소 거리
        int[] distances = bfs(visited, start);
        boolean destination = false;

        for(int i = 1; i < n_cities + 1; i++){
            if(distances[i] == distance) {
                System.out.println(i);
                destination = true;
            }
        }
        if(!destination)
            System.out.println("-1");

    }

    public static void main(String[] args) throws IOException{
        new Q15_특정거리도시찾기().solution();
    }
}
