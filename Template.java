import java.io.*;
import java.util.*;

public class Template {
    static int n, m;
    static int[][] board;

    /**
     * <2차원 리스트 90도 회전하기>
     */
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

    /**
     * <countByRange>를 통해 정렬된 문자열에서 특정 범위의 숫자가 몇 개 포함되어있는지 확인하는 로직
     *
     * <lowerBound>를 통해 특정 범위의 최솟값에 해당하는 숫자가 몇 번째 인덱스부터 등장하는지 구한다.
     * <upperBound>를 통해 특정 범위의 최댓값에 해당하는 숫자가 몇 번쨰 인덱스까지 등장하는지 구한다.
     *              -> 실제로는 직후의 큰 수의 인덱스를 구한다.(범위에 해당하는 숫자가 등장하는 횟수를 구하기 위함)
     */
    public int lowerBound(int[] arr, int target, int start, int end) {

        // target이 시작하는 지점의 인덱스 반환
        // start <= end 의 조건이 존재한다면 start와 end가 같은 값을 가질때 무한루프가 형성되기에 start < end 이다.
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public int upperBound(int[] arr, int target, int start, int end){

        // target이 끝나는 지점의 직후의 인덱스 반환
        // start <= end 의 조건이 존재한다면 start와 end가 같은 값을 가질때 무한루프가 형성되기에 start < end 이다.
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    // 값이 [left_Value, right_Value]인 데이터의 개수를 반환하는 함수
    public int countByRange(int[] arr, int leftValue, int rightValue){
        int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
        int rightIndex = upperBound(arr, rightValue, 0, arr.length);
        return rightIndex - leftIndex;
    }

    /**
     *  누적합 구하기 템플릿 -> 특정 공간까지의 누적합을 구하기 위해 해당 공간의 값과 그 위와 왼쪽의 누적합을 더하고 겹치는 부분에 대한 누적합을 뺸다.
     *                     특정 공간(A)에서 다른 공간(B)까지의 부분합을 구하기 위해서는 B까지의 누적합에서 A가 존재하는 가로, 세로 공간의 -1 만큼의 공간에 대한 누적합을 빼고 겹쳐있던 공간을 더한다.
     */
    public void 누적합(){

        int[][] arr = new int[n][n];
        int[][] prefixSum = new int[n + 1][n + 1];
        // 누적합 구하기 -> 0 ~ n-1인 arr의 누적합을 0 ~ n의 prefixSum이라는 누적합 배열로 선언하여 1~n에 각 누적합이 들어가게 설계, x = 0 OR y = 0 라인은 x = 1 OR y = 1 라인을 만들기 위한 공간
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                prefixSum[i][j] = arr[i - 1][j - 1] + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1];
            }
        }

        int max = 0;

        // i,j 에서 x(i+m-1), y(j+m-1)까지의 합 => (x,y)까지의 누적합 - (x,j-1)까지의 누적합 - (i-1,y)까지의 누적합 + (i-1, j-1)까지의 누적합(겹치는 부분)
        for (int i = 1; i < (n + 1) - m + 1; i++) {
            for (int j = 1; j < (n + 1) - m + 1; j++) {
                int sum = prefixSum[i + m - 1][j + m - 1] - prefixSum[i + m - 1][j - 1] - prefixSum[i - 1][j + m - 1] + prefixSum[i - 1][j - 1];
                max = Math.max(sum, max);
            }
        }
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
