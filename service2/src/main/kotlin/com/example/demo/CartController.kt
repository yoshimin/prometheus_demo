package com.example.demo

import org.springframework.http.HttpEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cart")
class CartController(private val repository: CartRepository) {
    @PostMapping("/add")
    fun add(@RequestBody item: Item): HttpEntity<Item> {
        val item = repository.save(item)
        return HttpEntity<Item>(item)
    }

    @PostMapping("/{id}/remove")
    fun remove(@PathVariable id: Long): HttpEntity<Int> {
        repository.deleteById(id)
        return HttpEntity<Int>(200)
    }
}
