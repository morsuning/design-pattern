package behavioral.state;

public class SoldOutState implements State {
    VendingMachine machine;
    public SoldOutState(VendingMachine machine) { this.machine = machine; }
    public void insertCoin() { System.out.println("You can't insert a coin, the machine is sold out."); }
    public void pressButton() { System.out.println("You pressed, but there are no items."); }
    public void dispense() { System.out.println("No items dispensed."); }
}
