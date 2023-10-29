package algorithm.Sort.Practice;

import java.util.*;
import java.io.*;

/**
 *  최대 K번의 교체이므로 a의 원소가 b의 원소보다 큰 경우 교체를 하지 않아도 된다.
 *  이 점을 감안하지 못하여 실수할 뻔 했다.
 *  문제를 잘 읽자...!!!!
 */
public class 실전_두배열의원소교체 {

    public void solution() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, k;

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        Integer[] b = new Integer[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for(int i = 0; i < k; i++){
            // A의 원소가 B의 원소보다 작은 경우
            if (a[i] < b[i]) {
                // 두 원소를 교체
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
            // A의 원소가 B의 원소보다 크거나 같을 때, 반복문을 탈출
            else break;
        }

        int result = Arrays.stream(a).sum();
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException{
        new 실전_두배열의원소교체().solution();
    }
}
