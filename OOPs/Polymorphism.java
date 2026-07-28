package OOPs;

public class Polymorphism {
    //2 types:- runtime and compile time
    //method overriding and method overloading
    //for method overriding, there needs to be inheritence.
    public static class Animal{
        int legs;
        String color;
        public void Sound(){
            System.out.println("This animal Makes a sound");
        }
        public void Sound(String name){
            System.out.println("Hi " + name + "! This animal makes a sound" );
        }
    }
    public static class Dog extends Animal{
        @Override
        public void Sound(){
            System.out.println("This animal barks!");
        }
        public void Sound(String s){
            System.out.println("Hi!" + s + ", This animal barks!");
        }
    }
    public static void main(String[] args){
        Animal a = new Dog();
        a.Sound();
        a.Sound("Anamika");
    }
}
