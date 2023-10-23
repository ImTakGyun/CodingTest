import java.io.*;
import java.util.*;

public class Template {
    static int n, m;
    static int[][] board;

    // 2차원 리스트 90도 회전하기
    public int[][] rotateMatrixBy90Degree(int[][] a){
        int n = a.length;
        int m = a[0].length;

        int[][] result = new int[m][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result[j][n - i - 1] = a[i][j];
            }
        }
        return result;
    }

    private void solution() throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
            sb.append(Arrays.toString(board[i])).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Template().solution();
    }
}
