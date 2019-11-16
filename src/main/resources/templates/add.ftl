<#import "parts/common.ftl" as c>

<@c.page>
    <div>
        <form method="post" action="/add">
            <input type="text" name="name" placeholder="Введите имя">
            <input type="text" name="price" placeholder="Введите цену">
            <input type="text" name="discount" placeholder="Введите скидку">
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