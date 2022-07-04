package kr.co.patternbot.common._hash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * packageName    : kr.co.patternbot.common._hash
 * fileName       : 전화번호목록
 * author         : j2022
 * date           : 2022-07-04
 * description    :
 * 문제 설명
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * phone_book의 길이는 1 이상 1,000,000 이하입니다.
 * 각 전화번호의 길이는 1 이상 20 이하입니다.
 * 같은 전화번호가 중복해서 들어있지 않습니다.
 * 입출력 예제
 * phone_book	return
 * ["119", "97674223", "1195524421"]	false
 * ["123","456","789"]	true
 * ["12","123","1235","567","88"]	false
 * 입출력 예 설명
 * 입출력 예 #1
 * 앞에서 설명한 예와 같습니다.
 *
 * 입출력 예 #2
 * 한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.
 *
 * 입출력 예 #3
 * 첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-04        j2022       최초 생성
 */
public class 전화번호목록 {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    public static class Solution{
        private String[] phone_book;
        private boolean answer;

        @Override public String toString(){
            return String.format("%d", answer);
        }
    }
    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution s);
    }
    public static class Service{
        SolutionService f = e -> {
            e.answer = true;
            Arrays.sort(e.phone_book);
            for (int i = 0; i< e.phone_book.length; i++){
                if (e.phone_book[i+1].startsWith(e.phone_book[i]))
                    return null;
            }
            return Solution.builder()
                    .phone_book(e.getPhone_book())
                    .answer(e.answer)
                    .build();
        };
        Solution test(Solution s){
            return f.solution(s);
        }
    }
    @Test void testSolutionTest(){
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean answer = true;
        Service service = new Service();
        Solution solution = Solution.builder()
                .phone_book(phone_book)
                .answer(answer)
                .build();
        System.out.println(service.test(solution));
    }
}
