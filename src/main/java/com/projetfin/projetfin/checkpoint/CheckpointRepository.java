package com.projetfin.projetfin.checkpoint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckpointRepository  extends JpaRepository<Checkpoint,Long> {
}
