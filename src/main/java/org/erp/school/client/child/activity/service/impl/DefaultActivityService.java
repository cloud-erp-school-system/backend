package org.erp.school.client.child.activity.service.impl;

import org.erp.school.client.child.activity.dto.ActivityDto;
import org.erp.school.client.child.activity.repository.ActivityRepository;
import org.erp.school.client.child.activity.service.ActivityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class DefaultActivityService implements ActivityService {

  private final ActivityRepository activityRepository;

  public DefaultActivityService(ActivityRepository activityRepository) {
    this.activityRepository = activityRepository;
  }

  @Override
  public Page<ActivityDto> getAllRequestActivity(
      String clientId, String requestId, String category, Pageable pageable) {
    return null;
  }

  @Override
  public Page<ActivityDto> getAllUserActivity(String username, String category, Pageable pageable) {
    return null;
  }

  @Override
  public ActivityDto getRequestActivity(String clientId, String requestId, String activityId) {
    return null;
  }

  @Override
  public ActivityDto getUserActivity(String username, String activityId) {
    return null;
  }

  @Override
  public URI saveRequestActivity(
      String clientId, String requestId, String category, ActivityDto dto) {
    return null;
  }
}
