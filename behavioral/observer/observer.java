package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Revers.
 * @date 2024/02/24 23:04
 **/
public class observer {
    // 观察者接口
    interface Observer {
        void update(String message);
    }

    // 具体的观察者
    class ConcreteObserver implements Observer {
        private String observerName;

        public ConcreteObserver(String observerName) {
            this.observerName = observerName;
        }

        @Override
        public void update(String message) {
            System.out.println(observerName + " received message: " + message);
        }
    }

    // 被观察的主题接口
    interface Subject {
        void attach(Observer o);
        void detach(Observer o);
        void notifyUpdate(String message);
    }

    // 具体的主题
    class ConcreteSubject implements Subject {
        private List<Observer> observers = new ArrayList<>();

        @Override
        public void attach(Observer o) {
            observers.add(o);
        }

        @Override
        public void detach(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyUpdate(String message) {
            for (Observer observer : observers) {
                observer.update(message);
            }
        }
    }

    // 演示
    public static void main(String[] args) {
        ConcreteSubject subject = new observer().new ConcreteSubject();

        Observer observer1 = new observer().new ConcreteObserver("Observer 1");
        Observer observer2 = new observer().new ConcreteObserver("Observer 2");
        Observer observer3 = new observer().new ConcreteObserver("Observer 3");

        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);

        subject.notifyUpdate("The Subject has sent a message!");

        //Observer 1 received message: The Subject has sent a message!
        //Observer 2 received message: The Subject has sent a message!
        //Observer 3 received message: The Subject has sent a message!
    }

}
