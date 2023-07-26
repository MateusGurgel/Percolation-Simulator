import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        int size = 20;
        int sites = size * size;
        List<Integer> possibleSites = new ArrayList<>();

        for (int i = 0; i < sites; i++) {
            possibleSites.add(i);
        }

        Random random = new Random();
        Percolation percolation = new Percolation(size);

        int percolationTries = 0;

        for (int i = 0; i < sites; i++) {

            percolationTries = i;

            int siteIndex = (random.nextInt(possibleSites.size() - 1 + 1) + 1) - 1;
            int site = possibleSites.get(siteIndex);

            percolation.open(site);

            possibleSites.remove(siteIndex);

            System.out.println();
            percolation.printPercolation();
            System.out.println();

            if(percolation.isPercolated()){
                System.out.println("Percolated");
                break;
            }

        }

        float percolateChance = (float) percolationTries / sites;
        System.out.println("Percolation Chance: " + percolateChance);

    }
}