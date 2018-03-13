/**
 * Example of interheritance and usage of this, super
 */
public class Animal {
    int legs;
    String fur;

    public Animal(int legs) {
        this.legs = legs;
        fur = "Unknown";
    }

    @Override
    public String toString() {
        return "AnimalInherit{" +
                "legs=" + legs +
                ", fur='" + fur + '\'' +
                '}';
    }
}


class Mammal extends Animal {
    public Mammal(int legs) {
        super(legs);
        fur = "Yes";
    }

    @Override
    public String toString() {
        return "Mammal{" +
                "legs=" + legs +
                ", fur='" + fur + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Animal bug = new Animal(3);
        System.out.println("bug.toString() = " + bug.toString());

        Mammal dog = new Mammal(4);
        System.out.println("dog.toString() = " + dog.toString());
    }
}