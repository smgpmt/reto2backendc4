/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosC4.controlador;

import RetosC4.modelo.Peripherals;
import RetosC4.servicio.PeripheralsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HP    
 */
@RestController
@RequestMapping("/api/peripherals")
@CrossOrigin("*")
public class PeripheralsController {
    @Autowired
    private PeripheralsService peripheralsService;
        
    @GetMapping("/all")
    public List<Peripherals> getAll(){
        return peripheralsService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional <Peripherals> getPeripherals(@PathVariable("reference") String reference) {
        return peripheralsService.getPeripherals(reference);
    }
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripherals create (@RequestBody Peripherals user) {
        return peripheralsService.create(user);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripherals update (@RequestBody Peripherals user) {
        return peripheralsService.update(user);
    }
    
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return peripheralsService.delete(reference);
    }
    
}
    
    

