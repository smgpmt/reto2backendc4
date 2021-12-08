//modelo
//interface
//repositorio
//servicio
//controlador


package RetosC4;

import RetosC4.interfaces.InterfacePeripherals;
import RetosC4.interfaces.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class RetosC4Application implements CommandLineRunner {

        @Autowired
        private InterfacePeripherals interfacePeripherals;
        
        @Autowired
        private InterfaceUser interfaceUser;
         
	public static void main(String[] args) {
		SpringApplication.run(RetosC4Application.class, args);
	}
        
        //Para que cada vez que se inicie el servicio se reinicie la tabla
        @Override
        public void run(String... args) throws Exception {
            interfacePeripherals.deleteAll();
            interfaceUser.deleteAll();
        }

}
