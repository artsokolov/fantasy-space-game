package com.motycka.edu.game.match

import com.motycka.edu.game.match.rest.CreateMatchRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/matches")
class MatchController {

    @PostMapping
    fun postMatch(
        @RequestBody request: CreateMatchRequest
    ): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.CREATED).body({})
    }
}