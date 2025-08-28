package behavioral.command;

public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("No command is assigned.");
    }

    @Override
    public void undo() {
        System.out.println("Nothing to undo.");
    }
}
