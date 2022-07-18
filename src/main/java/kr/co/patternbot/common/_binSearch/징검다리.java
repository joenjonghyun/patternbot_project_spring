package kr.co.patternbot.common._binSearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * packageName    : kr.co.patternbot.common._binSearch
 * fileName       : 징검다리
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 징검다리 {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Solution{
        int distance;
        int[] rocks;
        int n;
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
        Solution test(Solution s){
            SolutionService f = e -> {
                e.answer = 0;
                int left = 0;
                int right = e.getDistance();
                Arrays.sort(e.getRocks());
                while (left <= right) {
                    int mid = (left + right)/2;
                    int removeRocks = 0;
                    int prev = 0;

                    for (int i=0; i<e.getRocks().length; i++){
                        if (e.getRocks()[i] - prev < mid)
                            removeRocks++;
                        else
                            prev = e.getRocks()[i];
                    }
                    if(e.getDistance() - e.getRocks()[e.getRocks().length-1] < mid)
                        removeRocks++;
                    if (removeRocks <= e.getN()) {
                        e.answer = mid;
                        left = mid + 1;
                    }
                    else
                        right = mid - 1;
                }
                return Solution.builder()
                        .answer(e.answer)
                        .build();
            };
            return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        Solution s = Solution.builder()
                .distance(distance)
                .rocks(rocks)
                .n(n)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }









}
