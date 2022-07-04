package kr.co.patternbot.common._greedy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName    : kr.co.patternbot.common._greedy
 * fileName       : 조이스틱
 * author         : j2022
 * date           : 2022-07-04
 * description    :
 * 문제 설명
 * 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
 * ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
 *
 * 조이스틱을 각 방향으로 움직이면 아래와 같습니다.
 *
 * ▲ - 다음 알파벳
 * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
 * ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
 * ▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
 * 예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.
 *
 * - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
 * - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
 * - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
 * 따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
 * 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
 *
 * 제한 사항
 * name은 알파벳 대문자로만 이루어져 있습니다.
 * name의 길이는 1 이상 20 이하입니다.
 * 입출력 예
 * name	return
 * "JEROEN"	56
 * "JAN"	23
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-04        j2022       최초 생성
 */
public class 조이스틱 {
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class Solution{
        private String name;
        private int answer;

        @Override public String toString(){
            return String.format("%d", answer);
        }
    }
    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution s);
    }
    public static class Service{
        SolutionService f = e -> {
            e.answer = 0;
            int move = e.name.length() - 1; // 오른쪽으로 쭉 간 횟수

            for(int i = 0; i < e.name.length(); i++) {
                e.answer += Math.min(e.name.charAt(i) - 'A', 26 - (e.name.charAt(i) - 'A')); //상,하 알파벳 맞추기
                if (i < e.name.length() - 1 && e.name.charAt(i + 1) == 'A') {
                    int endA = i + 1;
                    while(endA < e.name.length() && e.name.charAt(endA) == 'A')
                        endA++;
                    move = Math.min(move, i * 2 + (e.name.length() - endA));// 오른쪽으로 갔다 다시 왼쪽으로 꺾기
                    move = Math.min(move, i + (e.name.length() - endA) * 2);// 왼쪽으로 갔다 다시 오른쪽으로 꺾기
                }
            }
            return Solution.builder()
                    .answer(e.getAnswer())
                    .name(e.getName())
                    .build();
        };
        Solution test(Solution s){
            return f.solution(s);
        }
    }
    @Test void testSolutionTest(){
        String name = "JEON";
        int answer = 0;
        Service service = new Service();
        Solution solution = Solution.builder()
                .name(name)
                .answer(answer)
                .build();
        System.out.println(service.test(solution));
    }
}
