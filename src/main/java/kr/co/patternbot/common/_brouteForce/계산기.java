package kr.co.patternbot.common._brouteForce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.junit.jupiter.api.Test;

/**
 * packageName    : kr.co.patternbot.common._brouteForce
 * fileName       : 계산기
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 계산기 {
    @Builder
    @Getter
    @AllArgsConstructor
    static class Solution{

        private int num1;
        private String opcode;
        private int num2;
        private int res;
        @Override public String toString(){

            return num1 + " "+opcode+" "+num2 +" = "+res;
        }
    }
    static class Service{
        static SolutionService solutionService = e -> {
            String opcode = e.opcode;
            int num1 = e.num1;
            int num2 = e.num2;
            int res = 0;
            switch (opcode){
                case "+": res = num1 + num2; break;
                case "-": res = num1 - num2; break;
                case "*": res = num1 * num2; break;
                case "/": res = num1 / num2; break;
            }
            return Solution.builder().num1(num1).num2(num2).opcode(opcode).res(res).build();
        };}

    @FunctionalInterface interface SolutionService {
        계산기.Solution solution(계산기.Solution s);
    }
    @Test
    void testSolution(){
        Service.solutionService.solution(Solution.builder().num1(1).num2(2).opcode("*").build());
    }
}
