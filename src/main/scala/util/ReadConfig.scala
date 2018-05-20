package util

import java.io.File

import com.typesafe.config.{Config, ConfigFactory}

trait ReadConfig extends LoggerSupport {
  var config: Config = null

  protected var configHome = "../conf/"

  /**
    * 设置配置文件,只写文件名即可
    *
    * 默认从configHome路径去读取文件,同时如果resources下有同名文件与会读取
    * 注意: 在前面的文件会覆盖后面文件的相同key的配置值
    *
    * @param files*/
  def setConfigFiles(files: String*) = {
    log.debug(s"config Home: $configHome")
    config = files.toList.map(load).reduce((a, b) => a.withFallback(b))
  }

  protected def load(file: String): Config = {
    val resourcesFIle = file
    val configFile = new File(makePath(file))
    if (configFile.exists()) {
      log.debug(s"loading file[${configFile.getPath}] and resourcesFIle [${resourcesFIle}]")
      ConfigFactory.parseFile(configFile).withFallback(ConfigFactory.load(resourcesFIle))
    } else {
      log.debug(s"loading resources[$resourcesFIle]")
      ConfigFactory.load(resourcesFIle)
    }

  }

  protected def makePath(fileName: String): String = {
    val newDir = configHome.trim.replaceAll("""\\""", "/")
    if (newDir.endsWith("/")) configHome + fileName
    else configHome + "/" + fileName
  }


}
