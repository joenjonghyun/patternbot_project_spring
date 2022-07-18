package kr.co.patternbot.common._sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * packageName    : kr.co.patternbot.common._sort
 * fileName       : 선택정렬
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 선택정렬 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Solution {
        private int [] array ;

        public String toString() {
            return Arrays.toString(array);
        }
    }
    @FunctionalInterface
    private interface SolutionService {
        Solution solution(Solution s);
    }
    @FunctionalInterface
    private interface TriConsumer {
        void accept(int[] arr,int start,int end);
    }

    class Service {
        SolutionService f = e ->{
            for (int i = 0; i<e.array.length-1; i++){
                int min = i;
                for (int j = i+1; j<e.array.length; j++){
                    if (e.array[j]<e.array[min]){
                        min=j;
                    }
                }
                this.swap(e.array,min,i);
            }
            return Solution.builder().array(e.array).build();
        };

        Solution test(Solution s) {
            return f.solution(s);
        }

        TriConsumer c = (arr, start, end) -> {
            int tmp=arr[start];
            arr[start]=arr[end];
            arr[end]=tmp;
        };

        void swap(int[] arr,int start,int end) {
            c.accept(arr, start, end);
        }

    }
    @Test
    void testSolution() {
        int [] arr = {7,5,2,9,10,11,15};
        Solution s = Solution.builder().array(arr).build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }
}
