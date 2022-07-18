package kr.co.patternbot.common._binSearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * packageName    : kr.co.patternbot.common._binSearch
 * fileName       : 부품찾기
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 부품찾기 {

    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearch(arr, target, start, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, end);
        }
    }

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Solution{
        int[] components;
        int[] askedComp;
        int n;
        int m;
        String[] result;

        @Override
        public String toString(){
            return String.format(Arrays.toString(result));
        }
    }

    @FunctionalInterface
    public interface SolutionService{
        Solution solution(Solution s);
    }

    class Service {
        Solution test(Solution s) {
            SolutionService f = e -> {
                String[] result = new String[e.getM()];
                Arrays.sort(e.getComponents());
                for (int i=0; i<e.getM(); i++) {
                    if (binarySearch(e.getComponents(), e.getAskedComp()[i], 0, e.getN() - 1) >= 0) {
                        result[i] = "YES";
                    } else result[i] = "NO";
                }
                return Solution.builder()
                        .components(e.components)
                        .askedComp(e.askedComp)
                        .result(result)
                        .build();
            };
            return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        int[] components = {8, 3, 7, 9, 2};
        int[] askedComp = {5, 7, 9};
        int n = 5;
        int m = 3;
        Solution s = Solution.builder()
                .components(components)
                .askedComp(askedComp)
                .n(n)
                .m(m)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }


}
