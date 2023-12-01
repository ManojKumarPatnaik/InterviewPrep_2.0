package Amazon;

public class MaxPromotionOverlap {
}
/*

/

https://leetcode.com/discuss/interview-question/396248/Facebook-or-Phone-Screen-or-Point-in-max-overlapping-intervals
/hi
no of promotirion - start date - end date

find max no of promoti at any point of time on a product

class Promotion {
  Date startTime;
  Date endTime;
}


- more than one promotion



int findMaxPromotionOverlapping(Promotion[] promotionList) {

    if(promotionList.length == 0) {
        return 0;
    }

    int maxPromotions = 0;

    for(int index1 = 0; index1 <promotionList.length; index1++) {

        int startTime = promotion[index1].startTime;
        int endTime = promotion[index1].endTime;

        int promotionTempVar = 1;

        for(int index2 = index1+1; index2<promotionList.length; index2++) {

            int otherPromotionStartTime = promotion[index2].startTime;
            int otherPromotionEndTime = promotion[index2].endTime;

            if(otherPromotionStartTime < endTime && otherPromotionEndTime >= startTime) {
                promotionTempVar++;
            }
        }

        if(promotionTempVar > maxPromotions) {

            maxPromotions =promotionTempVar;
        }
    }

    return maxPromotions;

}

 */