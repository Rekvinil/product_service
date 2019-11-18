<#import "parts/common.ftl" as c>

<@c.page>
    <div>
        <form method="post" action="/addProduct">
            <label>Имя<input name="name" placeholder="Введите имя" type="text"></label>
            <label>Цена<input type="text" name="price" placeholder="Введите цену"></label>
            <label>Скида<input type="text" name="discount" placeholder="Введите скидку"></label>
            <button type="submit">Добавить комикс</button>
        </form>
    </div>

    <#list products as product>
        <div>
            <b>${product.id}</b>
            <span>${product.name}</span>
            <i>${product.price}</i>
            <strong>${product.discount}</strong>
        </div>
    </#list>
</@c.page>