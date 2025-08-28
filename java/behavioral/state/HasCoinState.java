package behavioral.state;

public class HasCoinState implements State {
    VendingMachine machine;
    public HasCoinState(VendingMachine machine) { this.machine = machine; }
    public void insertCoin() { System.out.println("You can't insert another coin."); }
    public void pressButton() {
        System.out.println("You pressed the button...");
        machine.setState(machine.getSoldState());
    }
    public void dispense() { System.out.println("No item dispensed."); }
}
