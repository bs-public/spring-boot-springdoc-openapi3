package com.springdoc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Data Transfer Object for User information")
public class UserDTO {

  @Schema(
      description = "The auto-generated unique id of the user",
      accessMode = Schema.AccessMode.READ_ONLY)
  private Long id;

  @Schema(description = "The name of the user")
  private String name;

  @Schema(description = "The email of the user")
  private String email;
}
