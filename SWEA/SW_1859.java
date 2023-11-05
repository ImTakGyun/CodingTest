package SWEA;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 알면 쉽고 모르면 어려운 전형적인 구현 문제이다.
 *              이런 문제의 경우 문제를 잘 읽고 아이디어를 떠올리는 것이 굉장히 중요하다.
 *              주어진 일자에 따라 매매가가 달라지고 구매한 물건을 판매하기 위해서는 남은 일자중에 가장 비싸지는 일자에 파는 것이 최대 수익이다.
 *
 *              (1) 주어진 일자중에 가장 가격이 비싼 일자를 지정하고 해당 일자전까지 모든 일자에 대해 (비싼 가격 - 해당 일자 가격)의 합을 통해 수익을 구한다.
 *                  이후에 남은 일자들중에 다시 가격이 가장 비싼 일자를 지정하고 반복한다.
 *
 *              (1)의 경우 떠올리기 쉬운 아이디어이지만, 시간 복잡도가 올라간다.
 *
 *              <따라서 우리는 거꾸로 접근하는 방법(2)을 이용해야한다.>
 *              (2) 마지막 일자부터 접근해서 해당 일자의 가격을 최대 가격으로 지정하고 그전의 일자 가격이 해당 일보다 싸다면 차익을 더하고
 *                  오히려 그전의 일자가 비싸다면 그 때의 가격을 최대 가격으로 update 하는 것이다.
 *                  이렇게 진행하면 남은 일자에서의 최대가 되는 가격은 자연스럽게 지정이되고, 우리는 새로운 최대 가격이 나타나기 전까지의 차익을 구해서 더하면 되는 것이다.
 */
class SW_1859
{
    public static int[] days;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());

            // 입력될 N일 간의 매매가를 저장할 공간 생성
            int n = Integer.parseInt(st.nextToken());
            days = new int[n];

            st = new StringTokenizer(br.readLine());

            // N일 간의 매매가를 저장
            for(int i = 0; i < n; i++)
                days[i] = Integer.parseInt(st.nextToken());

            // 뒤에서부터 확인하며 이전일보다 당일 가격이 높다면 차익을 더한다.
            int max = days[n-1];
            long sum = 0;

            for(int i =2; i < n+1; i++){
                if(days[n-i] < max) sum += (max - days[n-i]);
                if(days[n-i] > max) max = days[n-i];
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}
