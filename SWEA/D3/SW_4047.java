package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 입력받은 문자열을 3글자씩 끊고 해당 3글자의 1글자로 문양 분류를, 남은 1~2로는 Integer.parseInt로 형변환하여 담아준다.
 */
public class SW_4047 {
    public static String[] arr;
    public static int[] s = new int[14];
    public static int[] d = new int[14];
    public static int[] h = new int[14];
    public static int[] c = new int[14];

    public static void main(String args[]) throws Exception
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = br.readLine();

            arr = new String[(str.length() / 3)];

            int a = 0;

            for(int i = 0; i < str.length(); i+=3){
                arr[a] = str.substring(i, i+3);
                a++;
            }

            String ans = "";
            for(int i = 0; i < arr.length; i++){

                String number = arr[i].substring(1, 3);
                int num = Integer.parseInt(number);

                if(arr[i].charAt(0) == 'S') {
                    if(s[num] == 1) {
                        ans = "ERROR";
                        break;
                    }
                    s[num]=1;
                }
                else if(arr[i].charAt(0) == 'D') {
                    if(d[num] == 1) {
                        ans = "ERROR";
                        break;
                    }
                    d[num]=1;
                }
                else if(arr[i].charAt(0) == 'H') {
                    if(h[num] == 1) {
                        ans = "ERROR";
                        break;
                    }
                    h[num]=1;
                }
                else if(arr[i].charAt(0) == 'C') {
                    if(c[num] == 1) {
                        ans = "ERROR";
                        break;
                    }
                    c[num]=1;
                }
            }

            if(ans.equals("ERROR")) System.out.println("#" + test_case + " " + ans);
            else {
                int snum = 13;
                int dnum = 13;
                int hnum = 13;
                int cnum = 13;

                for(int i = 1; i < 14; i++){
                    if(s[i] == 1) snum--;
                    if(d[i] == 1) dnum--;
                    if(h[i] == 1) hnum--;
                    if(c[i] == 1) cnum--;
                }

                System.out.println("#" + test_case + " " + snum + " " + dnum + " " + hnum + " " + cnum);
            }

            Arrays.fill(s, 0);
            Arrays.fill(d, 0);
            Arrays.fill(h, 0);
            Arrays.fill(c, 0);
        }
    }
}
