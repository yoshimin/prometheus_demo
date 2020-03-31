package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/cart")
class CartController {
    private val webclient = WebClient.create("http://localhost:8082")

    @PostMapping("/add/{item}")
    fun add(@PathVariable item: Item): Mono<HttpStatus> {
        return webclient
                .post()
                .uri("cart/add")
                .bodyValue(CartItem(name = item.name))
                .exchange()
                .map { HttpStatus.OK }
    }

    @PostMapping("/remove")
    fun remove(@RequestParam id: Long): Mono<HttpStatus> {
        return webclient
                .get()
                .uri { it.path("cart/remove").queryParam("id", id).build() }
                .exchange()
                .map { HttpStatus.OK }
    }
}
