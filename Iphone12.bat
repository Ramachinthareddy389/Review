:: Set Variables
set MAVEN_HOME=%~dp0%Resources\MAVEN
set PATH=%PATH%;%MAVEN_HOME%\bin;%~dp0%Resources\allure-cli\bin
set JDK="%ProgramFiles%\Java\jdk*"
for /d %%i in (%JDK%) do set JAVA_HOME=%%i
:: Display Variables and Launch MAVEN

set JAVA_HOME
echo %MAVEN_HOME%
echo %PATH%
pushd %~dp0%
timeout 1
mvn clean test -Dsurefire.suiteXmlFiles=TestNGSuites/Automated_UXRevamp_xmls/iPhone12.xml
pause
pause