package kts.restaurant_application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kts.restaurant_application.model.Admin;
import kts.restaurant_application.repository.AdminRepository;

@Service
public class AdminService implements ServiceInterface<Admin> {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findOne(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public Admin create(Admin entity) throws Exception {
        if(adminRepository.findByUsername(entity.getUsername()) != null){
            throw new Exception("Admin with given username address already exists");
        }
        return adminRepository.save(entity);
    }

    @Override
    public Admin update(Admin entity, Long id) throws Exception {
        Admin existingUser =  adminRepository.findById(id).orElse(null);
        if(existingUser == null){
            throw new Exception("Admin with given id doesn't exist");
        }
        existingUser.setFirstName(entity.getFirstName());
        existingUser.setLastName(entity.getLastName());
        existingUser.setUsername(entity.getUsername());
        existingUser.setPassword(entity.getPassword());
        existingUser.setDateOfBirth(entity.getDateOfBirth());
        existingUser.setSalary(entity.getSalary());

        return adminRepository.save(existingUser);
    }

    @Override
    public void delete(Long id) throws Exception {
        Admin existingAdmin = adminRepository.findById(id).orElse(null);
        if(existingAdmin == null){
            throw new Exception("Admin with given id doesn't exist");
        }
        existingAdmin.setIsDeleted(true);
        adminRepository.save(existingAdmin);
    }

}
