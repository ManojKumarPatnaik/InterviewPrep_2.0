/*
You're developing a system for scheduling advising meetings with students in a Computer Science program. Each meeting should be scheduled when a student has completed 50% of their academic program.

Each course at our university has at most one prerequisite that must be taken first. No two courses share a prerequisite. There is only one path through the program.

Write a function that takes a list of (prerequisite, course) pairs, and returns the name of the course that the student will be taking when they are halfway through their program. (If a track has an even number of courses, and therefore has two "middle" courses, you should return the first one.)

Sample input 1: (arbitrarily ordered)
prereqs_courses1 = [
	["Foundations of Computer Science", "Operating Systems"],
	["Data Structures", "Algorithms"],
	["Computer Networks", "Computer Architecture"],
	["Algorithms", "Foundations of Computer Science"],
	["Computer Architecture", "Data Structures"],
	["Software Design", "Computer Networks"]
]

In this case, the order of the courses in the program is:
	Software Design
	Computer Networks
	Computer Architecture
	Data Structures
	Algorithms
	Foundations of Computer Science
	Operating Systems

Sample output 1:
	"Data Structures"


Sample input 2:
prereqs_courses2 = [
	["Data Structures", "Algorithms"],
	["Algorithms", "Foundations of Computer Science"],
	["Foundations of Computer Science", "Logic"]
]


Sample output 2:
	"Algorithms"

Sample input 3:
prereqs_courses3 = [
	["Data Structures", "Algorithms"],
]


Sample output 3:
	"Data Structures"

Complexity analysis variables:

n: number of pairs in the input


*/

/*

MAP<
DS , Algo
Algo, CS
CS, Logic
Logic - X  completed
>


DS
Algo
FC


SD
CN
CN
DS
ALGO
CS
OS

*/

import com.sun.tools.javac.util.StringUtils;

import java.io.*;
import java.util.*;

public class CoinBaseCourseScheduling {
    public static void main(String[] argv) {
        String[][] prereqsCourses1 = {
                {"Foundations of Computer Science", "Operating Systems"},
                {"Data Structures", "Algorithms"},
                {"Computer Networks", "Computer Architecture"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Computer Architecture", "Data Structures"},
                {"Software Design", "Computer Networks"}
        };

        String[][] prereqsCourses2 = {
                {"Data Structures", "Algorithms"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Foundations of Computer Science", "Logic"}
        };

        String[][] prereqsCourses3 = {
                {"Data Structures", "Algorithms"}
        };


        String output = findTheMidCourse(prereqsCourses3);
        System.out.println(output);
    }

    private static String findTheMidCourse(String[][] prereqsCourses) {

        Map<String, String> depedencyGraph = new HashMap<>();
        Map<String, Integer> indgree = new HashMap<>();

        for(String[] coursesList: prereqsCourses) {
            String courseNeedToBeCompleted = coursesList[1];
            String courseItDependesOn = coursesList[0];
            indgree.put(courseNeedToBeCompleted, 0);
            indgree.put(courseItDependesOn, 0);
        }


        for(String[] coursesList: prereqsCourses) {

            String courseNeedToBeCompleted = coursesList[1];
            String courseItDependesOn = coursesList[0];
            depedencyGraph.put(courseItDependesOn, courseNeedToBeCompleted);
            indgree.put(courseNeedToBeCompleted, indgree.get(courseNeedToBeCompleted)+1);
        }

        //find the starting point
        String startingCourse = "";
        for(String[] coursesList: prereqsCourses) {
            String course = coursesList[0];
            if(indgree.get(course) == 0) {
                startingCourse = course;
            }
        }

        List<String> sequenceOfCourses = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startingCourse);

        while(!queue.isEmpty()) {

            String course = queue.poll();
            sequenceOfCourses.add(course);
            //find all the course which can start after the above course is done
            String courseCanStartNow = depedencyGraph.get(course);

            if(courseCanStartNow!=null)
            queue.add(courseCanStartNow);
        }

        //FIND THE MID ONE
        //if even, find the f
        int mid = 0;
        if(sequenceOfCourses.size()%2 != 0 ) {

            mid = sequenceOfCourses.size()/2;

        } else {
            mid = sequenceOfCourses.size()/2 -1;
        }

        //return the mid index course
        for(int i=0; i<sequenceOfCourses.size(); i++) {
            if(i == mid) {
                return sequenceOfCourses.get(i);
            }
        }
        return "";
    }
}
