# Petstore API-autotests

## Technology :

    Java
    Maven
    RestAssured

## Task :

Написать API - автотесты для сайта https://petstore.swagger.io/ по одному методу из следующих блоков :

    GET
    PUT
    POST
    DELETE

## Development Environment :

    Инструменты разработки : java 21, RestAssured
    IDE : IntelliJ IDEA 2023.2.3 (Community Edition)
    ОС : Microsoft Windows 10 Pro

## Code :

       - Исходный код выполняет тесты, описанные в описании задачи

       - Для тестирования всех методов достаточно запустить главный файл "TestCases.java"

       - Порядок выполнения тестов контролируется приоритетом. Если приоритет не задан, то некоторые тесты могут быть провалены, так как тест может попытаться удалить питомца, который не был загружен.
