package surajitg.mfanalytics.api;

import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  public static final String TRACE = "trace";

  @Value("${reflectoring.trace:false}")
  private boolean printStackTrace;

  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public ResponseEntity<Object> handleMethodArgumentNotValid(
    MethodArgumentNotValidException ex,
    HttpHeaders headers,
    HttpStatus status,
    WebRequest request
  ) {
    return new ResponseEntity<Object>("Invalid Parameters, please validate", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<Object> handleExceptionInternal(
      RuntimeException exception, 
      WebRequest request
  ){
    return new ResponseEntity<Object>("Sorry, We ran into an issue. Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
      //Body omitted as it's similar to the method of same name
      // in ProductController example...  
      //.....
  }

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> handleEntityNotFoundException(
    RuntimeException exception,
    WebRequest request
  ) {
    return new ResponseEntity<Object>("No Data Found", HttpStatus.NOT_FOUND);
  }


}

