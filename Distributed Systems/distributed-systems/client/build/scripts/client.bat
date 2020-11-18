@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  client startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and CLIENT_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\client-1.0.jar;%APP_HOME%\lib\shared-1.0.jar;%APP_HOME%\lib\rt-2.3.2.jar;%APP_HOME%\lib\grpc-netty-shaded-1.20.0.jar;%APP_HOME%\lib\grpc-protobuf-1.20.0.jar;%APP_HOME%\lib\grpc-stub-1.20.0.jar;%APP_HOME%\lib\protobuf-java-util-3.7.1.jar;%APP_HOME%\lib\imqxm-5.1.jar;%APP_HOME%\lib\imq-5.1.jar;%APP_HOME%\lib\fscontext-4.6-b01.jar;%APP_HOME%\lib\jaxb-runtime-2.3.2.jar;%APP_HOME%\lib\streambuffer-1.5.7.jar;%APP_HOME%\lib\saaj-impl-1.5.1.jar;%APP_HOME%\lib\stax-ex-1.8.1.jar;%APP_HOME%\lib\jakarta.xml.ws-api-2.3.2.jar;%APP_HOME%\lib\jakarta.xml.bind-api-2.3.2.jar;%APP_HOME%\lib\istack-commons-runtime-3.0.8.jar;%APP_HOME%\lib\jakarta.activation-api-1.2.1.jar;%APP_HOME%\lib\policy-2.7.6.jar;%APP_HOME%\lib\gmbal-4.0.0.jar;%APP_HOME%\lib\pfl-tf-tools-4.0.1.jar;%APP_HOME%\lib\pfl-tf-4.0.1.jar;%APP_HOME%\lib\mimepull-1.9.11.jar;%APP_HOME%\lib\woodstox-core-5.1.0.jar;%APP_HOME%\lib\stax2-api-4.1.jar;%APP_HOME%\lib\ha-api-3.1.12.jar;%APP_HOME%\lib\jakarta.xml.soap-api-1.4.1.jar;%APP_HOME%\lib\jakarta.jws-api-1.1.1.jar;%APP_HOME%\lib\jakarta.annotation-api-1.3.4.jar;%APP_HOME%\lib\grpc-protobuf-lite-1.20.0.jar;%APP_HOME%\lib\grpc-core-1.20.0.jar;%APP_HOME%\lib\protobuf-java-3.7.1.jar;%APP_HOME%\lib\guava-26.0-android.jar;%APP_HOME%\lib\proto-google-common-protos-1.12.0.jar;%APP_HOME%\lib\error_prone_annotations-2.3.2.jar;%APP_HOME%\lib\gson-2.7.jar;%APP_HOME%\lib\javax.jms-api-2.0.jar;%APP_HOME%\lib\txw2-2.3.2.jar;%APP_HOME%\lib\FastInfoset-1.2.16.jar;%APP_HOME%\lib\management-api-3.2.1.jar;%APP_HOME%\lib\pfl-basic-tools-4.0.1.jar;%APP_HOME%\lib\pfl-dynamic-4.0.1.jar;%APP_HOME%\lib\pfl-basic-4.0.1.jar;%APP_HOME%\lib\pfl-asm-4.0.1.jar;%APP_HOME%\lib\grpc-context-1.20.0.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\annotations-4.1.1.4.jar;%APP_HOME%\lib\animal-sniffer-annotations-1.17.jar;%APP_HOME%\lib\opencensus-contrib-grpc-metrics-0.19.2.jar;%APP_HOME%\lib\opencensus-api-0.19.2.jar;%APP_HOME%\lib\checker-compat-qual-2.5.2.jar;%APP_HOME%\lib\j2objc-annotations-1.1.jar;%APP_HOME%\lib\jaxm-api-5.1.jar


@rem Execute client
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %CLIENT_OPTS%  -classpath "%CLASSPATH%" de.uniba.rz.app.Main %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable CLIENT_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%CLIENT_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
