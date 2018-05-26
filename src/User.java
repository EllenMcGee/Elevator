import java.math.BigDecimal;

public class User {
    public User(Integer current, Integer desired) {
        this.currentFloor = current;
        this.desiredFloor = desired;

        if (currentFloor < desiredFloor) {
            desiredDirection = true;//up
        } else {
            desiredDirection = false;//down
        }

    }

   
    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Integer getDesiredFloor() {
        return desiredFloor;
    }

    public void setDesiredFloor(Integer desiredFloor) {
        this.desiredFloor = desiredFloor;
    }

    public Boolean getDesiredDirection() {
        return desiredDirection;
    }

    public void setDesiredDirection(Boolean desiredDirection) {
        this.desiredDirection = desiredDirection;
    }

    private final Double WALK_TIME_PER_FLOOR = 3.137;
    private Integer currentFloor;
    private Integer desiredFloor;
    private Boolean desiredDirection;
}
