package Bakjoon.Sort;

import java.util.*;
import java.io.*;

/**
 * 회고 : 함정이 있었다.
 *       정렬을 한 후 오름차순으로 맞춰진 정렬을 통해, 앞에서부터 더해가는 식으로 생각을 했다.
 *       하지만, 연산 결과값이 산출되면 정렬은 달라진다.
 *       항상 오름차순으로 재정렬을 하고 계산을 진행해야하는데, 이렇게 되면 시간초과가 난다.
 *       이 부분을 간과했고, 깨달음을 얻어 우선순위 큐를 사용해야함을 알게되었다.
 *
 *       <우선순위 큐>를 사용한다면, 언제나 가장 작은 수들이 반환 가능하고 연산으 진행한 결과값을 다시 우선순위 큐에 집어 넣는다면
 *       우리는 매번 재정렬 할 필요가 없이, 매번 작은 수부터 연산을 진행할 수 있다.
 *
 *       추가로, 이미 정렬된 숫자뭉치가 하나만 들어올 경우 비교횟수는 필요가 없다.
 *       때문에 0이 호출되는 것이 맞는데 이를 착각하고 하나의 뭉치가 들어오더라도 하나의 뭉치의 수만큼의 값이 출력되어야 한다고 생각했다.
 *
 * 핵심 Point : 모든 연산을 가장 작은 수부터 진행해야하는 경우, 재정렬이 필요하다면 우선순위 큐를 사용하자.
 */
public class B_1715 {

    public int n, result;
    public PriorityQueue<Integer> pq;

    public void Solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(Integer.parseInt(st.nextToken()));
        }

        while(pq.size() != 1){
            int n1 = pq.poll();
            int n2 = pq.poll();

            int sum = n1 + n2;
            result += sum;
            pq.add(sum);
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws Exception{
        new B_1715().Solution();
    }
}
