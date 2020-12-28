package log

import org.slf4j.{Logger, LoggerFactory, Marker}

trait Logging {
  def log = new TrailerLogger(this.getClass)
}


class TrailerLogger(clazz: Class[_]) extends Logger{

  var log = LoggerFactory.getLogger(clazz)

  override def getName = ""

  override def isWarnEnabled = true

  override def isWarnEnabled(marker: Marker) = ???

  override def error(s: String) = {
    log.error(s, null)
  }

  override def error(s: String, o: scala.Any) = {
    log.error(s, o)
  }

  override def error(s: String, o: scala.Any, o1: scala.Any) = {
    log.error(s, o, o1)
  }

  override def error(s: String, objects: AnyRef*) = {
    log.error(s, objects)
  }

  override def error(s: String, throwable: Throwable) = {
    log.error(s, throwable)
  }

  override def error(marker: Marker, s: String) = {
    log.error(marker, s)
  }

  override def error(marker: Marker, s: String, o: scala.Any) = {
    log.error(marker, s, o)
  }

  override def error(marker: Marker, s: String, o: scala.Any, o1: scala.Any) = {
    log.error(marker, s, o, o1)
  }

  override def error(marker: Marker, s: String, objects: AnyRef*) = {
    log.error(marker, s, objects)
  }

  override def error(marker: Marker, s: String, throwable: Throwable) = {
    log.error(marker, s, throwable)
  }

  override def trace(s: String) = {
    log.trace(s)
  }

  override def trace(s: String, o: scala.Any) = {
    log.trace(s, o)
  }

  override def trace(s: String, o: scala.Any, o1: scala.Any) = {
    log.trace(s, o, o1)
  }

  override def trace(s: String, objects: AnyRef*) = {
    log.trace(s, objects)
  }

  override def trace(s: String, throwable: Throwable) = {
    log.trace(s, throwable)
  }

  override def trace(marker: Marker, s: String) = {
    log.trace(marker, s)
  }

  override def trace(marker: Marker, s: String, o: scala.Any) = {
    log.trace(marker, s, o)
  }

  override def trace(marker: Marker, s: String, o: scala.Any, o1: scala.Any) = {
    log.trace(marker, s, o, o1)
  }

  override def trace(marker: Marker, s: String, objects: AnyRef*) = {
    log.trace(marker, s, objects)
  }

  override def trace(marker: Marker, s: String, throwable: Throwable) = {
    log.trace(marker, s, throwable)
  }

  override def isInfoEnabled = true

  override def isInfoEnabled(marker: Marker) = ???

  override def isErrorEnabled = true

  override def isErrorEnabled(marker: Marker) = ???

  override def isTraceEnabled = true

  override def isTraceEnabled(marker: Marker) = ???

  override def info(s: String) = {
    log.info(s)
  }

  override def info(s: String, o: scala.Any) = {
    log.info(s, o)
  }

  override def info(s: String, o: scala.Any, o1: scala.Any) = {
    log.info(s, o, o1)
  }

  override def info(s: String, objects: AnyRef*) = {
    log.info(s, objects)
  }

  override def info(s: String, throwable: Throwable) = {
    log.info(s, throwable)
  }

  override def info(marker: Marker, s: String) = {
    log.info(marker, s)
  }

  override def info(marker: Marker, s: String, o: scala.Any) = {
    log.info(marker, s, o)
  }

  override def info(marker: Marker, s: String, o: scala.Any, o1: scala.Any) = {
    log.info(marker, s, o, o1)
  }

  override def info(marker: Marker, s: String, objects: AnyRef*) = {
    log.info(marker, s, objects)
  }

  override def info(marker: Marker, s: String, throwable: Throwable) = {
    log.info(marker, s, throwable)
  }

  override def debug(s: String) = {
    log.debug(s)
  }

  override def debug(s: String, o: scala.Any) = {
    log.debug(s, o)
  }

  override def debug(s: String, o: scala.Any, o1: scala.Any) = {
    log.debug(s, o, o1)
  }

  override def debug(s: String, objects: AnyRef*) = {
    log.debug(s, objects)
  }

  override def debug(s: String, throwable: Throwable) = {
    log.debug(s, throwable)
  }

  override def debug(marker: Marker, s: String) = {
    log.debug(marker, s)
  }

  override def debug(marker: Marker, s: String, o: scala.Any) = {
    log.debug(marker, s, o)
  }

  override def debug(marker: Marker, s: String, o: scala.Any, o1: scala.Any) = {
    log.debug(marker, s, o, o1)
  }

  override def debug(marker: Marker, s: String, objects: AnyRef*) = {
    log.debug(marker, s, objects)
  }

  override def debug(marker: Marker, s: String, throwable: Throwable) = {
    log.debug(marker, s, throwable)
  }

  override def warn(s: String) = {
    log.warn(s)
  }

  override def warn(s: String, o: scala.Any) = {
    log.warn(s, o)
  }

  override def warn(s: String, objects: AnyRef*) = {
    log.warn(s, objects)
  }

  override def warn(s: String, o: scala.Any, o1: scala.Any) = {
    log.warn(s, o, o1)
  }

  override def warn(s: String, throwable: Throwable) = {
    log.warn(s, throwable)
  }

  override def warn(marker: Marker, s: String) = {
    log.warn(marker, s)
  }

  override def warn(marker: Marker, s: String, o: scala.Any) = {
    log.warn(marker, s, o)
  }

  override def warn(marker: Marker, s: String, o: scala.Any, o1: scala.Any) = {
    log.warn(marker, s, o, o1)
  }

  override def warn(marker: Marker, s: String, objects: AnyRef*) = {
    log.warn(marker, s, objects)
  }

  override def warn(marker: Marker, s: String, throwable: Throwable) = {
    log.warn(marker, s, throwable)
  }

  override def isDebugEnabled = true

  override def isDebugEnabled(marker: Marker) = ???
}

