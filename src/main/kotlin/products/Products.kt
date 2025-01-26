package products


fun main() {
    val products = ProductsRepository.products
        .filter{it.productCategory.equals(Category.CLOTHING)}
        .transform{it.copy(productPrice = it.productPrice * 2)}
        .transform{"${it.id}-${it.productName}-${it.productPrice}"}
    for (product in products){
        println(product)
    }
}

fun <R> List<Product>.transform(operation: (Product) -> R): List<R>{
    val result = mutableListOf<R>()
    for (product in this){
        result.add(operation(product))
    }
    return result
}

fun List<Product>.filter(isSuitable: (Product) -> Boolean): List<Product>{
    val result = mutableListOf<Product>()
    for (product in this){
        if (isSuitable(product)){
            result.add(product)
        }
    }
    return result
}