SET SRC=..\..\web-app\build\libs\web-app.jar
copy %SRC% web-app.jar
docker build --build-arg JAR_FILE=web-app.jar -t poznaninlp/otus_homework:1.2.6 .
del web-app.jar
