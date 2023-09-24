APP precio de producto
---
Construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta  tal que:
 
Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.
 
Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo, (se pueden cambiar el nombre de los campos y añadir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los mismos).
              
Desarrollar unos test al endpoint rest que  validen las siguientes peticiones al servicio con los datos del ejemplo:
                                                                                       
-          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
 

#### obtiene el precio según la prioridad

aplicación/servicio/apply-price?brandId=1&productId=35455&date=2020-06-14T16:00:00
##### Request

##### Response

```sh
{
    "brandId": 1,
    "productId": 35455,
    "price": 35.5
}
```

#### obtiene todos los precios segun el producto id
aplicación/servicio/byProductId?productId=35455
##### Request


##### Response

```sh
[
    {
        "brandId": 1,
        "productId": 35455,
        "price": 35.5,
        "curr": "EUR"
    },
    ...
]
```

#### obtiene todos los productos
aplicación/servicio/all
##### Request


##### Response

```sh
[
    {
        "brandId": 1,
        "productId": 35455,
        "price": 35.5,
        "curr": "EUR"
    },
    ...
]
```

