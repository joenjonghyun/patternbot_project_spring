package kr.co.patternbot.common._binSearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * packageName    : kr.co.patternbot.common._binSearch
 * fileName       : 입국심사
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 입국심사 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Solution{
        int n;
        int[] times;
        int answer;
        @Override
        public String toString(){
            return String.format("%d", answer);
        }
    }

    @FunctionalInterface
    public interface SolutionService{
        Solution solution(Solution s);
    }

    class Service{
        Solution test(Solution s){
            SolutionService f = e -> {
                e.answer = 0;
                Arrays.sort(e.getTimes());
                int start = 1;
                int end = e.times[e.getTimes().length-1] * e.getN();

                while (start <= end) {
                    int sum = 0;
                    int mid = (start+end)/2;
                    for (int time : e.getTimes()) {
                        sum += mid / time;
                    }
                    if(sum >= e.getN()){ // 심사하는 사람의 수가 더 많거나 같으므로 시간을 줄일 수 있다.
                        end = mid-1;
                        e.answer = mid;
                    }else{// 심사하는 사람의 수가 적으므로 시간을 늘려야한다.
                        start = mid+1;
                    }
                }

                return Solution.builder()
                        .answer(e.answer)
                        .build();
            };
            return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        int n = 6;
        int[] times = {7, 10};
        Solution s = Solution.builder()
                .n(n)
                .times(times)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));

    }


}
