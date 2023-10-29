package algorithm.Sort.Practice;

import algorithm.Sort.Concept.QuickSort;

import java.util.*;
import java.io.*;

/**
 *         //int[] - > Integer[]
 *         //Integer[] arr = Arrays.stream(list).boxed().toArray(Integer[]::new);
 *
 *         //Integer[]  -> int[]
 *         //list = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
 */

public class 실전_위에서아래로 {

    public void QuickSort(int[] list, int start, int end){
        // 원소가 1개인 경우 종료
        if(start == end) return;

        // 피벗은 첫 번째 원소
        int pivot = start;
        int left = start + 1;
        int right = end;

        while(left <= right){
            // 피벗보다 작은 데이터를 찾을 때까지 반복
            while(left <= end && list[left] >= list[pivot]) left++;
            // 피벗보다 큰 데이터를 찾을 때까지 반복
            while(right > start && list[right] <= list[pivot]) right--;
            // 엇갈렸다면 작은 데이터와 피벗을 교체
            if(left > right){
                int temp = list[right];
                list[right] = list[pivot];
                list[pivot] = temp;
            }
            // 엇갈리지 않았다면 큰 데이터와 작은 데이터를 교체
            else {
                int temp = list[right];
                list[right] = list[left];
                list[left] = temp;
            }
        }

        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
        QuickSort(list, start, right);
        QuickSort(list, right+1, end);
    }

    public void solution(int[] list){
        QuickSort(list, 0, list.length - 1);

        System.out.println("Quick Sort");
        for(int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] list = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            list[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] arr = Arrays.stream(list).boxed().toArray(Integer[]::new);

        System.out.println("기본 정렬 라이브러리 <Arrays.sort()>");
        Arrays.sort(arr, Collections.reverseOrder());
        Arrays.sort(list);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        new 실전_위에서아래로().solution(list);
    }
}
