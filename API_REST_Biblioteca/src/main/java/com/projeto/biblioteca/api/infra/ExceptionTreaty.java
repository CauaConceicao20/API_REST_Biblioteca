package com.projeto.biblioteca.api.infra;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionTreaty {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> zookeeperEntityNotFoundException() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> zookeeperMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		var erro = ex.getFieldErrors();
		
		return ResponseEntity.badRequest().body(erro.stream().map(DataErros::new).toList());
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?>zookeeperHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		String message = "Os campos obrigatórios estão vazios";
		return ResponseEntity.badRequest().body(new ErrorMessage(message));
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> zookeeperNoSuchElementException(NoSuchElementException ex) {
		return ResponseEntity.notFound().build();
	}
	
	public record DataErros(String message, String field) {
		
		public DataErros(FieldError erro) {
			this(erro.getDefaultMessage(), erro.getField());
		}	
	}
	
    public static class ErrorMessage {
        private final String Message;


        public ErrorMessage(String message) {
            this.Message = message;
        }

        public String getMessage() {
            return Message;
        }
        	
    }

}
