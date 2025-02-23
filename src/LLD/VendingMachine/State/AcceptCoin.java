package LLD.VendingMachine.State;

import LLD.VendingMachine.VendingMachine;
import LLD.VendingMachine.dto.Coin;
import LLD.VendingMachine.dto.Product;

import java.util.List;
import java.util.Map;

public class AcceptCoin implements State {

    VendingMachine vendingMachine;

    public Map<Integer, Product> displayInventory() {
        return null;
    }

    public void selectItemAndInsertCoin(Product p, Map<Coin, Integer> amount) {
        // TODO :: Implementation
    }

    public Map<Coin, Integer> dispenseChange() {
        return null;
    }

    public Product dispenseItem() {
        return null;
    }

    public List<Coin> refund() {
        return null;
    }
}
