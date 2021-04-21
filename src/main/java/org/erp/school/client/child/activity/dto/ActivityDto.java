package org.erp.school.client.child.activity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.erp.school.client.child.activity.Activity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActivityDto {
  private String id;

  @NotBlank private String referencing;

  @NotBlank
  @Size(max = 255, message = "Exceeded short description limit")
  private String shortDescription;

  private String description;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Timestamp created;

  @NotBlank private String createdBy;

  public static ActivityDto fromEntity(Activity entity) {
    return ActivityDto.builder()
        .created(entity.getCreated())
        .createdBy(entity.getCreatedBy().getUsername())
        .description(entity.getDescription())
        .shortDescription(entity.getShortDescription())
        .referencing(entity.getReferencing())
        .id(entity.getId())
        .build();
  }
}
