package behavioral.command;

import java.util.Stack;

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Stack<Command> undoStack = new Stack<>();

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoStack.push(onCommands[slot]);
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoStack.push(offCommands[slot]);
    }

    public void undoButtonWasPushed() {
        if (!undoStack.isEmpty()) {
            undoStack.pop().undo();
        } else {
            System.out.println("Undo stack is empty.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n------ Remote Control ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot ").append(i).append("] ")
              .append(onCommands[i].getClass().getSimpleName())
              .append("\t")
              .append(offCommands[i].getClass().getSimpleName())
              .append("\n");
        }
        sb.append("[undo] ").append(undoStack.isEmpty() ? "Empty" : undoStack.peek().getClass().getSimpleName()).append("\n");
        return sb.toString();
    }
}
