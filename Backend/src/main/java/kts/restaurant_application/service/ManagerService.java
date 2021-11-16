package kts.restaurant_application.service;


import kts.restaurant_application.model.Manager;
import kts.restaurant_application.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService implements ServiceInterface<Manager> {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public List<Manager> findAll() {
        return managerRepository.findAll();
    }

    @Override
    public Manager findOne(Long id) {
        return managerRepository.findById(id).orElse(null);
    }

    @Override
    public Manager create(Manager entity) throws Exception {
        if(managerRepository.findByUsername(entity.getUsername()) != null){
            throw new Exception("Admin with given username address already exists");
        }
        return managerRepository.save(entity);
    }

    @Override
    public Manager update(Manager entity, Long id) throws Exception {
        Manager existingUser =  managerRepository.findById(id).orElse(null);
        if(existingUser == null){
            throw new Exception("Admin with given id doesn't exist");
        }
        existingUser.setFirstName(entity.getFirstName());
        existingUser.setLastName(entity.getLastName());
        existingUser.setUsername(entity.getUsername());
        existingUser.setPassword(entity.getPassword());
        existingUser.setDateOfBirth(entity.getDateOfBirth());
        existingUser.setSalary(entity.getSalary());

        return managerRepository.save(existingUser);
    }

    @Override
    public void delete(Long id) throws Exception {
        Manager existingManager = managerRepository.findById(id).orElse(null);
        if(existingManager == null){
            throw new Exception("Admin with given id doesn't exist");
        }
        existingManager.setIsDeleted(true);
        managerRepository.save(existingManager);
    }

}
