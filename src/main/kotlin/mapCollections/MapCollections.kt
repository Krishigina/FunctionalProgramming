package mapCollections

/**
 * Расширение для преобразования значений в `Map`.
 * @param transform Функция для преобразования значений.
 * @return Новый `Map` с теми же ключами, но преобразованными значениями.
 */
fun <K, V, R> Map<K, V>.transformValues(transform: (V) -> R): Map<K, R> {
    val result = mutableMapOf<K, R>()
    for (item in this){
        result[item.key] = transform(item.value)
    }
    return result
}