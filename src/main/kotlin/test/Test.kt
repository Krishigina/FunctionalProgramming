package test

import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    val file = File("items.json")
    val fileBooks = File("books.json")
    writeToFile(file)
    val items = readFromFile(file)
    for (item in items) {
        println(item)
    }

    writeToFile(fileBooks)
    val books = readFromFileBooks(fileBooks)
    for (book in books) {
        println(book)
    }
}

fun writeToFile(file: File) {
    if (file.name == "items.json"){
    val items = mutableListOf<Item>()
    while (true) {
        print("Enter id or 0 to exit: ")
        val id = readln().toInt()
        if (id == 0) break
        print("Enter name: ")
        val name = readln()
        val item = Item(id, name)
        items.add(item)
    }
    val itemsAsString = Json.encodeToString(items)
    file.writeText(itemsAsString)

    }
    if (file.name == "books.json"){
        val books = mutableListOf<Book>()
        while (true){
            print("Enter name of book or 0 to exit: ")
            val name = readln()
            if (name == "0") break
            print("Enter the author name: ")
            val authorName = readln()
            print("Enter the year of presentation book: ")
            val year = readln().toInt()
            val book = Book(name, authorName, year)
            books.add(book)
        }
        val booksAsString = Json.encodeToString(books)
        file.writeText(booksAsString)
    }

}

fun readFromFile(file: File): List<Item> {
        val content = file.readText().trim()
        return Json.decodeFromString<List<Item>>(content)
}

fun readFromFileBooks(file: File): List<Book>{
    val content = file.readText().trim()
    return Json.decodeFromString<List<Book>>(content)
}