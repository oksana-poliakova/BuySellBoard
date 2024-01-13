<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BuySellBoard</title>
</head>
<body>
<h1>Hello BuySellBoard!</h1>
<h3>Goods from all over Austria</h3>
<#list getAllProducts as product>
    <div>
        <p><b>${product.title}</b></p>
        <p><b>${product.description}</b></p>
        <p><b>${product.price} EUR</b></p>
        <p><b>${product.city}</b></p>
        <p><b>${product.author!''}</b></p>  <!-- Use default value ('') if author is null -->
        <p><a href="/product/${product.id}">Read more</a></p>
    </div>
</#list>

</body>
</html>