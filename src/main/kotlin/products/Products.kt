package products


fun main() {
    val products = ProductsRepository.products
    var filtered = filter(products) {it.productCategory.equals(Category.SPORTS)}
    filtered = filter(filtered) {it.productPrice > 500}
    filtered = filter(filtered) {it.productRating > 4}
    for (product in filtered){
        println(product)
    }
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