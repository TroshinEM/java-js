package equipment;
import org.springframework.data.repository.CrudRepository;

import equipment.EquipmentTable;

// This will be AUTO IMPLEMENTED by Spring into a Bean called EquipmentRepository
// CRUD refers Create, Read, Update, Delete

public interface EquipmentRepository extends CrudRepository<EquipmentTable, Integer> {

}