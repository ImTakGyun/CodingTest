package algorithm.Search.Practice;

import java.util.*;
import java.io.*;

/**
 *   배운점 : 이진 탐색이 어느 부분에 들어가야 하는지 잘 모르겠다면, 제공된 조건이 10억과 같이 굉장히 크다면, <파라메트릭 서치>를 고려해보자.
 *          -> 떡 만들기 문제에서는 잘라낼 높이(H)를 이분탐색으로 진행하여 조건의 만족 여부에 따라 만족한다면 따로 저장해두고, 최적을 위한 반복을 진행했다.
 *          -> 공유기 설치 문제 또한, 위와 같이 거리 간격을 이분탐색 대상으로 진행하여 조건의 만족 여부에 따라 반복을 통해 최적의 거리를 구하는 로직이었다.
 *
 *   핵심 Point : <이진 탐색을 이용한 파라메트릭 서치 유형>
 *
 *               공유기 사이의 거리를 기준으로 Binary Search 를 진행하고 조건에 만족하는 거리를 구하고 최적의 조건으로 반복하며 최적의 결과를 구한다.
 *               -> 거리 : 최소(1), 최대(최대거리의 집 - 최소거리의 집)
 *               -> 거리를 기준으로 이분 탐색을 진행하여 mid 거리 이상의 간격으로 공유기를 설치한다.
 *               -> 설치된 공유기의 개수가 c보다 작다면 거리를 짧게 잡아야 하기 때문에 최대(end)를 mid - 1로 잡는다.
 *               -> 설치된 공유기의 개수가 c보다 크거나 같다면 거리를 넓게 잡아 조건에 만족시키거나 최적의 값을 구해야하므로 최소(start)를 mid + 1로 잡고 mid는 result에 저장해둔다.
 */
public class Q29_공유기설치 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //  집의 개수(N)와 공유기의 개수(C)를 입력받기
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 전체 집의 좌표 정보를 입력받기
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색을 위해 정렬 수행
        Arrays.sort(arr);

        int start = 1;                  // 가능한 최소 거리(min gap)
        int end = arr[n-1] - arr[0];    // 가능한 최대 거리(max gap)
        int result = 0;

        while(start <= end){
            // mid는 가장 인접한 두 공유기 사이의 거리(gap)을 의미
            int mid = (start + end) / 2;
            // 첫째 집에는 무조건 공유기를 설치한다고 가정
            int value = arr[0];
            int cnt = 1;

            // 현재의 mid 값을 이용해 앞에서부터 공유기를 설치하기
            for(int i = 0; i < n; i++){
                if(arr[i] >= value + mid){
                    value = arr[i];
                    cnt++;
                }
            }

            // C개 이상의 공유기를 설치할 수 있는 경우, 거리를 증가시키기
            if(cnt >= c){
                start = mid + 1;
                result = mid;
            }
            // C개 이상의 공유기를 설치할 수 없는 경우, 거리를 감소시키기
            else end = mid - 1;
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        new Q29_공유기설치().solution();
    }
}
