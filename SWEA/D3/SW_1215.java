package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 배열의 위에서부터 오른쪽으로 각 문자를 확인하기 때문에 회문이 형성되는 방향은 오른쪽, 아랫쪽 두 방향으로 이것만 확인하면 된다.
 *              조건에 만족하면 회문의 개수를 늘려줘야하는데 구현이 쉽지 않았기에, <우선 늘려주고 조건에 맞지 않으면 줄이는 방향으로 진행했다.>
 */
public class SW_1215 {

    public static char[][] arr;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            arr = new char[8][8];

            for(int i = 0; i < 8; i++){
                String str = br.readLine();
                for(int j = 0; j < 8; j++){
                    arr[i][j] = str.charAt(j);
                }
            }

            int result = 0;

            // 배열의 모든 문자를 순서대로 지나면서 오른쪽으로, 아래쪽으로 생성되는 회문을 확인(시작을 위에서부터 항상 왼쪽으로 조사하기 때문에 회문은 오른쪽, 아랫쪽 2가지 방향만 세면 된다.)
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){

                    // 조건의 길이만큼 회문이 형성되는지 확인
                    int nx = i + n - 1;
                    int ny = j + n - 1;

                    if(ny >= 0 && ny < 8) {
                        // 조건에 만족한다면 우선 회문이 된다고 가정하고 +1
                        result++;
                        for (int k = 0; k < (n+1)/2; k++) {
                            // 회문 조건에 부합하지 않다면 -1을 진행하고 break
                            if (arr[i][j + k] != arr[i][ny - k]) {
                                result--;
                                break;
                            }
                        }
                    }

                    if(nx >= 0 && nx < 8) {
                        // 조건에 만족한다면 우선 회문이 된다고 가정하고 +1
                        result++;
                        for (int k = 0; k < (n+1)/2; k++) {
                            // 회문 조건에 부합하지 않다면 -1을 진행하고 break
                            if (arr[i + k][j] != arr[nx - k][j]) {
                                result--;
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
