package util

/**
  * 通过继承LoggerSupport*/
object LoggerSupportTest extends LoggerSupport {
  def main(args: Array[String]): Unit = {
    log.debug("This is a log.debug")
    log.info("This is a logInfo")
    log.warn("This a logWarn")
    log.error("This a logError")
  }

}
