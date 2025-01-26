package products

import extensions.filter
import extensions.myForEach

fun main() {
    val products = ProductsRepository.products
        .filter{it.productCategory.equals(Category.CLOTHING)}
        .map{it.copy(productPrice = it.productPrice * 2)}
        .map{"${it.id}-${it.productName}-${it.productPrice}"}
        .myForEach(::println)
}