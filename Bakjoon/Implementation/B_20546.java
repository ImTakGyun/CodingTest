package Bakjoon.Implementation;

import java.util.*;
import java.io.*;

/**
 *  회고 : 그리디 방식의 준현(j)와 단순 구현 방식의 성민(s)의 주식 대회
 *        for-each 문의 방식을 좀 더 이해하는 계기가 되었다.
 *        문제는 쉬운 수준이었고 흐름을 따라가면 되었지만, 성민이의 33법칙에서 4번 이상 주식이 하락하는 경우도 존재하기에 고려했어야 했다.
 *
 *  핵심 point : 4번 이상 주식이 하락하는 경우 3번 하락시에도 매수, 4번 하락시에도 가능하다면 매수해야했다.
 *              이부분을 놓쳐서 한 번 실패했다.
 */

public class B_20546 {

    int cash;
    int[] stocks = new int[14];

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cash = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < stocks.length; i++){
            stocks[i] = Integer.parseInt(st.nextToken());
        }

        int jstock = 0, jcash = cash;
        int sstock = 0, scash = cash;

        for(int stock : stocks){
            if(jcash >= stock){
                int buy = jcash / stock;
                jcash -= buy * stock;
                jstock += buy;
            }
        }

        int preStock = stocks[0];
        int up = 0;
        int down = 0;

        for(int i = 1; i < stocks.length; i++){
            if(preStock < stocks[i]){
                up++;
                down = 0;
            }
            else if(preStock > stocks[i]){
                up = 0;
                down++;
            }

            if(up == 3){
                scash += sstock * stocks[i];
                sstock = 0;
            }
            else if(down >= 3){
                int buy = scash / stocks[i];
                scash -= buy * stocks[i];
                sstock += buy;
            }

            preStock = stocks[i];
        }

        jcash += jstock * stocks[13];
        scash += sstock * stocks[13];

        if(jcash > scash) System.out.println("BNP");
        else if(jcash < scash) System.out.println("TIMING");
        else System.out.println("SAMESAME");

    }

    public static void main(String[] args) throws Exception{
        new B_20546().solution();
    }
}
