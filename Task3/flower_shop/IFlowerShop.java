package Task3.flower_shop;

import Task3.flowers.Flower;

import java.util.List;

public interface IFlowerShop {

    List luxuryBouquet(Flower... flowers);

    List regularBouquet(Flower ... flowers);

    List cheapBouquet(Flower ... flowers);
}
