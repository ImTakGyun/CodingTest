package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : <완전 탐색 + 가지치기>
 *
 *              - 문제에서 주어진 조건을 분석해보면 최대 자릿수는 6자리, 최대 교환 횟수는 10번이다.
 *              - 때문에 각각의 교환에 대하여 완전 탐색을 진행할 때 6C2 = 15 이므로 15^10 의 시간복잡도가 계산된다.
 *              - 이는 제한 시간을 아슬아슬하게 초과하기 때문에 가지치기를 진행해야 한다.
 *
 *              전체적인 로직
 *              - 완전 탐색을 통해 첫번째 자리부터 마지막 자리까지 모든 교환의 경우를 수립한다.
 *              - 교환 진행후 재귀를 통해 교환 후의 숫자열에 대하여 교환횟수를 증가시키고 이를 반복한다.
 *              - 백트래킹을 통해 모든 자리 교환의 상황을 확인할 수 있다. -> 모든 경우를 비교하며 지정된 교환 횟수의 결과에서 최댓값을 얻는다.
 *              - 하지만, 모든 경우를 계산하면 시간 초과가 발생하기 때문에 가지치기를 삽입한다.
 *              - 가지치기의 경우, 이미 진행한 숫자열에 대한 동일한 교환을 v("몇 번째 교환인지, 숫자열"을 저장한 배열)를 통해 제거하는 것이다.
 *              - 44 ~ 56 줄의 코드를 통해 동일한 숫자열에 대한 동일 교환 상황은 제외된다.
 *
 *              백트래킹
 *              (1) 종료 조건 설정
 *              (2) 재귀하기 위한 조건을 확인하고 동작을 설정
 *              (3) 회귀후에 원상복구를 진행, 이후 백트래킹 진행
 */
public class SW_1244_Solution {
    // 숫자열의 교환을 위한 상금의 배열형
    public static int[] reward;
    // 교환 횟수
    public static int num;
    // 결과값(최대상금)
    public static int result;
    // 같은 교환 순서에 대해 같은 숫자열일 경우를 가지치기하기 위해서 선언
    public static ArrayList<ArrayList<Integer>> v;

    //완전 탐색을 백트래킹으로 실시하고 가지치기하는 로직
    public static void dfs(int n){

        // n이 총 교환 횟수와 같다면 결과를 result와 비교하여 최대상금을 측정
        if(n == num) {
            String str = "";
            for(int i = 0; i < reward.length; i++){
                str += reward[i];
            }
            int rw = Integer.parseInt(str);
            if(result < rw) result = rw;
            return;
        }

        // n이 num(총 교환횟수)보다 작다면, 완전 탐색을 진행하여 i번쨰 자리의 교환을 탐색한다.
        for(int i = 0; i < reward.length - 1; i++){
            for(int j = i + 1; j < reward.length; j++){

                // i와 j의 자리를 교환하고
                int temp = reward[i];
                reward[i] = reward[j];
                reward[j] = temp;

                // 교환후의 상금을 int로 선언한 후
                String c_reward = "";
                for(int t = 0; t < reward.length; t++){
                    c_reward += reward[t];
                }

                int check = Integer.parseInt(c_reward);

                // 이미 해당 숫자열에 대해 같은 교환횟수를 가진채 실행한 내역을 확인하고 있다면 다음 자리 교환으로 넘어간다.
                if(v.get(n).contains(check)){
                    temp = reward[i];
                    reward[i] = reward[j];
                    reward[j] = temp;
                    continue;
                }

                // 실행한 내역이 없다면 해당 자리 교환 후, 교환 횟수를 늘려서 재귀를 진행한다.
                dfs(n + 1);

                // 해당 경우에 대한 결과를 계산했다면, 내역을 저장하고 백트래킹을 진행한다. -> 교환했던 자리를 원상복구하고 다음 자리 교환으로 넘어간다.
                c_reward = "";
                for(int t = 0; t < reward.length; t++){
                    c_reward += reward[t];
                }
                check = Integer.parseInt(c_reward);
                v.get(n).add(check);
                temp = reward[i];
                reward[i] = reward[j];
                reward[j] = temp;
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

            String str = st.nextToken();                // 숫자열
            num = Integer.parseInt(st.nextToken());     // 교환 횟수
            v = new ArrayList<>();                      // v 초기화

            for(int i = 0; i < num; i++){
                v.add(new ArrayList<>());
            }

            reward = new int[str.length()];

            for(int i = 0; i < str.length(); i++){
                reward[i] = str.charAt(i) - '0';        // 숫자열을 배열형으로 변환
            }
            result = 0;

            dfs(0);

            System.out.println("#" + test_case + " " + result);
        }
    }
}
