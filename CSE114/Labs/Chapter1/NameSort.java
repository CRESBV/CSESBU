//Edward Buckler
// 111628438
// L05
import java.util.Scanner;
//a silent tear for the unused:
import java.util.Arrays;

public class NameSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String [] cityList = new String[3];
        System.out.println("Enter the first city : ");
        cityList[0] = input.nextLine();
        System.out.println("Enter the second city : ");
        cityList[1] = input.nextLine();
        System.out.println("Enter the third city : ");
        cityList[2] = input.nextLine();
        Boolean iWantToUseArraysSort = false;
        //unnecessary code begins here
        //should say Arrays.sort(cityList);
        int arraysSortIsTheTrueWayToDoThis;
        int thisIsAnnoying;
        String thisIsReallyAnnoying;
        while (iWantToUseArraysSort == false){
            arraysSortIsTheTrueWayToDoThis = cityList[0].compareToIgnoreCase(cityList[1]);
            thisIsAnnoying = cityList[1].compareToIgnoreCase(cityList[2]);
            if (arraysSortIsTheTrueWayToDoThis > 0){
                thisIsReallyAnnoying = cityList[0];
                cityList[0] = cityList[1];
                cityList[1]=thisIsReallyAnnoying;
            }
            else if (thisIsAnnoying > 0) {
                thisIsReallyAnnoying = cityList[1];
                cityList[1] = cityList[2];
                cityList[2] = thisIsReallyAnnoying;
            }
            else{
                iWantToUseArraysSort = true;
            }
        }
        //unnecessary code ends here
        System.out.println("The three cities in alphabetical order are "+cityList[0]+" "+cityList[1]+" "+cityList[2]);
    }
}
