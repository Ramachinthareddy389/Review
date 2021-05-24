set MAVEN_HOME=%~dp0%Resources\Maven
set PATH=%PATH%;%MAVEN_HOME%\bin;%~dp0%Resources\allure-cli\bin
set JDK="%ProgramFiles%\Java\jdk*"
for /d %%i in (%JDK%) do set JAVA_HOME=%%i
:: Display Variables and Launch Maven
set JAVA_HOME
pause
echo %MAVEN_HOME%
pause
echo %PATH%
pause
pushd %~dp0%
pause
mvn clean install
pause