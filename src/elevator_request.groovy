import User
import Elevator
import Calculations
import groovy.json.JsonOutput



Integer numOfStops = 1
Elevator elevator = new Elevator(numOfStops,false,3,[2])

@Grab( group = 'com.sparkjava', module = 'spark-core', version = '2.1' )
import static spark.Spark.*

staticFileLocation '.'

get '/hello', 'application/json', { req, res ->
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Request-Method", "*");
    res.header("Access-Control-Allow-Headers", "*");



    desiredFloor = req.queryParams("floorNum")
    println("${desiredFloor}")
    User user = new User(1, desiredFloor.toInteger())
    Calculations calculations = new Calculations(user, elevator)
    Double elevatorTime = calculations.getElevatorTime(numOfStops, desiredFloor.toInteger())
    Double stairTime = calculations.getStairTime(desiredFloor.toInteger())
    String fastestRoute = calculations.fastestRoute(numOfStops, desiredFloor.toInteger())
    def output = "Stair time: ${stairTime.round()}sec  |   Elevator Time: ${elevatorTime.round()}sec"//JsonOutput.toJson([eleTime: elevatorTime, stairTime: stairTime, fastestRoute: fastestRoute ])
    output
   // '{"hi": \${elevatorTime}}'
}

println 'Enter to exit'
System.in.newReader().readLine()
println "Done"
stop()
