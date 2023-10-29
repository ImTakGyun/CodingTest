package algorithm.BFSDFS.Practice;

import java.io.*;
import java.util.*;

/**
 *  어려운점: 바이러스가 중복된 것이 존재할 수 있음을 감안하지 못 헀음 -> 시간 겁나 날렸네
 *
 *  배운점 : 1. x,y 좌표와 함께 추가로 저장해야하는 값이 존재시에 Node class 를 선언할 수도 있고, v를 선언할 수도 있다.
 *            다만, 정렬이 추가적으로 필요한 경우 Node class 를 선언한 방식에서는 implements Comparable를 통해 compareTo()를 오버라이딩 해줘야한다.
 *                 정렬이 추가적으로 필요한 경우 2중 ArrayList 를 선언한 방식에서는 Collections.sort(리스트, 정렬조건) 을 사용하여 정렬해줘야한다.
 *                 이 때, 정렬조건은 람다 함수를 이용하여 (o1, o2) -> { return o1 - o2 } 로 선언함으로써 가장 간단하게 구현할 수 있다.
 *
 *         2. n초 후에 virus가 퍼져있는 상황을 구하는 경우 -> dfs,bfs를 이용하여 virus가 퍼지는 상황에서 n초 후의 상황을 구하는 경우
 *            virus 안에 바이러스 타입과 x ,y 좌표 뿐만 아니라 second도 변수로 넣어줌으로써 n초 후에 바이러스가 어디까지 퍼져 있는지 확인할 수 있다.
 *            (퍼지려는 바이러스의 second를 n과 비교하여 break를 걸면 된다.
 *
 */
public class Q17_경쟁적전염 {

    public static int n, k, s;
    public static int x, y;
    public static int[][] arr;

    // 4가지 이동 방향에 대한 배열
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};



    public void solution() throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        ArrayList<ArrayList<Integer>> viruses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0) {
                    ArrayList<Integer> virus = new ArrayList<>();
                    virus.add(arr[i][j]);
                    virus.add(i);
                    virus.add(j);
                    virus.add(0);
                    viruses.add(virus);
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());


        Queue<ArrayList<Integer>> q = new LinkedList<>();

        Collections.sort(viruses, (o1, o2) -> {
            return o1.get(0) - o2.get(0);
        });

        for(int i = 0; i < viruses.size(); i++){
                q.offer(viruses.get(i));
        }

        while(!q.isEmpty()){
            ArrayList<Integer> virus = q.poll();

            if(virus.get(3) == s) break;

            for(int i = 0; i < 4; i++){
                int nx = virus.get(1) + dx[i];
                int ny = virus.get(2) + dy[i];
                int ns = virus.get(3) + 1;

                if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                    if(arr[nx][ny] == 0){
                        arr[nx][ny] = virus.get(0);
                        ArrayList<Integer> o = new ArrayList<>();
                        o.add(0, virus.get(0));
                        o.add(1, nx);
                        o.add(2, ny);
                        o.add(3, ns);

                        q.offer(o);

//                        for(int r = 0; r < n; r++){
//                            for(int t = 0; t < n; t++){
//                                System.out.print(arr[r][t]);
//                            }
//                            System.out.println();
//                        }
//                        System.out.println();
                    }

                }
            }
        }

        System.out.println(arr[x-1][y-1]);
    }

    public static void main(String[] args) throws IOException {
        new Q17_경쟁적전염().solution();
    }
}
