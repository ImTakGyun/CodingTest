package algorithm.DynamicProgramming.Practice;

import java.util.*;
import java.io.*;

/**
 *  회고 : 진짜 상상도 하지 못한 로직
 *        1에서 2, 3, 5에 해당하는 서로소를 곱하고 이를 후보로 둔다.
 *        후보 중에서 가장 작은 값은 1 이후에 추가하고
 *        추가된 서로소 곱의 다음 곱셈결과 값은 [1] 번째 인덱스와 서로소를 곱한 값으로 이를 다시 후보에 추가한다.
 *
 *        이처럼 후보에서 가장 작은 값을 순서대로 쌓고 쌓아진 서로소는 그 다음 dp 테이블의 인데스 수로 가서 곱한 결과를 후보에 추가한다.
 *
 *        간단하게 설명하자면, 맨 앞의 인덱스의 수부터 각 서로소와의 곱을 후보로 두고
 *        가장 작은 후보를 dp 테이블의 그 다음 인덱스에 추가한다.
 *        서로소는 각각의 checkpoint를 통해 dp 테이블에 인덱스를 기억하고 후보를 생성한다.
 *        (인덱스가 올라가면서 그 값은 바로 직전보다 한 단계만 커지기 때문)
 *
 *        1 ([0] * 2 = 2, 3 = 3, 5 = 5) ->
 *        1, 2 ([0] * 3 = 3, 5 = 5 // [1] * 2 = 4) ->
 *        1, 2, 3 ( [0] * 5 // [1] * 2, 3) ->
 *        1, 2, 3, 4 ( [0] * 5 = 5 // [1] * 3 = 6 // [2] * 2 = 6) ->
 *        1, 2, 3, 4, 5 ( [1] * 3 = 6, 5 = 10 // [2] * 2 = 6) ->
 *        1, 2, 3, 4, 5, 6 ( [1] * 5 = 10 // [2] * 3 = 9 // [3] * 2 = 8) ->
 *        ...
 */

public class Q35_못생긴수 {

    static int n;

    public void solution(){

        // 못생긴 수를 담기 위한 테이블 (1차원 DP 테이블)
        int[] ugly = new int[n];

        // 2배, 3배, 5배를 진행할 인덱스
        int i2 = 0, i3 = 0, i5 = 0;
        // 처음의 곱셈 결과 ( 1 * 2, 3, 5)
        int next2 = 2, next3 = 3, next5 = 5;

        // 첫 번째 못생긴 수는 1
        ugly[0] = 1;

        // 1부터 n까지의 못생긴 수들을 찾기
        for(int i = 1; i < n; i++){

            // 가능한 곱셈 결과 중에서 가장 작은 수를 선택
            ugly[i] = Math.min(next2, Math.min(next3, next5));

            // 인덱스에 따라서 곱셈 결과를 증가
            if(ugly[i] == next2){
                i2++;
                next2 = ugly[i2] * 2;
            }

            if(ugly[i] == next3){
                i3++;
                next3 = ugly[i3] * 3;
            }

            if(ugly[i] == next5){
                i5++;
                next5 = ugly[i5] * 5;
            }
        }

        // n번째 못생긴 수를 출력
        System.out.println(ugly[n - 1]);
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        n = Integer.parseInt(st.nextToken());

        new Q35_못생긴수().solution();

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}
