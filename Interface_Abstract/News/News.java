package Interface_Abstract.News;

public class News implements INews {
    private int ID;
    private String Title;
    private String PublishDate;
    private String Author;
    private String Content;
    private float AverageRate;
    private int[] RateList = new int[3]; // Assuming 3 rates for simplicity

    public News() {
        // Default constructor
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public String getPublishDate() {
        return PublishDate;
    }
    public void setPublishDate(String publishDate) {
        PublishDate = publishDate;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }
    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }
    public float getAverageRate() {
        return AverageRate;
    }
    public int[] getRateList() {
        return RateList;
    }
    public void setRateList(int[] rateList) {
        RateList = rateList;
    }


    @Override
    public void Display() {
        System.out.println("Title: " + Title);
        System.out.println("Publish Date: " + PublishDate);
        System.out.println("Author: " + Author);
        System.out.println("Content: " + Content);
        System.out.print("Rates: ");
        for (int rate : RateList) {
            System.out.print(rate + " ");
        }
        System.out.println();
        System.out.println("Average Rate: " + AverageRate);
    }


    public void Calculate(){
        AverageRate= 0;
        for (int i = 0; i < RateList.length; i++) {
            AverageRate += RateList[i];
        }
        if (RateList.length > 0) {
            AverageRate /= RateList.length;
        }
    }

}
