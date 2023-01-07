[1mdiff --git a/pom.xml b/pom.xml[m
[1mindex c9aec19..0d77d53 100644[m
[1m--- a/pom.xml[m
[1m+++ b/pom.xml[m
[36m@@ -38,6 +38,7 @@[m
             <version>${junit.version}</version>[m
             <scope>test</scope>[m
         </dependency>[m
[32m+[m
     </dependencies>[m
 [m
     <build>[m
[1mdiff --git a/src/main/SQL/create_library.sql b/src/main/SQL/create_library.sql[m
[1mindex e69de29..a6cf9ec 100644[m
[1m--- a/src/main/SQL/create_library.sql[m
[1m+++ b/src/main/SQL/create_library.sql[m
[36m@@ -0,0 +1,9 @@[m
[32m+[m[32mdrop database library;[m
[32m+[m[32mcreate database library;[m
[32m+[m[32muse library;[m
[32m+[m[32mcreate table book([m
[32m+[m[32m    title varchar(30),[m
[32m+[m[32m    publisher varchar(30),[m
[32m+[m[32m    copies int,[m
[32m+[m[32m    ISBN long PRIMARY KEY,[m
[32m+[m[32m);[m
\ No newline at end of file[m
[1mdiff --git a/src/main/java/abinladin/libraryapplication/BookController.java b/src/main/java/abinladin/libraryapplication/BookController.java[m
[1mindex 3ef14e3..0a0308f 100755[m
[1m--- a/src/main/java/abinladin/libraryapplication/BookController.java[m
[1m+++ b/src/main/java/abinladin/libraryapplication/BookController.java[m
[36m@@ -6,7 +6,7 @@[m [mimport javafx.fxml.FXML;[m
 import javafx.scene.control.Button;[m
 import javafx.scene.control.DatePicker;[m
 import javafx.scene.control.TextField;[m
[31m-[m
[32m+[m[32mimport java.sql.*;[m[41m[m
 [m
 public class BookController {[m
 [m
[36m@@ -44,6 +44,18 @@[m [mpublic class BookController {[m
 [m
         bookArrayList.add(book);[m
 [m
[32m+[m[41m[m
[32m+[m[32m       try {[m[41m[m
[32m+[m[32m            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Abdullah@2511");[m[41m[m
[32m+[m[32m            Statement statement = con.createStatement();[m[41m[m
[32m+[m[41m[m
[32m+[m[32m            String query = String.format("insert into book values(\"%s\",\"%s\",\"%s\");", book.getTitle(), book.getAuthor(), book.getPublisher());[m[41m[m
[32m+[m[32m            statement.executeUpdate(query);[m[41m[m
[32m+[m[41m[m
[32m+[m[32m        } catch (SQLException e) {[m[41m[m
[32m+[m[32m            e.printStackTrace();[m[41m[m
[32m+[m[32m        }[m[41m[m
[32m+[m[41m[m
         titleField.clear();[m
         authorField.clear();[m
         publisher.clear();[m
[1mdiff --git a/src/main/java/abinladin/libraryapplication/MainApplication.java b/src/main/java/abinladin/libraryapplication/MainApplication.java[m
[1mindex aaf15b8..e3c3d3b 100755[m
[1m--- a/src/main/java/abinladin/libraryapplication/MainApplication.java[m
[1m+++ b/src/main/java/abinladin/libraryapplication/MainApplication.java[m
[36m@@ -17,6 +17,7 @@[m [mpublic class MainApplication extends Application {[m
         stage.setScene(scene);[m
         stage.setResizable(false);[m
         stage.show();[m
[32m+[m
     }[m
 [m
     public static void main(String[] args) {[m
[1mdiff --git a/src/main/java/module-info.java b/src/main/java/module-info.java[m
[1mindex 98af036..b76cc7c 100644[m
[1m--- a/src/main/java/module-info.java[m
[1m+++ b/src/main/java/module-info.java[m
[36m@@ -1,6 +1,7 @@[m
 module abinladin.libraryapplication {[m
     requires javafx.controls;[m
     requires javafx.fxml;[m
[32m+[m[32m    requires java.sql;[m
 [m
 [m
     opens abinladin.libraryapplication to javafx.fxml;[m
