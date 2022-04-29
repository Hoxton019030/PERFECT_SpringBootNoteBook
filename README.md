# PERFECT_SpringBootNoteBook

這是SpringBoot的筆記程式

https://drive.google.com/drive/folders/1Ew-YkK0FVaJfmkTd3j_Y4jpAcl3_crqv

<h1>Spring官網設置<h1>
<h3>網址：https://start.spring.io/<h3>
  
![image](https://user-images.githubusercontent.com/98711945/165891446-10cf39ca-f9ad-4b23-98c2-20d7474b423d.png)

  <h1>在application.properties裡可撰寫的設定<h1>
    
    #Context Path
server.port=8080
#埠號
server.servlet.context-path=/myapp
#
spring.mvc.hiddenmethod.filter.enabled=true

#setting jsp
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp

#連線池設定

# Connntection Setting

spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=SpringBootDB
spring.datasource.username=Hoxton
spring.datasource.password=orz93098

# Jpa Settings
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServer2016Dialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
