package algorithm.implementation.practice;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{

    private int x;
    private int y;
    private int stuff;

    public Node(int x, int y, int stuff){
        this.x = x;
        this.y = y;
        this.stuff = stuff;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getStuff(){
        return this.stuff;
    }

    //정렬 기준 설정 (x, y, stuff 순서대로 오름차순)
    @Override
    public int compareTo(Node other){

        // 우선순위가 높은 것부터 낮은 것으로 차례차례 크기 비교하기 위해 x와 y가 같을 때를 먼저 정의
        if(this.x == other.x && this.y == other.y){
            return Integer.compare(this.stuff, other.stuff);
        }
        if(this.x == other.x){
            return Integer.compare(this.y , other.y);
        }
        else return Integer.compare(this.x, other.x);
    }
}

public class Q12_기둥과보설치 {

    // 현재 설치된 구조물이 '가능한' 구조물인지 확인하는 함수
    public boolean possible(ArrayList<ArrayList<Integer>> answer){
        for(int i = 0; i < answer.size(); i++){
            int x = answer.get(i).get(0);
            int y = answer.get(i).get(1);
            int stuff = answer.get(i).get(2);

            // 기둥이라면
            if(stuff == 0){
                boolean check = false;

                //바닥 위인지 확인
                if(y == 0) check = true;
                else
                    // 보의 한 쪽 끝 부분 위 혹은 다른 기둥 위라면 정상
                    for(int j = 0; j < answer.size(); j++){

                        //보의 오른쪽 끝부분에 존재한다면
                        if(x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)) {
                            check = true;
                        }
                        //보의 왼쪽 끝부분에 존재한다면
                        if(x == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)){
                            check = true;
                        }
                        //기둥 위에 존재한다면
                        if(x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)){
                            check = true;
                        }
                    }
                // 위의 조건들에 어긋난다면 설치가 불가능한 구조물이다.
                if(!check) return false;
            }

            // 설치된 것이 '보'일 경우
            else if(stuff == 1) {

                boolean check = false;
                boolean left = false;
                boolean right = false;

                //'한쪽 끝부분이 기둥 위' 혹은 '양쪽 끝부분이 다른 보와 동시에 연결'이라면 정상
                for (int j = 0; j < answer.size(); j++) {

                    //왼쪽 끝이 기둥 위에 있다면
                    if(x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)){
                        check = true;
                    }
                    //오른쪽 끝이 기둥 위에 있다면
                    if(x + 1 == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2)){
                        check = true;
                    }
                    //왼쪽 끝이 보와 연결되어 있다면
                    if(x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)){
                        left = true;
                    }
                    //오른쪽 끝이 보와 연결되어 있다면
                    if(x + 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2)){
                        right = true;
                    }
                }

                if(left && right) check = true;
                if(!check) return false;
            }
        }

        return true;
    }

    public int[][] solution(int n, int[][] build_frame){

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        for(int i = 0; i < build_frame.length; i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int stuff = build_frame[i][2];
            int operate = build_frame[i][3];

            //구조물을 삭제하는 경우
            if(operate == 0){
                int index = 0;

                // 삭제하려는 구조물이 존재하다면 구조물의 위치를 저장한다.
                for(int j = 0; j < answer.size(); j++){
                    if(x == answer.get(j).get(0) && y == answer.get(j).get(1) && stuff == answer.get(j).get(2)){
                        index = j;
                        break;
                    }
                }

                //삭제하려는 구조물의 복제본을 만들어두고
                ArrayList<Integer> erase = answer.get(index);
                //구조물을 삭제한다.
                answer.remove(index);
                //삭제 이후에 구조물의 유효성을 검사 후 유효하지 않다면 다시 추가한다.
                if(!possible(answer))
                    answer.add(erase);
            }

            //구조물을 추가하는 경우
            if(operate == 1){
                ArrayList<Integer> insert = new ArrayList<>();
                insert.add(x);
                insert.add(y);
                insert.add(stuff);

                //일단 설치
                answer.add(insert);

                //설치된 구조물이 가능한지 확인 -> 가능하지 않다면 제거
                if(!possible(answer)){
                    answer.remove(answer.size() - 1);
                }
            }
        }



        // 결과값 가로를 기준으로 올림차순 정렬
        /**
         * 람다 함수를 이용한 코드 -> Node Class 생성과 Comparable을 상속하여 정의하지 않아도 된다.
         *
         * 2차원 배열인 answer의 sort 조건을 answer의 각 개체(1차원 배열)를 이용하여 재정의
         * Integer.compare(a, b) 는 a가 더 크다면 int 값으로 1을, 같다면 0, 작다면 -1을 반환한다.
         */
        Collections.sort(answer, (o1, o2) -> {
            if(o1.get(0) == o2.get(0) && o1.get(1) == o2.get(1))
                return Integer.compare(o1.get(2), o2.get(2));
            if(o1.get(0) == o2.get(0))
                return Integer.compare(o1.get(1), o2.get(1));
            else return Integer.compare(o1.get(0), o2.get(0));
        });

        /**
         * // 미리 정의해둔 Node Class와 comparable을 상속받아 비교 기준을 재정의한 것을 이용한 코드
         *
         * ArrayList<Node> ans = new ArrayList<Node>();
         *         for (int i = 0; i < answer.size(); i++) {
         *             ans.add(new Node(answer.get(i).get(0), answer.get(i).get(1), answer.get(i).get(2)));
         *         }
         *         Collections.sort(ans);
         */

        int[][] result = new int[answer.size()][3];

        for(int i = 0; i < answer.size(); i++){
            result[i][0] = answer.get(i).get(0);
            result[i][1] = answer.get(i).get(1);
            result[i][2] = answer.get(i).get(2);
        }

        return result;

    }

    public static void main(String[] args) throws IOException {
        int n = 20;
        int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int[][] result = {{}};

        result = new Q12_기둥과보설치().solution(n, build_frame);

        for(int i = 0; i < result.length; i++) {
            System.out.print(Arrays.toString(result[i]));
        }
    }
}
