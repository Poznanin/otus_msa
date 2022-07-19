SET SRC=..\..\web-app\build\libs\web-app.jar
copy %SRC% web-app.jar
docker build --build-arg JAR_FILE=web-app.jar -t arch.homework.health.dz1:1.0 .
del web-app.jar
