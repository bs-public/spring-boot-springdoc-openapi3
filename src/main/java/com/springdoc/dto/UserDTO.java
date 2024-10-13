package com.springdoc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Data Transfer Object for User information")
public class UserDTO {

  @Schema(
      description = "The auto-generated unique id of the user",
      accessMode = Schema.AccessMode.READ_ONLY)
  private Long id;

  @NotBlank
  @Schema(description = "The name of the user", requiredMode = Schema.RequiredMode.REQUIRED)
  private String name;

  @Email
  @Schema(description = "The email of the user", requiredMode = Schema.RequiredMode.REQUIRED)
  private String email;
}
