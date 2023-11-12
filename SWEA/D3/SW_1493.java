package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : <대각선의 내려오는 좌표의 순서> -> 이 부분을 가장 오래 고민했다.
 *                                          i는 1부터 항상 증가하게 두고(for)
 *                                          내부에서 j가 1부터 지정된 i까지 증가하게 설정한 후(for)
 *                                          좌표를 (j, i - (j - 1)) 로 둔다면, j에 의해 x는 증가하며 i 는 1씩 감소하며 대각선을 이룬다.
 *
 *              대각선에 찍히는 좌표의 순서를 배열에 삽입하고 순회하며 특정 좌표 a와 특정 좌표 b의 x,y 합을 배열에서 조회함으로써 몇 번째에 찍히는 좌표인지 알아낼 수 있다.
 *              주의할 점은, a와 b가 같은 좌표일 수 있다는 것이다. 때문에 if와 else if 관계가 아닌 if-if 관계로 선언해야한다.
 */
public class SW_1493 {

    static public int[][] arr = new int[401][401];

    public static void main(String args[]) throws Exception
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int cnt = 1;

            for(int i = 1; i < 401; i++){
                for(int j = 1; j < i + 1; j++) {
                    arr[j][i - (j - 1)] = cnt;
                    cnt++;
                }
            }

            int px = 0;
            int py = 0;
            int qx = 0;
            int qy = 0;

            for(int i = 1; i < 151; i++){
                for(int j = 1; j < 151; j++){
                    if(arr[i][j] == p){
                        px = i;
                        py = j;
                    }
                    if(arr[i][j] == q){
                        qx = i;
                        qy = j;
                    }
                }
            }

            int x = px + qx;
            int y = py + qy;

            System.out.println("#" + test_case + " " + arr[x][y]);
        }
    }
}
