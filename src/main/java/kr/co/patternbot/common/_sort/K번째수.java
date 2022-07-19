package kr.co.patternbot.common._sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName    : kr.co.patternbot.common._sort
 * fileName       : K번째수
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class K번째수 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor

    public static class Solution {
        private int[] arr;
        private int[][] commands;
        private int[] answer;
    }
    @FunctionalInterface
    private interface SolutionService {
        Solution solution(Solution s);
    }

    static class Service {
        Solution test(Solution s){
            SolutionService f = e -> {
                return null;
            };
            return f.solution(s);
        }
    }

    @Test
    void testSolution() {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        Solution s = Solution.builder().arr(arr).build();
        Service s1 = new Service();
        System.out.println(s1.test(s));


    }
}