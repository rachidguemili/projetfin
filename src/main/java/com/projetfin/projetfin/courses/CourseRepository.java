package com.projetfin.projetfin.courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends  JpaRepository<Course,Long> {
}
