package algorithm;

import java.util.*;

public class Practice {

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void dfs(int x){
        visited[x] = true;
        System.out.print(x + " ");

        for(int i = 0; i < graph.get(x).size(); i++){
            int y = graph.get(x).get(i);
            if(!visited[y]) dfs(y);
        }
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        visited[start] = true;

        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");

            for(int i = 0; i < graph.get(x).size(); i++){
                int y = graph.get(x).get(i);
                if(!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }

        }
    }

    public static void main(String[] args){
        for(int i = 0; i < 9; i++){
            graph.add(new ArrayList<>());
        }
    }


}
