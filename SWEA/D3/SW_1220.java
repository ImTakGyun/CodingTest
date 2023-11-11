package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 교착 상태는 1-2가 접하는 개수이기 때문에 1에서 또는 2에서만 확인을 진행하면 된다.
 *              1에서 확인한다고 가정한다면, 열을 순회하며(for) 등장하는 1 직후에 등장하는(for) 자성체를 조회한다.
 *              직후의 자성체가 1이라면 해당 부분은 교착이 아니므로 break를 걸고 다시 열을 이어서 순회하며 1의 등장을 기다리고,
 *              직후의 자성체가 2라면 해당 부분은 교착이므로 교착상태를 늘려주고(result + 1) 열을 이어서 순회한다.
 *
 *              => 1을 발견하고 직후에 2가 등장하는 개수만을 세는 것이기 때문에 중복 없이 모든 교착상태를 구할 수 있다.
 */
public class SW_1220 {

    public static int[][] arr;
    public static void main(String args[]) throws Exception
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T =10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            arr = new int[n][n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;

            // 각각의 열을 순회
            for(int i = 0; i < n; i++){
                // 해당 열을 위에서부터 흝으며 1을 탐색
                for(int j = 0; j < n; j++){
                    // 1이 발견되면 그 직후에 나오는 자성체를 확인
                    if(arr[j][i] == 1){
                        for(int k = j + 1; k < n; k++){
                            // 직후의 자성체가 같은 1이라면 넘긴다.(j가 순회하며 해당 자성체를 다시 조사할 것이기 때문)
                            if(arr[k][i] == 1) break;
                            // 직후의 자성체가 2라면 result(교착상태)를 늘려주고 멈춘다.
                            else if(arr[k][i] == 2) {
                                result++;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}
