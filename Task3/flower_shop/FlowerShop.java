package Task3.flower_shop;

import Task3.flowers.Flower;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FlowerShop implements IFlowerShop {

    @Override
    public List luxuryBouquet(Flower ... flowers){
        double bouquetPrice = 0;

        List<Flower> bouquet = new ArrayList<>();
        for (Flower flower:flowers) {
            bouquet.add(flower);
        }

        bouquet.sort(new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                return o1.freshness - o2.freshness;
            }
        });

        Accessories luxuryWrappingPaper = new Accessories(30.00);
        Accessories luxuryRibbon = new Accessories(20.50);

        System.out.println("Flowers in bouquet:" );

        for (Flower elem : bouquet){
            bouquetPrice += elem.flowerPrice;
            System.out.println(elem.flowerName);
        }

        System.out.println("Price: " + (bouquetPrice + luxuryRibbon.getPrice()
                + luxuryWrappingPaper.getPrice()) + " UAH");

        return bouquet;
    }
    @Override
    public List regularBouquet(Flower ... flowers){
        double bouquetPrice = 0;

        List<Flower> bouquet = new ArrayList<>();
        for (Flower flower:flowers) {
            bouquet.add(flower);
        }

        bouquet.sort(new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                return o1.freshness - o2.freshness;
            }
        });

        Accessories regularWrappingPaper = new Accessories(15.00);
        Accessories regularRibbon = new Accessories(10.50);

        System.out.println("Flowers in bouquet:" );

        for (Flower elem : bouquet){
            bouquetPrice += elem.flowerPrice;
            System.out.println(elem.flowerName);
        }

        System.out.println("Price: " + (bouquetPrice + regularRibbon.getPrice()
                + regularWrappingPaper.getPrice()) + " UAH");

        return bouquet;
    }

    @Override
    public List cheapBouquet(Flower ... flowers){
        double bouquetPrice = 0;

        List<Flower> bouquet = new ArrayList<>();
        for (Flower flower:flowers) {
            bouquet.add(flower);
        }

        bouquet.sort(new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                return o1.freshness - o2.freshness;
            }
        });

        Accessories cheapWrappingPaper = new Accessories(8.00);
        Accessories cheapRibbon = new Accessories(3.50);

        System.out.println("Flowers in bouquet:" );

        for (Flower elem : bouquet){
            bouquetPrice += elem.flowerPrice;
            System.out.println(elem.flowerName);
        }

        System.out.println("Price: " + (bouquetPrice + cheapWrappingPaper.getPrice()
                + cheapRibbon.getPrice()) + " UAH");

        return bouquet;
    }

    public void findFlowerByStem (List<Flower> bouquet, int minLength, int maxLength){
        System.out.println("Flowers in given range:");
        for (Flower flower : bouquet){
            if(minLength >= flower.minStemLength && maxLength <= flower.maxStemLength){
                System.out.println(flower.flowerName);
            }
        }
    }
}
