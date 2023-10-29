package algorithm.Sort.Practice;

import java.util.*;
import java.io.*;

/**
 *  배운점 : (double) persons[i] / sum; 에서 0 / 0 의 값이 0이 아니고 NaN(Not a Number)였음을 간과했음.
 */
class Node implements Comparable<Node>{

    private int stage;
    private double fail;

    public Node(int stage, double fail){
        this.stage = stage;
        this.fail = fail;
    }

    public int getStage(){
        return this.stage;
    }

    @Override
    public int compareTo(Node other){
        if (this.fail == other.fail) {
            return Integer.compare(this.stage, other.stage);
        }
        return Double.compare(other.fail, this.fail);
    }
}
public class Q25_실패율 {

    public int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        int[] persons = new int[N+2];

        // 각 stage 별로 머물러 있는 사람의 수 계산
        for(int i = 0; i < stages.length; i++){
            for(int j = 1; j < N+2; j++){
                if(stages[i] == j){
                    persons[j] += 1;
                }
            }
        }

        ArrayList<Node> list = new ArrayList<>();

        // 1 ~ N까지의 stage에 대한 실패율을 계산
        for(int i = 1; i < N+1; i++){
            //특정 stage에 도전한 사람의 수
            int sum = 0;
            double fail = 0;

            //특정 stage 도전한 사람의 총합
            for(int j = i; j < N+2; j++)
                sum += persons[j];

            //한 명 이상의 사람이 도전했다면 실패율을 계산, 한 명도 도전한 사람이 없다면 실패율은 기본값(0)
            if(sum >= 1) fail = (double) persons[i] / sum;

            list.add(new Node(i, fail));
        }

        Collections.sort(list);

        for(int i = 0; i < N; i++){
            answer[i] = list.get(i).getStage();
        }

        return answer;
    }

    public static void main(String[] args) throws IOException{

        int n = 4;
        int[] stages = {4, 4, 4, 4, 4};

        int[] answer = new Q25_실패율().solution(n, stages);
        int a = 0, b = 0;
        System.out.println((double) a/b);
        for (int j : answer) {
            System.out.print(j);
        }
    }
}
