package algorithm.implementation.practice;

import java.util.*;
import java.io.*;

public class Q9_문자열압축 {
    public int solution(String s) {

        int answer = s.length();

        // 문자열을 자를 단위 설정
        for(int step = 1; step < s.length() / 2 + 1; step++){

            // 잘려진 첫번째 단락
            String prev = s.substring(0, step);
            // 압축된 문자열 결과값
            String compressed = "";
            // 잘려진 단락이 중복되는 값
            int count = 1;

            // 두번째 단락부터 중복 확인
            for(int j = step; j < s.length(); j+= step){
                String sub = "";
                for(int k = j; k < j + step; k++){
                    if(k < s.length()) sub += s.charAt(k);
                }
                // 중복되는 단락이 등장하면 중복값 증가
                if(prev.equals(sub)) count++;

                // 중복되지 않은 단락이 등장하면 지금까지의 단락을 compressed에 넣고 새로 등장한 단락부터 재시작
                else{
                    compressed += (count >= 2) ? count + prev : prev;
                    prev = sub;
                    count = 1;
                }
            }

            // 연결되지 않은 마지막 단락을 확인 후 연결
            compressed += (count >= 2) ? count+prev : prev;
            // 기존의 압축된 문자열의 길이와 현재 압축한 문자열의 길이 비교
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(new Q9_문자열압축().solution(br.readLine()));
    }
}
