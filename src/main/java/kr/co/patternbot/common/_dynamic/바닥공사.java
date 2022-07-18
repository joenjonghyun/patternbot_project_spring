package kr.co.patternbot.common._dynamic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName    : kr.co.patternbot.common._dynamic
 * fileName       : 바닥공사
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 바닥공사 {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Solution{
        int n;
        int[] arr;
        int answer;

        @Override
        public String toString(){
            return String.format("%d", answer);
        }
    }

    @FunctionalInterface
    public interface SolutionService{
        Solution solution(Solution s);
    }

    class Service{
        Solution test(Solution s) {
            SolutionService f = e -> {
                e.arr = new int[e.n+1];
                e.arr[1] = 1;
                e.arr[2] = 3;

                for (int i = 3; i <= e.n; i++) {
                    e.arr[i] = e.arr[i-1] + e.arr[i-2] * 2;
                }

                e.answer = e.arr[e.n];

                return Solution.builder()
                        .answer(e.answer)
                        .build();
            };
            return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        int n = 3;

        Solution s = Solution.builder()
                .n(n)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }

}
