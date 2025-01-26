package extensionFunctions
import javax.swing.JLabel
import java.awt.Color

fun exampleWith(){
    with(mutableListOf<Int>()){
        while (true){
            print("Enter number or 0 to exit: ")
            val number = readln().toInt().takeIf {it != 0} ?: break
            add(number)
        }
        println("Max: ${max()}")
        println("Min: ${min()}")
        this
    }.forEach {println(it)}
}

fun exampleApply(){
    mutableListOf<Int>().apply {
        while (true){
            print("Enter number or 0 to exit: ")
            val number = readln().toInt().takeIf {it != 0} ?: break
            add(number)
        }
        println("Max: ${max()}")
        println("Min: ${min()}")
    }.forEach {println(it)}
}

fun formatText(title: String, body: List<String>, footer: String): String {
    require(title.isNotBlank()) { "Title must not be blank" }
    require(body.isNotEmpty()) { "Body must contain at least one paragraph" }
    require(footer.isNotBlank()) { "Footer must not be blank" }

    val debugKeyword = "debug"
    val oldHeader = "=== Начало текста ==="
    val newHeader = "=== Новый заголовок ==="
    val maxTextLength = 500

    return with(StringBuilder()){

        this.append("=== $title ===\n")
        body.forEach { paragraph -> this.append("$paragraph\n") }
        this.append("--- $footer ---\n")

        this.insert(0, "\n$oldHeader\n")
        this.append("\n=== Конец текста ===")

        val debugIndex = this.indexOf(debugKeyword)
        if (debugIndex != -1) {
            this.delete(debugIndex, debugIndex + debugKeyword.length)
        }

        val oldHeaderIndex = this.indexOf(oldHeader)
        if (oldHeaderIndex != -1) {
            this.replace(oldHeaderIndex, oldHeaderIndex + oldHeader.length, newHeader)
        }

        if (this.length > maxTextLength) {
            this.setLength(maxTextLength)
        }
        this
    }.toString()
}

fun main() {
    // Пример 1: Настройка объекта с помощью прямых вызовов
    val labelDirect = JLabel()
    labelDirect.text = "Hello, World!"
    labelDirect.font = labelDirect.font.deriveFont(16f)
    labelDirect.foreground = Color.BLUE

    // Пример 2: Настройка объекта с помощью функции `with`
    val labelWith = JLabel()
    with(labelWith) {
        text = "Hello, World!"
        font = font.deriveFont(16f)
        foreground = Color.BLUE
    }

    // Пример 3: Настройка объекта с помощью функции `also`
    val labelAlso = JLabel().also { label ->
        label.text = "Hello, World!"
        label.font = label.font.deriveFont(16f)
        label.foreground = Color.BLUE
    }

    // Пример 4: Настройка объекта с помощью функции `let`
    val labelLet = JLabel().let { label ->
        label.text = "Hello, World!"
        label.font = label.font.deriveFont(16f)
        label.foreground = Color.BLUE
        label // Возвращаем объект
    }

    val labelApply = JLabel().apply {
        text = "Hello, World!"
        font = font.deriveFont(16f)
        foreground = Color.BLUE
    }

    println(labelDirect)
    println(labelWith)
    println(labelAlso)
    println(labelLet)
    println(labelApply)
}