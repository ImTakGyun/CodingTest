package Bakjoon.DFSBFS;

import java.util.*;
import java.io.*;

/**
 * <질문의 역발상 - 학생을 선생으로부터 모두 숨겼을 때의 장애물의 개수로 정답을 산출하자!>
 *
 * 회고 : 물론, NxN 의 복도에서 빈 칸에서 장애물이 설치될 공간 3가지를 콤비네이션으로 뽑아서 성공하는 경우가 존재하면 결과를 산출할 수도 있다.
 *       하지만 위의 경우 모든 빈칸에서 3개의 공간을 뽑아야하는데 시간복잡도가 커진다.
 *       따라서 나는 학생들을 선생들의 확인에서 장애물을 이용하여 모두 숨겼을 때, 장애물이 설치된 개수가 3개를 초과하면 실패하는 것으로 진행했다.
 *       선생이 학생을 발견하면 중간에 장애물을 설치해서 학생을 숨기는 것이다.
 *       이렇게 장애물을 설치하면 다른 선생의 중복 확인 또한 피할 수 있고 시간 복잡도를 고려했을 때도, 선생의 시야를 한 번 씩만 확인하면 된다.
 *
 * 핵심 Point : 그저 구현만 하지 말자.
 *             적당히 생각해보고 방법이 없다면 단순 구현을 진행하지만
 *             더욱 간단한 방법이 있을지도 모르기에 5~10분간만 생각을 진행해보자.
 */

public class B_18428 {

    // NxN 의 복도를 구성
    public int n;
    public int[][] arr;
    // 설치된 장애물의 개수
    public int obj = 0;
    // 방향
    public int[] dx = {-1, 0 ,1, 0};
    public int[] dy = {0, 1, 0, -1};

    // 선생님의 위치에서 특정 방향 확인
    public void dfs(int x, int y, int dr){
        // 이미 장애물을 4개 이상 설치해야하는 상황이라면 종료
        if(obj > 3) return;

        int nx = 0, ny = 0;

        while(true){

            // 특정 방향으로 한 칸 이동 후의 좌표
            nx = x + dx[dr];
            ny = y + dy[dr];

            // 이동 후의 좌표가 유효할 때
            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                // 해당 좌표에 장애물이 존재한다면 더 이상 확인이 불가능하므로 종료
                if (arr[nx][ny] == 3) break;
                // 만약 학생이 존재한다면
                else if (arr[nx][ny] == 1) {
                    // 학생과 선생님이 나란히 존재한다면 장애물로 막을 수 없기에 무조건 실패(obj에 임의의 실패값 대입)
                    if(arr[x][y] == 2) {
                        obj = 100;
                        return;
                    }
                    // 학생과 선생님이 나란히 존재하지 않는다면 장애물 설치
                    arr[x][y] = 3;
                    // 설치된 장애물의 수 증가
                    obj++;
                    break;
                }
            }
            // 이동 후의 좌표가 유효하지 않다면 종료
            else return;

            // 다음의 이동을 위해서 좌표 변경
            x = nx;
            y = ny;
        }
    }

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 복도 구성(빈칸 = 0, 학생 = 1, 선생 = 2, 장애물 = 3)
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){

                char apl = st.nextToken().charAt(0);

                if(apl == 'X') arr[i][j] = 0;
                else if(apl == 'S') arr[i][j] = 1;
                else arr[i][j] = 2;
            }
        }

        // 선생님의 위치에서 모든 방향을 확인
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 2){
                    for(int dr = 0; dr < 4; dr++) dfs(i, j, dr);
                }
            }
        }

        // 학생을 선생으로부터 모두 숨겼을 때, 장애물이 3개 이하로 필요하면 성공, 4개 이상 필요하면 실패
        if(obj <= 3) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void main(String[] args) throws Exception{
        new B_18428().solution();
    }
}
