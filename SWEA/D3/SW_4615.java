package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : <Queue를 통해 후보를 저장해두고 뒤집는 조건이 충족하면 뒤집어 준다>
 *
 *              - 꽤나 애를 먹은 문제이다.
 *              - 이 문제를 풀 때 가장 주의해야할 점은 방향 설정과 후보 저장이다.
 *              - 입력받는 위치에 돌을 두었을 때, 돌이 들어가는 위치의 8방면을 확인하기 위한 방향을 dx,dy로 설정한다.
 *              - 모든 방향을 훑어보며(for),
 *              - While문을 통해 한 방향에 대해 파고들며, (if) 반대되는 색의 돌이 위치한다면 그 위치를 Queue에 저장하고 그 다음 위치를 조사한다.
 *                                                (else if) 비어있다면 break를 건다.
 *                                                (else) 같은 색의 돌이 있다면 지금까지 저장된 위치의 돌의 색을 뒤집어 준다.
 *
 *              - 이 때 후보지 위치를 저장하기 위해서는 Queue를 사용하는데, 이 때 위치값(x, y)를 저장하기 위해서는 <Node Class>를 선언해서 저장해주어야 한다.
 *              - 이를 통해 돌이 착수되는 경우마다, 8방면을 살피고 후보지를 저장하며 조건이 충족되면 저장된 후보지의 색을 뒤집어 주고 break 하는 것을 반복하여
 *              - 오슬로 게임이 원활하게 진행된다.
 */
class Node {

    int x;
    int y;

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

public class SW_4615 {

    public static int[][] arr;

    public static int[] dx = {-1, 0, 1, -1, 0, 1, -1, 1};
    public static int[] dy = {-1, -1, -1, 1, 1, 1, 0, 0};

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

            arr = new int[n+1][n+1];

            arr[n/2][n/2] = 2;
            arr[n/2 + 1][n/2] = 1;
            arr[n/2][n/2 + 1] = 1;
            arr[n/2 + 1][n/2 + 1] = 2;

            int x = 0;
            int y = 0;
            int r = 0;

            Queue<Node> q;

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());

                arr[x][y] = r;
                int nx = 0;
                int ny = 0;

                for(int j = 0; j < 8; j++){
                    q = new LinkedList<>();
                    nx = x + dx[j];
                    ny = y + dy[j];

                    while(nx >= 1 && nx <= n && ny >= 1 && ny <= n){
                        if(arr[nx][ny] != 0 && arr[nx][ny] != r) {
                            q.add(new Node(nx, ny));
                            nx += dx[j];
                            ny += dy[j];
                        }
                        else if(arr[nx][ny] == 0) break;
                        else{
                            while(!q.isEmpty()){
                                Node node = q.poll();
                                arr[node.getX()][node.getY()] = r;
                            }
                            break;
                        }
                    }
                }
            }

            int w = 0;
            int b = 0;

            for(int i = 1; i < n + 1; i++){
                for(int j = 1; j < n + 1; j++){
                    if(arr[i][j] == 1) b++;
                    else if(arr[i][j] == 2) w++;
                }
            }

            System.out.println("#" + test_case + " " + b + " " + w);
        }
    }
}
