fun main() {
    val dictionary = mutableMapOf<String, String>()
    dictionary["Nikita"] = "+7 (999) 111 22 33"
    dictionary["Kristina"] = "+7 (999) 222 11 33"

    println("Enter the person name: ")
    val name = readln()
    print("Enter the person number: ")
    val number = readln()

    dictionary[name] = number

    findNumber(dictionary)
}

fun findNumber(dictionary: MutableMap<String, String>){
    while (true){
        print("Enter person name or 0 to exit: ")
        val name = readln()
        if (name == "0") break
        println(dictionary[name] ?: println("Not found"))
    }

}