import java.nio.file.{Path, Paths}

import pureconfig.StringConvert

import scala.util.Try

package object configuration {

  case class Config(dirwatch: DirWatchConfig)
  case class DirWatchConfig(path: Path, filter: String, email: EmailConfig)
  case class EmailConfig(host: String, port: Int, message: String, recipients: Set[String], sender: String)


  // path doesn't have a StringConvert instance, we are going to create it here
  implicit val deriveStringConvertForPath = new StringConvert[Path] {
    override def from(str: String): Try[Path] = Try(Paths.get(str))
    override def to(path: Path): String = path.toString
  }
}