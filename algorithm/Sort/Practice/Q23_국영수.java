package algorithm.Sort.Practice;

import java.util.*;
import java.io.*;

class student implements Comparable<student>{

    private String name;
    private int kor;
    private int eng;
    private int math;

    public student(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int compareTo(student other){
        if(this.kor == other.kor && this.eng == other.eng && this.math == other.math)
            return this.name.compareTo(other.name);
        if(this.kor == other.kor && this.eng == other.eng)
            return Integer.compare(other.math, this.math);
        if(this.kor == other.kor)
            return Integer.compare(this.eng, other.eng);
        else
            return Integer.compare(other.kor, this.kor);
    }
}

public class Q23_국영수 {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayList<student> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        for(int i = 0; i < n; i++){
            System.out.println(list.get(i).getName());
        }
    }

    public static void main(String[] args) throws IOException{
        new Q23_국영수().solution();
    }
}
