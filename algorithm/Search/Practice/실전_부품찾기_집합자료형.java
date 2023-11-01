package algorithm.Search.Practice;

import java.util.*;
import java.io.*;

public class 실전_부품찾기_집합자료형 {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N(가게의 부품 개수)
        int n = Integer.parseInt(st.nextToken());

        // 집합(Set) 정보를 처리하기 위한 HashSet 라이브러리
        HashSet<Integer> s = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        // 매장에 존재하는 부품들을 Set 자료형으로 기억한다.
        for(int i = 0; i < n; i++){
            s.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        // M(손님이 확인 요청한 부품 개수)
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for(int i = 0; i < m; i++){
            int item = Integer.parseInt(st.nextToken());

            // 해당 부품이 존재하는지 확인
            if(s.contains(item)){
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }
    }

    public static void main(String[] args) throws IOException{
        new 실전_부품찾기_집합자료형().solution();
    }
}
