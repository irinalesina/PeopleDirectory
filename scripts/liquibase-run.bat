@echo off

set CUR_DIR=%~dp0
set LIB_DIR=%CUR_DIR%\..\lib
set RESOURCES_DIR=%CUR_DIR%\..\resources

set CLASSPATH="%LIB_DIR%\liquibase.jar;%LIB_DIR%\mysql-connector-java-5.1.34.jar"

set PROPERTIES_FILE=%RESOURCES_DIR%\liquibase.properties
if "%1" NEQ "" (
	set PROPERTIES_FILE=%1
)

java -jar "%LIB_DIR%\liquibase.jar" ^
	--classpath="%CLASSPATH%" ^
	--defaultsFile="%PROPERTIES_FILE%" ^
	--changeLogFile="%RESOURCES_DIR%\liquibase-changelog.xml" ^
	update
