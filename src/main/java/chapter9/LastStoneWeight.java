package chapter9;

import java.util.PriorityQueue;

/**
 * LeetCode简单练习题：最大堆演示案例
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (!pq.isEmpty() && pq.size() >= 2) {
            Integer stone1 = pq.poll();
            Integer stone2 = pq.poll();
            if (stone1 != stone2.intValue()) {
                pq.offer(stone1 - stone2);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }

    public static void main(String[] args) {
        assert new LastStoneWeight().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}) == 1;
    }

}
