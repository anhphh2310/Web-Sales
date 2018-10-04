package tma.datraining.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import tma.datraining.exception.BadRequestException;
import tma.datraining.exception.NotFoundDataException;
import tma.datraining.model.ResponseMsg;

@RestControllerAdvice
public class BaseController {

	private static final String NOT_FOUND_DATA = " exist in the database.";
	private static final String BAD_REQUEST = "Wrong something in request";
	
//	private static final Logger LOG  = LoggerFactory.getLogger(BaseController.class);
	
	@ExceptionHandler(NotFoundDataException.class)
	public ResponseEntity<ResponseMsg> notFoundData(NotFoundDataException ex, WebRequest re){
		ResponseMsg res = new ResponseMsg(HttpStatus.NOT_FOUND,ex.getMessage() + NOT_FOUND_DATA,re.getDescription(false));
		return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ResponseMsg> badRequest(BadRequestException ex, WebRequest re){
		ResponseMsg res = new ResponseMsg(HttpStatus.BAD_REQUEST, BAD_REQUEST, re.getDescription(false));
		return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
	}
	
}
