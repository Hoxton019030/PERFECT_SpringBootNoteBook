# PERFECT_SpringBootNoteBook

這是SpringBoot的筆記程式

https://drive.google.com/drive/folders/1Ew-YkK0FVaJfmkTd3j_Y4jpAcl3_crqv

# Spring官網設置

### 網址：<a href="https://start.spring.io/" target="_blank" >啟動器</a>
  
![image](https://user-images.githubusercontent.com/98711945/165891446-10cf39ca-f9ad-4b23-98c2-20d7474b423d.png)

  # 在application.properties裡可撰寫的設定
    

```
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

```


# SpringMVC常用註釋
  

+ @Controller
  
  控制器，編寫在類別上，表示是SpringMVC的Controller，負責處理由DispatcherServlet接收並分發過來的請求，通常寫在Controller的class上面
  


  ```Java
  @Controller
    public class PageController{
    @GetMapping("/")
    public String index(){
      return "index";
    }
    @GetMapping("/about")
    public String gotoAbout(){
      return "about";
    }
  }
  ```
  
+ @RequestMapping
  
  寫在Controller內的方法上，真正處理請求位址對應的註釋，若編寫在類別上，則代表該類別的所有回應請求的方法都已該位址為父位址，通常不會使用這個Annotaion，而是會使用更為精準的
  
   +  @GetMapping: 處理Get請求
    
    
   
  ```Java
  public Customer getCustomerById(@RequestParam("id") Integer id){
    Optional<Customer> optional = dao.findById(id);
    if(optional.isPresent()){
      Customer resCUS=optional.get();
      return resCus;
    }
    return null;
  }
  ```

    
    +  @PostMapping: 處理post請求
    
   
    ```JAVA
    @PostMapping("customer/insert3")
    public List<Customer> insertCustomer3(@RequestBody List<Customer> cus){
      //@RequestBody:傳到Controller內的
      //@ResponseBody:傳到Contoller外的
      List<Customer> resCus= dao.saveAll(cus);
      return resCus;

    }
    ```
    

  
  
+ @RestController

 
  ```java
  @RestController //表示本類別是一個符合RESTful，會回傳的都是JSON格式
  public class CustomerController{
    @Autowired//到IoC容器中尋找符合的Class
    private Customer dao;
    @PostMapping("customer/insert")
    public Customer insertCustomer(){
      //以下略
      
    }
  }
  ```

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
  
  
  # 在Dao繼承JpaRepository<WorkMessages, Integer>以調用CRUD方法
  ```java
  private 
  public interface WorkMessagesDao extends  JpaRepository<WorkMessages, Integer>{
	
	public WorkMessages findFirstByOrderByAddedDesc();
  }
  ```
  ```java
  public class WorkMessagesService {

	@Autowired
	private WorkMessagesDao dao;

	public void save(WorkMessages msg) {
  dao.save(msg);
	}
  
  ```


  # Pagebel物件的使用

  + ```java
    Pageable request =PageRequest.of(0,3,Sort.Direction.DESC,"id");
    ```

    取得一個第`0`頁開始，一頁`3`筆資料，按`DESC`(降冪)排列，根據`id`欄位屬性降冪排列的Pageable物件,拿到`Pageable`物件就可以使用`PagingAndSortingRepository`內```findAll(Pageable pageable)```方法取得Page物件。
    + page物件常用的方法
      1. ```getTotalPages();```
        取得Page物件內的總頁數
      2. ```getTotalElemets();```
        取得Page物件元素的總數
      3. ```getNumber();```
        取得目前的頁數(Page繼承的Slice物件內的方法)
      4. ```getContent()```
         取得Page物件內的資料List&lt;T>

    

# JpaRepository的HQL中參數的寫法

  >
   ###### 若要使用原生SQL做查詢，需在後面加上nativeQuery=true
      用原生SQL做查詢的話，就不是對Entity操作了，會變成對Table操作，因此操作的屬性就變成table的屬性了
  1. 根據參數位置(第幾個問號對應底下方法第幾個參數)
  
   
      ```JAVA
      @Query(value="from customer where name=?1"){
      Person findCustomerByName(String name);
      }
      ```
  2. 用:及@Param 做對應(★推薦)
     ```java
     @Query(value="from customer where name=:name) 
     // 指Customer的名字name=:name要跟@Param("name")對應到
     public List<Customer> findByName(@Param(value="name")String name);
     ```
#### 若在@Query做查詢時，若是要修改資料或是刪除資料，需要注意記得加上@Modifying
  ```java
     @Modifying
     @Query(value="DELETE FROM customer where id=?1",nativeQuery=true){
     void delAccount(int id);
     }
  ```

# 自動創建SQL表格(補充)
  1.  要先在`application.properties`裡面設定
  `spring.jpa.hibernate.ddl-auto=update `
  2.  在Bean裡面要這樣寫
   `columnDefinition = "nvarchar(200)"`
   `columnDefinition = "datetime"`，來讓SQL設定
    
      ```java
      @Entity
      @Table(name="work_messages")
      public class WorkMessages {

        public WorkMessages() {
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "next", columnDefinition = "nvarchar(200)")
        private String text;

        @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") // 從資料庫取出後轉格式
        @Temporal(TemporalType.TIMESTAMP) // 存進去的資料型別
        @Column(name = "added", columnDefinition = "datetime")
        private Date added;
      ```     

    
     


    
    





  
  
  

  
