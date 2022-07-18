package kr.co.patternbot.common._sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * packageName    : kr.co.patternbot.common._sort
 * fileName       : 두배열의원소교체
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 두배열의원소교체 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor

    public static class Solution{
        private int[] a;
        private Integer[] b;
        private int n;
        private int k;
        private int amax;

        public String toString(){
            return String.format("A배열: %s B배열: %s A원소합의 최대값: %d"
                    ,Arrays.toString(a),Arrays.toString(b),amax);
        }
    }
    @FunctionalInterface
    private interface SolutionService{
        Solution solution (Solution s);
    }

    class Service{
        SolutionService f = e ->{
            Arrays.sort(e.a);
            Arrays.sort(e.b, Collections.reverseOrder());

            for (int i = 0; i<e.k; i++){
                if (e.a[i] < e.b[i] ){
                    int temp = e.a[i];
                    e.a[i] = e.b[i];
                    e.b[i] = temp;
                }else{
                    break;
                }
            }
            for (int i : e.a){
                e.amax += i;
                System.out.println(i);//확인
            }
            return Solution.builder().a(e.a).b(e.b).amax(e.amax).build();
        };
        Solution test(Solution s){
            return f.solution(s);
        }
    }
    @Test
    void testSolution(){
        int[] a = {1, 2, 5, 4, 3};
        Integer[] b = {5, 5, 6, 6, 5};
        int n = 5;
        int k = 3;
        int amax = 0;
        Solution s = Solution.builder().a(a).b(b).k(k).n(n).amax(amax).build();
        Service s1 = new Service();
        System.out.println(s1.test(s));
    }
}
