package algorithm.Search.Practice;

import java.util.*;
import java.io.*;

/**
 * 매장의 재고 리스트를 <정렬>함으로써 이진탐색이 가능하도록 만들 수 있었다.
 *  + 이진 탐색은 해당 문제에서 오히려 복잡한 방법이었다.
 *  + 계수 정렬, Set 자료형을 통해 더욱 단순한 구현이 가능했기 때문이다.
 */
public class 실전_부품찾기_이진탐색 {

    public String BinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] == target) return "yes";
            else if(arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return "no";
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 매장에 존재하는 부품들을 기억한다.
        int[] store = new int[n];
        for(int i = 0; i < n; i++){
            store[i] = Integer.parseInt(st.nextToken());
        }

        // 매장의 부품들을 정렬한다.
        Arrays.sort(store);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 손님이 주문한 부품들을 기억한다.
        int[] customer = new int[n];
        for(int i = 0; i < m; i++){
            customer[i] = Integer.parseInt(st.nextToken());
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for(int i = 0; i < m; i++){
            System.out.print(BinarySearch(store, customer[i]) + " ");
        }
    }

    public static void main(String[] args) throws IOException{
        new 실전_부품찾기_이진탐색().solution();
    }
}
