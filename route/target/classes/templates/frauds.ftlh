<!DOCTYPE html>
<html>
<body>
<h1>Все услуги</h1><hr>
<#list frauds as fraud>
    <div>
        <p>
            <b>${fraud.name}</b> ${fraud.textFraud} <a href="/fraud/${fraud.id}">Подробнее</a>
        </p>
    </div>
</#list>
<hr>
<h3>Создать услугу</h3>
<form action="/fraud/create" method="post" enctype="multipart/form-data">
    Название услуги: <input type="text" name="name"/><br><br>
    Описание услуги услуги: <input type="text" name="textFraud"/><br><br>
    Маршрут услуги услуги: <input type="file" name="file"/><br><br>
    <input type="submit" value="Создать услугу"/>
</form>
</body>
</html>