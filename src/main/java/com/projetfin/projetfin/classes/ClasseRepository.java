package com.projetfin.projetfin.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository  extends JpaRepository<Classe,Long> {

}
