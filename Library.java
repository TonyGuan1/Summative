package library;
import java.util.*;
public class Library {
    public static void main(String args[]){
        Scanner reader = new Scanner (System.in);
        Scanner scanner = new Scanner (System.in);
        List<Books> bookList= new ArrayList<>();
        
        
        String bName;
        String bAuthor;
        String action;
        int idNum = 1;
        int bookNum;
        String bookAction;
        
        instructions();
        try{
        loop: while (true) {
                System.out.println("\nEnter the action");
                action = reader.nextLine();
                switch(action){
                    case "add":
                        System.out.println("Enter bookname" );
                        bName = reader.nextLine();
                        System.out.println("Enter the author for this book");
                        bAuthor = reader.nextLine();
                        Books b1 = new Books(bName, bAuthor, idNum);
                        bookList.add(b1);
                        System.out.println("Book: " + bName + " was added!");
                        idNum++;
                        break;
                   
                    case "instructions":
                        instructions();
                        break;
                     
                    case "list":
                        for(Books book : bookList) {
                            System.out.println("Book name: " + book.getName()+ ", Book id: " + book.getId()+ ", Book Author: " + book.getAuth() + ", Book Location; " + book.getLocation());   
                        }
                        break;
                    
                    case "borrowing":
                        System.out.println("\nEnter the book ID"); 
                        bookNum = Integer.parseInt(reader.nextLine());
                        System.out.println(bookList.get(bookNum-1).getLocation());
                        System.out.println("Type:\nborrow to take a book out\nreturn to give the book back");
                        bookAction = reader.nextLine();    
                        switch (bookAction){
                            case "borrow":
                                bookList.get(bookNum-1).borrowed();
                                break;
                            case "return":
                                bookList.get(bookNum-1).borrowed();
                                break;
                            default:
                                System.out.println("That doesn't work");
                        }
                        break;
                    
                    case "end":
                        break loop;
                    
                    default:
                        System.out.println("Please Try Again...");          
                }              
            }
        }
        catch (Exception e){
            System.out.println("Invalid Try Again");
        }
        
        for(Books book : bookList) {
            System.out.println("Book name: " + book.getName()+ ", Book id: " + book.getId()+ ", Book Author: " + book.getAuth() + ", Book Location; " + book.getLocation());
        }
    }
    public static void instructions(){
        System.out.println("Type: \nend to exit\nadd to insert a book\nborrow to check out/in\nlist to get the booklist\ninstructions to get help");
    }
}
// author, name, check in/out
class Books
{
    private String fname;
    private int stId= 0;
    private String bauth;
    private boolean location;
    String x= "";
    public Books(String name, String author, int id) {
        this.bauth = author;
        this.fname = name;
        this.stId = id;
        this.location = true;
        
    }
    
    public Books() {
        this.fname = "Unnamed Book";
        this.stId = 0;
    }

    public String getName()
    {
        return this.fname;
    }

    public int getId()
    {
        return this.stId;
    }
    
    public String getAuth()
    {
        return this.bauth;
    }
    
    public String getLocation(){
        if (this.location == true){
              x= "Available";
        }else{
              x="Checked Out";
        }
        return x;
    }

    public boolean updateName(String name)
    {
        this.fname = name;
        return true;
    }
    public void borrowed(){
        this.location = false;
    }
    
    public void returned(){
        this.location = true;
    }   
    
}
