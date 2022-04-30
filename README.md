# PERFECT_SpringBootNoteBook

這是SpringBoot的筆記程式

https://drive.google.com/drive/folders/1Ew-YkK0FVaJfmkTd3j_Y4jpAcl3_crqv

<h1>Spring官網設置<h1>
<h3>網址：https://start.spring.io/<h3>
  
![image](https://user-images.githubusercontent.com/98711945/165891446-10cf39ca-f9ad-4b23-98c2-20d7474b423d.png)

  <h1>在application.properties裡可撰寫的設定<h1>
    
![image](https://user-images.githubusercontent.com/98711945/165892010-e37a0498-2e64-4d36-8f8f-fe2102dafd68.png)


<h1>SpringMVC常用註釋<h1>
<ul>
<ol>@Controller</ol>
  
  控制器，編寫在類別上，表示是SpringMVC的Controller，負責處理由DispatcherServlet接收並分發過來的請求，通常寫在Controller的class上面
  
  ![image](https://user-images.githubusercontent.com/98711945/165895379-a0f9bcd0-8247-4fa3-a6fe-7212ed184a04.png)
  
<ol>@RequestMapping</ol>
  
  寫在Controller內的方法上，真正處理請求位址對應的註釋，若編寫在類別上，則代表該類別的所有回應請求的方法都已該位址為父位址，通常不會使用這個Annotaion，而是會使用更為精準的
  <ol>
    <li>@GetMapping</li> 處理Get請求
    
    
    ![image](https://user-images.githubusercontent.com/98711945/165896081-c1cf1e55-4c4e-4af3-ad30-5a4666ef121c.png)

    
    <li>@PostMapping</li> 處理post請求
    
    ![image](https://user-images.githubusercontent.com/98711945/165896116-cb4e09db-89d8-48fd-b3fe-960bee6b9166.png)
  </ol>
  
  
  
<ul/>
  
