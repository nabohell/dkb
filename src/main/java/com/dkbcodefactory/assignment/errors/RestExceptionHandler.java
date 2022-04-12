package com.dkbcodefactory.assignment.errors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ApiErrorResponse> handle(NotFoundException e) {
		return generateResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ApiErrorResponse> handle(Exception e) {
		return generateResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ServerException.class)
	protected ResponseEntity<ApiErrorResponse> handle(ServerException e) {
		return generateResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidRequestException.class)
	protected ResponseEntity<ApiErrorResponse> handle(InvalidRequestException e) {
		return generateResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	private ResponseEntity generateResponseEntity(String message, HttpStatus httpStatus) {
		ApiErrorResponse error = new ApiErrorResponse();
		error.setError(message);

		return new ResponseEntity(error, httpStatus);
	}



	public class ApiErrorResponse {
		private String error;

		public ApiErrorResponse() {
			super();
		}

		public String getError() {
			return error;
		}

		public void setError(String message) {
			this.error = message;
		}


	}
}