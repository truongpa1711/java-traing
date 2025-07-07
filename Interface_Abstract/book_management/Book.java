package Interface_Abstract.book_management;

public class Book implements IBook {
    private static int count = 0; // Static variable to keep track of the number of books
    private int id;
    private String name;
    private String publishDate;
    private String author;
    private String language;
    private float averagePrice;
    private float[] PriceList  = new float[5]; // Assuming 3 prices for simplicity
    public Book() {
        // Default constructor
        this.id = ++count;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public float getAveragePrice() {
        return averagePrice;
    }

    public float[] getPriceList() {
        return PriceList;
    }
    public void setPriceList(float[] priceList) {
        this.PriceList = priceList;
    }

    @Override
    public void display() {
        System.out.println("Book ID: " + getId());
        System.out.println("Name: " + name);
        System.out.println("Publish Date: " + publishDate);
        System.out.println("Author: " + author);
        System.out.println("Language: " + getLanguage());
        System.out.println("Average Price: " + averagePrice);
    }

    public void calculate(){
        float sum = 0;
        for (float price : PriceList) {
            sum += price;
        }
        this.averagePrice = sum / PriceList.length;
    }
}
