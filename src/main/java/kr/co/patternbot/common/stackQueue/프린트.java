package kr.co.patternbot.common.stackQueue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * packageName    : kr.co.patternbot.common.stackQueue
 * fileName       : 프린트
 * author         : j2022
 * date           : 2022-06-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-22        j2022       최초 생성
 */
public class 프린트 {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Solution{
        private int[] priorities;
        private int location;
        private int answer;

        @Override public String toString(){
            return String.format("dd", answer);
        }
    }

    @FunctionalInterface public interface SolutionService{
        Solution solution(Solution s);
    }

    public static class Service{
        SolutionService f = e -> {
            int answer = 1;
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            for (int priority : e.priorities) {
                queue.offer(priority);
            }

            while (!queue.isEmpty()){
                for (int i = 0; i < e.priorities.length; i++){
                    if (queue.peek() == e.priorities[i]){
                        if (i == e.location){
                            answer ++;
                            queue.poll();
                        }
                    }
                }
            }
            return Solution.builder()
                    .answer(e.getAnswer())
                    .location(e.getLocation())
                    .priorities(e.getPriorities())
                    .build();
        };
        Solution test(Solution s){
            return f.solution(s);
        }
    }

    @Test
    void testSolutionTest(){
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = 0;
        Service service = new Service();
        Solution solution = Solution.builder()
                .answer(answer)
                .priorities(priorities)
                .location(location)
                .build();
        System.out.println(service.test(solution));
    }
}
