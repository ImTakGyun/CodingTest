package algorithm.BFSDFS.CONCEPT;

import java.util.*;

public class example_queue {
    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();

        q.offer(5);
        q.offer(2);
        q.offer(3);
        q.poll();

        while(!q.isEmpty()){
            //poll() : 가장 먼저 들어온 원소의 값을 반환하고 큐에서 삭제한다.
            System.out.println(q.poll());
        }
    }
}
