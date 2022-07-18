package kr.co.patternbot.common._dfsBfs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName    : kr.co.patternbot.common._dfsBfs
 * fileName       : 네트워크
 * author         : j2022
 * date           : 2022-07-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-08        j2022       최초 생성
 */
public class 네트워크 {

    public void dfs(int node, boolean[] visited, int[][] computers) {
        visited[node] = true;

        for (int i=0; i<computers.length; i++){
            if (visited[i]==false && computers[node][i]==1){
                dfs(i, visited, computers);
            }
        }
    }

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Solution{
        int n;
        int[][] computers;
        boolean[] visited;
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
        Solution test(Solution s) {
            SolutionService f = e -> {
                e.answer = 0;
                e.visited = new boolean[e.n];

                for (int i=0; i<e.n; i++){
                    if (e.visited[i]==false){
                        e.answer++;
                        dfs(i, e.visited, e.computers);
                    }
                }
                return Solution.builder()
                        .visited(e.visited)
                        .computers(e.computers)
                        .n(e.n)
                        .answer(e.answer)
                        .build();
            };
            return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        Solution s = Solution.builder()
                .n(n)
                .computers(computers)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }



}
