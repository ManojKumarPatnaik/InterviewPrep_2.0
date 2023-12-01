package FB;


import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/maximum-population-year/submissions/

class MaxPopulationYear {
    public static int maximumPopulation(int[][] logs) {

        int[] birthDate = new int[logs.length];
        int[] deathDate = new int[logs.length];
        int k = 0;
        for (int i = 0; i < logs.length; i++) {
            birthDate[k] = logs[i][0];
            deathDate[k] = logs[i][1];
            k++;
        }


        Arrays.sort(birthDate);
        Arrays.sort(deathDate);

        int[] merge = new int[logs.length * 2];
        int[] deathArrayIndex = new int[merge.length];
        int b = 0;
        int d = 0;
        int m = 0;
        while (b < birthDate.length && d < deathDate.length) {
            if (birthDate[b] < deathDate[d]) {
                merge[m] = birthDate[b];
                b++;
                m++;
            } else if (birthDate[b] > deathDate[d]) {
                merge[m] = deathDate[d];
                deathArrayIndex[m] = 1;
                d++;
                m++;
            } else {
                b++;
                d++;
            }
        }

        while (b < birthDate.length) {

            merge[m] = birthDate[b];
            b++;
            m++;
        }

        while (d < deathDate.length) {

            merge[m] = deathDate[d];
            deathArrayIndex[m] = 1;
            d++;
            m++;
        }


        int maxPop = 0;
        int yearIndex = Integer.MAX_VALUE;
        int tempCount = 0;
        for (int i = 0; i < merge.length; i++) {
            if(merge[i] == 0) {
                continue;
            }
            if (deathArrayIndex[i] == 1) {
                tempCount--;
            } else {
                tempCount++;
                if (tempCount > maxPop) {
                    yearIndex = i;
                    maxPop = tempCount;
                }
            }
        }

        return merge[yearIndex];


    }

    //better solution than 1
    public static int maximumPopulation2(int[][] logs) {

        int[] birthDate = new int[logs.length];
        int[] deathDate = new int[logs.length];
        int k = 0;
        for (int i = 0; i < logs.length; i++) {
            birthDate[k] = logs[i][0];
            deathDate[k] = logs[i][1];
            k++;
        }


        Arrays.sort(birthDate);
        Arrays.sort(deathDate);

        Map<Integer,Integer>yearVsDeathTillThen = new TreeMap<>();

        int b = 0;
        int d=0;
        int deathCount=0;
        int aliveCount=0;
        int maxPopulationYear = 0;
        int maxPopulation =0;
        while (b < birthDate.length) {

            if (birthDate[b] < deathDate[d]) {
                aliveCount++;
                int population = aliveCount-deathCount;
                if(population>maxPopulation) {
                    maxPopulation = population;
                    maxPopulationYear = birthDate[b];
                }
                b++;
            } else if (birthDate[b] > deathDate[d]) {
                deathCount++;
                d++;
            } else {
                yearVsDeathTillThen.put(birthDate[b], deathCount);
                aliveCount++;
                deathCount++;
                b++;
                d++;
            }
        }


        return maxPopulationYear;

    }

    //better solution then 2
    public int maximumPopulation3(int[][] logs) {

        //as range of year constraint is 1950-2050
        int pop[] = new int[101];
        int res = 0;
        for (int[] l : logs) {
            ++pop[l[0]-1950];
            --pop[l[1]-1950];
        }

        res=0;
        for (int i = 1; i < pop.length; ++i) {
            pop[i] += pop[i - 1];
            res = pop[i] > pop[res] ? i : res;
        }
        return 1950+res;
    }


    public static void main(String args[]){

       // int[][] a = {{1957,2003},{1972,2017},{1962,1982},{1969,1973},{1962,1991},{2020,2034},{2041,2050},{1950,2012},{1981,1989},{2000,2049},{2045,2048},{2049,2050},{2013,2042},{1992,2024},{1951,2001},{2018,2022},{1971,2001},{1998,2047},{2025,2044},{2042,2050},{1958,2050},{2043,2045},{2046,2048},{2009,2029},{2034,2049},{2004,2043},{2017,2035},{1980,2017},{1962,1986},{1984,1994},{1957,1984},{1951,1956},{2004,2047},{2004,2007},{1966,2035},{1980,1995},{1990,1993},{2010,2043},{2006,2044},{1953,2048},{2013,2022},{2047,2050},{2026,2027},{1955,1991},{1968,2038},{2039,2048},{2049,2050},{1974,1978},{2041,2046},{2040,2048},{2037,2038},{2027,2036},{1954,2011},{2025,2029},{2046,2050},{1993,2036},{2018,2031},{2041,2049},{1999,2021},{1956,2038},{2028,2034},{1985,2001},{1982,2005},{2013,2047},{1977,1988},{2008,2042},{2005,2011},{1961,2027},{1979,2030},{2037,2041},{1966,1977},{1983,2015},{2001,2012},{1986,2012},{2001,2016},{2031,2048},{2030,2039},{2009,2045},{2017,2026},{1958,1972},{2035,2038},{1991,2023},{1957,2030},{1997,2004},{1955,1963},{1990,2047},{1977,2035},{1996,2016},{1998,2015},{1970,1988},{1955,1957},{2041,2045},{1999,2037},{2024,2037},{2041,2046}};
        int [][]a = {{1982,2048},{1968,1973},{2010,2018},{2003,2016},{1952,2003},{1953,1993},{1983,1997},{1976,2032},{1952,1981},{1999,2021}};
        int output = maximumPopulation2(a);
        System.out.print(output);


    }
}

