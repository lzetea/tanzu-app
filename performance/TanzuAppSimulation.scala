package com.tanzu.perf

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class TanzuAppSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080")
    //.baseUrl("http://10.213.73.10/")

  // A scenario is a chain of requests and pauses
  val scn = scenario("Main scenario")
    .exec(
      http("vote")
        .get("/")
        .check(status.is(200))
    )
    .exec(
      http("list-all")
        .get("/api/helloes")
        .check(status.is(200))
    )

  // https://gatling.io/docs/current/general/simulation_setup/  
  setUp(scn.inject(rampUsers(120).during(60.seconds)).protocols(httpProtocol))

}
