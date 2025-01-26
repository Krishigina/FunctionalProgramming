package lambdaExpressions

// TODO: Определить функцию высшего порядка processNumbers
// 1. Функция должна принимать:
//    - Список чисел для обработки.
//    - Лямбда-выражение для фильтрации чисел (возвращает Boolean).
//    - Лямбда-выражение для преобразования чисел (возвращает Int).
// 2. Реализовать логику фильтрации чисел на основе переданного лямбда-выражения.
// 3. Преобразовать отфильтрованные числа с помощью второго лямбда-выражения.
// 4. Вернуть новый список с преобразованными числами.
fun proccessNumbers(listNumbers: List<Int>, filter: (Int) -> Boolean, transform: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (number in listNumbers) {
        if (filter(number)){
            result.add(transform(number))
        }
    }
    return result
}


// TODO: Определить функцию startProcessing
// 1. Вывести сообщение: "Введите числа, разделенные пробелами:".
// 2. Считать строку чисел, введённую пользователем.
// 3. Преобразовать строку в список чисел.
// 4. Вызвать функцию processNumbers с:
//    - Условием: числа больше 10.
//    - Преобразованием: умножение числа на 3.
// 5. Вывести результат обработки в формате: "Результат обработки: [<результат>]".
fun startProcessing() {
    print("Введите числа, разделенные пробелами: ")
    val listNumbers = readln().split(" ").map { it.toInt() }
    val result = proccessNumbers(
        listNumbers, { it > 10 }, { it * 3 }
    )
    println("Результат обработки: $result")
}
fun main() {
    startProcessing()
}