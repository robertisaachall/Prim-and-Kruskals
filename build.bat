@echo off
cls

set DRIVE_LETTER=%1:
set NODES=%2
set NODES_EDGES=%3
set START=%4
set END=%5
set PATH=%DRIVE_LETTER%\Java\bin;%DRIVE_LETTER%\Java\ant-1.9.9\bin;c:\Windows
ant Graph -Ddrive-letter=%DRIVE_LETTER% -Dnodes=%NODES% -Dnodes-edges=%NODES_EDGES%
