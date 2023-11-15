package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : <그리디 + 백트래킹을 진행하고 조건을 설정한다.>
 *
 *              - 문제에서 주어진 조건을 분석해보면 가장 큰 수가 제일 앞으로 가야한다..
 *              - 하지만, 가장 큰 수는 중복될 수 있기 때문에, 중복된다면 백트래킹을 실시해야한다.
 *              - 때문에 조건을 걸어 단일 최댓값이라면 제일 앞 자리로만 보내고, 중복이라면 백트래킹을 통해 경우를 계산하기로 한다.
 *
 *              전체적인 로직
 *              - 숫자열을 순회하며 최댓값을 구하고 이를 다시 한 번 숫자열의 각 숫자들과 비교하여 인덱스를 저장함과 동시에 단일인지 중복인지에 대한 정보를 저장한다.
 *              - 단일 최댓값이라면, 단순히 가장 앞 자리(start)와 교환한다.
 *              - 하지만 최댓값의 자리 자체가 가장 앞 자리(start)였다면, 해당 자리 이후를 새로운 숫자열로(start + 1) 하여 재귀를 진행한다.
 *              - 중복 최댓값이라면, 백트래킹을 진행하는데 이 때도 위의 조건과 같이 이미 최댓값이 가장 앞자리에 위치했다면 이후의 숫자열만(start + 1) 가지고 재귀한다.
 *              - 중복 최댓값중에 가장 앞 자리에 위치하는 경우가 없다면, 모든 중복 최댓값의 위치와 가장 앞 자리를 비교하는 모든 상황을 백트래킹으로 진행한다.
 *              - 또한 중복 최댓값에서 최댓값 끼리 자리를 교환하는 경우도 있기 때문에 이 숫자열 또한 최대상금의 후보로 넣기 위해 현재의 최대 상금과 비교하여 result를 최신화한다.
 *              - 만약 앞 자리부터 조건에 맞게 최댓값들로 위치시키며 진행해 나갔는데, 뒤에 두자리만 남고 교환 횟수가 아직 남아있다면 이 두자리를 계속 교환하고 result를 최신화한다.
 *              - n이 총 교환 횟수와 같다면 모든 자리 교환이 완료된 것이므로, result를 최신화한다.
 *
 *              백트래킹
 *              (1) 종료 조건 설정
 *              (2) 재귀하기 위한 조건을 확인하고 동작을 설정
 *              (3) 회귀후에 원상복구를 진행, 이후 백트래킹 진행
 */

public class SW_1244 {

    // 상금에 대한 숫자열을 자리 교환을 위해 배열형으로 저장한다.
    public static int[] reward;

    // 동일한 최대값들이 존재 가능하기 때문에, 현재의 교환 횟수의 상황에서 최댓값이 몇 개 중복되고 위치는 어디인지 확인하기 위한 배열을 선언
    public static int[][] same;

    // 총 교환 횟수
    public static int num;

    // 최대 상금
    public static int result;

    public static void dfs(int start, int end, int count){

        // 총 교환횟수만큼 swap 했다면 result와 비교하여 최대 상금 저장
        if(count == num) {
            String st = "";
            for(int i = 0; i < reward.length; i++){
                st += reward[i];
            }
            int rw = Integer.parseInt(st);
            if(result < rw) result = rw;
            return;
        }

        // 한 자리 수가 입력되었을 때에 대한 예외처리
        if(start == end) return;

        // 현재 숫자열의 최댓값
        int max = 0;
        // 현재 숫자열의 최댓값 중복 횟수
        int cnt = 0;

        // start ~ end 까지 조사하며 최대값 저장
        for(int i = start; i <= end; i++){
            if(reward[i] > max) {
                max = reward[i];
            }
        }

        // 최댓값의 위치 저장(중복 최대값 가능)
        for(int i = start; i <= end; i++){
            if(reward[i] == max) {
                same[count][cnt] = i;
                cnt++;
            }
        }

        // 만약 중복 최댓값이고 그 중 하나가 가장 앞자리에 존재한다면 최댓값끼리의 자리 교환이 가능하기 때문에 이 때의 숫자열을 최대 상금 후보로하여 result를 최신화한다.
        if(cnt != 1 && same[count][0] == start){
            String st = "";
            for(int i = 0; i < reward.length; i++){
                st += reward[i];
            }
            int rw = Integer.parseInt(st);
            if(result < rw) result = rw;
        }

        // 만약 끝쪽 2자리에 해당하는 경우에 대해 두 자리수를 총 교환 횟수에 만족할 때까지 바꿔준다.
        if(end - start == 1){
            int temp = reward[start];
            reward[start] = reward[end];
            reward[end] = temp;
            dfs(start, end, count+1);
            temp = reward[start];
            reward[start] = reward[end];
            reward[end] = temp;
        }
        // 만약 최댓값(단일, 중복 모두 가능)이 가장 앞자리에 위치했다면, start를 늘려 숫자열 범위를 좁히고 백트래킹을 진행한다.
        else if(same[count][0] == start) {
            dfs(start + 1, end, count);
        }
        // 만약 중복 최댓값이고 모든 최댓값이 가장 앞 자리 이후에 존재한다면
        else{
            // 그 중 하나의 최댓값과 가장 앞 자리를 교환해주고
            for(int i = 0; i < cnt; i++){
                int temp = reward[start];
                reward[start] = reward[same[count][i]];
                reward[same[count][i]] = temp;
//                System.out.println(Arrays.toString(reward) + " " + count);
                // 교환횟수를 늘려주고 재귀를 진행한다.
                dfs(start+1, end, count+1);
                // 회귀후에 원상복구를 진행하고 다음 최댓값과의 자리 교환의 경우를 계산한다.
                temp = reward[start];
                reward[start] = reward[same[count][i]];
                reward[same[count][i]] = temp;
            }
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
            String str = st.nextToken();
            num = Integer.parseInt(st.nextToken());

            same = new int[num][str.length()];
            reward = new int[str.length()];

            for(int i = 0; i < str.length(); i++){
                reward[i] = str.charAt(i) - '0';
            }
            result = 0;

            if(str.length() == 1) result = Integer.parseInt(str);

            dfs(0, reward.length - 1, 0);

            System.out.println("#" + test_case + " " + result);
        }
    }
}
