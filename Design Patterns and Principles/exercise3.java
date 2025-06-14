class Computer {
    private String CPU;
    private String RAM;
    private String storage;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }

    static class Builder {
        private String CPU;
        private String RAM;
        private String storage;

        Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        Computer build() {
            return new Computer(this);
        }
    }
}

class BuilderTest {
    public static void main(String[] args) {
        Computer comp = new Computer.Builder()
            .setCPU("i7")
            .setRAM("16GB")
            .setStorage("512GB SSD")
            .build();
    }
}