package mapCollections

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("email") val email: String,
    @SerialName("age") val age: Int,
    @SerialName("is_active") val isActive: Boolean,
    @SerialName("address") val address: String,
    @SerialName("phone") val phone: String,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("role") val role: String
)

/**
 * Преобразует список пользователей в Map, где ключ — `id`, а значение — объект `User`.
 * @param users Список пользователей.
 * @return Коллекция Map пользователей.
 */
fun usersToMap(users: List<User>): Map<Int, User> {
//    val result = mutableMapOf<Int, User>()
//    for (user in users){
//        result[user.id] = user
//    }
//    return result
    return users.associateBy { it.id }
}