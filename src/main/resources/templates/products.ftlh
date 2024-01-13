<!DOCTYPE html>
<html>
    <head>
        <title>BuySellBoard</title>
    </head>
    <body>
        <h1>Hello BuySellBoard!</h1>
        <h3>Goods from all over Austria</h3>
        <#list products as product>
            <div>
                <p><b>${product.title}</b></p>
                <p><b>${product.price} EUR</b></p>
                <p><a href="/product/${product.id}">Read more</a></p>
            </div>
        </#list>
        <h3>Add a new good</h3>
        <div>
            <form action="/product/create" method="post">
                <label for="title">Title:</label>
                <input type="text" name="title"/>

                <label for="title">Description:</label>
                <input type="text" name="description"/>

                <label for="title">Price:</label>
                <input type="number" name="price"/>

                <label for="title">City:</label>
                <input type="text" name="city"/>

                <label for="title">Name:</label>
                <input type="text" name="name"/>

                <input type="submit" value="Add a new good">
            </form>
        </div>
    </body>
</html>