
import java.util.*;

public class Bookstore implements BookstoreSpecification {

    private final ArrayList<Product> products = new ArrayList<>(); //to hold all available products
    private final ArrayList<Member> members = new ArrayList<>(); //to hold all store's members
    private final double bookPrice = 19.99; //to hold the fixed price of each book
    private final double cdPrice = 11.99; //to hold the fixed price of each CD
    private final double dvdPrice = 14.99; //to hold the fixed price of each DVD

    /*
        no-arg constructor
     */
    public Bookstore() {

        //default books available
        Product book1 = new Book("Harry Potter and the Sorcerer's Stone", bookPrice, 8, "J.K. Rowling", 1997);
        products.add(book1); //adding book to the books ArrayList
        Product book2 = new Book("Harry Potter and the Chamber of Secrets", bookPrice, 11, "J.K. Rowling", 1998);
        products.add(book2);
        Product book3 = new Book("Harry Potter and the Prisoner of Azkaban", bookPrice, 13, "J.K. Rowling", 1999);
        products.add(book3);

        //default CDs available
        Product cd1 = new CD("Star Wars (Soundtrack)", cdPrice, 4, "John Williams", 1977);
        products.add(cd1); //adding CD to the CDs ArrayList
        Product cd2 = new CD("Star Wars: The Force Awakens (Album)", cdPrice, 5, "John Williams", 2015);
        products.add(cd2);
        Product cd3 = new CD("Thriller (Album)", cdPrice, 7, "Michael Jackson", 1982);
        products.add(cd3);

        //default DVDs available
        Product dvd1 = new DVD("Jurassic World: Dominion", dvdPrice, 13, "Colin Trevorrow", 2022);
        products.add(dvd1); //adding dvd to the DVDs ArrayList
        Product dvd2 = new DVD("Top Gun: Maverick", dvdPrice, 2, "Joseph Kosinski", 2022);
        products.add(dvd2);
        Product dvd3 = new DVD("Minions: The Rise of Gru", dvdPrice, 1, "Kyle Balda", 2022);
        products.add(dvd3);

        //default members of the store
        Member member1 = new Member("Jose", "Sierra", 1, 1, 1);
        members.add(member1);
        Member member2 = new Member("Moe", "Salah", 1, 0, 0);
        members.add(member2);

        //default premium members of the store
        Member premiumMember1 = new PremiumMember("John", "Doe", 4, 0, 0, "Visa", true);
        members.add(premiumMember1); //adding premium member to the premiumMemberList ArrayList
        Member premiumMember2 = new PremiumMember("Jane", "Doe", 1, 0, 0, "Cash", false);
        members.add(premiumMember2);
    }

    /*
        getMemberList() Method that returns the members ArrayList
        @return ArrayList members that contains all bookstore members
     */
    public ArrayList<Member> getMemberList() {
        return members;
    }

    /*
        getProducts() Method that returns the products ArrayList
        @return ArrayList products that contains all bookstore's products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /*
        addMember() Method that adds a regular member to the members ArrayList
        @param String name The first name of the member
        @param String surname The last name of the member
        @param int books The number of books bought by the member
        @param int CDs the number of CDs bought by the member
        @param int DVDs The number of DVDs bought by the member
     */
    public void addMember(String name, String surname, int books, int CDs, int DVDs) {
        Member member = new Member(name, surname, books, CDs, DVDs);

        //to have all regular members come first in the members ArrayList
        int index = 0;
        for (Member m : members) {
            if (m instanceof PremiumMember) {
                index++; //number of premium members
            }
        }
        index = members.size() - index; //index of first premium member in the ArrayList
        members.add(index, member); //add regular member right before the premium members list starts
    }

    /*
        addPremiumMember() Method that adds a premium member to the members ArrayList
        @param String name The first name of the premium member
        @param String surname The last name of the premium member
        @param int books The number of books bought by the premium member
        @param int CDs the number of CDs bought by the premium member
        @param int DVDs The number of DVDs bought by the premium member
        @param String payMethod The method pf payment used by the premium member
        @param boolean paid Whether the membership fee has been paid or not
     */
    public void addPremiumMember(String name, String surname, int books, int CDs, int DVDs, String payMethod, boolean paid) {
        Member premiumMember = new PremiumMember(name, surname, books, CDs, DVDs, payMethod, paid);
        members.add(premiumMember);
    }

    /*
        getNumBooks() Method that returns the number of books the store has available
        @return int the number of books
     */
    public int getNumBooks() {
        int num = 0;
        for (Product x : products) {
            if (x instanceof Book) {
                num++; //number of books
            }
        }
        return num;
    }

    /*
        getNumCDs() Method that returns the number of CDs the store has available
        @return int the number of CDs
     */
    public int getNumCDs() {
        int num = 0;
        for (Product x : products) {
            if (x instanceof CD) {
                num++; //number of CDs
            }
        }
        return num;
    }

    /*
        getNumDVDs() Method that returns the number of DVDs the store has available
        @return int the number of DVDs
     */
    public int getNumDVDs() {
        int num = 0;
        for (Product x : products) {
            if (x instanceof DVD) {
                num++; //number of DVDs
            }
        }
        return num;
    }

    /*
        getNumMembers() Method that returns the number of regular members the store has
        @return int the number of regular members
     */
    public int getNumMembers() {
        int num = 0;
        for (Member x : members) {
            if (!(x instanceof PremiumMember)) {
                num++; //number of regular members
            }
        }
        return num;
    }

    /*
        getNumPremiumMembers() Method that returns the number of premium members the store has
        @return int the number of premium members
     */
    public int getNumPremiumMembers() {
        int num = 0;
        for (Member x : members) {
            if (x instanceof PremiumMember) {
                num++; //number of premium members
            }
        }
        return num;
    }

    /*
        getBookPrice() Method that returns the price of a book
        @return int the price of a book
     */
    public double getBookPrice() {
        return bookPrice;
    }

    /*
        getCDprice() Method that returns the price of a CD
        @return int the price of a CD
     */
    public double getCDprice() {
        return cdPrice;
    }

    /*
        getDVDprice() Method that returns the price of a DVD
        @return int the price of a DVD
     */
    public double getDVDprice() {
        return dvdPrice;
    }

    /*
        removeProduct() Method that removes a product from the products ArrayList
        @param index The index of the product that is to be removed from the products ArrayList
     */
    public void removeProduct(int index) {
        products.remove(index);
    }

    /*
        removeMember() Method that removes a member from the members ArrayList
        @param index The index of the member that is to be removed from the ArrayList
     */
    public void removeMember(int index) {
        members.remove(index);
    }

    /*
        startProductPurchase() Method that displays list of available products for purchase and lets user pick one to buy
        @param int loginChoice What becomes the index of the member int the members ArrayList
        @param int ProductChoice What becomes the index of the product in the products ArrayList
     */
    @Override
    public void startProductPurchase(int loginChoice, int productChoice) {

        loginChoice--; //loginChoice becomes index of member
        productChoice--; //becomes index of product

        Member temp = members.get(loginChoice);

        //product is a book
        if (productChoice < getNumBooks()) {
            temp.setNumOfBooksBought(temp.getNumOfBooksBought() + 1);
        } //if product is a CD
        else if (productChoice < getNumCDs()) {
            temp.setNumOfCDsBought(temp.getNumOfCDsBought() + 1);
        } //else product is a DVD
        else {
            temp.setNumOfDVDsBought(temp.getNumOfDVDsBought() + 1);
        }

        //remove 1 book from inventory
        Product temp1 = products.get(productChoice);
        temp1.productSold();
    }

    /*
        addProduct() Method that adds a product to the products ArrayList
        @param String name The product's name
        @param double price The product's price
        @param int copies The number of copies of product
        @param String creator The product's creator's name
        @param int year The year the product was published
     */
    @Override
    public void addProduct(String name, double price, int copies, String creator, int year, int product) {

        switch (product) {

            //it's a book
            case 1 -> {
                Product book = new Book(name, price, copies, creator, year);
                //to have books come first in the products ArrayList
                int index = getNumBooks();
                products.add(index, book); //add new book after the last book in the products ArrayList
            }

            //it's a CD
            case 2 -> {
                Product cd = new CD(name, price, copies, creator, year);
                //to have all CDs come after Books in the products ArrayList
                int index = getNumBooks() + getNumCDs();
                for (Product x : products) {
                    if (x instanceof Book || x instanceof CD) {
                        index++; //number of books and CDs
                    }
                }
                products.add(index, cd);
            }

            //it's a DVD
            case 3 -> {
                Product dvd = new DVD(name, price, copies, creator, year);
                products.add(dvd); //add new DVD to the end of the products ArrayList
            }
            default -> {
            }
        }
    }
    
    /*
        restockProduct() Method that restocks a product with a number of copies
        @param index The index of the product in the products ArrayList
        @param moreCopies The number of additional copies to be restocked
    */
    @Override
    public void restockProduct(int index, int moreCopies) {
        
        index--; //becomes index of product
        
        Product temp = products.get(index);
        
        //if product is a book, CD, or DVD
        switch (temp) {
            case Book book -> book.setNumCopies(book.getNumCopies() + moreCopies);
            case CD cd -> cd.setNumCopies(cd.getNumCopies() + moreCopies);
            case DVD dvd -> dvd.setNumCopies(dvd.getNumCopies() + moreCopies);
            case default -> {
            }
        }
    }
    
    /*
        inventoryValue() Method that calculates the entire current inventory's value and returns it
        @return double The value of the entire bookstore inventory
    */
    @Override
    public double inventoryValue() {

        //get total number of books available
        int totalBooks = 0;
        for (Product p : products) {
            if (p instanceof Book book) {
                totalBooks += book.getNumCopies();
            }
        }

        //get total number of CDs available
        int totalCDs = 0;
        for (Product p : products) {
            if (p instanceof CD cd) {
                totalCDs += cd.getNumCopies();
            }
        }

        //get total number of DVDs available
        int totalDVDs = 0;
        for (Product p : products) {
            if (p instanceof DVD dvd) {
                totalDVDs += dvd.getNumCopies();
            }
        }

        return totalBooks * bookPrice + totalCDs * cdPrice + totalDVDs * dvdPrice; //the entire available inventory value
    }
}
