package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  풀이 : 모든 위치에서 탐색(dfs) => 방문한 노드의 개수(Max)
 *
 *  핵심 Point : <각각의 경로에 대한 최장경로 비교를 위해서 전체 경로에서 분기조건을 위해 하나의 경로가 완료되면 방문 여부를 초기화 시키며 dfs가 동작>
 *
 *              - dfs를 통해 각각의 경로에 대한 길이를 도출한 후, result와의 비교를 통해 모든 경로에서 최장 길이를 구한다.
 *              - 여기서 <주의해야할 점>은, 여러개의 경로가 존재하기 때문에, 경로의 분기가 이루어질 경우를 위해서 하나의 경로가 마무리되면 return을 하며 방문값을 초기화해줘야한다.
 *              - 방문값을 초기화해주지 않으면 분기된 경로에 영향을 주기 때문이다.
 */
public class SW_2814 {

    public static ArrayList<ArrayList<Integer>> list;
    public static int[] visited;
    public static int result;

    // 출발 node 와 해당 노드가 몇 번째로 거쳐지는지에 대한 count 값
    public static void dfs(int node, int count){

        // node 방문
        visited[node]+= 1;

        // 해당 노드와 연결된 간선을 순회
        for(int i = 0; i < list.get(node).size(); i++){
            // 각 간선의 도착지 설정
            int destination = list.get(node).get(i);
            // 방문하지 않은 도착지라면 dfs 재귀
            if(visited[destination] != 1) {
                dfs(destination, count + 1);
            }
        }

        // 해당 노드와 연결된 간선의 목적지가 모두 방문 불가라면 지금까지의 경로 길이를 result와 비교후 크다면 대체, 작다면 continue
        if(count > result) result = count;
        // 현재의 경로가 끝났으므로, 전체 경로의 분기를 위해서 거친 노드 방문값 초기화
        visited[node] -= 1;
        return;
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 조회 여부 저장
            visited = new int[n+1];

            list = new ArrayList<>();
            for(int i = 0; i < n + 1; i++){
                list.add(new ArrayList<>());
            }

            // 입력받은 간선 정보 저장
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                list.get(n1).add(n2);
                list.get(n2).add(n1);
            }

            result = 0;

            // 출발 노드를 변경하며 dfs() 함수(-> 최장경로 판단) 동작 + 조회 여부 배열 초기화
            for(int i = 1; i < n + 1; i++){
                dfs(i, 1);
                Arrays.fill(visited, 0);
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
