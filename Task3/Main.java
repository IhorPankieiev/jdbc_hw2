//Цветочница. Определить иерархию цветов. Создать несколько объектов-цветов. Собрать букет (используя аксессуары) с определением его
// стоимости. Провести сортировку цветов в букете на основе уровня свежести. Найти цветок в букете, соответствующий заданному диапазону
// длин стеблей.

package Task3;

import Task3.flowers.Chamomile;
import Task3.flowers.Flower;
import Task3.flowers.Rose;
import Task3.flowers.Tulip;
import Task3.flower_shop.FlowerShop;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Flower rose = new Rose( 3);
        Flower tulip = new Tulip(2);
        Flower chamomile = new Chamomile(1);

        FlowerShop flowerShop = new FlowerShop();

        List<Flower> luxury = flowerShop.luxuryBouquet(rose, tulip, chamomile);

        List<Flower> regular = flowerShop.regularBouquet(rose, tulip);

        List<Flower> cheap = flowerShop.cheapBouquet(rose, rose, tulip, tulip);

        flowerShop.findFlowerByStem(luxury, 40, 60);
    }
}
