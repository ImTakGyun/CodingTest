package algorithm.BFSDFS.CONCEPT;

import java.util.*;
public class example_stack {
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();

        s.push(5);
        s.push(2);
        s.pop();

        while(!s.empty()){
            //peek() : 최상단의 노드의 값만을 반환한다. (삭제X)
            System.out.println(s.peek());
            // 최상단의 노드를 삭제한다.
            s.pop();
        }
    }
}
