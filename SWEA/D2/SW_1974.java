package SWEA.D2;

import java.util.*;
import java.io.*;

public class SW_1974 {

    public static int[][] arr = new int[9][9];

    public static boolean check(ArrayList<ArrayList<Integer>> arr){

        for(int i = 0; i < arr.size(); i++) {
            Collections.sort(arr.get(i));
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (arr.get(i).get(j) == j + 1) continue;
                else return false;
            }
        }
        return true;
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {

            for (int i = 0; i < arr.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ArrayList<ArrayList<Integer>> square = new ArrayList<>();
            ArrayList<ArrayList<Integer>> row = new ArrayList<>();
            ArrayList<ArrayList<Integer>> column = new ArrayList<>();

            for(int i = 0; i < 9; i++){
                square.add(new ArrayList<>());
                row.add(new ArrayList<>());
                column.add(new ArrayList<>());
            }

            int s = 0;

            for (int i = 0; i < arr.length; i += 3) {
                for (int j = 0; j < arr.length; j += 3) {
                    for(int p = i; p < i+3; p++){
                        for(int q = j; q < j+3; q++){
                            square.get(s).add(arr[p][q]);
                        }
                    }
                    s++;
                }
            }

            int l = 0;

            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr.length; j++){
                    row.get(l).add(arr[i][j]);
                    column.get(l).add(arr[j][i]);
                }
                l++;
            }

            System.out.print("#" + test_case + " ");
            if(check(square) && check(row) && check(column)) System.out.println("1");
            else System.out.println("0");
        }
    }
}
