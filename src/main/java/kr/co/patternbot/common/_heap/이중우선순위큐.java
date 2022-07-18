package kr.co.patternbot.common._heap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * packageName    : kr.co.patternbot.common._heap
 * fileName       : 이중우선순위큐
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 이중우선순위큐 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor

    public static class Solution{
        private String [] operations;
        private int [] answer;


        public String toString(){
            return String.format(" ");
        }

    }

    @FunctionalInterface
    private interface SolutionService{
        Solution solution (Solution s);
    }

    class Service{
        SolutionService f = e ->{
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            int maxcnt = 0;
            int cnt = 0;

            for (int i = 0; i < e.operations.length; i++){
                StringTokenizer st = new StringTokenizer(e.operations[i]);
                String str = st.nextToken();

                switch (str){
                    case "I":
                        String next = st.nextToken();
                        min.add(Integer.parseInt(next));
                        max.add(Integer.parseInt(next));
                        break;

                    case "D":
                        if (min.size() == 0) {
                            st.nextToken();
                        }else if (st.nextToken().equals("1")){
                            min.remove(max.poll());

                        }else{
                            max.remove(min.poll());

                        }break;
                }
            }
            if (min.size() - maxcnt == 0){
                e.answer[1] = 0;
            }else {
                e.answer[1] = min.poll();
            }
            if (max.size() - cnt ==0){
                e.answer[0] = 0;
            } else {
                e.answer[0] = max.poll();
            }

            return Solution.builder().operations(e.operations).answer(e.answer).build();
        };
        Solution test (Solution s){
            return f.solution(s);
        }

    }

    @Test
    void testSolution() {
        String [] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int [] answer;
        Service s1 = new Service();
        Solution s = Solution.builder().operations(operations).build();
        System.out.println(s1.test(s));

    }}