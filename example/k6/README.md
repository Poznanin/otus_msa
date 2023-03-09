### Пример Web-app
Имеется веб-приложение, которое выполняет базовый CRUD над таблицей Users.
Доступен swagger
```sh
http://localhost:8080/swagger-ui/index.html
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
postman-to-k6 "k6_example_CRUD.postman_collection.json" -o k6-example-edit.js
postman-to-k6 "k6_example_select.postman_collection.json" -o k6-example-select.js
```

#### Запуск нагрузки
```sh
k6 run --duration 600s --vus 1 k6-example-edit.js
k6 run --duration 600s --vus 10 k6-example-select.js
```