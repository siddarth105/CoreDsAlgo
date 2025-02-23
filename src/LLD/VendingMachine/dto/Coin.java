package LLD.VendingMachine.dto;

public enum Coin {
    ONE(1), TWO(2), FIVE(5), TEN(10), HUNDRED(100);
    private int value;
    Coin(int value) {
        this.value = value;
    }
}
