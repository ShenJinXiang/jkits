# JKits

java 工具集合

## 目录结构
```
src
  |-- main
  |  |-- java
  |  |   |-- com
  |  |       |-- shenjinxiang
  |  |           |-- core
  |  |           |   |-- Consts                                常量管理
  |  |           |-- kit
  |  |           |   |-- Base64Kit.java                        Base64工具
  |  |           |   |-- Config.java                           读取到配置文件resources/config.properties的配置
  |  |           |   |-- DateKit.java                          日期工具
  |  |           |   |-- DESUtil.java                          DES加解密工具
  |  |           |   |-- GzipKit.java                          GZIP压缩、解压缩工具
  |  |           |   |-- JedisFactory.java                     redis链接工具
  |  |           |   |-- JsoupKit.java                         Jsoup工具，用于爬取数据
  |  |           |   |-- MongodbManager.java                   mongodb数据库链接工具
  |  |           |   |-- StrKit.java                           字符串处理工具
  |  |           |   |-- ThreadPool.java                       线程池
  |  |           |   |-- ZipKit.java                           ZIP压缩、解压缩工具
  |  |           |
  |  |           |-- Start
  |  |-- resources
  |      |-- config.properties                                 主配置文件
  |
  |-- test
  |  |-- java
         |-- com
             |-- shenjinxiang
                 |-- kit
                     |-- ConfigTest.java                       Config 测试
                     |-- GzipKitTest.java                      GZIP工具 测试
                     |-- JsoupKit.java                         Jsoup 测试
                     |-- StrKitTest.java                       字符串处理工具测试
                     |-- ZipKit.java                           ZIP工具 测试
```