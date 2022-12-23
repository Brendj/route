<!DOCTYPE html>
<html>
<body>
<h1>Подробная информация о товаре</h1><hr>
<b>Название услуги: </b>${fraud.name}<br>
<b>Информация о услуге: </b>${fraud.textFraud}<br>
<b>Маршрут услуги: </b>${fraud.route}<br>
<b>Версия маршрута: </b>${fraud.routeVersion}<br>
<hr>
<h3>Обновить услугу</h3>
<form action="/fraud/update" method="post" enctype="multipart/form-data">
    <input type="hidden" value="${fraud.id}" name="id"/>
    Название услуги: <input type="text" name="name"/><br><br>
    Описание услуги услуги: <input type="text" name="textFraud"/><br><br>
    Маршрут услуги услуги: <input type="file" name="file"/><br><br>
    <input type="submit" value="Обновить услугу"/>
</form>
</body>
</html>