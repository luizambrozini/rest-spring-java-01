package br.tec.lvconsult.repositories;

import br.tec.lvconsult.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRespository extends JpaRepository<Person, Long> {
}
