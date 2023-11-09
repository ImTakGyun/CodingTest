package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : <손님을 sort 하고, 앞에서부터 해당 손님이 몇 번쨰로 도착했는지와 그때까지 만들어진 총 붕어빵 개수를 비교하면 풀 수 있다.>
 *
 *            - 꽤나 애먹은 문제였다.
 *            - 감을 잡기 어려웠다. 계속 매초 생성된 붕어빵에서 손님의 명수를 제외하려고 했더니 굉장히 복잡했다.
 *            - 애초에 반대로 생각해서 손님이 도착했을 때 붕어빵이 몇 개 만들어졌는지를 확인하면 훨씬 수월했다.
 */
public class SW_1860 {

    public static void main(String args[]) throws Exception
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] cust = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                cust[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(cust);

            String ans = "Possible";

            for(int i = 0; i < n; i++){
                if((cust[i] / m ) * k < (i + 1)) {
                    ans = "Impossible";
                    break;
                }
            }

            System.out.println("#" + test_case + " " + ans);

            /**
             * 조금 돌아간 방법 - 시간 복잡도가 굉장히 복잡하다.
             *              - 다만 풀 수 있으면 된거지...
             *              - 매초 붕어빵이 생성된 개수와 해당 시간부터 그 전까지 들릴 손님의 명수를 뺴서 저장한다.
             *              - sort 시에 가장 앞단에 -가 나오면 이는 Impossible
             *              - 아니라면 Possible
             */
//            int last = cust[cust.length - 1];
//
//            int[] num = new int[last+1];
//
//
//            for(int i = 0; i < last + 1; i++){
//
//                int minus = 0;
//
//                for(int j = 0; j < cust.length; j++){
//                    if(cust[j] <= i)
//                        minus++;
//                    else break;
//                }
//
//                num[i] = (i / m) * k - minus;
//            }
//
//            System.out.print("#" + test_case + " ");
//
//            Arrays.sort(num);
//
//            if(num[0] < 0) System.out.println("Impossible");
//            else System.out.println("Possible");
        }
    }
}
