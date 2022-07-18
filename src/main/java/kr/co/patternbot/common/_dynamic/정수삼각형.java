package kr.co.patternbot.common._dynamic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName    : kr.co.patternbot.common._dynamic
 * fileName       : 정수삼각형
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 정수삼각형 {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Solution{
        int[][] triangle;
        int[][] dp;
        int max;

        @Override
        public String toString(){
            return String.format("%d", max);
        }
    }

    @FunctionalInterface
    public interface SolutionService{
        Solution solution(Solution s);
    }

    class Service{
        Solution test(Solution s) {
            SolutionService f = e -> {
                e.dp = new int[e.triangle.length][e.triangle.length];
                e.dp[0][0] = e.triangle[0][0];
                for (int i = 1; i < e.triangle.length; i++) {
                    e.dp[i][0] = e.dp[i-1][0] + e.triangle[i][0];
                    e.dp[i][i] = e.dp[i-1][i-1] + e.triangle[i][i];
                }

                for (int i = 2; i < e.triangle.length; i++)
                    for (int j = 1; j < i; j++)
                        e.dp[i][j] = Math.max(e.dp[i-1][j-1], e.dp[i-1][j]) + e.triangle[i][j];

                e.max = 0;
                for (int i = 0; i < e.dp.length; i++)
                    e.max = Math.max(e.max, e.dp[e.dp.length - 1][i]);

                return Solution.builder()
                        .max(e.max)
                        .build();
            };
            return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};

        Solution s = Solution.builder()
                .triangle(triangle)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }

}
