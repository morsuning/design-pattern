package behavioral.templatemethod;

public abstract class Game {

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    /**
     * 这是一个“钩子”(Hook)方法。
     * 它在抽象类中有一个默认的（通常是空的）实现。
     * 子类可以根据需要选择性地重写它，从而“钩入”算法的特定步骤。
     * 这为子类提供了更大的灵活性。
     */
    void addNewCharacterToGame() {
        // 默认实现为空
    }

    // 模板方法
    public final void play() {
        initialize();
        startPlay();
        // 调用钩子方法
        addNewCharacterToGame();
        endPlay();
    }
}
