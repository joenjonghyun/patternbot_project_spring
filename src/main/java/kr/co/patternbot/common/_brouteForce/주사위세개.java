package kr.co.patternbot.common._brouteForce;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * packageName    : kr.co.patternbot.common._brouteForce
 * fileName       : 주사위세개
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 주사위세개 {
    @Data
    @AllArgsConstructor
    static class Solution{

        private int num1;
        private String opcode;
        private int num2;
        @Override public String toString(){

            System.out.println("01 주사위");
            // 홀수나올때까지 주사위굴려 합하는 프로그래밍
            // Random random = new Random();
            Random random = new Random();
            int result = 0;
            while(true) {
                int r = random.nextInt(5)+1;
                System.out.println(" dice value : "+ r);
                if(r % 2 != 0) {
                    break;
                }
                result += r;
            }
            System.out.println(result);
            // 6면인 주사위를 5회 굴려서 나온 합계를 구하시오.
            // (int) (Math.random() * 최댓값) + 최솟값
            result = 0;
            for(int i=0; i<5; i++) {
                double d = Math.random();
                int temp = (int) (d * 6) +1;  // 랜덤으로 (1-6) 정수값
                System.out.println(temp);
                result += temp;
            }
            System.out.println("Sum : "+result);
            // 플레이어(Math 랜덤값)와 컴퓨터(Random 랜덤값) 주사위 굴리기를 해 이기면
            // "Win", 비기면 "Draw.", 지면 "Lose"를 출력하세요.
            int player=(int)(Math.random()*6)+1;
            //int p = random(1,6);
            System.out.println("플레이어 숫자"+player);
            int com= new Random().nextInt(5)+1;
            System.out.println("컴퓨터 숫자"+com);
            String s = "Draw";
            if(player!=com) s = (player>com) ? "Win" : "Lose";
            System.out.println(s);
            return "";
        }
    }
    @FunctionalInterface interface SolutionService {
        주사위세개.Solution solution(주사위세개.Solution s);
    }
    @Test
    void testSolution(){

    }
}