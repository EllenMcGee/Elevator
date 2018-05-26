class Elevator {

    final Double TRAVEL_TIME_PER_FLOOR = 2.765
    final Double STOP_TIME_PER_FLOOR = 12
    boolean currentDirection
    Integer currentFloor
    def stop

    Elevator(int numOfStops){
        stop = new Integer[numOfStops]
    }


}


