package kr.co.patternbot.common._sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName    : kr.co.patternbot.common._sort
 * fileName       : 성적이낮은순서로학생출력하기
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 성적이낮은순서로학생출력하기 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor

    public static class Solution{
        private String[] name;
        private String[] score;
        private int n;
        private String[] temp;



        public String toString(){
            return String.format("");
        }

    }
    @FunctionalInterface private interface SolutionService{
        Solution solution (Solution s);
    }

    @Test
    void testSolution(){
        String[] name = {"권솔이","김한슬","홍정명"};
        String[] score = {"85","72","32"};
        int n = 2;


        Solution s = Solution.builder().name(name).score(score).n(n).build();

        SolutionService f = e ->{
            List<Map<String,String>> listMapInsert = new ArrayList<Map<String,String>>();
            for (int i = 0; i<=n; i++){
                Map<String,String> map = new HashMap<String,String>();
                map.put(name[i],score[i]);

                listMapInsert.add(map);


                System.out.println("List Map Insert : " + listMapInsert.toString());//확인
                System.out.println("");


            }

            return Solution.builder().name(name).score(score).n(n).build();
        };
        System.out.println(f.solution(s));


    }
}
