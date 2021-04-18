package org.erp.school.client.child.activity.controller;

import io.swagger.annotations.Api;
import org.erp.school.client.child.activity.dto.ActivityDto;
import org.erp.school.client.child.activity.service.ActivityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api
public class ActivityController {

  private final ActivityService activityService;

  public ActivityController(ActivityService activityService) {
    this.activityService = activityService;
  }

  @GetMapping("client/{clientId}/request/{requestId}/activity/{category}")
  public ResponseEntity<Page<ActivityDto>> getAllRequestActivity(
      @PathVariable String clientId,
      @PathVariable String requestId,
      @PathVariable String category,
      Pageable pageable) {
    return ResponseEntity.ok(
        activityService.getAllRequestActivity(clientId, requestId, category, pageable));
  }

  @GetMapping("client/{clientId}/request/{requestId}/activity/{activityId}")
  public ResponseEntity<ActivityDto> getRequestActivity(
      @PathVariable String clientId,
      @PathVariable String requestId,
      @PathVariable String activityId) {
    return ResponseEntity.ok(activityService.getRequestActivity(clientId, requestId, activityId));
  }

  @PostMapping("client/{clientId}/request/{requestId}/activity/{category}")
  public ResponseEntity<ActivityDto> postRequestActivity(
      @PathVariable String clientId,
      @PathVariable String requestId,
      @PathVariable String category,
      @RequestBody @Valid ActivityDto dto) {
    return ResponseEntity.created(
            activityService.saveRequestActivity(clientId, requestId, category, dto))
        .build();
  }

  @GetMapping("user/{username}/activity/{category}")
  public ResponseEntity<Page<ActivityDto>> getAllUserActivity(
      @PathVariable String username, @PathVariable String category, Pageable pageable) {
    return ResponseEntity.ok(activityService.getAllUserActivity(username, category, pageable));
  }

  @GetMapping("user/{username}/activity/{activityId}")
  public ResponseEntity<ActivityDto> getUserActivity(
      @PathVariable String username, @PathVariable String activityId) {
    return ResponseEntity.ok(activityService.getUserActivity(username, activityId));
  }
}
