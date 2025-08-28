/**
 * 备忘录模式 (Memento)
 *
 * 目的:
 * 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。
 * 这样以后就可将该对象恢复到原先保存的状态。
 *
 * 使用场景:
 * 1. 当你需要为一个对象提供撤销（undo）操作时。
 * 2. 当你需要保存对象在不同时间点的状态快照时。
 */

// --- 备忘录 (Memento) ---
class Memento {
    constructor(state) {
        this.state = state;
    }

    getState() {
        return this.state;
    }
}

// --- 发起人 (Originator) ---
class Originator {
    constructor() {
        this.state = "";
    }

    setState(state) {
        console.log(`Originator: Setting state to -> ${state}`);
        this.state = state;
    }

    saveStateToMemento() {
        console.log("Originator: Saving state to Memento.");
        return new Memento(this.state);
    }

    getStateFromMemento(memento) {
        this.state = memento.getState();
        console.log(`Originator: State restored from Memento -> ${this.state}`);
    }
}

// --- 负责人 (Caretaker) ---
class Caretaker {
    constructor() {
        this.mementoList = [];
    }

    add(memento) {
        this.mementoList.push(memento);
        console.log("Caretaker: Memento saved.");
    }

    get(index) {
        return this.mementoList[index];
    }
}

// --- 客户端 ---
function client() {
    const originator = new Originator();
    const caretaker = new Caretaker();

    originator.setState("State #1");
    caretaker.add(originator.saveStateToMemento());
    originator.setState("State #2");
    caretaker.add(originator.saveStateToMemento());

    console.log(`
Current State is: ${originator.state}`);
    originator.getStateFromMemento(caretaker.get(0));
    console.log(`State after restore: ${originator.state}`);
}

client();
