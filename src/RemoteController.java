public class RemoteController {
    private final Command onCommand;
    private final Command offCommand;

    public RemoteController(Command onCommand, Command offCommand) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
    }

    public void on() {
        onCommand.execute();
    }

    public void off() {
        offCommand.execute();
    }
}


