package algorithm.DynamicProgramming.Practice;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 다이나믹 프로그래밍 문제를 풀 때는 논리적인 점화식이 필요하다.
 *              i번째 값을 선택할지 말지에 대한 선택에 까지는 생각이 미쳤지만 어떤 기준을 가지고 결정해야하는지 생각이 나지 않았다.
 *              i번째 식량창고까지의 최적의 해를 구한다는 개념으로 <i-1까지의 최적의 해>와 <i-2까지의 최적의 해 + i번째 값>의 비교를 통해 현재까지(i)의 최적의 값을 구했어야했다..
 *              이 문제에서 점화식을 세우기 위한 Point는 <i번째 식량창고까지의 최적의 해(최대값)>을 구하고 고려대상이 되는 리스트의 값을 늘려가며
 *              <i-1번째 까지에서의 최대 + i+1 번째 수> vs <i번째 까지의 최대> 를 통해 최대값을 구하는 식을 반복하는 것이었다.
 */
public class 실전_개미전사 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정수 N을 입력받기
        int n = Integer.parseInt(st.nextToken());

        // 모든 식량 정보 입력받기
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
        int[] value = new int[n];

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        value[0] = arr[0];
        value[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < n; i++){
            value[i] = Math.max(value[i-1], value[i-2] + arr[i]);
        }

        // 계산된 결과 출력
        System.out.println(value[n-1]);
    }

    public static void main(String[] args) throws IOException{
        new 실전_개미전사().solution();
    }
}
