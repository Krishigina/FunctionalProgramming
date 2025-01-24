package products

class ConditionCategoryBeauty : Condition {
    override fun isSuitable(product: Product): Boolean {
        return product.productCategory.equals(Category.BEAUTY)
    }
}