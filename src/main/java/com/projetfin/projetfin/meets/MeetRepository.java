package com.projetfin.projetfin.meets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetRepository  extends JpaRepository<Meet,Long> {
}
