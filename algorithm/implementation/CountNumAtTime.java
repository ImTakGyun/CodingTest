package algorithm.implementation;

import java.io.*;
import java.util.*;

public class CountNumAtTime {

    // 해결 아이디어 => 가능한 모든 시각의 경우를 하나씩 모두 세서 풀 수 있는 문제(완전 탐색)

    // 입력 받은 시각
    static int c = 0;
    static int result = 0;

//    public static int Allcount(){
//        return 60 * 60;
//    }
//
//    public static int contain3Minute() {
//        int count = 0;
//
//        for(int i = 0; i < 6; i++){
//            for(int j = 0; j < 10; j ++){
//                if(i == 3 || j == 3)
//                    count += 60;
//                else
//                    count += contain3Secound();
//            }
//        }
//
//        return count;
//    }
//
//    public static int contain3Secound() {
//
//        int count = 0;
//        for(int i = 0; i < 6; i++){
//            for(int j = 0; j < 10; j ++){
//                if(i == 3 || j == 3)
//                    count++;
//            }
//        }
//
//        return count;
//    }

    // 나동빈 코드 => 훨씬 간단하다.
    public static boolean check(int h, int m, int s){
        if(h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
            return true;
        return false;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();

//        for(int i = 0; i <= c; i++){
//            if(i == 3 || i == 13 || i == 23)
//                result += Allcount();
//            else
//                result += contain3Minute();
//        }

        for(int i = 0; i <= c; i++) {
            for (int j = 0; j < 60; j++){
                for( int k = 0; k < 60; k++) {
                    // 매 시간 안에 '3'이 포함되어 있다면 카운트를 증가
                    if(check(i, j, k)) result++;
                }
            }
        }

        System.out.println(result);
    }
}
