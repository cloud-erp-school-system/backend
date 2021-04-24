package org.erp.school.activity.controller;

import io.swagger.annotations.Api;
import org.erp.school.activity.dto.ActivityDto;
import org.erp.school.activity.service.ActivityService;
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

  @GetMapping("request/{requestId}/activity/{category}")
  public ResponseEntity<Page<ActivityDto>> getAllRequestActivity(
      @PathVariable String requestId, @PathVariable String category, Pageable pageable) {
    return ResponseEntity.ok(activityService.getAllRequestActivity(requestId, category, pageable));
  }

  @GetMapping("activity/{activityId}")
  public ResponseEntity<ActivityDto> getRequestActivity(@PathVariable String activityId) {
    return ResponseEntity.ok(activityService.getActivity(activityId));
  }

  @PostMapping("request/{requestId}/activity/{category}")
  public ResponseEntity<ActivityDto> postRequestActivity(
      @PathVariable String requestId,
      @PathVariable String category,
      @RequestBody @Valid ActivityDto dto) {
    return ResponseEntity.created(activityService.saveRequestActivity(requestId, category, dto))
        .build();
  }

  @GetMapping("user/{username}/activity/{category}")
  public ResponseEntity<Page<ActivityDto>> getAllUserActivity(
      @PathVariable String username, @PathVariable String category, Pageable pageable) {
    return ResponseEntity.ok(activityService.getAllUserActivity(username, category, pageable));
  }
}
