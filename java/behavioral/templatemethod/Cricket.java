package behavioral.templatemethod;

public class Cricket extends Game {

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized!");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started.");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    // 重写钩子方法，提供自定义行为
    @Override
    void addNewCharacterToGame() {
        System.out.println("Adding a new batsman to the Cricket game.");
    }
}
