package behavioral.state;

public class VendingMachine {
    private State noCoinState;
    private State hasCoinState;
    private State soldState;
    private State soldOutState;

    private State currentState;
    private int count = 0;

    public VendingMachine(int numberOfItems) {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);

        this.count = numberOfItems;
        if (numberOfItems > 0) {
            currentState = noCoinState;
        } else {
            currentState = soldOutState;
        }
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void pressButton() {
        currentState.pressButton();
        if (currentState == hasCoinState) { // Check if state allows dispensing
            currentState.dispense();
        }
    }

    // Getters and Setters for states and count
    public State getNoCoinState() { return noCoinState; }
    public State getHasCoinState() { return hasCoinState; }
    public State getSoldState() { return soldState; }
    public State getSoldOutState() { return soldOutState; }
    public int getCount() { return count; }
    public void setState(State state) { this.currentState = state; }
    public void releaseItem() {
        System.out.println("An item comes rolling out the slot...");
        if (count > 0) {
            count--;
        }
    }
}
