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
import mintic.reto3.Service.CategoryService;
import mintic.reto3.Model.Category;


@RestController
@RequestMapping("/api/Category")

@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST,RequestMethod.DELETE})//Anotacion que responde a las peticiones desde cualquier lado
public class CategoryController {
    
    @Autowired //Anotacion que inyecta todas las caracteristicas del objeto que se va a usar
    private CategoryService categoryService;

    @GetMapping("/all") //Anotacion que permite deducir el mapa de donde va a buscar lo que se va a ejecutar
    public List<Category> getCategorys(){
        return categoryService.getAll();
    }


    @GetMapping("/{id}")//Anotacion que permite deducir el mapa de donde va a buscar lo que se va a ejecutar
    public Optional<Category> getCategory(@PathVariable("id") int id){//convierte en variable lo que llega en la ruta
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public Category save(@RequestBody Category Category){ //hace una peticion para  que los parametros del json lleguen bien como un modelo
        return categoryService.save(Category);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)//status 201
    public Category update(@RequestBody Category Category){ //hace una peticion para que los parametros del json lleguen bien como un modelo
        return categoryService.update(Category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//status 204
    public String deleteCategory(@PathVariable("id") int id){ //convierte en variable lo que llega en la ruta
        categoryService.deleteCategory(id);
        return "redirect:/";
    }
}
