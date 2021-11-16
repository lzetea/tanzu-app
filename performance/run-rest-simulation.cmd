set GATLING_HOME=C:\Dev\gatling-charts-highcharts-bundle-3.6.1
set APP_PATH=C:\Dev\workspaces\tanzu-app

%GATLING_HOME%\bin\gatling.bat ^
-sf %APP_PATH%\performance\ ^
-s com.tanzu.perf.TanzuAppSimulation ^
-rf %GATLING_HOME%\results
