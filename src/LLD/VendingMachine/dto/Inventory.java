package LLD.VendingMachine.dto;

import LLD.VendingMachine.MachineException;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Inventory {
    Map<Product, Integer> productCountMap;
    Map<Integer, Product> selfProductMap;
    Stack<Integer> avilableSelf;

    public void addProduct(Product p) throws MachineException {
        int selfNumber = 0;
        if(productCountMap.containsKey(p))
            productCountMap.put(p, productCountMap.getOrDefault(p, 0) + 1);
        else{
            if(!avilableSelf.isEmpty())
                selfNumber = avilableSelf.pop();
            else
                throw new MachineException("No Self to add new product");

            selfProductMap.put(selfNumber, p);
            productCountMap.put(p, 1);
        }
    }

    public void loadProduct(List<Product> products) {

    }
}
