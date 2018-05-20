package util

import org.apache.log4j.Logger

trait LoggerSupport {
  protected val log = Logger.getLogger(this.getClass)
}
