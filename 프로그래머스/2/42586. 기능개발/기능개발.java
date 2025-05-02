import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int length = progresses.length;
        Queue<Integer> days = new LinkedList<>();

        for(int i=0;i<length;i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) - (day * speeds[i]) > 0) {
                day++;
            }

            days.add(day);
        }

        int deployment = 1;
        int now = days.poll();

        while(!days.isEmpty()) {
            if(now >= days.peek()) {
                deployment++;
                days.poll();
            } else {
                answer.add(deployment);
                deployment = 1;
                now = days.poll();
            }
        }
        answer.add(deployment);
        int[] response = new int[answer.size()];
        for(int i=0;i<answer.size();i++) {
            response[i] = answer.get(i);
        }

        return response;
    }
}