package products

class ConditionRatingMore4 : Condition {
    override fun isSuitable(product: Product): Boolean {
        return product.productRating > 4
    }
}