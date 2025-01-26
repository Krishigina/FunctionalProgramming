package products


fun main() {
    val products = ProductsRepository.products
    var filtered = filter(products) {it.productCategory.equals(Category.CLOTHING)}
    var transformed = transform(filtered, {it.copy(productPrice = it.productPrice * 2)})
    val strings = transform(transformed){"${it.id}-${it.productName}-${it.productPrice}"}
    for (product in strings){
        println(product)
    }
}

fun <R> transform(products: List<Product>, operation: (Product) -> R): List<R>{
    val result = mutableListOf<R>()
    for (product in products){
        result.add(operation(product))
    }
    return result
}

fun filter(products: List<Product>, isSuitable: (Product) -> Boolean): List<Product>{
    val result = mutableListOf<Product>()
    for (product in products){
        if (isSuitable(product)){
            result.add(product)
        }
    }
    return result
}