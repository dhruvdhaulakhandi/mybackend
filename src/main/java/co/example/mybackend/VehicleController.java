package co.example.mybackend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin(origins = "*")
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    // Naya vehicle add karo
    @PostMapping
    public ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle) {
        if (vehicle.getBrand() == null || vehicle.getBrand().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Brand khaali nahi ho sakta");
        }
        if (vehicle.getModel() == null || vehicle.getModel().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Model khaali nahi ho sakta");
        }
        if (vehicle.getPrice() <= 0) {
            return ResponseEntity.badRequest().body("Price 0 se zyada hona chahiye");
        }
        if (vehicle.getYear() < 1900 || vehicle.getYear() > 2100) {
            return ResponseEntity.badRequest().body("Year sahi nahi hai");
        }
        return ResponseEntity.ok(vehicleRepository.save(vehicle));
    }

    // Sabhi vehicles dekho
    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Sirf "for sale" wale vehicles dekho
    @GetMapping("/forsale")
    public List<Vehicle> getForSaleVehicles() {
        return vehicleRepository.findAll().stream()
                .filter(Vehicle::isForSale)
                .toList();
    }

    // Ek specific vehicle ki detail (comparison/parts page ke liye)
    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }
}
