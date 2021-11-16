package Backend.src.main.java.kts.restaurant_application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Backend.src.main.java.kts.restaurant_application.dto.AdminDTO;
import Backend.src.main.java.kts.restaurant_application.helper.AdminMapper;
import Backend.src.main.java.kts.restaurant_application.model.Admin;
import Backend.src.main.java.kts.restaurant_application.service.AdminService;

@RestController
@RequestMapping(value =  "/api/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

        @Autowired
        private AdminService adminService;

        private final AdminMapper adminMapper;

        @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<List<AdminDTO>> getAllUsers() {
            List<Admin> users = adminService.findAll();

            return new ResponseEntity<>(toUserDTOList(users), HttpStatus.OK);
        }

        //Parametar je u kontroler moguce poslati kao parametar koji je promenljiva u URL-u zahteva - Path Variable
        @RequestMapping(value="/{id}", method=RequestMethod.GET)
        public ResponseEntity<AdminDTO> getUser(@PathVariable Long id){
            Admin user = adminService.findOne(id);
            if(user == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(adminMapper.toDto(user), HttpStatus.OK);
        }

        @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<AdminDTO> createUser(@RequestBody AdminDTO adminDTO){
            Admin user;
            try {
                user = adminService.create(adminMapper.toEntity(adminDTO));
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(adminMapper.toDto(user), HttpStatus.CREATED);
        }

        @RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<AdminDTO> updateUser(@RequestBody AdminDTO adminDTO, @PathVariable Long id){
            Admin admin;
            try {
                admin = adminService.update(adminMapper.toEntity(adminDTO), id);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(adminMapper.toDto(admin), HttpStatus.OK);
        }

        @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
        public ResponseEntity<Void> deleteUser(@PathVariable Long id){
            try {
                adminService.delete(id);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        }

        public AdminController() {
            adminMapper = new AdminMapper();
        }

        private List<AdminDTO> toUserDTOList(List<Admin> admins){
            List<AdminDTO> adminDTOS = new ArrayList<>();
            for (Admin admin: admins) {
                adminDTOS.add(adminMapper.toDto(admin));
            }
            return adminDTOS;
        }
    }


