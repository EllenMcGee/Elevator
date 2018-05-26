import User
import Elevator
import Calculations
import groovy.json.JsonOutput

//User user = new User(6,4)
int numOfStops = 2
Elevator elevator = new Elevator(numOfStops,false,4,[3,1])
//Calculations calculations = new Calculations(user, elevator)

@Grab( group = 'com.sparkjava', module = 'spark-core', version = '2.1' )
import static spark.Spark.*

staticFileLocation '.'

get '/hello', 'application/json', { req, res ->
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Request-Method", "*");
    res.header("Access-Control-Allow-Headers", "*");



    desiredFloor = req.queryParams("floorNum")
    println("${desiredFloor}")
    User user = new User(6, desiredFloor.toInteger())
    Calculations calculations = new Calculations(user, elevator)
    Double elevatorTime = calculations.getElevatorTime(numOfStops, desiredFloor.toInteger())
    def output = JsonOutput.toJson([time: elevatorTime])
    output
   // '{"hi": \${elevatorTime}}'
}

println 'Enter to exit'
System.in.newReader().readLine()
println "Done"
stop()
