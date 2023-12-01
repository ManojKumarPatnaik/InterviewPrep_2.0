package Ola;


/*
Given an array containing size, movement direction data of asteroid, find out the end state of the aestroids.
Absolute vale signifies the size of aestroid and + and - signifies the direction. Bigger asteroid will destory smaller asteroid

Sample: [8.-5]
Output : [8]


public class Question1 {


    //psedu code

    ReaminingAsteroids(asteroids[]):
    - Define Stack asteroidMovingRight;
    - For Loop from i =0 to asteroids.length
        - if asteroids[i] >= 0, push it it in asteroidMovingRight stack
            - asteroidMovingRight.add(asteroids[i])
        - else
            boolean isNegDirAsteroidDestroyed = false;
            do Loop:
             - if asteroidMovingRight isNotEmpty && asteroids[i] > asteroidMovingRight.peek()
                    - asteroidMovingRight.pop() // destorying the +asteroid
                else if asteroidMovingRight isNotEmpty && asteroids[i] <= asteroidMovingRight.peek()
                       isNegDirAsteroidDestroyed= true;
                        break;

            while (asteroidMovingRight.isNotEmpty())


             -  if isNegDirAsteroidDestroyed == false
                outputArray add asteroids[i]


   // any Asteroids present in stack, add those in output Array
        - while asteroidMovingRight getIsNotEmpty

            - outputArray.add(asteroidMovingRight.pop())


    return outputArray;

}



Question 2:


arr = {9:00,9:20}
departure = {9:40,10:00}

Given the arrival and departure time of the trains to the railway station,
find the minimum number of platform required that no train has to wait for another train to occupy the
 platform


Psuedo:

    Sort Arr array
    Sort Dep array

    Now create one Sorted Array combining Arrival and Depature + One more array list for Depature Index in combined sorted
        - check first index of both Arr and Dep,
            if Arrival is < Dep
                - put arrival value in the combined sorted array and increment arrival index
            else
                - put  dep value in the combined sorted array + also the index where this dep value goes in combined sorted array , store it in some array list


      - now have 2 variables, Busy=0 and TotalPlatform =0
      - Now iterate over sorted array
        - for a value, check its index in departure array list which we created, if index is not there mean its arrival,
         arrival comes in, if Busy < Total Platform, increment Busy else if ==, increment both

        - if we know that its departure, we need to decrease the Busy by 1.

- return Total Platform variable.
 */