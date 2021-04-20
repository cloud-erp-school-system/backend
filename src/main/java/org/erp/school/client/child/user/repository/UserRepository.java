package org.erp.school.client.child.user.repository;

import org.erp.school.client.child.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {}
