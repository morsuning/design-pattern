package behavioral.memento;

import java.util.Stack;

public class History {
    private Stack<TextEditor.EditorState> history = new Stack<>();

    public void save(TextEditor editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            editor.restore(history.pop());
        } else {
            System.out.println("Cannot undo: History is empty.");
        }
    }
}
