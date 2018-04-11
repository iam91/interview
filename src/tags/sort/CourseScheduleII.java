package tags.sort;

/**
 * Created by zwy on 18-4-11.
 */
public class CourseScheduleII {
    // https://leetcode.com/problems/course-schedule-ii/description/

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return new int[0];

        int n = numCourses;
        int[] order = new int[n];

        int[][] graph = new int[n][n];
        int[] inDegree = new int[n];
        int edgeCount = 0;
        for(int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            edgeCount++;
            graph[from][to] = 1;
            inDegree[to]++;
        }

        int head = 0, tail = 0;
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                order[tail++] = i;
            }
        }


        while(head < tail) {
            int curr = order[head++];
            for(int i = 0; i < n; i++) {
                if(graph[curr][i] == 1) {
                    graph[curr][i] = 0;
                    inDegree[i]--;
                    edgeCount--;
                    if(inDegree[i] == 0) {
                        order[tail++] = i;
                    }
                }
            }
        }

        if(edgeCount == 0) return order;
        else return new int[0];
    }
}
