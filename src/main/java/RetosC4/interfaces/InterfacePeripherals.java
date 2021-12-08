/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RetosC4.interfaces;

import RetosC4.modelo.Peripherals;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author HP
 */
public interface InterfacePeripherals extends MongoRepository<Peripherals, String> {
    
}
