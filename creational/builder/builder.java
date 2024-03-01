package creational.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Revers.
 * @date 2024/02/24 19:51
 **/
public class builder {
    public class Computer {
        private String HDD;
        private String RAM;

        // 可选参数
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public String getHDD() {
            return HDD;
        }

        public String getRAM() {
            return RAM;
        }

        public boolean isGraphicsCardEnabled() {
            return isGraphicsCardEnabled;
        }

        public boolean isBluetoothEnabled() {
            return isBluetoothEnabled;
        }

        private Computer(ComputerBuilder builder) {
            this.HDD = builder.HDD;
            this.RAM = builder.RAM;
            this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
            this.isBluetoothEnabled = builder.isBluetoothEnabled;
        }

        //Builder Class
        public static class ComputerBuilder {

            // 必要参数
            private String HDD;
            private String RAM;

            // 可选参数
            private boolean isGraphicsCardEnabled;
            private boolean isBluetoothEnabled;

            public ComputerBuilder(){}

            public ComputerBuilder setHdd(String hdd) {
                this.HDD = hdd;
                return this;
            }

            public ComputerBuilder setRAM(String ram) {
                this.RAM = ram;
                return this;
            }

            public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
                this.isGraphicsCardEnabled = isGraphicsCardEnabled;
                return this;
            }

            public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
                this.isBluetoothEnabled = isBluetoothEnabled;
                return this;
            }

            public Computer build(){
                return new builder().new Computer(this);
            }

        }
    }


    // 客户端代码
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder()
                .setHdd("500GB")
                .setRAM("16GB")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true)
                .build();

        System.out.println("HDD: " + computer.getHDD());
        System.out.println("RAM: " + computer.getRAM());
        System.out.println("Graphics Card: " + computer.isGraphicsCardEnabled());
        System.out.println("Bluetooth: " + computer.isBluetoothEnabled());


//      HDD: 500 GB
//      RAM: 16 GB
//      Graphics Card: true
//      Bluetooth: true
    }

}
