package org.erp.school.client.child.activity.service.impl;

import org.erp.school.client.child.activity.Activity;
import org.erp.school.client.child.activity.dto.ActivityDto;
import org.erp.school.client.child.activity.enums.ActivityCategory;
import org.erp.school.client.child.activity.exception.ActivityNotFoundException;
import org.erp.school.client.child.activity.exception.InvalidActivityCategoryException;
import org.erp.school.client.child.activity.repository.ActivityRepository;
import org.erp.school.client.child.activity.service.ActivityService;
import org.erp.school.client.child.user.User;
import org.erp.school.client.child.user.exception.UserNotFoundException;
import org.erp.school.client.child.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class DefaultActivityService implements ActivityService {

  private final ActivityRepository activityRepository;
  private final UserRepository userRepository;

  public DefaultActivityService(
      ActivityRepository activityRepository, UserRepository userRepository) {
    this.activityRepository = activityRepository;
    this.userRepository = userRepository;
  }

  @Override
  public Page<ActivityDto> getAllRequestActivity(
      String requestId, String category, Pageable pageable) {
    var activityCategory = parseCategory(category);
    return new PageImpl<>(
        activityRepository
            .findAllByReferencingAndCategory(requestId, activityCategory, pageable)
            .stream()
            .map(ActivityDto::fromEntity)
            .collect(Collectors.toList()),
        pageable,
        activityRepository.countByReferencingAndCategory(requestId, activityCategory));
  }

  @Override
  public Page<ActivityDto> getAllUserActivity(String username, String category, Pageable pageable) {
    var activityCategory = parseCategory(category);
    var createdBy =
        getUser(username);
    return new PageImpl<>(
        activityRepository
            .findAllByCreatedByAndCategory(createdBy, activityCategory, pageable)
            .stream()
            .map(ActivityDto::fromEntity)
            .collect(Collectors.toList()),
        pageable,
        activityRepository.countByCreatedByAndCategory(createdBy, activityCategory));
  }

  @Override
  public ActivityDto getActivity(String id) {
    var activity =
        activityRepository
            .findById(id)
            .orElseThrow(
                () -> new ActivityNotFoundException("Cannot find activity with id: " + id));
    return ActivityDto.fromEntity(activity);
  }

  @Override
  public URI saveRequestActivity(String requestId, String category, ActivityDto dto) {
    var user = getUser(dto.getCreatedBy());
    var activity =
        activityRepository.save(
            Activity.builder()
                .id(dto.getId())
                .category(parseCategory(category))
                .created(Timestamp.from(Instant.now()))
                .createdBy(user)
                .description(dto.getDescription())
                .referencing(dto.getReferencing())
                .shortDescription(dto.getShortDescription())
                .build());
    return ServletUriComponentsBuilder.fromCurrentRequest()
        .path("activity")
        .buildAndExpand(activity.getId())
        .toUri();
  }

  private ActivityCategory parseCategory(String category) {
    try {
      return ActivityCategory.valueOf(category);
    } catch (Exception e) {
      throw new InvalidActivityCategoryException("Category " + category + " does not exist");
    }
  }

  private User getUser(String username) {
    return userRepository
        .findById(username)
        .orElseThrow(
            () -> new UserNotFoundException("Cannot find user with username: " + username));
  }
}
