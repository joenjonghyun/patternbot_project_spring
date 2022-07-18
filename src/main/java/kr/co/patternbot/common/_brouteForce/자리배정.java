package kr.co.patternbot.common._brouteForce;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * packageName    : kr.co.patternbot.common._brouteForce
 * fileName       : 자리배정
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 자리배정 {
    @Data
    @AllArgsConstructor
    static class Solution {

        private int num1;
        private String opcode;
        private int num2;

        @Override
        public String toString() {
            System.out.println("07 예약");
            // 1. 배열을 이용하여 간단한 극장 예약시스템 작성
            // 2. 아주 작은 극장이라 좌석이 10개만  됨.
            // 3. 먼저 좌석 배치표를 보여주고 예약이 끝나면 1로
            // 4. 예약이 안된 좌석은 0으로 나타내라.

            int seat[] = new int[10];
            int rserved;

            while (true) {
                System.out.println("좌석을 예약하시겠습니까? (1또는 0)");
                int q = 0;

                if (q == 0) break;
                System.out.println("현재의 예약상태는 다음과 같습니다.");
                System.out.println("===");
                for (int i = 0; i < 10; i++) {
                    System.out.print(i + 1 + " ");
                }
                System.out.println();
                for (int i : seat)
                    System.out.print(i + " ");
                System.out.println();
                System.out.println("몇 번째 좌석을 에약하시겠습니까?");
                rserved = 0;
                seat[rserved - 1] = 1;
                System.out.println("예약되었습니다.");
            }
            System.out.println("프로그램을 종료합니다.");
            return "";
        }
        @FunctionalInterface
        interface SolutionService {
            계산기.Solution solution(계산기.Solution s);
        }

        @Test
        void testSolution() {

        }

    }
    static void bank(Scanner scanner){


    }


}