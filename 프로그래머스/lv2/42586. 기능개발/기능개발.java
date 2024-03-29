import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) (Math.ceil((100.0 - progresses[i]) / speeds[i])));
        }
        
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int day = queue.poll();
            int cnt = 1;

            while (!queue.isEmpty() && day >= queue.peek()) {
                cnt++;
                queue.poll();
            }
            list.add(cnt);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}