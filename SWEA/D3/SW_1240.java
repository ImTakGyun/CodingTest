package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : <문자열을 원하는대로 끊어먹기>
 *
 *              - 딱히 어려운 문제는 아니었다.
 *              - 다만 문제 설명에 대한 충분한 이해와 문자열을 구분하는 이해가 필요한 문제였다.
 */
public class SW_1240 {

    public static String[] encrypt = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
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

            int start = 0;
            int end = 0;
            String code = "";

            // 입력받은 n개의 줄을 조회
            for(int i = 0; i < n; i++){
                String str = br.readLine();

                // 입력된 줄의 오른쪽 끝부터 왼쪽으로 순차적으로 순회한다.
                for(int j = str.length() - 1; j > 0; j--){
                    // 만약 1이 등장한다면 이전 위치 인덱스를 end에 저장하고(substring을 받기 위해 +1) end에서 56칸 왼쪽에 위치한 인덱스 값을 start에 저장한다.
                    if(str.charAt(j) == '1') {
                        end = j  + 1;
                        start = end - 56;
                        // start부터 end까지의 문자열을 code에 보관해둔다.
                        code = str.substring(start, end);
                        break;
                    }
                }
            }

            // code에서 7개의 비트로 이루어진 8개의 암호문을 구분하여 보관하기 위한 arr 선언
            String[] arr = new String[8];
            // 각각의 암호문을 복호화한 값을 저장하기 위한 decrypt 선언
            int[] decrypt = new int[8];

            // code 문자열을 7자리씩 끊어서 arr에 저장한다.
            for(int i = 0; i < 8; i++){
                arr[i] = code.substring(i * 7, (i + 1) * 7 );

                // 저장된 7자리의 문자열(암호문)을 해독표를 통해 복호화한 후 decrypt에 저장한다.
                for(int j = 0; j < 10; j++){
                    if(arr[i].equals(encrypt[j])) decrypt[i] = j;
                }
            }

            int a = 0;
            int b = 0;

            // 홀수 자리 합과 짝수 자리 합을 나누어 저장하고
            for(int i = 0; i < 8; i+=2){
                a += decrypt[i];
                b += decrypt[i+1];
            }

            // 조건의 만족 여부에 따라서 결과를 출력한다.
            if(((a * 3 + b) % 10) == 0) System.out.println("#" + test_case + " " + (a + b));
            else System.out.println("#" + test_case + " " + 0);

        }
    }
}
