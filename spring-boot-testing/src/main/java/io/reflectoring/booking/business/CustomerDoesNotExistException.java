package io.reflectoring.booking.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CustomerDoesNotExistException extends RuntimeException {
	Logger log = LoggerFactory.getLogger(this.getClass());

  CustomerDoesNotExistException(Long customerId) {
    super(String.format("A customer with ID '%d' doesn't exist!", customerId));
    log.info("Inside CustomerDoesNotExistException constructor....");
  }

}
