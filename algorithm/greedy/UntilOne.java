package algorithm.greedy;

import java.util.*;
import java.io.*;

//문제 해결 아이디어 : 주어진 N에 대하여 최대한 많이 나누기를 수행하면 된다. -> 한 번 나누는 작업은 빼는 작업 여러번과 같기 때문이다.
public class UntilOne {
    static int n, k;
    static int count = 0;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());

        Scanner st = new Scanner(System.in);

        // 공백을 기준으로 구분하여 입력 받기
        n = st.nextInt();
        k = st.nextInt();

        // 초기 답안 -> 내것이 더 직관인 것 같다.
        while(n>1) {
            if (n % k == 0) {
                n /= k;
                count++;
            } else {
                n -= 1;
                count++;
            }
        }

//        // 나동빈 답안
//        while(true) {
              // N이 K로 나누어 떨어지는 수가 될 때까지 뺴기
//            int target = (n/k) * k;
//            count += (n - target);
//            n = target;
//
              // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
//            if(n<k) break;
//
              // K로 나누기
//            n /= k;
//            count ++;
//        }
//
          // 마지막으로 남은 수에 대하여 1씩 뺴기 (위에 로직은 0으로 만드는 횟수 이기 때문, 그리고 n(target)은 항상 0이 되어 넘어오게 된다
//        count += (n-1);

        System.out.println(count);
    }
}
