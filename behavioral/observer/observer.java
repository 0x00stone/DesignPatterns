package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Revers.
 * @date 2024/02/24 23:04
 **/
public class observer {
    public interface Subject {
        // 注册观察者
        void registerObserver(Observer observer);
        // 移除观察者
        void removeObserver(Observer observer);
        // 通知观察者
        void notifyObservers(String message);
    }

    public interface Observer {
        // 更新消息
        void update(String message);
    }

    public class ConcreteSubject implements Subject {
        private List<Observer> observers = new ArrayList<Observer>();

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers(String message) {
            for (Observer observer : observers) {
                observer.update(message);
            }
        }

    }

    public class ConcreteObserverOne implements Observer {
        @Override
        public void update(String message) {
            //TODO: 获取消息通知，执行自己的逻辑...
            System.out.println("ConcreteObserverOne is notified.");
        }
    }

    public class ConcreteObserverTwo implements Observer {
        @Override
        public void update(String message) {
            //TODO: 获取消息通知，执行自己的逻辑...
            System.out.println("ConcreteObserverTwo is notified.");
        }
    }

    public static void main(String[] args) {
        ConcreteSubject subject = new observer().new ConcreteSubject();
        subject.registerObserver(new observer().new ConcreteObserverOne());
        subject.registerObserver(new observer().new ConcreteObserverTwo());
        subject.notifyObservers("hello");
    }
}
