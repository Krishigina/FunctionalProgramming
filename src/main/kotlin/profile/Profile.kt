package profile

fun main() {
    val profiles = ProfilesRepository.profiles
    var filtered = filter(profiles) { it.age > 25 }
    filtered = filter(filtered) { it.firstName.startsWith("A") }
    filtered = filter(filtered) { it.gender.equals(Gender.MALE) }
    for (person in filtered) {
        println(person)
    }
}

fun filter(profiles: List<Person>, isSuitable: (Person) -> Boolean): List<Person> {
    val result = mutableListOf<Person>()
    for (person in profiles) {
        if (isSuitable(person)) {
            result.add(person)
        }
    }
    return result
}