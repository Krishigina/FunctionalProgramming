package products


fun main() {
    val products = ProductsRepository.products
    var filtered = filter(products, object: Condition{
        override fun isSuitable(product: Product): Boolean {
            return product.productCategory.equals(Category.SPORTS)
        }
    })
    filtered = filter(filtered, object: Condition{
        override fun isSuitable(product: Product): Boolean {
            return product.productPrice > 500
        }
    })
    filtered = filter(filtered, object: Condition{
        override fun isSuitable(product: Product): Boolean {
            return product.productRating > 4
        }
    })
    for (product in filtered){
        println(product)
    }
}
fun filter(products: List<Product>, condition: Condition): List<Product>{
    val result = mutableListOf<Product>()
    for (product in products){
        if (condition.isSuitable(product)){
            result.add(product)
        }
    }
    return result
}