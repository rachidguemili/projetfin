package com.projetfin.projetfin.chapters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository  extends JpaRepository<Chapter,Long> {
}
