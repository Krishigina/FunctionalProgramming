package dictionary

import kotlinx.serialization.json.Json
import java.io.File
import kotlin.time.measureTime

fun main() {
    val file = File("dictionary.json")
    val content = file.readText().trim()
    val dictionary = Json.decodeFromString<Map<String, String>>(content)
//    val dictionaryMap = dictionary.associate { it.value to it.description }
//    val mapAsString = Json.encodeToString(dictionaryMap)
//    file.writeText(mapAsString)
    showDescription(dictionary)
}

fun showDescription(dictionary: Map<String, String>) {
    while (true) {
        print("Enter word or 0 to exit: ")
        val text = readln().lowercase()
        if (text == "0") break
        val time = measureTime {
            dictionary[text]?.let { println(it) } ?: println("Not found")
        }
        println("Duration: $time")
    }
}