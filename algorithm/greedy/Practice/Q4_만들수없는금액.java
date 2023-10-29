package algorithm.greedy.Practice;

import java.util.*;
import java.io.*;

/**
 * Tip : 1부터 연속되는 숫자들을 통해 연속된 모든 숫자의 합까지의 조합들이 가능해진다.
 *          EX) 1, 2, 3, 4, 5 => 1+2+3+4+5 인 15까지의 조합이 가능해짐, 이 때 16이 조합이 불가능한 정수중 가장 작은 수가 된다.
 */
public class Q4_만들수없는금액 {

    static int n;
    static List<Integer> coins = new ArrayList<Integer>(n);

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());

        for(int i = 0; i < n; i++){
            coins.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(coins);

        int min = 1;

        for(int i = 0; i < n; i++){

            if(min < coins.get(i)) break;

            min += coins.get(i);
        }

        System.out.println(min);
    }

}

//    이코테 답안 : 같은 맥락이지만 최적화 되어있음
//    public static int n;
//    public static ArrayList<Integer> arrayList = new ArrayList<>();
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//
//        for (int i = 0; i < n; i++) {
//            arrayList.add(sc.nextInt());
//        }
//
//        Collections.sort(arrayList);
//
//        int target = 1;
//        for (int i = 0; i < n; i++) {
//            // 만들 수 없는 금액을 찾았을 때 반복 종료
//            if (target < arrayList.get(i)) break;
//            target += arrayList.get(i);
//        }
//
//        System.out.println(target);
//    }