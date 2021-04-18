package org.erp.school.client.child.activity.service;

import org.erp.school.client.child.activity.dto.ActivityDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface ActivityService {
  Page<ActivityDto> getAllRequestActivity(
      String clientId, String requestId, String category, Pageable pageable);

  Page<ActivityDto> getAllUserActivity(String username, String category, Pageable pageable);

  ActivityDto getRequestActivity(String clientId, String requestId, String activityId);

  ActivityDto getUserActivity(String username, String activityId);

  URI saveRequestActivity(String clientId, String requestId, String category, ActivityDto dto);
}
