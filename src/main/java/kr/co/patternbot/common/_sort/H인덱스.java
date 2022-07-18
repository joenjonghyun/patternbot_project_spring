package kr.co.patternbot.common._sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * packageName    : kr.co.patternbot.common._sort
 * fileName       : H인덱스
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class H인덱스 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor

    public static class Solution{
        private int[] citations;
        private int answer;

        public String toString(){
            return Integer.toString(answer);
        }
    }
    @FunctionalInterface
    private interface SolutionService{
        Solution solution (Solution s);
    }

    class Service{
        SolutionService f = e ->{
            Arrays.sort(e.citations);

            for (int i=0; i<e.citations.length; i++){
                int h = e.citations.length - i;

                if (e.citations[i] >= h){
                    e.answer=h;
                    break;
                }
            }
            return Solution.builder()
                    .citations(e.citations)
                    .answer(e.answer)
                    .build();
        };
        Solution test(Solution s){return f.solution(s);}
    }
    @Test
    void testSolution(){
        int[] citations = {3, 0, 6, 1, 5};
        int answer = 0;
        Solution s = Solution.builder()
                .citations(citations)
                .answer(answer)
                .build();
        Service b = new Service();
        System.out.println(b.test(s));


    }
}
