package introGenerics

fun <T, R> transform(list: List<T>, operation: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    for (el in list){
        result.add(operation(el))
    }
    return result
}