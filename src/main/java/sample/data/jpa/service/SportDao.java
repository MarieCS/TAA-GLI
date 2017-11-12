package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.Sport;

@Transactional
public interface SportDao extends JpaRepository<Sport, Long> {

}