//Raymond McCarthy - X00179223

//painting class
public class Painting {
    private String artist;
    private String title;
    private double purchasePrice;
    private double sellingPrice;
    private int yearCreated;

    //constructor
    public Painting(String artist, String title, double purchasePrice, double sellingPrice, int yearCreated) {
        this.artist = artist;
        this.title = title;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.yearCreated = yearCreated;
    }

    //getter and setter methods
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }
}
