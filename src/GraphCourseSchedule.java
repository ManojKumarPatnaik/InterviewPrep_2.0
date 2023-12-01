import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
https://leetcode.com/problems/course-schedule/

Input:
    numCourses = 2,
    prerequisites = [[1,0]]

Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Input:
    5
    [[1,4],[2,4],[3,1],[3,2]]
Output: true
 */
class GraphCourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Queue<Integer> courseWithNoPreRequiste = new LinkedList<>();
        int[] indgree = new int[numCourses];

        //convert it to the adjancency list graph
        ArrayList<Set<Integer>> graph = new ArrayList<>();

        //initialize the graph with 0
        for(int i =0; i<numCourses; i++) {
            graph.add(new HashSet<>());
        }

        //fill up the graph
        for(int[] courseDependency : prerequisites) {

            int courseToBeCompleted = courseDependency[0];
            int dependencyCourse = courseDependency[1];

            graph.get(dependencyCourse).add(courseToBeCompleted);
            indgree[courseToBeCompleted]++;
        }


        //fill up the courses with no dependency or indegree 0
        for(int[] courseDependency : prerequisites) {

            int course = courseDependency[1];
            if(indgree[course] == 0 && !courseWithNoPreRequiste.contains(course)) {
                courseWithNoPreRequiste.add(course);
            }
        }



        while(!courseWithNoPreRequiste.isEmpty()) {
            int nodeWithIndgreeZero = courseWithNoPreRequiste.poll();
            System.out.println(nodeWithIndgreeZero);
            Set<Integer> dependencyCourses = graph.get(nodeWithIndgreeZero);
            for(Integer course: dependencyCourses) {
                indgree[course]--;
                if(indgree[course] == 0) {
                    courseWithNoPreRequiste.add(course);
                }
            }
        }

        for(int i =0; i<indgree.length; i++) {
            if(indgree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}