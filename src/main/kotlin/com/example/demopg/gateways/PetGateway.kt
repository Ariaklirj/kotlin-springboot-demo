package com.example.demopg.gateways

import com.example.demopg.entities.Animal
import com.example.demopg.entities.PetDescription
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import java.net.URI

         @Component
class PetGateway(
    private val template: RestTemplate
) {
    
    companion object {
        const val key = "PP7yO0gNd99JaIzGnbSWWeaB0mgh0uTxlnni8JG9B2h9DjtWAu"
        const val secret = "dA7FwIGhYUjA9noiNl1JKbH2QGV0Q0F3BYaqDoES"
        const val grant = "client_credentials"
        
        const val authUrl = "https://api.petfinder.com/v2/oauth2/token"
        const val petByIdUrl = "https://api.petfinder.com/v2/animals/"
    }
    
    fun findPetDescriptionById(apiPetId: String): PetDescription {
        val token = authenticate()
        return template.exchange(
            URI.create(petByIdUrl + apiPetId),
            HttpMethod.GET,
            authHeaders(token),
            Animal::class.java
        ).body!!.animal
    }
    
    private fun authenticate(): String {
        val auth = template.postForObject(URI.create(authUrl), authRequest(), Auth::class.java)
        return auth!!.access_token
    }
    
    private fun authRequest(): HttpEntity<MultiValueMap<String, String>> {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_FORM_URLENCODED
        
        val map: MultiValueMap<String, String> = LinkedMultiValueMap()
        map.add("grant_type", grant)
        map.add("client_id", key)
        map.add("client_secret", secret)
        
        return HttpEntity(map, headers)
    }
    
    private fun authHeaders(token: String): HttpEntity<MultiValueMap<String, String>> {
        val headers = HttpHeaders()
        headers.setBearerAuth(token)
        
        return HttpEntity(LinkedMultiValueMap(), headers)
    }
}

data class Auth(
    val token_type: String,
    val expires_in: Long,
    val access_token: String
)
