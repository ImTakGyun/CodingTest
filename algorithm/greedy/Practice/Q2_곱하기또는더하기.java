package algorithm.greedy.Practice;

import java.util.*;
import java.io.*;

public class Q2_곱하기또는더하기 {

    // 해결 아이디어 : 0, 1 이 나온 경우 곱하면 더 작아지거나 그대로임 따라서 0 또는 1인 경우는 더하기를 하는게 효율적
    public static void main(String[] args) throws IOException {
        Scanner st = new Scanner(System.in);
        String s = st.next();

        // 첫 번쨰 문자를 숫자로 변경한 값을 대입 (tip -> int 자료형은 최대 21억까지 저장 가능, 숫자 문자 값 - 0 문자 값은 뺼셈)
        int result = s.charAt(0) - '0';
        for(int i = 1; i < s.length(); i++){

            int num = s.charAt(i) - '0';
            // 두 수 중에서 하나라도 '0' 혹은 '1' 인 경우, 곱하기 보다는 더하기 수행
            if(result <= 1 || num <= 1)
                result += num;
            else
                result *= num;
        }

        System.out.println(result);
    }
}
