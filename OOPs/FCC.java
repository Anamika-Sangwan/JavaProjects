package OOPs;

public class FCC {
    public static class Book{
        String title;
        String author;
        Book(){
            this.title = "Unknown";
            this.author = "Unknown";
        }
        Book(String title){
            this.title = title;
            this.author = "Unknown";
        }
        Book(String title, String author){
            this.title = title;
            this.author = author;
        }
        public void showBookInfo(){
            System.out.println("The name of the book is " + title + " written by " + author);
        }
    }
    public static void main(String[] args){
        Book a = new Book("Gone with the Wind", "Margaret Mitchell");
        Book b = new Book("Crime and Punishment");
        a.showBookInfo();
        b.showBookInfo();
    }

}
