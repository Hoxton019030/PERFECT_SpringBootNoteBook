# PERFECT_SpringBootNoteBook

這是SpringBoot的筆記程式

https://drive.google.com/drive/folders/1Ew-YkK0FVaJfmkTd3j_Y4jpAcl3_crqv

<h1>Spring官網設置<h1>
# Spring官網設置

### 網址：<a href="https://start.spring.io/" target="_blank" >啟動器</a>
  
![image](https://user-images.githubusercontent.com/98711945/165891446-10cf39ca-f9ad-4b23-98c2-20d7474b423d.png)

  # 在application.properties裡可撰寫的設定
    

`
#埠號
server.port=8080
#Context Path
server.servlet.context-path=/myapp
#過濾器是否打開
spring.mvc.hiddenmethod.filter.enabled=true

#設定JSPjsp
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp

#連線池的設定
# Connntection Setting

spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=SpringBootDB
spring.datasource.username=你的SQL Server使用者名稱
spring.datasource.password=你的SQL Server密碼

# Jpa Settings
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServer2016Dialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl


<<<<<<< HEAD
<h1>SpringMVC常用註釋<h1>

<ul>
  <li>@Controller</li>
=======
`


# SpringMVC常用註釋
  

+ @Controller
  
>>>>>>> 06a21e29d335f5a845ddf179576b8e6edbf9933c
  控制器，編寫在類別上，表示是SpringMVC的Controller，負責處理由DispatcherServlet接收並分發過來的請求，通常寫在Controller的class上面
  
  ![image](https://user-images.githubusercontent.com/98711945/165895379-a0f9bcd0-8247-4fa3-a6fe-7212ed184a04.png)
  
<<<<<<< HEAD
  <li>@RequestMapping</li>
=======
+ @RequestMapping
  
>>>>>>> 06a21e29d335f5a845ddf179576b8e6edbf9933c
  寫在Controller內的方法上，真正處理請求位址對應的註釋，若編寫在類別上，則代表該類別的所有回應請求的方法都已該位址為父位址，通常不會使用這個Annotaion，而是會使用更為精準的
  
   +  @GetMapping: 處理Get請求
    
    
     ![image](https://user-images.githubusercontent.com/98711945/165896081-c1cf1e55-4c4e-4af3-ad30-5a4666ef121c.png)

    
    +  @PostMapping: 處理post請求
    
        ![image](https://user-images.githubusercontent.com/98711945/165896116-cb4e09db-89d8-48fd-b3fe-960bee6b9166.png)
    

  
  
+ @RestController

  ![image](https://user-images.githubusercontent.com/98711945/166092473-2f404812-eeb6-4fbe-96c4-a7a141626c3a.png)

  用來標記Restful風格的控制器類型，等同於在@Controller加上@ResponseBody，會直接回傳一個字串，通常用於回應Json格式的字串


# Spring Boot常用取得參數的方式
+ @PathVariable

  將請求URL中的變數對應到功能處理方法的參數上，講白話文就是，取得URL中的變數作為程式的參數
 
  
  + 取得路徑中的值
    http://localhost:8080/getProduct/{id}
  ```Java
  
  @GetMapping("/getProdict/{id}")
  public String getProduct1(@PathVariable int productId){
  //...find product code
   return "some-page"
  ```
  
  + 取得路徑中的參數
     http://localhost:8080/getProduct/?productId=5
  ```Java
  
  @GetMapping("/getProdict")
  public String getProduct1(int productId){
  //...find product code
   return "some-page";
  ```
  

+ ModelAttribute
  用於從From表單或是Model(通常會是一個JavaBean)中取得屬性值，
  
  ```Java
  @PostMapping("/postProduct")
  public String sendProduct(@ModelAttribute ProductModel product){
  // ...some code
  return "some-page";
  ```
  
+ HttpServletRequest
  用HttpServletRequest接收參數
  
  ```Java
  @PostMapping("/login")
  public String checkLogin(HttpServletRequest request){
  String username = request.getParameter("username");
  String password = request.getParameter("password");
  //...
 
  ```
# Spring Boot常用導入參數的方式

  + @RequestParam
    當請求參數不存在時，又不想報錯，可以使用required=false來指定該參數不是必須的

  ```Java
  @GetMapping("/getMapping")
  public String getProduct2(@RequestParam(value="id",required=false)int id){
  // ... some code
  return "some-page";
  ```
  
  + @RequestBody 用來接收JSON格式的資料
  
  
  
