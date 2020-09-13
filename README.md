# Решение задачи - сводная таблица (Pivot table) для датасета "Налоги РФ"

## Цели
1. Работа с кодом Java SE, Spring Boot
2. Работа с БД, понимание SQL
3. Понимание принципов плоского и многомерного представления данных.
4. Проектирование и реализация API.
5. Работа с HTTP API, JSON.
6. Инструменты для CI/CD
7. Документирование
8. Файл БД dataset/data.sqlite содержит единственную таблицу source_data (датасет) с 10К записей по налогам РФ за 2010-2015 годы. Нужно реализовать API для отображения датасета в виде двухмерной сводной таблицы на стеке JavaSE/Spring Boot

## Описание колонок таблицы source_data
a - группа налога
b - подгруппа налога
c - округ РФ
d - регион РФ
y - год
v - значение

## Серверная часть
Принимает запросы клиента по HTTP API, выполняет запросы в БД и отдает результат в виде JSON.

Вызов API GET принимает два параметра

row - название столбца БД для группировки таблицы по горизонтали
col - название столбца БД для группировки таблицы по вертикали
Каждый параметр может принимать значения a,b,c,d,y

http://localhost:8080/?row=b&col=d
В результате запроса в БД sqlite возвращается массив JSON, где каждый элемент - результат агрегации по указанным столбцам таблицы

## пример возвращаемого значения:
[
    {"row" : "Транспортный налог", "col" : "Краснодарский край", "val" : 1},
    {"row" : "Транспортный налог", "col" : "Ростовская область", "val" : 2},
    {"row" : "Земельный налог", "col" : "Краснодарский край", "val" : 3},
    {"row" : "Земельный налог", "col" : "Ростовская область", "val" : 4}
]

## Реализация:

1. Использовались Java SE 11 и Spring Boot.
2. Так как в таблице source_data нет primary_key, то было принято решение выполнить реализацию задачи с использованием jdbc.
3. При разработке использовалась база данных sqlite.
4. Проект скачивается к себе на локальную машину и запускается с использованием Intellij Idea.
    - подключаем базу данных sqlite, указываем в ней URL (путь к файлу data.sqlite, который находится в главной директории проекта.)
    - переходим в Project Structure, выбираем там 11 java.
    - переходим в File->Settings->Gradle, устанавливаем там java 11. 