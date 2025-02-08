package app.dto.customer.response;

import org.springframework.http.HttpStatus;

public record CustomerDtoDeleteResponse(

        int statusCode,
        String reasonPhrase,
        boolean success,
        String message) {

    public static final String SUCCESS_MESSAGE = "Customer with id %s has been deleted successfully.";
    public static final String FAILURE_MESSAGE = "Customer with id %s has not been found!";

    public static CustomerDtoDeleteResponse of(Long id, boolean isUserFound) {
        if (isUserFound)
            return new CustomerDtoDeleteResponse(
                    HttpStatus.OK.value(),
                    HttpStatus.OK.getReasonPhrase(),
                    true, SUCCESS_MESSAGE.formatted(id));
        else
            return new CustomerDtoDeleteResponse(
                    HttpStatus.NOT_FOUND.value(),
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    false, FAILURE_MESSAGE.formatted(id));
    }
}
