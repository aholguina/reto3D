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
import mintic.reto3.Service.CostumeService;
import mintic.reto3.Model.Costume;


@RestController
@RequestMapping("/api/Costume")

@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})//Anotacion que responde peticiones desde cualquier lado
public class CostumeController {
    
    @Autowired  //Anotacion que inyecta todas las caracteristicas del objeto que se va a usar
    private CostumeService costumeService;

    @GetMapping("/all")  //Anotacion que permite deducir el mapa de donde va a buscar lo que se va a ejecutar
    public List<Costume> getCostumes(){
        return costumeService.getAll();
    }


    @GetMapping("/{id}")
    public Optional<Costume> getCostume(@PathVariable("id") int id){//convierte en variable lo que llega en la ruta
        return costumeService.getCostume(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public Costume save(@RequestBody Costume costume){ //hace una peticion para  que los parametros del json lleguen bien como un modelo
        return costumeService.save(costume);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public Costume update(@RequestBody Costume costume){ //hace una peticion para  que los parametros del json lleguen bien como un modelo
        return costumeService.update(costume);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//status 201
    public String deleteCostume(@PathVariable("id") int id){ //convierte en variable lo que llega en la ruta
        costumeService.deleteCostume(id);
        return "redirect:/";
    }
}
