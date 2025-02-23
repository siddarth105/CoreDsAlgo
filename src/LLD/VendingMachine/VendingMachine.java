package LLD.VendingMachine;

import LLD.VendingMachine.State.AcceptCoin;
import LLD.VendingMachine.State.Ready;
import LLD.VendingMachine.State.State;
import LLD.VendingMachine.dto.Coin;
import LLD.VendingMachine.dto.Inventory;
import LLD.VendingMachine.dto.Product;
import java.util.*;

public class VendingMachine {

    Ready ready = new Ready();
    AcceptCoin acceptCoin = new AcceptCoin();

    State machineState = null;
    Map<Coin,Integer> amountInDenomination = new HashMap<>();
    Inventory inventory = new Inventory();

    public VendingMachine(){
        machineState = ready;

        List<Product> products = new ArrayList<>();
        inventory.loadProduct(products);
        // loadAmount -> initialise amountInDenomination with values
    }

    public void insertCoin(Product p,Map<Coin,Integer> amount){
        machineState.selectItemAndInsertCoin(p, amount);
    }

    public void setMachineState(State machineState) {
        this.machineState = machineState;
    }

    public Ready getReady() {
        return ready;
    }

    public AcceptCoin getAcceptCoin() {
        return acceptCoin;
    }
}
