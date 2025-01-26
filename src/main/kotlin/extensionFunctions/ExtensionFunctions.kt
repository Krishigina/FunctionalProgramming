package extensionFunctions

fun List<Int>.sunOfEvents(): Int {
    var sum = 0
    for (number in this) if (number % 2 == 0){
        sum+=number
    }
    return sum
}

fun processList(){
    val string = readln().split(" ").map {it.toInt()}
    print("Сумма чётных чисел: ${string.sunOfEvents()}")

}
fun main() {
    processList()
}
