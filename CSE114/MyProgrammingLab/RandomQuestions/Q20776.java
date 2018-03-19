import java.util.Arrays;

public class Q20776 {
    public static void main(String[] args) {
        Integer[] nerd = {0, 12, 4, 1234, 41234, 32};
        Arrays.sort(nerd);
        System.out.println(getWidgetMatch(0, nerd));
    }


    public static boolean getWidgetMatch(Integer widget1, Integer [] widgetList) {
        int lowVal = 0, highVal = widgetList.length, midVal = (highVal - lowVal) / 2 + lowVal;
        while (highVal - lowVal > 1) {
            if (widget1.compareTo(widgetList[midVal]) == 0) {
                return true;
            } else if (widget1.compareTo(widgetList[midVal]) > 0) {
                lowVal = midVal;
            } else {
                highVal = midVal;
            }
            midVal = (highVal - lowVal) / 2 + lowVal;
        }
        if (widget1.equals(widgetList[midVal])) {
            return true;
        }
        return false;
    }


    public static boolean getWidgetMatch3(Integer widget1, Integer[] widgetList) {
        int low = 0;
        int high = widgetList.length;
        while (high - low > 1) {
            int mid = (high - low) / 2 + low;
            int comp = widget1.compareTo(widgetList[mid]);
            if (comp == 0) {
                return true;
            } else if (comp > 0) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return widget1.equals(widgetList[low]);
    }

}