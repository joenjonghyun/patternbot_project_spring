package kr.co.patternbot.common._brouteForce;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * packageName    : kr.co.patternbot.common._brouteForce
 * fileName       : 가위바위보
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 가위바위보 {
    @Data
    @AllArgsConstructor
    static class Solution{

        private int num1;
        private String opcode;
        private int num2;
        @Override public String toString(){

            System.out.println("02 가위바위보");
            System.out.println(" ----------- 1 -------------");
            int a = (int)(Math.random()*3)+1;
            int b = (int)(Math.random()*3)+1;
            System.out.println((a == b) ? "Draw" : (b > (a+1)%3) ? "Win":"lose");
            System.out.println(" ----------- 2 -------------");
            a = (int)(Math.random()*3)+1;
            b = (int)(Math.random()*3)+1;
            System.out.println(a);
            System.out.println(b);
            String s = "";
            if (a == b) s= "Draw";
		/*
		 2%3 2 3
		 3%3 0 1
		 1%3 1 2
		 * */
            else s = (b > (a+1)%3) ? "Win":"lose";
            System.out.println(s);
            System.out.println(" ----------- 3 -------------");
            String[] arr = {"가위", "바위", "보", "Draw", "Win", "Lose"};
            int[] arr2 = new int[2];
            for(int i =0 ; i<arr2.length; i++) arr2[i] = (int)(Math.random()*3)+1;
            int p = arr2[0], c = arr2[1];
            System.out.printf("Player : %s %d\n",arr[p-1], p);
            System.out.printf("Computer : %s %d\n",arr[c-1], c);
            int i = 3;
            switch(Math.abs(p - c)) {
                case 1: i = (p > c) ? 5 : 4;
                case 2: i = (p > c) ? 4 : 5;
                default: break;
            }
            System.out.printf("Player: %s", arr[i]);
            return "";
        }
    }
    @FunctionalInterface interface SolutionService {
        가위바위보.Solution solution(가위바위보.Solution s);
    }
    @Test
    void testSolution(){

    }
}
