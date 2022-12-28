# java-example-payara
Web Application using Payara Platform Community 6


Prerequisites:

1) JDK must be installed (see [Java 19 and Java 17 available now](https://www.oracle.com/java/technologies/downloads/#java17))

2) Look for Java Home folder location:

        java -XshowSettings:properties -version

    there is property `java.home`. Export it into environment:
    
        export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.0.4.1.jdk/Contents/Home

3) Download Payara Server 6 from [Payara Platform Community Edition](https://www.payara.fish/downloads/payara-platform-community-edition/)

4) Install Payara Server 6:

        sudo mv ~/Downloads/payara6 /usr/local/
        sudo chown -R username /usr/local/payara6


New project setup inside IntelliJ IDEA:

* Create new project with `Jakarta EE` generator

* Enter project name, eg `Payara`

* Select `Template` as `Web Application`

* Select `Application server` as `Glassfish 6.2022.2`
  
    Create new if not exists following steps `New...` -> `Glassfish Server`, then set `GlassFish Home` to `/usr/local/payara6`

* Select `Language` as `Java` and `Build System` as `Maven`

* Then press `Next` button and select `Version` as `Jakarta EE 9`, check on `Web Profile` and press `Create` button.

To use  JSF it is necessary to install plugin [`Jakarta EE: Server Faces (JSF)`](https://plugins.jetbrains.com/plugin/18583-jakarta-ee-server-faces-jsf-) in IntelliJ IDEA

### Create JDBC Connection Pool

    /usr/local/payara6/bin/asadmin add-library mysql-connector-j-8.0.31.jar
    /usr/local/payara6/bin/asadmin create-jdbc-connection-pool --restype javax.sql.DataSource --datasourceclassname com.mysql.cj.jdbc.MysqlDataSource --property user=username:password=Secr8*Et*p*Asswd#:DatabaseName=database:ServerName=127.0.0.1:port=3306:useSSL=false DatabaseConnectionPool
    /usr/local/payara6/bin/asadmin ping-connection-pool DatabaseConnectionPool
