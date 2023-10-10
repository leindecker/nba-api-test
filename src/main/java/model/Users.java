package model;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class Users {

    private Long id;

    private String name;

    private String email;

    private String gender;

    private String status;
}
