package mintic.reto3.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;
import mintic.reto3.Service.ClientService;
import mintic.reto3.Model.Client;


@RestController
@RequestMapping("/api/Client")

@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})//Anotacion que responde peticiones desde cualquier lado
public class ClientController {
    
    @Autowired //Anotacion que inyecta todas las caracteristicas del objeto que se va a usar
    private ClientService clientService;

    @GetMapping("/all") //Anotacion que permite deducir el mapa de donde va a buscar lo que se va a ejecutar
    public List<Client> getClients(){
        return clientService.getAll();
    }


    @GetMapping("/{id}") //Anotacion que permite deducir el mapa de donde va a buscar lo que se va a ejecutar
    public Optional<Client> getClient(@PathVariable("id") int id){//convierte en variable lo que llega en la ruta
        return clientService.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public Client save(@RequestBody Client Client){ //hace una peticion para que los parametros del json lleguen bien como un modelo
        return clientService.save(Client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public Client update(@RequestBody Client Client){ //hace una peticion para que los parametros del json lleguen bien como un modelo
        return clientService.update(Client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//status 201
    public String deleteClient(@PathVariable("id") int id){ //convierte en variable lo que llega en la ruta
        clientService.deleteClient(id);
        return "redirect:/";
    }
}
