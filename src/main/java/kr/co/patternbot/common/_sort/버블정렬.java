package kr.co.patternbot.common._sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * packageName    : kr.co.patternbot.common._sort
 * fileName       : 버블정렬
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 버블정렬 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Solution {
        private int[] array;
        private int temp;

        public String toString() {
            return Arrays.toString(array);
        }
    }

    @FunctionalInterface
    private interface SolutionService {
        Solution solutionServiceApply(Solution solutionParam);
    }

    class Service {
        SolutionService f = e -> {
            for (int i = 0; i < e.array.length; i++) {
                for (int j = 0; j < 9-i; j++) {
                    if (e.array[j] > e.array[j + 1]) {
                        e.temp = e.array[j];
                        e.array[j] = e.array[j + 1];
                        e.array[j + 1] = e.temp;
                    }
                }
            }
            return Solution.builder().array(e.array).build();
        };
        Solution test(Solution solutionParamTest) {
            return f.solutionServiceApply(solutionParamTest);
        }
    }
    @Test
    void testSolution() {
        int[] arr = {1, 9, 4, 6, 11, 10, 3, 15, 2, 13};
        Solution solutionInstance = Solution.builder().array(arr).build();
        Service serviceInstance = new Service();
        System.out.println(serviceInstance.test(solutionInstance));

    }
}
