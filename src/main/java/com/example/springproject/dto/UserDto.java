package com.example.springproject.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDto(
        @NotBlank(message = "Ad hissesi bosh qala bilmez")
        @Size(min = 3)
                @NotNull(message = "Ad hissesi bosh qala bilmez")
        String name,

        @Min(value = 10,message = "Age 10 dan kicik ola bilmez")
        int age) {

}
