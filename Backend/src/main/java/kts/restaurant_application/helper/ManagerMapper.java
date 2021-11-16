package kts.restaurant_application.helper;

import kts.restaurant_application.dto.AdminDTO;
import kts.restaurant_application.dto.ManagerDTO;
import kts.restaurant_application.model.Admin;
import kts.restaurant_application.model.Manager;

public class ManagerMapper implements MapperInterface<Manager, ManagerDTO>{
    @Override
    public Manager toEntity(ManagerDTO dto) {
        return new Manager(dto.getFirstName(), dto.getLastName(), dto.getUsername(), dto.getPassword(), dto.getDateOfBirth(), dto.getSalary(), dto.getDeleted());
    }

    @Override
    public ManagerDTO toDto(Manager entity) {
        return new ManagerDTO(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getUsername(), entity.getPassword(), entity.getDateOfBirth(), entity.getSalary(), entity.getIsDeleted());
    }
}
