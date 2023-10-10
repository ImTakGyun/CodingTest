package algorithm.greedy;

import java.util.*;

//첫쨰 줄에 모험가의 수 N이 주어진다. (1<= N <= 100,000)
//둘째 줄에 각 모험가의 공포도의 값을 N 이하의 자연수로 주어지며, 각 자연수는 공백으로 구분합니다.
//여행을 떠날 수 있는 그룹 수의 최댓값을 출력합니다.

public class Q1_모험가길드 {

    // 문제 해결 아이디어 : 오름차순으로 정렬하여 '현재 그룹에 포함된 모험가의 수' 가 '현재 확인하고 있는 공포도' 보다 크거나 같다면 이를 그룹으로 설정하면 된다.
    // 오답 : 정렬까지는 잘 떠올렸지만 ArrayList 의 구현 상황에서 문법적으로 부족하였고, 그룹 변수를 만들어서 공포도와 비교하는 아이디어를 놓침
    public static int n;
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        //list에 입력값 담기
        for(int i =0; i < n; i++){
            arrayList.add(sc.nextInt());
        }
        Collections.sort(arrayList);

        int result = 0; //총 그룹의 수
        int group = 0; // 현재 그룹에 포함된 모험가의 수

        for(int i =0; i<n; i++){
            group += 1;
            if(group >= arrayList.get(i)){
                result += 1;
                group = 0;
            }
        }

        System.out.println(result);
    }
}
