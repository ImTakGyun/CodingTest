package algorithm.Sort.Practice;

import java.util.*;
import java.io.*;

/**
 * <String, Int> 조합된 객체의 정렬이 필요하므로 Class를 정의하고 정렬기준을 재정의함으로써 정렬가능하다.
 * 하지만, 2중 ArrayList를 통해 1~100까지의 점수에 해당하는 리스트를 만들고, 각 점수에 이름을 차례로 추가함으로써 점수 올림차순으로 이름을 출력할 수 있다.
 */
class Student implements Comparable<Student>{

    String name;
    int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }
    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    @Override
    public int compareTo(Student other){
        return this.score - other.score;
    }
}

public class 실전_성적순으로출력하기 {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Student> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        for(int i = 0; i < n; i++){
            System.out.println(list.get(i).getName());
        }




    }

    public static void main(String[] args) throws IOException{
        new 실전_성적순으로출력하기().solution();
    }
}
