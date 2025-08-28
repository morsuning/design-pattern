package behavioral.state;

public class NoCoinState implements State {
    VendingMachine machine;
    public NoCoinState(VendingMachine machine) { this.machine = machine; }
    public void insertCoin() {
        System.out.println("You inserted a coin.");
        machine.setState(machine.getHasCoinState());
    }
    public void pressButton() { System.out.println("You pressed the button, but there's no coin."); }
    public void dispense() { System.out.println("You need to pay first."); }
}
