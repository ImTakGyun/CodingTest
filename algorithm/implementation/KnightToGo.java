package algorithm.implementation;

import java.util.*;
import java.io.*;

// 2차원 배열이 사용되는 전형적인 구현 문제
public class KnightToGo {
    // 해결 아이디어 => 구현 문제라서 조건에 충실하면 됨
    // 어려웠던 점 => 입력 받은 String에서 charAt() 함수를 통해 문자를 분리하여 받아올 수 있음을 몰랐음.

    static int n = 8;

    public static void main(String[] args) throws IOException{

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());

        String inputData = st.nextToken();

        // 현재 나이트의 위치 입력받기 => String 의 charAt()을 통해 문자를 분리하여 원하는 위치값을 변환
        int row = inputData.charAt(1) - '0';
        int column = inputData.charAt(0) - 'a' + 1;

        //나이트가 이동할 수 있는 8가지 방향 정의
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        //8가지 방향에 대하여 이동 이후의 위치가 유효한지 확인
        int result = 0;
        for (int i = 0; i < 8; i++){
            //이동하고자 하는 위치 확인
            int nextRow = row + dy[i];
            int nextColumn = column + dx[i];

            if(nextRow >= 1 && nextRow <= n && nextColumn >= 1 && nextColumn <= n)
                result++;
        }

        System.out.println(result);
    }
}
