# PERFECT_SpringBootNoteBook

這是SpringBoot的筆記程式

https://drive.google.com/drive/folders/1Ew-YkK0FVaJfmkTd3j_Y4jpAcl3_crqv

# Spring官網設置

### 網址：<a href="https://start.spring.io/" target="_blank" >啟動器</a>
  
![image](https://user-images.githubusercontent.com/98711945/165891446-10cf39ca-f9ad-4b23-98c2-20d7474b423d.png)
![image](https://user-images.githubusercontent.com/98711945/166162052-d10ea1bb-f133-4c3b-b435-75322f3ce929.png)


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

# Maven依賴
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.6.7</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.jerryboot</groupId>
	<artifactId>springbootdemo</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>springbootdemo</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>11</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<!-- START使用JSP的工具 -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
		</dependency>
		<!-- END使用JSP的工具 -->
		<dependency>
			<groupId>com.microsoft.sqlserver</groupId>
			<artifactId>mssql-jdbc</artifactId>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>

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
  
  ```html
  <form action="processForm3" method="get>
	<input type="text" name="studentname" placeholder="請輸入姓名"/>
	<input type="submit"/>
  </form>
  ```
  
  ```java
  @GetMapping("/processForm3")
  public String formAction(@RequestParam("studentname") String theName , Model model){
  String result = "hi"+theName+"form processForm3";
  model.addAttribute("message",result);
  return "studnet_response"
  ```
  
  ```html
  <h1>回傳訊息:${message}</h1>
  <!-- 會出現hi小明form processForm3 -->
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
    ```java
    public Page<WorkMessages> findByPage(Integer pageNumber){
		PageRequest pgb = PageRequest.of(pageNumber-1, 3, Sort.Direction.DESC, "added");
		Page<WorkMessages> page = dao.findAll(pgb);
		return page;
	}
    ```
    + page物件常用的方法
      1. ```getTotalPages();```
        取得Page物件內的總頁數
      2. ```getTotalElemets();```
        取得Page物件元素的總數
      3. ```getNumber();```
        取得目前的頁數(Page繼承的Slice物件內的方法)
      4. ```getContent()```
         取得Page物件內的資料List&lt;T>

    
# JpaRepository介紹
通常用在Dao裡面，別忘了加上`@Repository(表示該類是用來執行與資料庫相關的操作，通常是DAO)`的標籤
>這是JpaRepository繼承了`PagingAndSortingRepository`，和`QueryByExampleExecutor`
```java
public interface JpaRepository<T, ID> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {};
```
>這是`PagingAndSortingRepository`繼承了CrudRepository
```java
public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> 
```
因此繼承了JpaRepository就代表**擁有了**
1.  基本的CRUD功能(都是靜態，可以直接呼叫)
2.  分頁功能
3.  當然還有HQL的查詢功能


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

    
# 過濾器(用來做一些驗證)
  官方網站:https://hibernate.org/validator/
  官方文件:https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#validator-gettingstarted
  + 範例
  ```java
  @Entity
@Table(name = "work_messages")
public class WorkMessages {

	public WorkMessages() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Size(min = 1, max = 199,message="請輸入2到199的字串") //Validation
	@Column(name = "next", columnDefinition = "nvarchar(200)")
	private String text;

   // ...
}
  ```
  ```java
  @PostMapping("/message/add")
	public ModelAndView postMessage(ModelAndView mav, @Valid @ModelAttribute(name = "workMessages") WorkMessages msg,
			BindingResult br) {
		if (!br.hasErrors()) {
			service.save(msg);
			WorkMessages newMsg = new WorkMessages();
			mav.getModel().put("workMessages", newMsg);
		}
		WorkMessages lastestMsg = service.getLastest();
		mav.getModel().put("lastMessage",lastestMsg);
		mav.setViewName("addMessage");
		return mav;
	}
  ```


  1. 先加入Dependency
  ```
   		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation  </artifactId>
		  </dependency>
  ```
  1.  在Bean的屬性上加上想要的限制，例如限制字節長度的`@Size(min=10,max=100`,E-mail格式的`@E-Mail`之類的

  2.  

  

   




     


    
    





  
  # 豆知識
  1. 
       1. 先寫Entity
       2. 再寫DAO
       3. 再寫Service
       4. 再寫Controller
   
  

  
