package OOPs;

public class FCC {
    public static class Person{
        String name;
        int age;
        Person(){
            this("Default", 0);
        }
        Person(String name, int age){
            this.name = name;
            this.age = age;
        }
        public void speak(){
            System.out.println("Person with the name " + name + "speaks! and is aged " + age);
        }
    }

    public static void main(String[] args){
        Person a = new Person("Anamika",22);
        Person b = new Person("Ron", 18);
        Person c = new Person("David",35);
        Person d = new Person();
        a.speak();
        b.speak();
        c.speak();
        d.speak();
    }

}
