package Bakjoon;

import java.util.*;
import java.io.*;

public class B_1439 {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = br.readLine();

        int cnt = 1;

        for(int i = 0; i < s.length() - 1; i++){
            if((s.charAt(i) - '0') != (s.charAt(i+1) - '0')) cnt++;
            else continue;
        }

        System.out.println(cnt/2);

    }

    public static void main(String[] args) throws IOException{
        new B_1439().solution();
    }
}
