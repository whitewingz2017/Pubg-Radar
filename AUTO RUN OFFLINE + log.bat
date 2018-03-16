@echo off
for /f "tokens=14" %%a in ('ipconfig ^| findstr IPv4') do set _IPaddr=%%a
echo YOUR IP ADDRESS IS: %_IPaddr%
java -jar target\pubg-radar-1.0-SNAPSHOT-jar-with-dependencies.jar %_IPaddr% PortFilter %_IPaddr% Offline > logall.txt
pause