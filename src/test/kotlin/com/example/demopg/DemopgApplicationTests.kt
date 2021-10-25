package com.example.demopg

import com.example.demopg.repository.entitys.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.boot.test.web.client.postForObject
import org.springframework.http.HttpStatus

@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
	properties = [
		"spring.datasource.url=jdbc:h2:mem:testdb"
	]
)
class DemopgApplicationTests(@Autowired val client: TestRestTemplate) {

	@Test
	fun `test creat user`() {
		val user = User("Joel", "Lima","Just Testing",null,null)
		val response = client.postForEntity<String>("/users/create",user)
		assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(response.body).contains(user.firstname)
	}

	@Test
	fun `test creat and get`(){
		val id:Long = 19

		val user = User("Test","Gonzales", "Esto es un test",null,id.toLong())
		val user2 = User("Test2","Gonzales2", "Esto es un test",null,null)
		val user3 = User("Test3","Gonzales3", "Esto es un test",null,null)
		val created_user = client.postForObject<User>("/users/create",user)
		client.postForObject<User>("/users/create",user2)
		client.postForObject<User>("/users/create",user3)

		val getEntity = client.getForEntity<String>("/users/${created_user?.id}")
		assertThat(getEntity.statusCode).isEqualTo(HttpStatus.OK)
		assertThat(getEntity.body).contains(created_user?.id.toString())
		assertThat(getEntity.body).contains(created_user?.firstname)

	}

}
