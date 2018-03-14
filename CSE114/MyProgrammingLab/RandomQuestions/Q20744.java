//Edward Buckler
//111628438
//L05
//20744
/*
Write the definition of a class Q20744 containing:
An instance variable name of type String, initialized to the empty String.
An instance variable score of type int, initialized to zero.
A method called setName that has one parameter, whose value it assigns to the instance variable name.
A method called setScore that has one parameter, whose value it assigns to the instance variable score.
A method called getName that has no parameters and that returns the value of the instance variable name.
A method called getScore that has no parameters and that returns the value of the instance variable score.
No constructor need be defined.
*/
public class Q20744 {
    private String name = "";
    private int score = 0;

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }


}
