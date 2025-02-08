package app.dto.customer.response;

import app.entity.Customer;
import org.springframework.http.HttpStatus;

public record CustomerDtoUpdateResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        Customer customer) {

    public static final String SUCCESS_MESSAGE = "User with id %s has been updated successfully.";
    public static final String FAILURE_MESSAGE = "User with id %s has not been found!";

    public static CustomerDtoUpdateResponse of(Long id, boolean isUserFound, Customer customerUpdated) {
        if (isUserFound)
            return new CustomerDtoUpdateResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true, SUCCESS_MESSAGE.formatted(id), customerUpdated);
        else
            return new CustomerDtoUpdateResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false, FAILURE_MESSAGE.formatted(id), null);
    }
}
