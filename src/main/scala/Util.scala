import cats.effect.IO
import cats.implicits._

object Util {

  implicit class RichIO[A](io: IO[A]) {

    def logErrorAndThrow(): IO[A] =
      io.handleErrorWith { error =>
        IO(println(s"Error: ${error.getMessage}")) >> IO
          .raiseError(error)
      }
  }

}
