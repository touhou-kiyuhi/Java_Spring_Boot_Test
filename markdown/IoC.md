# IoC(Inversion of Control)

## IoC(Inversion of Control)：控制反轉
* 「將 object 的控制權(所謂的 Control (控制)，就是對於 object 的控制權)交給了外部的 Spring 容器來管理」
### DI(Dependency Injection)：依賴注入
* 例：Spring 容器把 HpPrinter 給「注入」到 Teacher 這個 class 裡面，因此才稱為是 「DI 依賴注入」
### IoC + DI：基本上只要有用到「IoC 控制反轉」的地方，一定就要搭配「DI 依賴注入」
* 因為 IoC 會讓我們把 object 的控制權給交出去，所以後續必定需要搭配 DI，才能夠又把這個 object 給注入回來讓我們使用
### Bean
* 「由 Spring 容器來管理的 object，我們賦予他們一個新的名字，就叫做 Bean」
* **@Componenet：創建一個 Bean 的方法，就是在 class 上面加上一行**
* Bean 的名字為 class name 的第一字母轉成小寫
* **@Autowired：注入 Bean 的方法**
    * 該 Class 也必須為 Bean
    * 根據變數類型尋找 Bean
* **@Qualifier：指定注入的 Bean 的名字**
    * 必須搭配 @Autowired 一起使用
    * 指定的是「Bean 的名字」
* **@PostConstruct：初始化 Bean 的方法**
    * 方法有特定格式
        1. 這個方法必須是 public
        2. 這個方法的返回值必須是 void
        3. 這個方法「不能」有參數
        4. 這個方法的名字可以隨意取，不影響 Spring Boot 運作
    * 一個 class 建議只有一個方法加上 @PostConstruct
    * 比較舊的寫法：「實作 InitializingBean interface」
* **Spring Boot 設定檔：applicaiton.properties**
    * 放在 src/main/resources 這個資料夾底下的 applicaiton.properties 檔案
    * properties 的語法格式：key=value
        * 不需要加上空白鍵排版
        * key 中的 . 表示「的」的概念
        * 使用 # 來表示 comment
    * **@Value：讀取 Spring Boot 設定檔（application.properties）中的值**
        1. 必須使用固定格式 `@Value("${XXXX}")`
        2. 該 class 必須是 Bean 或是 Configuration
        3. Java 中的變數和 application.properties 中的類型需要一致
        4. 可以設定預設值：`@Value("${XXXX:200}")`
---
## 參考資料
* [Spring Boot 零基礎入門 (5) - Spring IoC 簡介](https://ithelp.ithome.com.tw/articles/10322852)
* [Spring Boot 零基礎入門 (6) - IoC、DI、Bean 的介紹](https://ithelp.ithome.com.tw/articles/10323805)
* [Spring Boot 零基礎入門 (7) - Bean 的創建和注入 - @Component、@Autowired](https://ithelp.ithome.com.tw/articles/10324575)
* [Spring Boot 零基礎入門 (8) - 指定注入的 Bean - @Qualifier](https://ithelp.ithome.com.tw/articles/10325057)
* [Spring Boot 零基礎入門 (9) - Bean 的初始化 - @PostConstruct](https://ithelp.ithome.com.tw/articles/10325525)
* [Spring Boot 零基礎入門 (10) - 讀取 Spring Boot 設定檔 - @Value、application.properties](https://ithelp.ithome.com.tw/articles/10326370)