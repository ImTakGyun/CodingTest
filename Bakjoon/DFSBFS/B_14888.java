package Bakjoon.DFSBFS;

import java.util.*;
import java.io.*;

/**
 *  회고 : 백트래킹으로 풀이할 수 있는 문제. + <Divide & Conquer>
 *
 *  핵심 Point : 각 연산자의 사용횟수를 저장한 배열을 통해 백트래킹을 사용한 모든 경우 계산이 가능하였다.
 *
 */
public class B_14888 {
    // 연산을 수행할 수의 개수
    public static int n;
    // 연산을 수행하고자 하는 수 배열
    public static int[] nums;
    // 더하기, 빼기, 곱하기, 나누기 연산자 개수
    public static int[] ops = new int[4];
    // 연산자의 총 개수
    public static int sum;

    // 최솟값과 최댓값 초기화
    public static int max = -100000001;
    public static int min = 1000000001;

    // 깊이 우선 탐색 (DFS) 메서드
    public void dfs(int count, int result, int[] used){
        // 모든 연산자를 다 사용한 경우, 최솟값과 최댓값 업데이트
        if(count == sum){
            if(result > max) max = result;
            if(result < min) min = result;
            return;
        }

        // 각 연산자에 대하여 사용 가능한 상태라면 결과값을 계산하고 재귀 수행
        for(int i = 0; i < 4; i++){
            // 특정 연산자의 사용횟수
            int op = used[i];
            // 아직 해당 연산자를 사용할 수 있다면
            if(op < ops[i]){
                // 결과값 저장할 update
                int update = 0;
                // '+'라면
                if(i == 0){
                    update = result + nums[count + 1];
                }
                // '-'라면
                else if(i == 1){
                    update = result - nums[count + 1];
                }
                // '*'라면
                else if(i == 2){
                    update = result * nums[count + 1];
                }
                // '/'라면
                else if(i == 3){
                    // 음수에 대한 나누기
                    if(result < 0) update = ((Math.abs(result) / nums[count + 1]) * (-1));
                    // 양수에 대한 나누기
                    else update = result / nums[count + 1];
                }

                // 특정 연산자의 사용횟수 증가
                used[i] += 1;
                // dfs(지금까지 사용한 연산자의 수, 계산 결과값, 각 연산자의 사용횟수 배열)를 통해 재귀
                dfs(count + 1, update, used);
                // 회귀한 경우, 다른 경우에 대한 계산을 위해 특정 연산자의 사용횟수 감소
                used[i] -= 1;
            }
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 계산할 식에 나열되는 숫자들
        n = Integer.parseInt(st.nextToken());
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 각 연산자의 사용가능횟수
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            ops[i] = Integer.parseInt(st.nextToken());
            sum += ops[i];
        }

        // 지금까지 각 연산자를 사용한 횟수를 저장할 배열
        int[] used = new int[4];
        // 백트래킹 시작
        dfs(0, nums[0], used);

        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new B_14888().solution();
    }
}
