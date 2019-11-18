<#import "parts/common.ftl" as c>

<@c.page>
    <div>
        <form method="post" action="/addCharacteristic">
            <label>Имя<input name="name" placeholder="Введите имя" type="text"></label>
            <label>Описание<input type="text" name="description" placeholder="Введите описание"></label>
            <button type="submit">Добавить характеристику</button>
        </form>
    </div>

    <#list characteristics as characteristic>
        <div>
            <b>${characteristic.id}</b>
            <span>${characteristic.name}</span>
            <i>${characteristic.description}</i>
        </div>
    </#list>
</@c.page>