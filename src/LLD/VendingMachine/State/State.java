package LLD.VendingMachine.State;

import LLD.VendingMachine.dto.Coin;
import LLD.VendingMachine.dto.Product;

import java.util.List;
import java.util.Map;

public interface State {

    Map<Integer, Product> displayInventory(); // Map<SelfNumber,Product(price)>
    void selectItemAndInsertCoin(Product p,Map<Coin,Integer> amount); // Map<Coin,count>
    Map<Coin,Integer> dispenseChange(); // Map<Coin,count>
    Product dispenseItem();
    List<Coin> refund();
}
