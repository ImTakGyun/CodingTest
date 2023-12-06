package Programmers.Implementation;

import java.util.*;
import java.io.*;

class Node {
    private int pos1X;
    private int pos1Y;
    private int pos2X;
    private int pos2Y;
    private int distance;

    public int getPos1X() {
        return this.pos1X;
    }
    public int getPos1Y() {
        return this.pos1Y;
    }
    public int getPos2X() {
        return this.pos2X;
    }
    public int getPos2Y() {
        return this.pos2Y;
    }
    public int getDistance() {
        return this.distance;
    }

    public Node(int pos1X, int pos1Y, int pos2X, int pos2Y, int distance) {
        this.pos1X = pos1X;
        this.pos1Y = pos1Y;
        this.pos2X = pos2X;
        this.pos2Y = pos2Y;
        this.distance = distance;
    }
}

public class P_블록이동하기 {

    public int[][] map;
    // 위, 아래, 오른쪽, 왼쪽
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, 1, -1};
    public int n;

    // 왼쪽칸/오른쪽칸에서 up, down

    public ArrayList<Node> getNextPos(Node pos){
        ArrayList<Node> nextPos = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            int pos1NextX = pos.getPos1X() + dx[i];
            int pos1NextY = pos.getPos1Y() + dy[i];
            int pos2NextX = pos.getPos2X() + dx[i];
            int pos2NextY = pos.getPos2Y() + dy[i];
            int distanceNext = pos.getDistance() + 1;

            if(map[pos1NextX][pos1NextY] == 0 && map[pos2NextX][pos2NextY] == 0){
                nextPos.add(new Node(pos1NextX, pos1NextY, pos2NextX, pos2NextY, distanceNext));
            }
        }

        int[] hor = {-1, 1};

        // 현재 로봇이 가로로 놓여 있는 경우
        if(pos.getPos1X() == pos.getPos2X()){
            // 위쪽으로 회전하거나, 아래쪽으로 회전
            for(int i = 0; i < 2; i++){
                // 위쪽 혹은 아래쪽 두 칸이 모두 비어 있다면
                if(map[pos.getPos1X() + hor[i]][pos.getPos1Y()] == 0 && map[pos.getPos2X() + hor[i]][pos.getPos2Y()] == 0){
                    nextPos.add(new Node(pos.getPos1X(), pos.getPos1Y(), pos.getPos1X() + hor[i], pos.getPos1Y(), pos.getDistance() + 1));
                    nextPos.add(new Node(pos.getPos2X(), pos.getPos2Y(), pos.getPos2X() + hor[i], pos.getPos2Y(), pos.getDistance() + 1));
                }
            }
        }

        // 현재 로봇이 세로로 놓여 있는 경우
        int[] ver = {-1, 1};
        if(pos.getPos1Y() == pos.getPos2Y()){
            // 왼쪽으로 회전하거나, 오른쪽으로 회전
            for(int i = 0; i < 2; i++){
                // 왼쪽 혹은 오른쪽 두 칸이 모두 비어 있다면
                if(map[pos.getPos1X()][pos.getPos1Y() + ver[i]] == 0 && map[pos.getPos2X()][pos.getPos2Y() + ver[i]] == 0){
                    nextPos.add(new Node(pos.getPos1X(), pos.getPos1Y(), pos.getPos1X(), pos.getPos1Y() + ver[i], pos.getDistance() + 1));
                    nextPos.add(new Node(pos.getPos2X(), pos.getPos2Y(), pos.getPos2X(), pos.getPos2Y() + ver[i], pos.getDistance() + 1));
                }
            }
        }

        return nextPos;
    }

    public int solution(int[][] board) {

        n = board.length;
        map = new int[n + 2][n + 2];

        for(int i = 0; i < n + 2; i++){
            Arrays.fill(map[i], 1);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i+1][j+1] = board[i][j];
            }
        }

        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> visited = new ArrayList<>();
        Node pos = new Node(1, 1, 1, 2, 0);

        q.offer(pos);
        visited.add(pos);

        while(!q.isEmpty()){
            pos = q.poll();

            if((pos.getPos1X() == n && pos.getPos1Y() == n) || (pos.getPos2X() == n && pos.getPos2Y() == n)){
                return pos.getDistance();
            }

            ArrayList<Node> nextPos = getNextPos(pos);
            for(Node npos : nextPos){
                boolean check = true;

                for(Node node : visited){
                    if(npos.getPos1X() == node.getPos1X() && npos.getPos1Y() == node.getPos1Y() && npos.getPos2X() == node.getPos2X() && npos.getPos2Y() == node.getPos2Y()){
                        check = false;
                        break;
                    }
                }
                if(check){
                    q.offer(npos);
                    visited.add(npos);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception{
        int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        int result = new P_블록이동하기().solution(board);
        System.out.println(result);
    }
}
