package structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Revers.
 * @date 2024/02/24 20:12
 **/
public class composite {
    // 抽象组件类
    abstract class Component {
        protected String name;

        public Component(String name) {
            this.name = name;
        }

        public abstract void add(Component component);
        public abstract void remove(Component component);
        public abstract void display();
    }

    // 叶子组件类
    class Leaf extends Component {
        public Leaf(String name) {
            super(name);
        }

        @Override
        public void add(Component component) {
            // 叶子组件不能添加子组件
        }

        @Override
        public void remove(Component component) {
            // 叶子组件不能移除子组件
        }

        @Override
        public void display() {
            System.out.println("Leaf: " + name);
        }
    }

    // 复合组件类
    class Composite extends Component {
        private List<Component> children = new ArrayList<>();

        public Composite(String name) {
            super(name);
        }

        @Override
        public void add(Component component) {
            children.add(component);
        }

        @Override
        public void remove(Component component) {
            children.remove(component);
        }

        @Override
        public void display() {
            System.out.println("Composite: " + name);
            for (Component child : children) {
                child.display();
            }
        }
    }

    // 客户端代码
    public static void main(String[] args) {
        // 创建复合组件
        Composite root = new composite().new Composite("Root");

        // 创建叶子组件
        Leaf leaf1 = new composite().new Leaf("Leaf1");
        Leaf leaf2 = new composite().new Leaf("Leaf2");

        // 将叶子组件添加到复合组件中
        root.add(leaf1);
        root.add(leaf2);

        // 创建另一个复合组件
        Composite branch1 = new composite().new Composite("Branch1");

        // 创建叶子组件
        Leaf leaf3 = new composite().new Leaf("Leaf3");
        Leaf leaf4 = new composite().new Leaf("Leaf4");

        // 将叶子组件添加到复合组件中
        branch1.add(leaf3);
        branch1.add(leaf4);

        // 将复合组件添加到根组件中
        root.add(branch1);

        // 显示树形结构
        root.display();

//        Composite: Root
//        Leaf: Leaf1
//        Leaf: Leaf2
//        Composite: Branch1
//        Leaf: Leaf3
//        Leaf: Leaf4
    }
}
