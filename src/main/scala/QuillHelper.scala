import io.getquill.*
import io.getquill.ast.Infix
import zio.{Has, Task, ZIO}

import java.sql.{Connection, SQLException}
import scala.util.Try

object QuillHelper {

  val ctx = SimpleContext

  import ctx._

  inline def dummyQuote(dummy: DummyClass)  = quote {
    query[DummyClass].insert(lift(dummy))
  }

  inline def dummyQuoteSeq (dummy: Seq[DummyClass])  = quote {
    liftQuery(dummy).foreach {
      s => query[DummyClass].insert(s)
    }
  }

  def insertDummy(dummy: DummyClass) = {
    for {
      r <- ctx.run(dummyQuote(dummy))
    } yield r
  }

  def insertDummySeq(dummySeq: Seq[DummyClass]) = {
    for {
      r <- ctx.run(dummyQuoteSeq(dummySeq))
    } yield r
  }
}
