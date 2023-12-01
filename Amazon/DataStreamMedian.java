package Amazon;

public class DataStreamMedian {

    static int size = 0;
    static int midValue1 = Integer.MIN_VALUE;
    static int midValue2 = Integer.MIN_VALUE;

    public DataStreamMedian() {

    }

    public static void addNum(int num) {

        size += 1;

        if (size % 2 > 0) {

            if(size == 1) {
                midValue1 = num;
                midValue2 = num;
            }

            midValue1 = midValue2;
            midValue2 = num;
        } else {

        midValue2 = num;
    }

}

    public static double findMedian() {

        if (midValue2 == Integer.MIN_VALUE) {
            return midValue1;

        }

        return (double) (midValue1 + midValue2) / 2;

    }

    public static void main(String args[]) {
        DataStreamMedian obj = new DataStreamMedian();
        obj.addNum(-1);
        System.out.println(obj.findMedian());
        obj.addNum(-2);
        System.out.println(obj.findMedian());
        obj.addNum(-3);
        System.out.println(obj.findMedian());
        obj.addNum(-4);
        System.out.println(obj.findMedian());
        obj.addNum(-5);
        System.out.println(obj.findMedian());
    }
}
