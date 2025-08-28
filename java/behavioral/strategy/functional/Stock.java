package behavioral.strategy.functional;

public class Stock {
    private String symbol;
    private double price;
    private double units;

    public Stock(String symbol, double price, double units) {
        this.symbol = symbol;
        this.price = price;
        this.units = units;
    }

    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public double getUnits() { return units; }

    @Override
    public String toString() {
        return "Stock{" + "symbol='" + symbol + "'" + ", price=" + price + ", units=" + units + '}';
    }
}
