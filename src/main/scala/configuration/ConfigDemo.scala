/**
  * Created by salim on 10/02/2016.
  */

package configuration

import pureconfig._

import scala.util.{Failure, Success}


object ConfigDemo extends App {

  val config = loadConfig[Config] match {
    case Failure(f) => throw f
    case Success(conf) => conf
  }

  println("dirwatch.path: " + config.dirwatch.path)
  println("dirwatch.filter: " + config.dirwatch.filter)
  println("dirwatch.email.host: " + config.dirwatch.email.host)
  println("dirwatch.email.port: " + config.dirwatch.email.port)
  println("dirwatch.email.message: " + config.dirwatch.email.message)
  println("dirwatch.email.recipients: " + config.dirwatch.email.recipients)
  println("dirwatch.email.sender: " + config.dirwatch.email.sender)

  println("The loaded configuration is: " ++ config.toString)


}
