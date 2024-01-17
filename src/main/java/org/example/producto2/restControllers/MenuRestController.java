package org.example.producto2.restControllers;


import org.example.producto2.services.MenuDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/api")
@RestController
public class MenuRestController {
    @Autowired
    private MenuDAOImpl menuService;

    /*@DeleteMapping("/menus/delete/{id}")
    @ResponseBody
    public RestResponse deleteMenu(@PathVariable Long id){
        menuService.delete(id);
        return new RestResponse().isOk("El menú "+id+" ha sido borrado",
                HttpStatus.ACCEPTED);
    }*/
}
