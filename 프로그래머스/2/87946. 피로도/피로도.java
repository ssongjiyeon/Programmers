import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = 0;

        int adventure = maxAdventure(k, dungeons, new boolean[dungeons.length], 0);
        answer = Math.max(answer, adventure);

        return answer;
    }

    public int maxAdventure(int k, int[][] dungeons, boolean[] visited, int maxCnt) {
        int cnt = maxCnt;

        for(int i=0;i<dungeons.length;i++) {
            if(visited[i]) continue;
            if(k - dungeons[i][0] < 0) continue;

            visited[i] = true;
            int now = maxAdventure(k-dungeons[i][1], dungeons, visited, maxCnt + 1);
            cnt = Math.max(now, cnt);
            visited[i] = false;
        }

        return cnt;
    }
}