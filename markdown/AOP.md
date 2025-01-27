# AOP(Aspect-Oriented Programming)

## AOP(Aspect-Oriented Programming)：切面導向程式設計
* 「透過切面，統一的去處理方法之間的共同邏輯」
* 在 pom.xml 載入 Spring AOP
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-aop</artifactId>
    </dependency>
    ```
### @Aspect：製造切面的方法
* **@Before：在切入點方法「執行前」執行切面**
    1. 步驟一：我們指定了「切入點為 HpPrinter 中的所有方法」
    2. 步驟二：在切入點的方法「執行之前」
    3. 步驟三：執行下面的 before() 方法
* **其他用法：@After、@Around**
    ```java
    @Aspect
    @Component
    public class MyAspect {

        @Before("execution(* com.example.demo.Spring_IoC.HpPrinter.*(..))")
        public void before() {
            System.out.println("I'm before");
        }

        @After("execution(* com.example.demo.Spring_IoC.HpPrinter.*(..))")
        public void after() {
            System.out.println("I'm after");
        }

        @Around("execution(* com.example.demo.Spring_IoC.HpPrinter.*(..))")
        public Object around(ProceedingJoinPoint pjp) throws Throwable {
            System.out.println("I'm around before");

            // 執行切入點的方法，obj 為切入點方法執行的結果
            Object object = pjp.proceed();

            System.out.println("I'm around after");

            return object;
        }
    }
    ```
* 在 Spring AOP 裡面，有三種時機點可以選擇
    1. **@Before：在方法「執行前」執行切面**
    2. **@After：在方法「執行後」執行切面**
    3. **@Around：在方法「執行前」和「執行後」，執行切面**
* 切入點 (Pointcut) 撰寫：常見的寫法邏輯
    1. 切入點為 com.example.demo.HpPrinter 底下的 print() 方法
        ```Java
        execution(* com.example.demo.HpPrinter.print())
        ```
    2. 切入點為 com.example.demo.HpPrinter 底下的所有方法
        ```java
        execution(* com.example.demo.HpPrinter.*(..))
        ```
    3. 切入點為 com.example.demo 這個 package 中的所有 class 的所有方法（不包含子 package）
        ```java
        execution(* com.example.demo.*(..))
        ```
    4. 切入點為 com.example.demo 這個 package 及其底下所有子 package 中的所有 class 的所有方法
        ```java
        execution(* com.example.demo..*(..))
        ```
    5. 切入點為那些帶有 @MyAnnotation 的方法
        ```java
        @annotation(com.example.demo.MyAnnotation)
        ```
* Spring AOP 以前最常被用在以下三個地方
        1. 權限驗證
        2. 統一的 Exception 處理
        3. log 記錄
---
## 參考資料
* [Spring Boot 零基礎入門 (11) - Spring AOP 簡介](https://ithelp.ithome.com.tw/articles/10327252)
* [Spring Boot 零基礎入門 (12) - Spring AOP 的用法 - @Aspect](https://ithelp.ithome.com.tw/articles/10329009)
