//Edward Buckler
//111628438
//L05
//20745
/*
Write the definition of a class Q20745 containing:
An instance variable winner of type String, initialized to the empty String.
An instance variable secondPlace of type String, initialized to the empty String.
An instance variable thirdPlace of type String, initialized to the empty String.
A method called setWinner that has one parameter, whose value it assigns to the instance variable winner.
A method called setSecondPlace that has one parameter, whose value it assigns to the instance variable secondPlace.
A method called setThirdPlace that has one parameter, whose value it assigns to the instance variable thirdPlace.
A method called getWinner that has no parameters and that returns the value of the instance variable winner.
A method called getSecondPlace that has no parameters and that returns the value of the instance variable secondPlace.
A method called getThirdPlace that has no parameters and that returns the value of the instance variable thirdPlace.
No constructor need be defined.
*/
public class Q20745 {
    private String winner = "", secondPlace = "", thirdPlace = "";

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setSecondPlace(String secondPlace) {
        this.secondPlace = secondPlace;
    }

    public void setThirdPlace(String thirdPlace) {
        this.thirdPlace = thirdPlace;
    }

    public String getWinner() {
        return winner;
    }

    public String getSecondPlace() {
        return secondPlace;
    }

    public String getThirdPlace() {
        return thirdPlace;
    }
}
