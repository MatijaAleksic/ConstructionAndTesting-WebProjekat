package kts.restaurant_application.controller;

import kts.restaurant_application.dto.AdminDTO;
import kts.restaurant_application.dto.ManagerDTO;
import kts.restaurant_application.helper.AdminMapper;
import kts.restaurant_application.helper.ManagerMapper;
import kts.restaurant_application.model.Admin;
import kts.restaurant_application.model.Manager;
import kts.restaurant_application.service.AdminService;
import kts.restaurant_application.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value =  "/api/manager", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    private final ManagerMapper managerMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ManagerDTO>> getAllUsers() {
        List<Manager> users = managerService.findAll();

        return new ResponseEntity<>(toUserDTOList(users), HttpStatus.OK);
    }

    //Parametar je u kontroler moguce poslati kao parametar koji je promenljiva u URL-u zahteva - Path Variable
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<ManagerDTO> getUser(@PathVariable Long id){
        Manager user = managerService.findOne(id);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(managerMapper.toDto(user), HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ManagerDTO> createUser(@RequestBody ManagerDTO managerDTO){
        Manager user;
        try {
            user = managerService.create(managerMapper.toEntity(managerDTO));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(managerMapper.toDto(user), HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ManagerDTO> updateUser(@RequestBody ManagerDTO managerDTO, @PathVariable Long id){
        Manager manager;
        try {
            manager = managerService.update(managerMapper.toEntity(managerDTO), id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(managerMapper.toDto(manager), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        try {
            managerService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ManagerController() {
        managerMapper = new ManagerMapper();
    }

    private List<ManagerDTO> toUserDTOList(List<Manager> managers){
        List<ManagerDTO> managerDTOS = new ArrayList<>();
        for (Manager manager: managers) {
            managerDTOS.add(managerMapper.toDto(manager));
        }
        return managerDTOS;
    }
}
