package kr.co.patternbot.common._dynamic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName    : kr.co.patternbot.common._dynamic
 * fileName       : 등굣길
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 등굣길 {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Solution{
        int m;
        int n;
        int[][] puddles;
        int[][] dp;
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
                e.dp = new int[e.n+1][e.m+1];

                for (int[] puddle : e.puddles)
                    e.dp[puddle[1]][puddle[0]] = -1;
                e.dp[0][1] = 1;

                for(int i=1; i<=e.m; i++){
                    for(int j=1; j<=e.n; j++){
                        if (e.dp[j][i] == -1) e.dp[j][i] = 0;
                        else e.dp[j][i] = (e.dp[j-1][i] + e.dp[j][i-1]) % 1000000007;
                    }

                }
                e.answer = e.dp[e.n][e.m];
                return Solution.builder()
                        .answer(e.answer)
                        .build();
            };
            return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        Solution s = Solution.builder()
                .m(m)
                .n(n)
                .puddles(puddles)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }

}
