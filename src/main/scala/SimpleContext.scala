import io.getquill.{NamingStrategy, SnakeCase, SqliteZioJdbcContext, UpperCase}

object SimpleContext extends SqliteZioJdbcContext(NamingStrategy(SnakeCase, UpperCase))
