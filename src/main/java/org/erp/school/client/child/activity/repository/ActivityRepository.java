package org.erp.school.client.child.activity.repository;

import org.erp.school.client.child.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, String> {
}
