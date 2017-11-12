package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.Lieu;
@Transactional
public interface LieuDao extends JpaRepository<Lieu, Long> {

}
