package profile

fun main() {
    val profiles = ProfilesRepository.profiles
    for (person in profiles){
        println(person)
    }
}