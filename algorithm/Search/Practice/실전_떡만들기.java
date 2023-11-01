package algorithm.Search.Practice;

import java.util.*;
import java.io.*;

/**
 * <전형적인 이진탐색 문제이자 파라메트릭 서치 유형의 문제>
 *     파라메트릭 서치? : 원하는 조건을 만족하는 가장 알맞은 값을 찾는 문제 -> 최적화 문제를 결정 문제로 바꾸어 해결하는 기법
 *
 *  핵심 Point : 설정한 높이(H)를 크게 잡으면 잘린 떡의 길이는 짧아지고 작게 잡으면 잘린 떡의 길이는 길어지기 때문에 이를 이용하여 이진탐색을 수행할 수 있게된다.
 *              현재 설정한 높이(H)로 도출한 결과를 통해 조건의 만족 여부를 판별하고 이를 따라서 탐색 범위를 좁혀가며 문제를 해결하는 것이다.
 *              (절단기의 높이가 0 ~ 10억 이기 때문에 순차탐색의 경우 시간초과 -> <이진탐색 아이디어를 떠올리기>)
 *  어려웠던 점: 이진탐색이 들어가는 위치를 파악하기 힘들었다.
 *            처음에는 크기순으로 나열 후에 큰 것부터 순차적으로 차이를 더해가며 m 이상이 되는 순간을 구한 후
 *            마지막 떡의 길이와 그 전의 떡의 길이를 가지고 이진 탐색을 수행하며 높이의 최대를 구하려 하였다.
 *            하지만 이는 복잡한 로직이었고 m의 길이는 20억까지 가능하였기에 최대 n번 반복은 불가피했다. 또한 0~10억 사이의 이진탐색도 가능하였다.
 *            이의 시간복잡도는 O(N)이지만 이코테 로직의 단순성을 고려하면 힘든 구현이었다.
 *
 *  배운 점:    처음부터 0~10억 사이의 이진탐색을 통해 각각의 H에 대한 total을 계산하는 로직을 통해 간단히 구현할 수 있었다.
 *            물론 시간복잡도는 위보다 높기는 하였지만 이 또한 O(logN) * O(N)으로 높은 편은 아니었다.
 *            구현의 단순성을 고려하면 해당 방식이 옳다고 생각한다.
 *
 *            <특정값을 이용한 리스트의 각 데이터 차의 최소의 합을 구하는 문제는 특정값을 구하기 위한 로직이 중점이 됨을 알 수 있었다.>
 *             -> 특정값을 구하기 위해 이진탐색을 이용하고 total을 통해 최적인지 아닌지 판단하면 해결가능했다.
 *
 */
public class 실전_떡만들기 {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] riceCake = new int[n];

        for(int i = 0; i < n; i++){
            riceCake[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색을 위한 시작점과 끝점 설정
        int start = 0;
        int end = (int) 1e9;
        int result = 0;
        while(start <= end){
            long total = 0;
            int mid = (start + end) / 2;

            for(int i = 0; i < n; i++){
                if(riceCake[i] > mid)
                    total += (riceCake[i] - mid);
            }

            if(total < m) end = mid - 1;
            else {
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);

    }

    public static void main(String[] args) throws IOException{
        new 실전_떡만들기().solution();
    }
}
