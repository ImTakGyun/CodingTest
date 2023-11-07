package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 단순 구현 or 방향지정 조건 합불 여부 구하기
 *
 *  실수 : BufferedReader 는 버퍼를 형성하고 입력받은 것을 읽어오는 것이기 때문에 하나의 프로젝트에서 하나만 생성되어야 한다.
 *        BufferedReader를 여러번 생성하면 이전 버퍼들은 사라지고 새로운 버퍼가 생성되기 때문에 test 반복문 내부에 들어가면 안된다.
 */
public class SW_1206 {

    public static int[] building;


    // a번째 건물 주변에서 가장 높은 건물의 높이를 구하고 그 높이가 a번째 건물의 높이보다 크다면 0을, 작다면 그 차이를 반환한다.
    public static int check(int a){

        int max = 0;

        // a번째 건물 주변에서 가장 큰 건물의 높이를 max에 저장한다.
        for(int i = 1; i < 3; i++){
            int m = Integer.max(building[a-i],building[a+i]);
            if(m > max) max = m;
        }

        //max가 a번째 건물 높이보다 높다면 0 반환
        if(max >= building[a]) return 0;
        //아니라면 차이 반환
        else return building[a] - max;

    }

    public static void main(String args[]) throws Exception {

        int T = 10;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            building = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                building[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;

            // a번째 건물의 주변에서 조건에 만족하는지 확인한 후 반환되는 값들을 모두 더한다.(sum => 조건에 만족하는 층수)
            for(int i = 2; i < n-2; i++)
                sum += check(i);

            System.out.println("#" + test_case + " " + sum);
        }
    }
}
