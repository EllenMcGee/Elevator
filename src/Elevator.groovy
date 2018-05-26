class Elevator {

    final Double TRAVEL_TIME_PER_FLOOR = 2.765
    final Double STOP_TIME_PER_FLOOR = 8
    boolean currentDirection
    Integer currentFloor
    def stop

    Elevator(int numOfStops, Boolean currentDirection, Integer currentFloor, def stop){
        this.stop = stop
        this.currentDirection = currentDirection
        this.currentFloor = currentFloor
        this.stop = stop
    }

}


