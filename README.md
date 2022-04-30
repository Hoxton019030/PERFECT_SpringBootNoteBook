# PERFECT_SpringBootNoteBook

這是SpringBoot的筆記程式

https://drive.google.com/drive/folders/1Ew-YkK0FVaJfmkTd3j_Y4jpAcl3_crqv

# Spring官網設置

### 網址：https://start.spring.io/
  
![image](https://user-images.githubusercontent.com/98711945/165891446-10cf39ca-f9ad-4b23-98c2-20d7474b423d.png)

  # 在application.properties裡可撰寫的設定
    
![image](https://user-images.githubusercontent.com/98711945/165892010-e37a0498-2e64-4d36-8f8f-fe2102dafd68.png)


# SpringMVC常用註釋
  

+ @Controller
  
  控制器，編寫在類別上，表示是SpringMVC的Controller，負責處理由DispatcherServlet接收並分發過來的請求，通常寫在Controller的class上面
  
  ![image](https://user-images.githubusercontent.com/98711945/165895379-a0f9bcd0-8247-4fa3-a6fe-7212ed184a04.png)
  
+ @RequestMapping
  
  寫在Controller內的方法上，真正處理請求位址對應的註釋，若編寫在類別上，則代表該類別的所有回應請求的方法都已該位址為父位址，通常不會使用這個Annotaion，而是會使用更為精準的
  
   +  @GetMapping: 處理Get請求
    
    
    ![image](https://user-images.githubusercontent.com/98711945/165896081-c1cf1e55-4c4e-4af3-ad30-5a4666ef121c.png)

    
    +  @PostMapping: 處理post請求
    
    ![image](https://user-images.githubusercontent.com/98711945/165896116-cb4e09db-89d8-48fd-b3fe-960bee6b9166.png)
    
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
   return "some-page"
  ```
  
  ![image](https://user-images.githubusercontent.com/98711945/166092309-c9b62f61-5522-44b3-b1f7-a5aa53f83856.png)
  ▲取得?id=的值
+ @RestController

![image](https://user-images.githubusercontent.com/98711945/166092473-2f404812-eeb6-4fbe-96c4-a7a141626c3a.png)

  用來標記Restful風格的控制器類型，等同於在@Controller加上@ResponseBody，會直接回傳一個字串，通常用於回應Json格式的字串

  
  
  
  
