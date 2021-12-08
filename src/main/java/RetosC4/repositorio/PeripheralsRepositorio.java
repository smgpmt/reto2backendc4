/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosC4.repositorio;

import RetosC4.interfaces.InterfacePeripherals;
import RetosC4.modelo.Peripherals;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author HP
 */
@Repository
public class PeripheralsRepositorio {
    @Autowired 
    private InterfacePeripherals interfacePeripherals;
    
    public List<Peripherals>getAll() {
        return interfacePeripherals.findAll();
    }
    public Optional<Peripherals> getPeripherals(String reference) {
        return interfacePeripherals.findById(reference);
    }
    
    public Peripherals create(Peripherals peripherals){
        return interfacePeripherals.save(peripherals);
    }
    public void update(Peripherals peripherals){
       interfacePeripherals.save(peripherals);
    }
    public void delete(Peripherals peripherals){
       interfacePeripherals.delete(peripherals);
    }
}
