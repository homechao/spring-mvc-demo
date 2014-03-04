@echo off
echo [INFO] Use maven tomcat7-plugin run the project.

set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m -Xrunjdwp:transport=dt_socket,address=8787,server=y,suspend=y
call mvn tomcat7:run

cd bin
pause 
