package algorithm.greedy;

import java.util.*;
import java.io.*;

/**
 * greedy 알고리즘을 이용한 기본 문제
 * 주의점 : 탐욕적 방식을 통해 정확한 답을 찾는다는 보장이 있을 떄 효과적
 *        따라서 해법이 정당한지 검토하는 과정이 필요하다.
 *  검증 : 반복되는 수열을 통해 가장 큰 수와 두 번째로 큰 수가 등장하는 횟수를 파악한다.
 */
public class LawOfLargeNum {

    static int n;
    static int m;
    static int k;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        for(int i = 0; i<n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        int count = m / (k + 1) * k;
        count += m % (k + 1);

        int sum = first * count + second * (m - count);

        System.out.println(sum);
    }
}
