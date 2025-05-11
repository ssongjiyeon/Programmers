import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> foods = new PriorityQueue<>();

        for(int sco: scoville) {
            foods.offer(sco);
        }

        int cnt = 0;
        while(foods.size() > 0) {
            int minScoville = foods.poll();

            if(minScoville >= K) break;
            if(foods.size() == 0) {
                cnt = -1;
                break;
            }

            int secondScoville = foods.poll();
            int newScoville = minScoville + (secondScoville * 2);
            foods.offer(newScoville);
            cnt++;
        }

        return cnt;
    }
}