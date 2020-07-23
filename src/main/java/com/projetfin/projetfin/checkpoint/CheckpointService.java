package com.projetfin.projetfin.checkpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckpointService {

	@Autowired CheckpointRepository checkpointRepository;

}
