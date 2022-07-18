package kr.co.patternbot.common._stackQueue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * packageName    : kr.co.patternbot.common._stackQueue
 * fileName       : 기능개발
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 기능개발 {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor

    public static class Solution{
        private int[] progresses;
        private int[] speeds;
        private int cnt;


        public String toString(){
            return String.format("progresses: %s speeds:%s  기능: %d개  ",
                    Arrays.toString(progresses), Arrays.toString(speeds),cnt);
        }

    }
    @FunctionalInterface private interface SolutionService{
        Solution solution (Solution s);
    }

    class Service{
        SolutionService f = e ->{
            Queue<Integer> workDate = new LinkedList<>();
            ArrayList<Integer> release = new ArrayList<>();
            for (int i = 0; i<e.progresses.length; i++){
                workDate.add((int) Math.ceil((100.0 - e.progresses[i])/e.speeds[i]));
                // System.out.println("1/"+workDate);
            }
            int front = workDate.poll();
            int cnt = 1;

            while (!workDate.isEmpty()){
                if (front < workDate.peek()){
                    //System.out.println("2/"+workDate.peek());//확인
                    release.add(cnt);
                    cnt = 1;
                    front = workDate.poll();
                }else {
                    cnt ++;
                    //System.out.println("3/"+cnt);
                    workDate.poll();
                    //System.out.println("4/"+workDate);
                }
            }
            release.add(cnt);
            //System.out.println("5/"+release);


            return Solution.builder().progresses(e.progresses).speeds(e.speeds).cnt(cnt).build();
        };
        Solution test(Solution s){
            return f.solution(s);
        }
    }

    @Test
    void testSolution(){
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        Service s1 = new Service();
        Solution s = Solution.builder().progresses(progresses).speeds(speeds).build();
        System.out.println(s1.test(s));
    }
}