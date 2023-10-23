package model;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class Posts {

    private String title;

    private String body;
}
