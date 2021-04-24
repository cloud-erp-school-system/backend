package org.erp.school.activity.service;

import org.erp.school.activity.dto.ActivityDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface ActivityService {
  Page<ActivityDto> getAllRequestActivity(String requestId, String category, Pageable pageable);

  Page<ActivityDto> getAllUserActivity(String username, String category, Pageable pageable);

  ActivityDto getActivity(String id);

  URI saveRequestActivity(String requestId, String category, ActivityDto dto);
}
