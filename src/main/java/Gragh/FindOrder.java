package Gragh;

import java.util.*;

public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] orders = new int[numCourses];
        int index = 0;
        int[] indegrees = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
        }
        if (getCourses(indegrees, queue) == false) return new int[0];

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int course = queue.poll();
                orders[index++] = course;
                for (int[] prerequisite : prerequisites) {
                    if (course == prerequisite[1]) {
                        indegrees[prerequisite[0]]--;
                        if (indegrees[prerequisite[0]] == 0) {
                            queue.offer(prerequisite[0]);
                        }
                    }
                }
            }
        }

        for (int indegree : indegrees) {
            if (indegree != 0) return new int[]{};
        }
        return orders;
    }

    public boolean getCourses(int[] indegrees, Queue<Integer> queue) {
        boolean isAdded = false;
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
                isAdded = true;
            }
        }
        return isAdded;
    }
}
