package kr.co.patternbot.common._greedy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * packageName    : kr.co.patternbot.common._greedy
 * fileName       : 큰수만들기
 * author         : j2022
 * date           : 2022-07-04
 * description    :
 * 문제 설명
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 *
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
 *
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한 조건
 * number는 2자리 이상, 1,000,000자리 이하인 숫자입니다.
 * k는 1 이상 number의 자릿수 미만인 자연수입니다.
 * 입출력 예
 * number	k	return
 * "1924"	2	"94"
 * "1231234"	3	"3234"
 * "4177252841"	4	"775841"
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-04        j2022       최초 생성
 */
public class 큰수만들기 {
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class Solution{
        private String number;
        private int k;
        private StringBuilder answer;
        private int start;
        private int max;



        @Override public String toString(){
            return String.format("%s", answer);
        }
    }

    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution s);
    }

    public static class Service{
        SolutionService f = e -> {
            e.answer = new StringBuilder("");
            int len = e.answer.length() - e.k;
           e.start = 0;

            while (e.start < e.number.length() && e.answer.length() != len){
                int leftNum = e.k + e.answer.length() +1;
                e.max = 0;
                for (int j = e.start; j < leftNum; j++){
                    if (e.max < e.number.charAt(j) - '0'){
                        e.max = e.number.charAt(j) - '0';
                        e.start = j +1;
                        return null;
                    }
                }
            }
            return Solution.builder()
                    .k(e.getK())
                    .answer(e.getAnswer())
                    .number(e.getNumber())
                    .build();
        };
        Solution test(Solution s){
            return f.solution(s);
        }
    }

    @Test void testSolutionTest(){
        String number = "1924";
        int k = 2;
        StringBuilder answer = new StringBuilder("94");
        Service service = new Service();
        Solution solution = Solution.builder()
                .k(k)
                .answer(answer)
                .number(number)
                .build();
        System.out.println(service.test(solution));
    }
}
