package algorithm.BFSDFS.practice;

import java.util.*;
import java.io.*;

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
