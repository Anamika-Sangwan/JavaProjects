package OOPs;
public class Inheritance{
    public static class Organism{
        String name;
        Organism(){
            System.out.println("In organism");
        }
        public void sound(){
            System.out.println("organism makes a sound");
        }
    }
    //Parent class
    public static class Animal extends Organism{
        int legs;
        String color;
        String name;
        Animal(){
            System.out.println("In Animal");
        }
        public void sound(){
            System.out.println("This Animal makes a sound!");
        }
    }
    //Child class
    public static class Dog extends Animal{
        Dog(String color){
            super();
            legs = 4;
            this.color = color;
            name = "Dog";
        }
        @Override
        public void sound(){
            super.sound();
            System.out.println("This Animal Barks!");
        }
        public void fetch(){
            System.out.println("This animal fetches the ball!");
        }
    }


    public static class Main{
        public static void main(String[] args){
            //1. Reference type is Animal and also the Object type is Animal
            Animal animal = new Animal();
            //Reference type is Animal but the object type is Dog
            Animal dog = new Dog("Whtie");
            //Reference type of Dog and object type of Dog
            Dog bob = new Dog("Brown");

            //1
            animal.sound();
        }
    }
}