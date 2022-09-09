# Домашнее задание
Инфраструктурные паттерны

## Цель:
В этом ДЗ вы создадите простейший RESTful CRUD.

## Описание/Пошаговая инструкция выполнения домашнего задания:
Сделать простейший RESTful CRUD по созданию, удалению, просмотру и обновлению пользователей.
Пример API - https://app.swaggerhub.com/apis/otus55/users/1.0.0
Добавить базу данных для приложения.
Конфигурация приложения должна хранится в Configmaps.
Доступы к БД должны храниться в Secrets.
Первоначальные миграции должны быть оформлены в качестве Job-ы, если это требуется.
Ingress-ы должны также вести на url arch.homework/ (как и в прошлом задании)

## На выходе должны быть предоставлена
ссылка на директорию в github, где находится директория с манифестами кубернетеса
инструкция по запуску приложения.
команда установки БД из helm, вместе с файлом values.yaml.
команда применения первоначальных миграций
команда kubectl apply -f, которая запускает в правильном порядке манифесты кубернетеса
Postman коллекция, в которой будут представлены примеры запросов к сервису на создание, получение, изменение и удаление пользователя. Важно: в postman коллекции использовать базовый url - arch.homework.
Задание со звездочкой:
+5 балла за шаблонизацию приложения в helm чартах


# Инструкция
## Что сделано
В ходе выполнения задания сделано:
1. REST сервис web-app, обеспечивающий CRUD операции для таблицы Users
2. Манифесты для разворачивания БД postgres и сервиса. В сервисе используется система миграции flyway. Актуальность БД проверяется при старте приложения.
3. Настроен ingress на пути arch.homework/otusapp/poznanin/
4. HELM чарт для установки приложения
5. Отчет о тестировании приведен в файле newman_report.json

Все артефакты созданы для Docker Desktop

## Состав папок
| Папка                         | Описание                           |
|-------------------------------|------------------------------------|
| /web-app                      | веб-сервис для ДЗ                  |
| /kubernetes                   | содержит все ДЗ по теме кубернетес |
| /kubernetes/dz2               | ДЗ по второй теме                  |
| /kubernetes/dz2/manifests     | Манифесты для кубера               |
| /kubernetes/dz2/web-app-chart | Helm скрипты                       |


## Сборка web-app
Собрать с использованием gradle
1. Должен быть установлен не особо дремучий Gradle
2. Из папки web-app выполнить команду ./gradlew bootJar
3. Получившийся артефакт web-app.jar скопировать в папку /kubernetes/dz1

## Создание образа
1. Зайти в папку /kubernetes/dz2
2. В файле create_image.bat проверить актуальность пути к артефакту web-app.jar в переменной SRC
3. Выполнить create_image.bat

## Установка с помощью манифестов
Создаем неймспейс
```sh
kubectl create namespace dz2
```
Создаем configmap с настройками
```sh
kubectl apply -f web_app_config.yaml -n dz2
```
Создаем secret с настройками
```sh
kubectl apply -f web_app_secret.yaml -n dz2
```
Поднимаем postgres
```sh
kubectl apply -f postgres.yaml -n dz2
```
Создаем deployment с сервисом
```sh
kubectl apply -f deployment.yaml -n dz2
```
Создаем service с сервисом
```sh
kubectl apply -f service.yaml -n dz2
```
Создаем ingress с привязкой к arch.homework
```sh
kubectl apply -f ingress.yaml -n dz2
```
## Удаление 
Удалить namespace dz2
```sh
kubectl delete namespace dz2
```
## установка и работа с помощтщью HELM
Если приложение уже было установлено через манифесты, удалите его через удаление namespace

Команда для проверки итоговых Helm скриптов
```sh
helm install web-app ./web-app-chart --dry-run
```
Команда для установки
```sh
helm install web-app ./web-app-chart
```

Команда для удаления
```sh
helm uninstall web-app
```

## Проверка через postman

Коллекция запросов на управление пользователями
```sh
dz2.postman_collection.json
```
Результат работы команды newman run
```sh
newman run dz2.postman_collection.json --reporters cli,json --reporter-json-export newman_report.json
```
