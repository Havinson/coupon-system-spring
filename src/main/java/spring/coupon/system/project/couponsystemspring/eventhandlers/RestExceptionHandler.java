package spring.coupon.system.project.couponsystemspring.eventhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import spring.coupon.system.project.couponsystemspring.entinies.ApiError;
import spring.coupon.system.project.couponsystemspring.exception.CouponSystemException;

//@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<Object> handleThrowable(Throwable throwable) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
		return new ResponseEntity<Object>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CouponSystemException.class)
	public ResponseEntity<Object> handleCouponSystemException(CouponSystemException exception) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
		return new ResponseEntity<Object>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handleMethodArgumentException(MethodArgumentTypeMismatchException exception) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getValue() + " is illegal value for "
				+ exception.getName() + ". A value of type " + exception.getRequiredType() + " is expected.");
		return new ResponseEntity<Object>(apiError, HttpStatus.BAD_REQUEST);
	}
}
