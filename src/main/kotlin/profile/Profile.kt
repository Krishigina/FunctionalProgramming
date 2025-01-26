package profile

import extensions.transform
import extensions.filter

fun main() {
    ProfilesRepository.profiles
        .filter { it.age > 25 }
        .filter { it.firstName.startsWith("A") }
        .filter { it.gender.equals(Gender.MALE) }
        .transform { it.copy(age = it.age + 1) }
        .sortedBy { it.firstName }
        .forEach({ println(it) })
    showEmail()

}

fun showEmail() {
    print("Введите id пользователя: ")
    val id = readln().toInt()
    ProfilesRepository.profiles.find { it.id == id }?.let { println(it.email) } ?: println("Пользователь не найден")
}


