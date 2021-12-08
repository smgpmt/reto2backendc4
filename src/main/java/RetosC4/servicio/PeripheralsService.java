/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetosC4.servicio;

import RetosC4.modelo.Peripherals;
import RetosC4.repositorio.PeripheralsRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class PeripheralsService {
    @Autowired
    private PeripheralsRepositorio peripheralsRepositorio;

    public List<Peripherals> getAll(){
        return peripheralsRepositorio.getAll();
    }

    public Optional<Peripherals> getPeripherals(String reference) {
        return peripheralsRepositorio.getPeripherals(reference);
    }
    
    public Peripherals create(Peripherals peripherals){
        if(peripherals.getReference() == null) {
            return peripherals;
        }else{
            return peripheralsRepositorio.create(peripherals);
        }
    }

    public Peripherals update(Peripherals peripherals) {

        if (peripherals.getReference() != null) {
            Optional<Peripherals> peripheralsDb = peripheralsRepositorio.getPeripherals(peripherals.getReference());
            if (!peripheralsDb.isEmpty()) {
                if (peripherals.getBrand() != null) {
                    peripheralsDb.get().setBrand(peripherals.getBrand());
                }
                if (peripherals.getCategory() != null) {
                    peripheralsDb.get().setCategory(peripherals.getCategory());
                }
                if (peripherals.getDescription() != null) {
                    peripheralsDb.get().setDescription(peripherals.getDescription());
                }
                if (peripherals.getPrice() != 0.0) {
                    peripheralsDb.get().setPrice(peripherals.getPrice());
                }
                if (peripherals.getPrice() != 0.0) {
                    peripheralsDb.get().setPrice(peripherals.getPrice());
                }
                if (peripherals.getQuantity() != 0) {
                   peripheralsDb.get().setQuantity(peripherals.getQuantity());
                }
                if (peripherals.getPhotography() != null) {
                   peripheralsDb.get().setPhotography(peripherals.getPhotography());
                }
                peripheralsDb.get().setAvailability(peripherals.isAvailability());
                peripheralsRepositorio.update(peripheralsDb.get());
                return peripheralsDb.get();
            } else {
                return peripherals;
            }
        }else{
            return peripherals;
        }
    }

    public boolean delete(String reference){
        Boolean aboolean = getPeripherals(reference).map(peripherals -> {
            peripheralsRepositorio.delete(peripherals);
            return true;
        }).orElse(false);
        return aboolean;
    }
}
