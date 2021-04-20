package org.erp.school.client.child.activity.repository;

import org.erp.school.client.child.activity.Activity;
import org.erp.school.client.child.activity.enums.ActivityCategory;
import org.erp.school.client.child.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, String> {
  Page<Activity> findAllByReferencingAndCategory(
      String referencing, ActivityCategory category, Pageable pageable);

  long countByReferencingAndCategory(String referencing, ActivityCategory category);

  Page<Activity> findAllByCreatedByAndCategory(
      User user, ActivityCategory category, Pageable pageable);

  long countByCreatedByAndCategory(User user, ActivityCategory category);
}
