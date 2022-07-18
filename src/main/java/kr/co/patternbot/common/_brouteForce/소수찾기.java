package kr.co.patternbot.common._brouteForce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import static kr.co.patternbot.common.lambda.Lambda.choi;

/**
 * packageName    : kr.co.patternbot.common._brouteForce
 * fileName       : 소수찾기
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 소수찾기 {
    @Builder
    @Getter
    @AllArgsConstructor
    static class Solution{
        private int a;
        private String res;
        @Override public String toString(){
            return "소수 :" +  res;
        }

    }
    @FunctionalInterface interface SolutionService{ Solution solution(Solution solution);}

    static class Service{
        static SolutionService solutionService = e ->{
            int count = 0;
            String res = "";
            for (int i = 2; i <= e.a; i++) {
                for (int j = 2; j <= i; j++) {
                    if (i % j == 0) {
                        count++;
                    }
                }

                if (count == 1) {
                    res += " " + choi(i);
                }
                count = 0;
            }

            return Solution.builder().res(res).build();
        };
    }

    @Test
    void solution(){
        System.out.println(Service.solutionService.solution(Solution.builder().a(100).build()));
    }
}
