package pages;

public class Dog extends Animal{

    public static boolean isDog(Object obj){
        if(obj instanceof pages.Dog){
            return true;
        }
        return false;
    }

    public Dog(String name){
        this.name = name;

    }
    public Dog(){

    }

    @Override
    public void speak() {
        System.out.println(getClass()+ " " + name + " is barking!");
    }

}


