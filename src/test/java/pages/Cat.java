package pages;

public class Cat extends Animal {

    public static boolean isCat(Object obj){
        if(obj instanceof pages.Cat){
            return true;
        }
        return false;
    }


    public Cat(String name){
        this.name = name;

    }
    public Cat(){

    }

    @Override
    public void speak() {
        System.out.println(getClass() + " " + name + " is meowing!");
    }

}
