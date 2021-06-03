//Raymond McCarthy X00179223

import java.util.ArrayList;

//gallery class
public class Gallery {
    private ArrayList<Painting> paintings = new ArrayList<>();

    //method to add paintings to arraylist
    public void addPainting(String artist, String title, double purchasePrice, double sellingPrice, int yearCreated){
        Painting p = new Painting(artist, title, purchasePrice, sellingPrice, yearCreated);
        paintings.add(p);
    }
    
    //method to display list of paintings
    public void displayList(){
        System.out.println("Paintings");
        System.out.printf("%-10s | %-10s | %-12s | %-10s %n", "Artist", "Title", "Purchase Price", "Selling Price");
        for(int i=0; i< paintings.size(); i++){
            System.out.printf("%-10s | %-20s | €%,10.2f | €%,10.2f %n", paintings.get(i).getArtist(),
                    paintings.get(i).getTitle(), paintings.get(i).getPurchasePrice(),
                    paintings.get(i).getSellingPrice());
        }
    }
    
    //method to calculate government tax
    public void calcGovernmentTax(){
        int tax1450 = 1;
        int tax1551 = 5;
        int tax1701 = 7;
        double totalTax = 0;

        double[] taxDue = new double[paintings.size()];
        System.out.printf("%-25s | %-10s %n", "Title", "Tax Due");
        for(int i =0; i< paintings.size(); i++){

            double purchasePrice = paintings.get(i).getPurchasePrice();

            if(paintings.get(i).getYearCreated() >= 1450 && paintings.get(i).getYearCreated() <= 1550){
                totalTax = purchasePrice*tax1450/100;
            }else if(paintings.get(i).getYearCreated() >= 1551 && paintings.get(i).getYearCreated() <= 1700){
                totalTax = purchasePrice*tax1551/100;
            }else if(paintings.get(i).getYearCreated() >= 1701 && paintings.get(i).getYearCreated() <= 1900){
                totalTax = purchasePrice*tax1701/100;
            }

            taxDue[i] = totalTax;

            System.out.printf("%-25s | €%-,10.2f%n", paintings.get(i).getTitle(), taxDue[i]);

        }
    }
    
    //method to calculate sales tax
    public void calcTaxOnProfit(){
        double profit;
        double profitTax = 0;
        double totalTax = 0;
        final int taxRate = 12;

        System.out.printf("%-25s | %-10s %n", "Title", "Tax on Profit");

        for(int i =0; i< paintings.size(); i++) {
            try {
                if (paintings.get(i).getSellingPrice() - paintings.get(i).getPurchasePrice() > 0){
                    profit = paintings.get(i).getSellingPrice() - paintings.get(i).getPurchasePrice();
                    profitTax = profit/100*taxRate;
                    totalTax+=profitTax;
                } else if(paintings.get(i).getSellingPrice() - paintings.get(i).getPurchasePrice() < 0){
                    profitTax = 0;
                    throw new PaintingSoldAtALoss(); //exception to tell user painting sold at a loss
                }
            }catch (PaintingSoldAtALoss loss){
                System.out.println(loss.getMessage());
            }
            System.out.printf("%-25s | €%-,10.2f%n", paintings.get(i).getTitle(), profitTax);
        }


        System.out.printf("%-25s | €%-,10.2f%n", "Total Tax Paid: ", totalTax);

    }

}
