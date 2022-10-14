# Домашнее задание
Prometheus. Grafana
## Цель:
В этом ДЗ вы научитесь инструментировать сервис.
Инструментировать сервис из прошлого задания метриками в формате Prometheus с помощью библиотеки для вашего фреймворка и ЯП.
Сделать дашборд в Графане, в котором были бы метрики с разбивкой по API методам:
1. Latency (response time) с квантилями по 0.5, 0.95, 0.99, max
2. RPS
3. Error Rate - количество 500ых ответов
4. Добавить в дашборд графики с метрикам в целом по сервису, взятые с nginx-ingress-controller:
5. Latency (response time) с квантилями по 0.5, 0.95, 0.99, max
6. RPS
7. Error Rate - количество 500ых ответов
8. Настроить алертинг в графане на Error Rate и Latency.

### На выходе должно быть:
1. скриншоты дашборды с графиками в момент стресс-тестирования сервиса. Например, после 5-10 минут нагрузки.
json-дашборды.

### Задание со звездочкой (+5 баллов)
Используя существующие системные метрики из кубернетеса, добавить на дашборд графики с метриками:
Потребление подами приложения памяти
Потребление подами приолжения CPU
Инструментировать базу данных с помощью экспортера для prometheus для этой БД.
Добавить в общий дашборд графики с метриками работы БД.

# Отчет о выполнении

В ходе выполнения задания было сделано:

1. В сервис web-app Добавлена ручка для Actuator с выгрузкой в Prometheus
2. Добавлены Helm с настройкой ServiceMonitor
3. В docker-desktop установлен helm kube-prometheus-stack-40.1.2
4. В grafamna созданы две доски для мониторинга web-app-chart и nginx-ingress
5. В Grafana созданы alert
6. В nginx-ingress включен стандартный мониторинг
7. В postman сделаны две коллекции для эмуляции нагрузки. (сценарий select И сценарий crud)
8. На основе созданных коллекций с помощью утилиты postman-to-k6 сделаны скрипты для нагрузки 
9. Проведена нагрузка с помощью k6

## Инструкция

Все артефакты созданы для Docker Desktop

### Состав папок
| Папка                         | Описание                           |
|-------------------------------|------------------------------------|
| /web-app                      | веб-сервис для ДЗ                  |
| /kubernetes                   | содержит все ДЗ по теме кубернетес |
| /kubernetes/dz3               | ДЗ по третей теме                  |
| /kubernetes/dz3/web-app-chart | Helm скрипты                       |
| /kubernetes/dz3/results       | **Результаты ДЗ**                      |


### Сборка web-app
Собрать с использованием gradle
1. Должен быть установлен не особо дремучий Gradle
2. Из папки web-app выполнить команду ./gradlew bootJar
3. Получившийся артефакт web-app.jar скопировать в папку /kubernetes/dz2

### Создание образа
1. Зайти в папку /kubernetes/dz3
2. В файле create_image.bat проверить актуальность пути к артефакту web-app.jar в переменной SRC
3. Выполнить create_image.bat

### Установка и работа с помощтщью HELM
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

### Включить мониторинг для ingress
```sh
elm upgrade nginx-ingress-controller-1660578948 nginx-ingress-controller-9.2.27 --set prometheus.create=true --set prometheus.port=9901
```
### Утилита для нагрузки
Утилита для нагрузки
https://k6.io/docs/getting-started/installation/

#### Подготовка на основе коллекций Postman (в случае, если что-то поменялось)
Установить конвертатор
```sh
npm install -g @apideck/postman-to-k6
```
Создать коллекции из Postman (v)
```sh
postman-to-k6 "dz3 load testing edit.postman_collection.json" -o k6-dz3-edit.js
postman-to-k6 "dz3 load testing select.postman_collection.json" -o k6-dz3-select.js
```

#### Запуск нагрузки
```sh
k6 run --duration 600s --vus 1 k6-dz3-edit.js
k6 run --duration 600s --vus 10 k6-dz3-select.js
```