interface Command {
    void execute();
}

class Light {
    void on() {
        System.out.println("Light ON");
    }
    void off() {
        System.out.println("Light OFF");
    }
}

class LightOnCommand implements Command {
    private Light light;
    LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.on();
    }
}

class RemoteControl {
    private Command command;
    void setCommand(Command command) {
        this.command = command;
    }
    void pressButton() {
        command.execute();
    }
}

class CommandTest {
    public static void main(String[] args) {
        Light light = new Light();
        Command command = new LightOnCommand(light);
        RemoteControl remote = new RemoteControl();
        remote.setCommand(command);
        remote.pressButton();
    }
}