package algorithm.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UDLR {
    //시뮬레이션 유형 -> 쉬운 알고리즘이지만 한 줄 입력을 받기 위해서는 버퍼를 비워야한다는 부분을 주의해야함. -> nextLine() 또는 ArrayList를 가지고 add 를 반복해야함.
    //이동 후의 좌표를 저장하는 변수들을 만들어 놓고 이동 가능한지를 판별하는 부분이 point
    static int n;
    static int x =1, y = 1;

    // 동서남북 이동 (>, <, v, ^ )
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[] moveTypes = {'R', 'L', 'D', 'U'};

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();  // 버퍼 비우기
        String[] plans = sc.nextLine().split(" ");

        for(int i = 0; i < plans.length; i++) {
            //String.charAt('index') => String에서 해당 인덱스에 해당하는 값을 char로 가져온다.
            char plan = plans[i].charAt(0);

            //이동 후의 좌표를 미리 계산
            int nx = 0, ny = 0;

            for(int j = 0; j < 4; j++){
                if(plan == moveTypes[j]){
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }

            if(nx < 1 || ny < 1|| nx > n || ny > n) continue;

            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }
}
