package pages;

import java.util.List;

public abstract class Animal {

        protected String name;
        protected int age;

        public String getName() {

            return name;
        }

        public void setName(String name) {
            //remove digits if any
            String noDigitName = name.replaceAll("[0-9]", "");
            this.name = noDigitName;
        }


        public Animal(String newName){
            this.name = newName;
            age = 0;
        }

        public Animal(){
            name = "nameless one";
            age = 0;
        }

        public Animal(String name1, int age1){
            this.name = name1;
            this.age = age1;
        }

        public void walk() {
            System.out.println(getClass()+ " " + name + " is walking");
        }

        public void sleep() {
            System.out.println(getClass()+ " " + name + " is sleeping.");
        }

        public void eat(String what) {
            System.out.println(getClass() + " " + name + " is eating " + what + ".");
        }

    public abstract void speak();


    void printNames(List<Animal> animals){
        System.out.println("Names below: ");
        for (Animal animal:animals) {
            System.out.println(animal.getName());
            animal.speak();
        }
    }

}

