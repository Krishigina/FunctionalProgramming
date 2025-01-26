import extensions.transform

/**
 * Класс для представления информации о продукте.
 *
 * @property id Уникальный идентификатор продукта.
 * @property name Название продукта.
 * @property price Цена продукта.
 * @property category Категория продукта.
 */
data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val category: String
)

/**
 * Метод, который обрабатывает список продуктов для отображения в UI.
 *
 * @param products Список продуктов, полученных из репозитория.
 * @return Список строк, готовых для отображения в UI.
 */
fun processProductsForUI(products: List<Product>): List<String> {
    return products
        .filter { it.price >= 100 && (it.category == "Electronics" || it.category == "Books") }
        .sortedBy { it.price }
        .map{"Product ID: ${it.id} | Name: ${it.name} | Price: $${it.price}"}
}