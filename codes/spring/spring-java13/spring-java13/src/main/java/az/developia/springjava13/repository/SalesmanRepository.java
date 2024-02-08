package az.developia.springjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springjava13.component.SalesmanEntity;

public interface SalesmanRepository extends JpaRepository<SalesmanEntity,Integer> {

}
