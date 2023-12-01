package Amazon;

//https://leetcode.com/problems/rectangle-overlap/
public class RectangleOverlap1 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        //not overlapping conditions

        if (rec1[2] <= rec2[0]) return false;       //rec2 is at left of rec1
        else if (rec1[0] >= rec2[2]) return false;  //rec2 is at right of rec1
        else if (rec1[3] <= rec2[1]) return false;   //rec2 is at top of rec1
        else if (rec1[1] >= rec2[3]) return false;   //rec2 is at bottom of rec1
        else
            return true;

    }
}

