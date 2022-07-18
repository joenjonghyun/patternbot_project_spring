package kr.co.patternbot.common._stackQueue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * packageName    : kr.co.patternbot.common._stackQueue
 * fileName       : 주식가격
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 주식가격 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor

    public static class Solution{
        private int[] prices;
        private int[] answer;


        public String toString(){
            return String.format("답: %s ", Arrays.toString(answer));
        }

    }
    @FunctionalInterface private interface SolutionService{
        Solution solution (Solution s);
    }

    class Service{
        SolutionService f = e ->{
            int[] answer = new int[e.prices.length];
            for (int i = 0; i< e.prices.length; i++){
                for (int j = i+1; j < e.prices.length; j ++){
                    answer[i]+=1;
                    System.out.println(answer[i]);
                    if (e.prices[i]>e.prices[j]){
                        break;
                    }

                }
            }

            return Solution.builder().answer(answer).build();
        };

        Solution test (Solution s){
            return f.solution(s);
        }
    }

    @Test
    void testSolution(){
        int[] prices = {1, 2, 3, 2, 3};
        Service s1 = new Service();
        Solution s = Solution.builder().prices(prices).build();
        System.out.println(s1.test(s));



    }
}
