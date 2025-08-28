package behavioral.chain;

public class EmailLogger extends Logger {
    public EmailLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Email Logger: " + message);
    }
}
