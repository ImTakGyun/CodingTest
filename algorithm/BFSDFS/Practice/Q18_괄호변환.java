package algorithm.BFSDFS.Practice;

public class Q18_괄호변환 {

    public String reverse(String s){

        // 첫 번째와 마지막 문자를 제거
        String u = s.substring(1, s.length()-1);

        String new_u = "";

        for(int i = 0; i < u.length(); i++){
            if(u.charAt(i) == '(')
                new_u += ")";
            else
                new_u += "(";
        }

        return new_u;
    }

    /**
     *     "올바른 괄호 문자열"인지 판단
     *
     *     이코테 함수 : 문자열 p가 균형잡히고 올바른 괄호 문자열 인지 판단한다.
     *                이 때 p는 분리될 수 있는 균형잡힌 문자열도 처리 가능하다.
     *                하지만 이미 p는 전제조건이 "더이상 분리될 수 없는" + "균형잡힌 괄호 문자열" 이므로 오버스펙이다.
     *
     *     -> 따라서 나는 '(' 로 시작하는지만 확인하였다.
     *     -> 하지만 이는 전젝조건을 이용한 것이기 때문에 올바른 괄호 문자열을 확인하는 로직을 얻어가기로 한다.
     *        (count 변수를 이용하여 '(' 가 등장하면 +1, ')'가 등장하면 -1 해줌으로써 마지막에 count가 0이 된다면 올바른 문자열임을 판단한다.)
     *
     *     public boolean checkProper(String p) {
     *         int count = 0; // 왼쪽 괄호의 개수
     *         for (int i = 0; i < p.length(); i++) {
     *             if (p.charAt(i) == '(') count += 1;
     *             else {
     *                 if (count == 0) { // 쌍이 맞지 않는 경우에 false 반환
     *                     return false;
     *                 }
     *                 count -= 1;
     *             }
     *         }
     *         return true; // 쌍이 맞는 경우에 true 반환
     *     }
     */

    // 전제조건을 이용한 "올바른 괄호 문자열"인지 판단
    public boolean rightString(String s){

        if(s.charAt(0) == '(')
            return true;

        return false;
    }

    /**
     *   "균형잡힌 괄호 문자열"의 인덱스 반환
     *
     *   이코테 함수 : count를 이용하여 '(' 가 등장하면 +1, ')'가 등장하면 -1 함으로써 <for문내에서 count가 0이되는 곳의 i(index)를 반환>
     *     public int balancedIndex(String p) {
     *         int count = 0; // 왼쪽 괄호의 개수
     *         for (int i = 0; i < p.length(); i++) {
     *             if (p.charAt(i) == '(') count += 1;
     *             else count -= 1;
     *             if (count == 0) return i;
     *         }
     *         return -1;
     *     }
     */

    // 분리되지 않는 균형잡힌 문자열을 생성해서 넘겨준다.
    public String split(String s){

        String sub = "";
        int count = 0;

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == '('){
                count++;
                sub += s.charAt(i);
            }
            if(s.charAt(i) == ')'){
                count--;
                sub += s.charAt(i);
            }

            if(count == 0) break;
        }
        return sub;
    }

    public String solution(String p) {

        String answer = "";
        if(p.isEmpty()) return answer;

        String u = split(p);
        String v = p.substring(u.length());

        // "올바른 괄호 문자열"이면, v에 대해 함수를 수행한 결과를 붙여 반환
        if(rightString(u))
            answer = u + solution(v);

        // "올바른 괄호 문자열"이 아니라면 아래의 과정을 수행
        else
           answer = "(" + solution(v) + ")" + reverse(u);

        return answer;
    }

    public static void main(String[] args){
        String s = "()))((()";
//        String v = s.substring(s.length());
//        System.out.println(v.isEmpty());
//        System.out.println(v.equals(""));
//        System.out.println(v.equals(null));
        String answer = new Q18_괄호변환().solution(s);
        System.out.println(answer);
    }

}
