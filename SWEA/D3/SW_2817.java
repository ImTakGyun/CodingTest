package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 * 핵심 Point :  <백트래킹 + 완전 탐색> :
 *
 *              - n개의 숫자중 1~n개의 숫자를 더하는 경우를 완전 탐색한다.
 *              - total을 1~n으로 각각 분기하고
 *              - 0 ~ n-1 인덱스의 숫자들중 total의 개수만큼 앞에서부터 순회하며 뽑는다.
 *              - 이 때, count(지금까지 더한 숫자의 개수)가 total(현재 고려할 숫자 개수)과 같아지면서 sum(지금까지의 숫자 합)이 k(만들려는 총합)와 같은 경우
 *                result(결과)를 증가시켜준다.
 *
 *              <다른 풀이>
 *              - 위의 방식의 경우 total을 1 ~ n으로 정해두고 숫자 후보들을 변경하면서 총합을 구하여 결과를 도출하였다.
 *              - 다른 방식으로는 이러한 로직을 따르지 않고, 모든 숫자들을 순서대로 순회하면서 이 숫자를 더하는 경우와 더하지 않는 경우로 분기하여 모든 경우를 고려할 수 있다.
 *              - 현재의 풀이와 같이 dfs에는 index(몇 번째 숫자까지 진행했는지), sum(지금까지의 숫자 총 합)을 받는다.
 *              - 0 ~ n-1까지 숫자를 순회하는 것이기 때문에 종료조건의 경우 index == n인지이고 이 때 sum이 k와 같다면 result를 증가시키고 회귀한다.
 *              - 만약 index != n이라면 arr[index+1]의 숫자에 대해 더하는 경우와 더하지 않는 경우를 나누어
 *                dfs(index + 1, sum + arr[index+1]) 과 dfs(index + 1, sum) 으로 모든 경우를 위한 분기를 처리해준다.
 *              - 이 때의 시간복잡도를 줄이기 위한 가지치기는 sum이 k를 초과하는 경우 회귀하게끔 설정하는 것이다.
 *
 */
public class SW_2817 {

    public static int[] arr;

    public static int n;
    public static int k;
    public static int total;
    public static int result;

    public static void dfs(int index, int count, int sum){

        if(sum > k) return;

        if(count == total) {
            if(sum == k) {
                result++;
                return;
            }
            else return;
        }

        for(int i = index + 1; i < n; i++){
            int value = arr[i];
            dfs(i, count + 1, sum + value);
        }
    }

    public static void main(String args[]) throws Exception
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n];
            result = 0;

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i < n + 1; i++){
                total = i;
                for(int j = 0; j < n; j++) {
                    dfs(j, 1, arr[j]);
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
