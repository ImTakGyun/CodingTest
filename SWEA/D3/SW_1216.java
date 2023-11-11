package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  회고 : 겁나 어려웠다. 파이썬으로 풀면 몇 줄 안 나오던데... 물론 효율적인 코드는 아니겠지만 그래도 코드 양이 정말 많고 복잡했다...ㅠ
 *
 *  핵심 Point : 각 행과 열을 독립적으로 다룬다.(for)
 *              각 행과 열에서 길이가 가장 긴 회문이 존재한다는 가정으로 회문의 길이를 조금씩 줄여나가며 조사한다.(for) + 해당 길이의 회문이 존재한다는 의미를 consist = 1로 잡는다.
 *              시작 위치가 가능한 점들을 순회하며(for) + 시작 위치에서 지정된 길이의 회문이 존재한다는 가정으로 list에 해당 길이를 추가한다.
 *              각 시작 위치에서 지정한 회문의 길이만큼을 차례로 조사하며 조건에 만족하는지 확인한다.(for) + 만족하지 않는다면 추가했던 길이를 list에서 제거하고 consist = 0으로 변경한 후 break를 건다.
 *              회문이 발견되면 consist 의 값이 1에서 변경되지 않았기 때문에, 더 이상 시작 위치를 다르게 하며 또, 회문의 길이를 줄여가며 조사할 필요가 없다.(break, break)
 */
public class SW_1216 {

    public static char[][] arr;
    public static ArrayList<Integer> result;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            arr = new char[100][100];

            for(int i = 0; i < 100; i++){
                String str = br.readLine();
                for(int j = 0; j < 100; j++){
                    arr[i][j] = str.charAt(j);
                }
            }

            result = new ArrayList<>();

            for(int i = 0; i < 100; i++){
                for(int length = 100; length > 0; length--){
                    int consist = 1;
                    for(int k = 0; k <= 100 - length; k++){
                        result.add(length);
                        for(int t = 0; t < (length + 1)/2; t++){
                            if(arr[i][k + t] != arr[i][k + length - 1 - t]){
                                result.remove(result.size()-1);
                                consist = 0;
                                break;
                            }
                        }
                        if(consist == 1) break;
                    }
                    if(consist == 1) break;
                }

                for(int length = 100; length > 0; length--){
                    int consist = 1;
                    for(int k = 0; k <= 100 - length; k++){
                        result.add(length);
                        for(int t = 0; t < ((length + 1)/2); t++){
                            if(arr[k + t][i] != arr[k + length - 1 - t][i]){
                                result.remove(result.size()-1);
                                consist = 0;
                                break;
                            }
                        }
                        if(consist == 1) break;
                    }
                    if(consist == 1) break;
                }
            }

            Collections.sort(result);

            System.out.println("#" + test_case + " " + result.get(result.size() - 1));
        }
    }
}
