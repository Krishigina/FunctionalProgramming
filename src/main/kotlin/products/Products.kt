package products


fun main() {
    val products = ProductsRepository.products
    for (product in products){
        println(product)
    }
}