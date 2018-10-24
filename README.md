# -Java-Spring-JPA-Hibernate-MySQL-PaintHub
PaintHub created with Java Spring JPA Hibernate MySQL Maven

If you just want to watch the result of this code, check out screenshots folder, there are images with description  

If you want to download and check this project on your computer do next:
1. Download TestSi folder to any directory
2. Open your java programming environment (IntellijIDEA or Eclipse (My was IntellijIDEA)) and open this project
3. Configure your MySQL server (i recommend XAMPP for this project)
    You need to change some options in your server
    a) Open file php.ini that is located somewhere in your server application folder, find and change these variables
        post_max_size = 512M
        upload_max_filesize = 512M
        max_execution_time = 32000
        max_input_time = 32000
     It will add to your server more time for importing
     b) Open file my.ini, find and change these variables
        max_allowed_packet = 16M
        innodb_log_file_size = 256M
        innodb_log_buffer_size = 8M
      It will allow you to upload large images on server
4. Start your MYSQL server, create new database, and import in it database image.sql 
5. In your environment open file TestSi/src/main/webapp/resources/database.properties
   and replace connection data on yours.
6. Deploy
7. Check your browser
