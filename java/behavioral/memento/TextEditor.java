package behavioral.memento;

public class TextEditor {
    private String text;

    public TextEditor() {
        this.text = "";
    }

    public void write(String newText) {
        this.text += newText;
        System.out.println("Editor content: " + this.text);
    }

    public EditorState save() {
        System.out.println("Saving state...");
        return new EditorState(this.text);
    }

    public void restore(EditorState state) {
        this.text = state.getText();
        System.out.println("State restored. Editor content: " + this.text);
    }

    // Memento: 私有静态内部类，实现了最佳封装
    public static class EditorState {
        private final String text;

        private EditorState(String text) {
            this.text = text;
        }

        private String getText() {
            return text;
        }
    }
}
