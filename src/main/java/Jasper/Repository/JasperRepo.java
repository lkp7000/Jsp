package Jasper.Repository;

import Jasper.Entity.JasperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JasperRepo extends JpaRepository<JasperEntity,Long> {
}
