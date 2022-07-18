package kr.co.patternbot.common._brouteForce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static kr.co.patternbot.common.lambda.Lambda.Atm;

/**
 * packageName    : kr.co.patternbot.common._brouteForce
 * fileName       : ATM
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class ATM {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Solution{
        private int num;
        private int prev;
        private int sum;
        private int people;
        private int [] arr;

        @Override
        public String toString() {
            return "Solution{" +
                    "num=" + num +
                    ", prev=" + prev +
                    ", sum=" + sum +
                    ", people=" + people +
                    ", arr=" + Arrays.toString(arr) +
                    '}';
        }
    }
    @FunctionalInterface interface SolutionService{
        Solution solution(Solution s);
    }

    @Test
    void testSolution(){

        SolutionService f = e -> {
            int [] arr = new int[e.getNum()];
            for(int i =0; i < e.getNum(); i++){
                arr[i] = e.getPeople();
            }
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            int prev = 0;
            int sum = 0;
            for(int i = 0; i<arr.length; i++){
                prev += arr[i];
                sum += prev;

            }
            return Solution.builder().num(e.getNum()).people(e.getPeople()).prev(prev).sum(sum)
                    .arr(arr).build();

        };
        Solution s =f.solution(Solution.builder().prev(Atm()).num(Atm()).people(Atm()).build());
        System.out.println(f.solution(s));

    }}
