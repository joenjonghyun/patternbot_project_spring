package kr.co.patternbot.common.heap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * packageName    : kr.co.patternbot.common.heap
 * fileName       : 더맵게
 * author         : j2022
 * date           : 2022-06-28
 * description    :
 * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
 *
 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
 * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * scoville의 길이는 2 이상 1,000,000 이하입니다.
 * K는 0 이상 1,000,000,000 이하입니다.
 * scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
 * 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
 * 입출력 예
 * scoville	K	return
 * [1, 2, 3, 9, 10, 12]	7	2
 * 입출력 예 설명
 * 스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
 * 새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
 * 가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]
 *
 * 스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
 * 새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
 * 가진 음식의 스코빌 지수 = [13, 9, 10, 12]
 *
 * 모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-28        j2022       최초 생성
 */
//뭔가잘못됨
//잘못 된 이유 : 스트링.포맷에 그 뭐야 그거 안 해줌 스트링 값 넣는 곳에 %d를 안 해줬음 주의부탁!
public class 더맵게 {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    public static class Solution{
        private int[] scoville;
        private int k;
        private int answer;
        //속성
        @Override public String toString(){

            return String.format("scoville: %s, K: %d, return: %d", Arrays.toString(scoville), k, answer);}
    }

    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution s);
    }

    public static class Service{

        SolutionService f = e -> {
            e.answer = 0;

            //최대 값이 우선순위인 큐 = 최대 힙, 최소 값이 우선순위인 큐 = 최소 힙

            //자동오름차순정렬
            PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

            for (int i=0; i<e.scoville.length; i++) {
                minHeap.add(e.scoville[i]);
            }

            while (minHeap.peek() < e.k) {
                //제일낮은값, 제일낮은값+1 빼기
                int min1 = minHeap.poll();
                int min2 = minHeap.poll();

                //힙에 넣기
                minHeap.add(min1 + min2*2);
                e.answer++;

                //제일 낮은 값이 K이상이면 끝
                if (minHeap.peek() >= e.k) {
                    break;
                }

                //마지막 수가 K보다 작을 때
                if (minHeap.peek() < e.k && minHeap.size() == 1) {
                    e.answer = -1;
                    break;
                }
            }

            return Solution.builder()
                    .answer(e.getAnswer())
                    .k(e.getK())
                    .scoville(e.getScoville())
                    .build();
        };
        Solution test(Solution s){
            return f.solution(s);
        }
    }

    @Test void testSolutionTest(){
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        int answer = 2;
        Service service = new Service();
        Solution solution = Solution.builder()
                .scoville(scoville)
                .k(k)
                .answer(answer)
                .build();
        System.out.println(service.test(solution));
    }







}