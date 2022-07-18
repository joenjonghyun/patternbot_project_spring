package kr.co.patternbot.common._sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * packageName    : kr.co.patternbot.common._sort
 * fileName       : 위에서아래로
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 위에서아래로 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor

    public static class Solution {
        private Integer[] array;


        public String toString() {
            return String.format(Arrays.toString(array));
        }

    }

    @FunctionalInterface
    private interface SolutionService {
        Solution solution(Solution s);
    }

    class Service {
        SolutionService f = e -> {
            Arrays.sort(e.array, Collections.reverseOrder());
            return Solution.builder().array(e.array).build();
        };
        Solution test(Solution s) {
            return f.solution(s);
        }
    }

    @Test
    void testSolution() {
        Integer[] arr = {3, 15, 27, 12};
        Solution s = Solution.builder().array(arr).build();
        Service s2 = new Service();
        System.out.println(s2.test(s));

    }
}
