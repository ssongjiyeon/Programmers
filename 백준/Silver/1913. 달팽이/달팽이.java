import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = {};
    static int N = 0;
    static int TARGET = 0;
    static int targetR, targetC = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        TARGET = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        targetR = N/2 + 1;
        targetC = N/2 + 1;

        makeMap(N/2, N/2);
        printMap();
        System.out.println(targetR + " " + targetC);
    }

    public static void makeMap(int nowR, int nowC) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int num = 1;
        int move = 0;
        map[nowR][nowC] = num;

        while(true) {
            for(int i=0;i<4;i++) {
                if(i == 0 || i == 2) move++;
                int nowMove = 0;

                while(nowMove < move) {
                    num++;
                    nowR += dr[i];
                    nowC += dc[i];

                    if(nowR < 0 || nowR >= N || nowC < 0 || nowC >= N) return;

                    map[nowR][nowC] = num;

                    if(num == TARGET) {
                        targetR = nowR + 1;
                        targetC = nowC + 1;
                    }

                    nowMove++;
                }
            }
        }
    }

    public static void printMap() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
    }
}