package codes.recursive;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class AutoCommand {
    private int speed;

    public AutoCommand(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
