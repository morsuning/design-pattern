package behavioral.templatemethod;

/**
 * 具体类 (ConcreteClass) - Football
 */
public class Football extends Game {

    @Override
    void initialize() {
        System.out.println("Football Game Initialized: Teams are on the field.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started: The whistle has blown.");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished: Final whistle.");
    }
}