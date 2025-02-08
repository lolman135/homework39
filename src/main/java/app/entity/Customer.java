package app.entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Long id;
    private String fullName;
    private String email;
    private int socialSecurityNumber;

    public Customer(String fullName, Long id, int socialSecurityNumber) {
        this.fullName = fullName;
        this.id = id;
        this.socialSecurityNumber = socialSecurityNumber;
    }
}
