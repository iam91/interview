package tags.sort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zwy on 18-4-11.
 */
public class CourseSchedule {
    // https://leetcode.com/problems/course-schedule/

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // return canFinishDfs(numCourses, prerequisites);
        return canFinishKahn(numCourses, prerequisites);
    }

    private boolean canFinishKahn(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return false;

        int n = numCourses;
        int[][] graph = new int[n][n];
        int[] inDegree = new int[n];
        int edgeCount = 0;

        for(int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            edgeCount++;
            inDegree[to]++;
            graph[from][to] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            Integer curr = q.poll();
            for(int i = 0; i < n; i++) {
                if(graph[curr][i] == 1) {
                    graph[curr][i] = 0;
                    inDegree[i]--;
                    edgeCount--;
                    if(inDegree[i] == 0)
                        q.offer(i);
                }
            }
        }
        return edgeCount == 0;
    }

    private boolean canFinishDfs(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return false;

        // construct graph
        int n = numCourses;
        int[][] graph = new int[n][n];

        for(int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph[from][to] = 1;
        }

        // dfs
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0)
                if(!dfs(graph, i, visited, stack)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] g, int curr, int[] visited, Stack<Integer> stack) {
        if(stack.contains(curr)) return false;

        stack.push(curr);
        visited[curr] = 1;
        for(int i = 0; i < visited.length; i++) {
            if(g[curr][i] == 1) {
                if(!dfs(g, i, visited, stack)) return false;
            }
        }
        stack.pop();
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();

        int k = 3;
//        int[][] pre = {{1,0},{2,6},{1,7},{5,1},{6,4},{7,0},{0,5}};
        int[][] pre = {{1,0},{1,2},{0,1}};
        System.out.println(c.canFinish(k, pre));
    }
}
