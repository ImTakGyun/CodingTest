package SWEA.D2;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 겁나 쓰레기처럼 푼 것 같은데... 가독성도 좋고 메모리와 속도도 나름 좋은 편인 것 같다...
 *              우선, 생각할 점은 숫자 x에 대해서 구성하는 숫자들을 나누는 것이다.
 *              1000까지 증가가 가능하기 때문에 a,b,c,d로 각 자릿수를 입력 받았다. ( a = x%10, b = (x/10)%10, c = (x/100)%10, d = (x/1000)%10 )
 *              a,b,c,d 가 3,6,9 중에 하나라면 3으로 나눈 나머지가 0이 나오게 된다.
 *              따라서 a,b,c,d <각각에 대해 0이 아니면서 3으로 나눈 나머지가 0 이 되는 경우가 존재한다면(if문)>
 *              x를 출력하지 않고 a,b,c,d 각각에 대해 printer 함수를 호출함으로써 n번의 박수가 출력되게 한다.
 *              아니라면(각각의 숫자 모두가 0 또는 3으로 나눈 나머지가 숫자라면) x를 출력한다.
 */
public class SW_1928 {

    public static void printer(int n){
        if(n == 3 || n == 6 || n == 9){
            System.out.print("-");
        }

    }
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int cnt = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        while(cnt <= n){
            a = cnt % 10;
            b = (cnt / 10) % 10;
            c = (cnt / 100) % 10;
            d = (cnt / 1000) % 10;

            if((a != 0 && (a%3) == 0 ) || (b != 0 && (b%3) == 0) || (c != 0 && (c%3) == 0) || (d != 0 && (d%3) == 0 )){
                printer(a);
                printer(b);
                printer(c);
                printer(d);
                System.out.print(" ");
            }
            else System.out.print(cnt + " ");

            cnt++;
        }

    }
}
