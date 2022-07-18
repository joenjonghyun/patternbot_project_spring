package kr.co.patternbot.common._binSearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName    : kr.co.patternbot.common._binSearch
 * fileName       : 떡볶이떡만들기
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */

public class 떡볶이떡만들기 {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Solution{
        int n;
        int m;
        int[] arr;
        int result;

        @Override
        public String toString(){
            return String.format("%d", result);
        }
    }

    @FunctionalInterface
    public interface SolutionService{
        Solution solution(Solution s);
    }

    class Service{
        Solution test(Solution s){
            SolutionService f = e ->{
                int start = 0;
                int end = (int) 1e9;
                e.result = 0;
                while (start <= end) {
                    long total = 0;
                    int mid = (start+end)/2;

                    for (int i=0; i<e.getN(); i++){  //잘랐을때의 떡의 양 계산
                        if (e.getArr()[i] > mid) {
                            total += e.getArr()[i] - mid;
                        }
                    }
                    if (total < e.getM()){ // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
                        end = mid-1;
                    }
                    else { // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
                        e.result = mid;
                        start = mid + 1;
                    }
                }

                return Solution.builder()
                        .result(e.result)
                        .build();
            };
            return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        int n = 4;
        int m = 6;
        int[] arr = {19, 15, 10, 17};
        Solution s = Solution.builder()
                .n(n)
                .m(m)
                .arr(arr)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }

}
