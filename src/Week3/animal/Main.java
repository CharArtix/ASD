package Week3.animal;

public class Main {

    public static void main(String[] args) {
        Dog loli = new Dog("loli");
        Cat lola = new Cat("lola");
        Dog anjing = new BigDog("anjing");

        greetMe(loli);
        greetMe(lola);
        greetMe(anjing);
    }

    public static void greetMe(Animal a){
        a.greets();
    }
}
