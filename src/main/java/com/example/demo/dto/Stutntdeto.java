package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stutntdeto {

    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    private int age;
    private String password;

}
