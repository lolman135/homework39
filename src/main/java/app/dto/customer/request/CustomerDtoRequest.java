package app.dto.customer.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerDtoRequest(Long id, String fullName, String email, int socialSecurityNumber) {
}
