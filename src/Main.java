public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();

        RemoteControl lightControl = new RemoteControl(light::turnOn, light::turnOff);
        RemoteControl fanControl = new RemoteControl(fan::startRotate, fan::stopRotate);

        System.out.println("Using Light Remote:");
        lightControl.on();
        lightControl.off();

        System.out.println("Using Fan Remote:");
        fanControl.on();
        fanControl.off();
    }
}