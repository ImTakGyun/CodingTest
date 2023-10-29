package algorithm.greedy.Practice;

import java.util.*;
import java.io.*;

/**
 *     Comparator(정렬 기준을 구현하는데 사용) 와 Comparable(객체의 기본 정렬 기준을 생성하는데 사용)
 *     Interface Comparator 는 compare(객체1, 객체2) 와 equals 를 오버라이딩하여 매개변수의 객체1과 객체2를 비교한다.
 *     Interface Comparable 은 compareTo(객체) 를 오버라이팅하여 매개변수의 객체와 자기 자신을 비교한다.
 *     -> 왼쪽(or 자기 자신)이 크면 1, 같으면 0, 작으면 -1 을 반환한다.
 *     -> 이렇게 반환된 값을 기반으로 정렬 메서드가 동작한다.
 *     -> 따라서 이는 정렬을 위한 기준을 생성하는 것이다. (실제 정렬 로직은 정렬 메서드 안에 존재)
 *     -> Ex) Arrays.sort(배열) => 배열 내부의 객체에 존재하는 기본 정렬 기준으로 정렬
 *     -> Ex) Arrays.sort(배열, 정렬 기준) => 배열 내부의 객체들을 지정된 정렬 기준으로 정렬
 *
 *     우선순위 큐
 *     -> 일반적인 큐의 구조 FIFO(First In First Out)를 가지면서,
 *        데이터가 들어온 순서대로 데이터가 나가는 것이 아닌 우선순위를 먼저 결정하고
 *        그 우선순위가 높은 데이터가 먼저 나가는 자료구조이다.
 *     -> 우선순위를 두기 위한 비교에서 compareTo가 1이면 객체의 우선순위를 비교 대상보다 낮게, -1이면 비교 대상보다 높게 측정한다.
 */

class Food implements Comparable<Food> {

    private int time;
    private int index;

    public Food(int time, int index){
        this.time = time;
        this.index = index;
    }

    public int getTime(){
        return this.time;
    }

    public int getIndex(){
        return this.index;
    }

    // 시간이 짧은 것이 높은 우선순위를 가지도록 설정
    // 우선순위 큐에서 compareTo의 반환값이 1이라면 other의 우선순위를 높이기 위해 this와의 자리를 교체한다.
    @Override
    public int compareTo(Food other){
        return Integer.compare(this.time, other.time);
    }
}

public class Q6_무지의먹방라이브 {

    public static int solution(int[] food_times, long k){
        //전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
        long total_time = 0;

        for(int i = 0; i < food_times.length; i++)
            total_time += food_times[i];

        if(total_time <= k)
            return -1;

        //시간이 적은 음식부터 차례로 제거하기 위해 우선순위 큐를 사용한다.
        PriorityQueue<Food> pq = new PriorityQueue<>();

        for(int i = 0; i < food_times.length; i++)
            // food_times에 기록된 시간을 바탕으로 Food 객체를 생성하여 우선순위 큐에 삽입한다.
            pq.offer(new Food(food_times[i], i+1));

        total_time = 0; //먹기 시작할 때부터 흐른 총시간
        long previous = 0; //직전 음식을 다 먹은 시간
        long length = food_times.length; // 남은 음식의 개수

        // <total_time + (현재 음식 시간 - 이전 음식 시간) * 현재 음식 개수> 와 <k> 비교
        while(total_time + ((pq.peek().getTime() - previous) * length) <= k){
            int now = pq.poll().getTime();
            total_time += (now - previous) * length;
            length -= 1; // 다 먹은 음식 제외
            previous = now; // 이전 음식 시간 재설정
        }

        // 남은 음식 중에서 몇 번째 음식인지 확인하여 출력한다.
        ArrayList<Food> result = new ArrayList<>();

        while(!pq.isEmpty())
            result.add(pq.poll());

        // 음식 번호 기준으로 정렬한다.
        Collections.sort(result, new Comparator<Food>(){
            @Override
            public int compare(Food a, Food b){
                return Integer.compare(a.getIndex(), b.getIndex());
            }
        });

        return result.get((int) ((k - total_time) % length)).getIndex();
    }

    public static void main(String[] args) throws IOException{

        int[] food_times = {3, 1, 2};

        int k = 5;

        int result = solution(food_times, k);
        System.out.println(result);

    }
}

