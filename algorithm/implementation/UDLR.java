package algorithm.implementation;

import java.util.*;
import java.io.*;

public class UDLR {
    //시뮬레이션 유형 -> 쉬운 알고리즘이지만 한 줄 입력을 받아 특정 조건으로 분리하여 배열을 만드는 r.readLine().split(" ")에 대해 무지했음.
    //이동 후의 좌표를 저장하는 변수들을 만들어 놓고 이동 가능한지를 판별하는 부분이 point
    static int n;
    static int x =1, y = 1;

    // 동서남북 이동 (>, <, v, ^ ) => x는 행, y는 열
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    // R: 오른쪽으로 한 칸(0, 1), L: 왼쪽으로 한 칸(0, -1), D: 아래로 한 칸(1,0), U: 위로 한 칸(-1, )
    static char[] moveTypes = {'R', 'L', 'D', 'U'};

    public static void main(String[] args) throws IOException {

        // 버퍼 리더기 생성.
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        // 버퍼에서 한 줄을 읽는다.
        StringTokenizer st = new StringTokenizer(r.readLine());

        // 읽어온 라인을 공백을 기준으로 Token으로 생성하여 반환한다.
        n = Integer.parseInt(st.nextToken());

        // 버퍼에서 읽어온 한 줄을 " "을 기준으로 구분하여 배열에 담는다.
        String[] plans =  r.readLine().split(" ");

        for(int i = 0; i < plans.length; i++) {
            //String.charAt('index') => String에서 해당 인덱스에 해당하는 값을 char로 가져온다.
            char plan = plans[i].charAt(0);

            //이동 후의 좌표를 미리 계산하여 담아둘 공간 생성
            int nx = 0, ny = 0;

            for(int j = 0; j < 4; j++){
                if(plan == moveTypes[j]){
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }

            if(nx < 1 || ny < 1 || nx > n || ny > n) continue;

            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }
}
