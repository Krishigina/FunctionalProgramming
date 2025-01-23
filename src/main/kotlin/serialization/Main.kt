package serialization

import kotlinx.serialization.json.Json

fun main() {
    fun serializeUser(user: User): String {
        return Json.encodeToString(user)
    }

    fun deserializeUser(json: String): User {
        return Json.decodeFromString<User>(json)
    }
}