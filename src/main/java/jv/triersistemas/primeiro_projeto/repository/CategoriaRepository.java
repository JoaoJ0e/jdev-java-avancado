package jv.triersistemas.primeiro_projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
}
