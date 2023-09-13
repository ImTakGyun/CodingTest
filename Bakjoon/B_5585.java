package Bakjoon;

import java.io.*;
import java.util.*;

public class B_5585 {

    static int n;
    static int num = 0;
    static int[] type = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(bf.readLine());

        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
//        int price = Integer.parseInt(st.nextToken());
        n = 1000 - price;

        for(int i = 0; i<type.length; i++){
            num += n/type[i];
            n %= type[i];
        }

        System.out.println(num);
    }
}