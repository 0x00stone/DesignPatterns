package behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Revers.
 * @date 2024/02/24 22:35
 **/
public class memento {
    // 备忘录类
    class Memento {
        private String state;

        public Memento(String state){
            this.state = state;
        }

        public String getState(){
            return state;
        }
    }

    // 发起人类
    class Originator {
        private String state;

        public void setState(String state){
            this.state = state;
        }

        public String getState(){
            return state;
        }

        public Memento saveStateToMemento(){
            return new Memento(state);
        }

        public void getStateFromMemento(Memento memento){
            state = memento.getState();
        }
    }

    // 负责人类，负责保存备忘录对象
    class Caretaker {
        private List<Memento> mementoList = new ArrayList<Memento>();

        public void add(Memento state){
            mementoList.add(state);
        }

        public Memento get(int index){
            return mementoList.get(index);
        }
    }

    // 客户端类，演示备忘录模式的使用
    public static void main(String[] args) {
        Originator originator = new memento().new Originator();
        Caretaker caretaker = new memento().new Caretaker();

        originator.setState("State #1");
        originator.setState("State #2");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());

        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("First saved State: " + originator.getState());

        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("Second saved State: " + originator.getState());

        //Current State: State #4
        //First saved State: State #2
        //Second saved State: State #3
    }
}
