package kr.co.patternbot.common._brouteForce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import static kr.co.patternbot.common.lambda.Lambda.lotto;

/**
 * packageName    : kr.co.patternbot.common._brouteForce
 * fileName       : 로또
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 로또 {
    @Getter
    @Builder
    @AllArgsConstructor
    static class Solution{

        private String res;
        private int lottonumber;

        @Override public String toString(){

            System.out.println("06 로또");

            return "";
        }
    }
    @FunctionalInterface interface SolutionService {
        로또.Solution solution(로또.Solution s);
    }
    @Test
    void testSolution(){
        SolutionService f = e ->{
            String res = "";
            int[] lotto = new int[6];
            for (int i = 0; i < 6; i++) {
                lotto[i] = e.getLottonumber();
                for (int j = 0; j < i; j++) {
                    if (lotto[i] == lotto[j])
                        i--;
                    break;
                }
            }
            for (int i = 0; i < 6; i++) {
                res += String.format(lotto[i] + " ");
            }
            return Solution.builder().res(res).build();
        };
        Solution s = f.solution(Solution.builder().lottonumber(lotto()).build());
    }
}
