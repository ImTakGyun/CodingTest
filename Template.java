import java.io.*;
import java.util.*;

public class Template {
    static int n, m;
    static int[][] board;

//  private void tokenizing() throws IOException { st = new StringTokenizer(r.readLine()); }
//  private int nextInt() { return Integer.parseInt(st.nextToken()); }

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
