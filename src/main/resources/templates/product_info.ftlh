<!DOCTYPE html>
<html>
    <head>
        <title>BuySellBoard</title>
    </head>
    <body>
        <h1>Hello BuySellBoard!</h1>
        <h3>Detailed info about the good</h3>
        <p>Title: ${product_info.title}</p>
        <p>Description: ${product_info.description]}</p>
        <p>Price: ${product_info.price}</p>
        <p>City: ${product_info.city}</p>
        <p>Author: ${product_info.author}</p>
        <div>
            <form action="/product/delete/${product_info.id}" method="post">
                <input type="submit" value="Delete the good">
            </form>
        </div>
    </body>
</html>