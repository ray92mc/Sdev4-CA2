//Raymond McCarthy X00179223

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//test class
public class Test {
    //main method
    public static void main(String[] args) {
        String artist = null;
        String title = null;
        double purchasePrice = 0.0;
        double sellingPrice = 0.0;
        int yearCreated = 0;

        //import file
        File inFile = new File("files", "gallery.txt");
        Gallery gallery = new Gallery();
        try (Scanner in = new Scanner(inFile)){
            while(in.hasNextLine()){
                String line = in.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");
                while(lineScanner.hasNext()){
                    artist = lineScanner.next();
                    title = lineScanner.next();
                    purchasePrice = Double.parseDouble(lineScanner.next());
                    sellingPrice = Double.parseDouble(lineScanner.next());
                    yearCreated = Integer.parseInt(lineScanner.next());
                }
                gallery.addPainting(artist, title, purchasePrice, sellingPrice, yearCreated);
            }
        } catch (FileNotFoundException ex){  //exception when file can not be found
            System.out.println("Problem: "+ ex.getMessage());
        }

        //user menu
        while (true) {
            System.out.println("Please press 1 to view the painting");
            System.out.println("Please press 2 to view the tax due on paintings");
            System.out.println("Please press 3 to view the tax on profit");
            System.out.println("Press 4 to quit");

            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    gallery.displayList();
                    break;
                case 2:
                    gallery.calcGovernmentTax();
                    break;
                case 3:
                    gallery.calcTaxOnProfit();
                    break;
                case 4:
                    System.exit(0);
            }
        }


    }
}
