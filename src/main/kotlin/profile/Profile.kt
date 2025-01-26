package profile

fun main() {
    val profiles = ProfilesRepository.profiles
        .filter { it.age > 25 }
        .filter { it.firstName.startsWith("A") }
        .filter { it.gender.equals(Gender.MALE) }
        .transform { it.copy(age = it.age + 1) }
    for (person in profiles) {
        println(person)
    }
}

fun <R> List<Person>.transform(operation: (Person) -> R): List<R> {
    val result = mutableListOf<R>()
    for (person in this) {
        result.add(operation(person))
    }
    return result
}

fun List<Person>.filter(isSuitable: (Person) -> Boolean): List<Person> {
    val result = mutableListOf<Person>()
    for (person in this) {
        if (isSuitable(person)) {
            result.add(person)
        }
    }
    return result
}