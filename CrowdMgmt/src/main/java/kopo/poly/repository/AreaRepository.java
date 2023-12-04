package kopo.poly.repository;

import kopo.poly.repository.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, String> {

    List<AreaEntity> findAllByOrderByLocation();
}
