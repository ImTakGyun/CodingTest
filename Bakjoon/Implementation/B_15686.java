package Bakjoon.Implementation;

import java.util.*;
import java.io.*;

/**
 * 회고 : 시간이 다소 걸렸지만, 오랜만에 혼자 힘으로 풀어낸 골드 문제
 *       항상 지금까지 배열, 리스트 를 순회할 때 for문을 통해 int i = 0 ~ n까지를 순회하고는 했다.
 *       하지만 이번 문제에서 iterator를 활용한 for-each문을 통해서 빠르게 접근하는 로직으로 구현 가능함을 알게 되었다.
 *       또한, 문제의 풀이가 떠오르면 이를 divide & Conquer 를 통해 기능별 함수를 생성하고 이를 활용함으로써 문제를 풀어내는 능력을 기르게 된 것 같다.
 */

public class B_15686 {

    // 제공되는 n,m 그리고 이를 통한 arr, 그리고 결과를 저장한 result
    public static int n, m;
    public static int[][] arr;
    public static int result;

    // 집들의 위치를 저장할 house
    public static ArrayList<Node> house = new ArrayList<>();
    // 치킨집들의 위치를 저장할 house
    public static ArrayList<Node> chicken = new ArrayList<>();
    // 살아남은 치킨집들의 위치를 저장할 house
    public static ArrayList<Node> survive = new ArrayList<>();

    // 위치정보를 저장할 node
    static class Node{
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

    // 살아남은 치킨집들을 토대로 입력받은 집에서 가장 가까운 치킨집과의 거리를 반환해주는 함수
    public int short_distance(Node home){
        // 가장 멀리 있을 경우의 값을 초기에 집어넣음
        int shortest = n * 2;
        // 살아남은 치킨집들과의 거리를 계산하고 최소값을 저장
        for(int i = 0; i < survive.size(); i++){
            Node chic = survive.get(i);
            int dx = Math.abs(home.getX() - chic.getX());
            int dy = Math.abs(home.getY() - chic.getY());

            int sum = dx + dy;

            if(sum < shortest) shortest = sum;
        }
        // 최소값(가장 가까운 거리)을 반환
        return shortest;
    }

    // 백트래킹을 활용하여 m개의 치킨집만을 선택하는 알고리즘
    public void dfs(int num, int count){

        // m개의 선택이 끝났다면 short_distance() 을 통해 각각의 집들과 살아남은 치킨집들과의 최소거리를 구한다.
        // 이 때 sum을 통해 최소의 도시 치킨거리 값을 갖도록 한다.
        if(count == m){
            int sum = 0;
            // 각각의 집에 대해서
            for(int i = 0; i < house.size(); i++){
                // short_distance()을 통해 최소 치킨거리를 구한다.
                int dist = short_distance(house.get(i));
                sum += dist;
            }
            // 산출한 각각의 집들의 최소 치킨거리의 합을 통해 최소 도시 치킨거리를 구한다.
            if(sum < result) result = sum;

            // m개 선택이라는 종료조건에 만족했으므로 회귀가 일어날 수 있도록 꼭 return 해준다.
            return;
        }

        // 만약, num이 기존의 치킨집들의 개수를 뛰어넘는다면 멈춘다.
        if(num >= chicken.size()) return;

        // 입력된 치킨집을 선택한 경우에 대하여 계산
        survive.add(chicken.get(num));
        dfs(num + 1, count + 1);

        // 입력된 치킨집을 선택하지 않았을 경우에 대하여 계산
        survive.remove(survive.size() - 1);
        dfs(num + 1, count);
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                // 집일 경우 집의 위치 정보 저장
                if(arr[i][j] == 1){
                    house.add(new Node(i, j));
                }
                // 치킨집일 경우 치킨집의 위치 정보 저장
                else if(arr[i][j] == 2){
                    chicken.add(new Node(i, j));
                }
            }
        }

        // result의 초기값의 경우 도시 치킨거리가 최대가 되도록 임의 설정 (집에서 치킨집의 최대 거리(2n) * 집의 개수)
        result = 2 * n * house.size();
        dfs(0, 0);
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception{
        new B_15686().solution();
    }
}
