package algorithm.Search.Practice;

import java.util.*;
import java.io.*;

public class 실전_부품찾기_계수정렬 {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N(가게의 부품 개수)
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[1000001];

        st = new StringTokenizer(br.readLine());

        // 매장에 존재하는 부품들을 기억한다.
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(st.nextToken());
            arr[x] = 1;
        }

        st = new StringTokenizer(br.readLine());

        // M(손님이 확인 요청한 부품 개수)
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        String[] customer = new String[n];
        for(int i = 0; i < m; i++){
            int item = Integer.parseInt(st.nextToken());
            // 해당 부품이 존재하는지 확인
            if(arr[item] == 1){
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }
    }

    public static void main(String[] args) throws IOException{
        new 실전_부품찾기_계수정렬().solution();
    }

}
