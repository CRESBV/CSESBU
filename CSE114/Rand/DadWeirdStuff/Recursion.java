import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
//       int total= count(0,10);
//        System.out.println("total = " + total);

        Integer widget=new Integer(5);
        Integer[] widgetList={new Integer(3), new Integer(5), new Integer(7), new Integer(8)};
        System.out.println(getWidgetMatch2(widget,widgetList));
        System.out.println(getWidgetMatch3(widget,widgetList));
    }

    private static int count(int currentNumber, int maxNumber) {
        System.out.println("currentNumber = [" + currentNumber + "], maxNumber = [" + maxNumber + "]");
        if(currentNumber<maxNumber) {
            System.out.println(currentNumber);
            return currentNumber+count(++currentNumber,maxNumber);
        }
        return currentNumber;
    }

    private static boolean getWidgetMatch2(Integer widget1, Integer[] widgetList) {
        return (Arrays.binarySearch(widgetList,widget1)>=0);
    }

//    private static boolean getWidgetMatch(Integer widget1, Integer[] widgetList) {
//        int index=0;
//        while()
//        return (Arrays.binarySearch(widgetList,widget1)>=0);
//    }
    public static boolean getWidgetMatch3(Integer widget1, Integer[] widgetList) {
        int low=0;
        int high=widgetList.length;
        while(high-low>1) {
            int mid=(high-low)/2+low;
            System.out.println("mid = " + mid);
            int comp=widget1.compareTo(widgetList[mid]);
            if(comp==0) {return true;}
            else if(comp>0){low=mid;}
            else {high=mid;}
            System.out.println("high = " + high+" low="+low);
        }
        return widget1.equals(widgetList[low]);
    }


}