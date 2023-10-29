package algorithm.implementation.Practice;

import java.util.*;
import java.io.*;

public class Q8_문자열재정렬 {

    //숫자가 하나도 등장하지 않으면 -1, 등장하면 N
    int summary = -1;
    ArrayList<Character> CharList = new ArrayList<>();

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        //문자를 하나씩 확인하며
        for(int i = 0; i < str.length(); i++){
            // 알파벳인 경우 결과 리스트에 삽입
            // 기존: if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') -> ## Character 내장 함수를 살펴보자!
            if(Character.isLetter(str.charAt(i)))
                CharList.add(str.charAt(i));
            //숫자는 따로 더하기
            else {
                //숫자가 처음 등장했다면 summary를 0으로 초기화
                if(summary == -1) summary = 0;
                //첫 숫자가 등장 이후에는 누적하기
                summary += (str.charAt(i) - '0');
            }
        }

        //알파벳을 오름차순으로 정렬
        Collections.sort(CharList);

        for(int i = 0; i < CharList.size(); i++)
            System.out.print(CharList.get(i));

        // 숫자가 하나라도 존재하는 경우 가장 뒤에 출력
        if (summary != -1) System.out.println(summary);
    }

    public static void main(String[] args) throws IOException{
        new Q8_문자열재정렬().solution();
    }
}
