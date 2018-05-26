import User
import Elevator

class Calculations {

    User user
    Elevator elevator

    Calculations(User user, Elevator elevator){
        this.user = user
        this.elevator = elevator
    }

    Double getElevatorTime(Integer numOfStops, Integer desiredFloor) {
        Double distanceBeforePickup
        Double time

        if (numOfStops == 0) {
            distanceBeforePickup = (elevator.currentFloor - user.currentFloor).abs()
        } else {
            def highest = getFurthestFloor()
            distanceBeforePickup = 2 * (highest - elevator.currentFloor).abs() + (elevator.currentFloor - user.currentFloor).abs()
        }
        Double distanceAfterPickup = ((desiredFloor - user.currentFloor).abs())
        time = (distanceBeforePickup * elevator.TRAVEL_TIME_PER_FLOOR) + (numOfStops * elevator.STOP_TIME_PER_FLOOR) + (distanceAfterPickup * elevator.TRAVEL_TIME_PER_FLOOR) + (elevator.STOP_TIME_PER_FLOOR/2)
    }

    Double getStairTime(Integer desiredFloor){
        Double time = (user.currentFloor - desiredFloor).abs()*user.WALK_TIME_PER_FLOOR
        return time
    }

    String fastestRoute(Integer numOfStops, Integer desiredFloor ){
        Double elevatorTime = getElevatorTime(numOfStops,desiredFloor)
        Double stairTime = getStairTime(desiredFloor)
        if (elevatorTime>=stairTime){
            return "Stairs"
        }
        else {
            return "Elevator"
        }
    }

    Integer getFurthestFloor() {
        def a = elevator.stop[0]
        for (int i = 0; i < elevator.stop.size(); i++) {
            if (elevator.currentDirection == true && elevator.stop[i] > a)
                a = elevator.stop[i]
            else if (elevator.currentDirection == false && elevator.stop[i] < a)
                a = elevator.stop[i]
        }
        return a
    }
}
