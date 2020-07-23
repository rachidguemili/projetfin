package com.projetfin.projetfin.checkpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/checkpoints")
@CrossOrigin
public class CheckpointController {


		@Autowired CheckpointService checkpointService;

}
