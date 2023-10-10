package algorithm.implementation;

import java.util.*;
import java.io.*;

public class stringReorder {

    //해결 아이디어 : 숫자인 경우 따로 합계 계산, 알파벳의 경우 별도의 리스트에 저장
    //오답 : Character 자료형에 문자인지 확인하는 함수가 존재함을 모르고 있었음 + 숫자의 문자형태의 (int) 값은 다름을 모르고 있었음

    public static String str;
    public static ArrayList<Character> result = new ArrayList<Character>();
    public static int value = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();


//        for(int i = 0; i < input.length(); i++){
//            if((int)input.charAt(i) < 10) {
//                sum += (int) input.charAt(i);
//                continue;
//            }
//            else
//                list.add(input.charAt(i));
//        }

        //문자를 하나씩 확인하며
        for (int i = 0; i < str.length(); i++){
            //알파벳인 경우 결과 리스트에 삽입
            if(Character.isLetter(str.charAt(i))){
                result.add(str.charAt(i));
            }
            //숫자는 따로 더하기
            else {
                value += str.charAt(i) - '0';
            }
        }

        // 알파벳을 오름차순으로 정렬
        Collections.sort(result);

        // 알파벳을 차례대로 출력
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }

        //숫자가 하나라도 존재하는 경우 가장 뒤에 출력
        if(value != 0)
            System.out.println(value);
    }
}
