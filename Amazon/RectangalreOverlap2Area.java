package Amazon;

//https://leetcode.com/problems/rectangle-area/submissions/
public class RectangalreOverlap2Area {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {


        //find the area of Rec1 and Rec2
        int recOneArea = (ax2 - ax1) * (ay2 - ay1);
        int recTwoArea = (bx2 - bx1) * (by2 - by1);

        if (ax2 <= bx1 || ax1 >= bx2 || ay2 <= by1 || ay1 >= by2) {
            return recOneArea + recTwoArea;
        }

        int overlapArea = 0;
        if (recOneArea > recTwoArea) {
            overlapArea = findOverlapArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        } else {
            overlapArea = findOverlapArea(bx1, by1, bx2, by2, ax1, ay1, ax2, ay2);
        }

        return (recOneArea + recTwoArea) - overlapArea;
    }

    private int findOverlapArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        //find  x1
        int x1, x2, y1, y2;

        if (bx1 >= ax1 && bx1 <= ax2)
            x1 = bx1;
        else
            x1 = ax1;

        //find x2
        if (bx2 >= ax1 && bx2 <= ax2)
            x2 = bx2;
        else
            x2 = ax2;


        //find y1,
        if (by1 >= ay1 && by1 <= ay2)
            y1 = by1;
        else
            y1 = ay1;


        //find y2
        if (by2 >= ay1 && by2 <= ay2)
            y2 = by2;
        else
            y2 = ay2;

        return (x2 - x1) * (y2 - y1);
    }
}
/*
simple way to find the overlap
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {


        //find the area of Rec1 and Rec2
        int recOneArea = (ax2-ax1)*(ay2-ay1);
        int recTwoArea = (bx2-bx1)*(by2-by1);


         int overlapArea = 0;
        int x1 = Math.max(ax1,bx1);
        int x2 = Math.min (ax2,bx2);
        int y1 = Math.max(ay1,by1);
        int y2 = Math.min(ay2,by2);

        //as overlap area is also a valid rectangalre
        if(x2>=x1 && y2>=y1) {
            overlapArea = (x2-x1) * (y2-y1);
        }

        return (recOneArea + recTwoArea)-overlapArea;
    }

}



 */
