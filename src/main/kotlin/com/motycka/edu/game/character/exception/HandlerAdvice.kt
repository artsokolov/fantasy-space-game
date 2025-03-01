package com.motycka.edu.game.character.exception

import com.motycka.edu.game.character.CharacterController
import com.motycka.edu.game.error.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice(assignableTypes = [CharacterController::class])
class HandlerAdvice {

    @ExceptionHandler(UnknownCharacterClass::class)
    fun handleUnknownCharacterClass(e: UnknownCharacterClass): ResponseEntity<ErrorResponse> {
        val code = HttpStatus.UNPROCESSABLE_ENTITY

        return ResponseEntity.status(code).body(ErrorResponse(
            e.message ?: "Unknown error",
            code.value()
        ))
    }

    @ExceptionHandler(CharacterNotFoundException::class)
    fun handleCharacterNotFound(e: CharacterNotFoundException): ResponseEntity<ErrorResponse> {
        val code = HttpStatus.NOT_FOUND

        return ResponseEntity.status(code).body(ErrorResponse(
            e.message ?: "Unknown error",
            code.value()
        ))
    }
}