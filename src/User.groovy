class User {

    final Double WALK_TIME_PER_FLOOR = 10
    Integer currentFloor
    Integer desiredFloor
    Boolean desiredDirection

    User(Integer current, Integer desired){
        this.currentFloor = current
        this. desiredFloor = desired

        if (currentFloor < desiredFloor) {
            desiredDirection = true //up
        } else {
            desiredDirection = false //down
        }
    }

}


