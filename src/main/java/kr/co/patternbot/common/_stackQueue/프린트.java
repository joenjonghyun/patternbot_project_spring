package kr.co.patternbot.common._stackQueue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * packageName    : kr.co.patternbot.common._stackQueue
 * fileName       : 프린트
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 프린트 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor

    public static class Solution{
        private int location;
        private Integer[] priorities;
        private int answer;


        public String toString(){
            return String.format("priorities :%s  location:%d  answer: %d", Arrays.toString(priorities),location,answer);
        }

    }
    @FunctionalInterface private interface SolutionService{
        Solution solution (Solution s);
    }

    class Service{
        SolutionService f = e->{
            int answer = 1;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int n : e.priorities) {
                pq.offer(n);
                System.out.println(pq);
            }
            ;
            while(!pq.isEmpty()) {
                for(int i = 0; i < e.priorities.length; i++) {
                    if(pq.peek() == e.priorities[i]) {
                        if(e.location == i) {
                            e.answer = answer;
                            return Solution.builder()
                                    .priorities(e.priorities)
                                    .answer(e.answer)
                                    .location(e.location).build();
                        }
                        pq.poll();
                        answer++;
                    }
                }
            }
            return Solution.builder()
                    .priorities(e.priorities)
                    .answer(9999)//이상있을시 반환..
                    .location(e.location).build();
        };
        Solution test (Solution s){return f.solution(s);}

    }
    @Test
    void testSolution(){
        Integer[] priorities = {2, 3};
        int location = 1;

        Service s2 = new Service();
        Solution s = Solution.builder()
                .priorities(priorities)
                .location(location).build();
        System.out.println(s2.test(s));


    }
}
