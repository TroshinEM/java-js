package equipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;
import java.util.Map;
@Controller

@RequestMapping(path="/equipment")
public class MainController {
    @Autowired
    private EquipmentRepository EquipmentRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewEquipment (@RequestBody Map<String,String> params) {
        String model = params.get("model").toString();
        String serial = params.get("serial").toString();


        EquipmentTable n = new EquipmentTable();
        n.setModel(model);
        n.setSerial(serial);
        EquipmentRepository.save(n);
        return "Saved";
    }

    @PostMapping(path = "/delete")
    public @ResponseBody String delEquipment (@RequestBody Map<String,String> params) {
        String ids = params.get("id").toString();
        Integer id = Integer.parseInt(ids);
        EquipmentRepository.deleteById(id);
        return "Deleted";
    }

    @PostMapping(path = "/update_model")
    public @ResponseBody String updateEquipment (@RequestBody Map<String,String> params) {
        String ids = params.get("id").toString();
        String model = params.get("model").toString();
        Integer id = Integer.parseInt(ids);
        EquipmentTable n = EquipmentRepository.findById(id).get();
        n.setModel(model);
        EquipmentRepository.save(n);
        return "Updated";
    }

    @PostMapping(path = "/update_serial")
    public @ResponseBody String updateSerial (@RequestBody Map<String,String> params) {
        String ids = params.get("id").toString();
        String serial = params.get("serial").toString();
        Integer id = Integer.parseInt(ids);
        EquipmentTable n =EquipmentRepository.findById(id).get();
        n.setSerial(serial);
        EquipmentRepository.save(n);
        return "Updated";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<EquipmentTable> getAllEquipment() {
        return EquipmentRepository.findAll();
    }


};

