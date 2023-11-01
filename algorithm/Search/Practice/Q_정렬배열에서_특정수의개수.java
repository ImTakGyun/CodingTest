package algorithm.Search.Practice;

import java.util.*;
import java.io.*;

public class Q_정렬배열에서_특정수의개수{

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

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 데이터의 개수 N, 찾고자 하는 값 x 입력받기
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 전체 데이터 입력받기
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 값이 [x, x] 범위에 있는 데이터의 개수 계산
        int cnt = countByRange(arr, x, x);

        // 값이 x인 원소가 존재하지 않는다면
        if (cnt == 0) System.out.println(-1);
            //  값이 x인 원소가 존재한다면
        else System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException{
        new Q_정렬배열에서_특정수의개수().solution();
    }

}
