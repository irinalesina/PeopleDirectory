@echo off

set USERNAME="%1"
set PASSWORD="%2"

set CUR_DIR=%~dp0
set LIB_DIR=%CUR_DIR%/../lib

set CLASSPATH="%LIB_DIR%/liquibase.jar;%LIB_DIR%/mysql-connector-java-5.1.34.jar"

java -jar "%LIB_DIR%/liquibase.jar" ^
	--classpath="%CLASSPATH%" ^
	--changeLogFile="%CUR_DIR%/../resources/liquibase-changelog.xml" ^
	--driver="com.mysql.jdbc.Driver" ^
	--url="jdbc:mysql://localhost:3306/people" ^
    --username="%USERNAME%" ^
    --password="%PASSWORD%" ^
	update
