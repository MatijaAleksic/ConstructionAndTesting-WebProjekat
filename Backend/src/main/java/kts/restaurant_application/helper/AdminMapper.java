package Backend.src.main.java.kts.restaurant_application.helper;

import Backend.src.main.java.kts.restaurant_application.dto.AdminDTO;
import Backend.src.main.java.kts.restaurant_application.model.Admin;

public class AdminMapper implements MapperInterface<Admin, AdminDTO> {

    @Override
    public Admin toEntity(AdminDTO dto) {
        return new Admin(dto.getFirstName(), dto.getLastName(), dto.getUsername(), dto.getPassword(), dto.getDateOfBirth(), dto.getSalary(), dto.getDeleted());
    }

    @Override
    public AdminDTO toDto(Admin entity) {
        return new AdminDTO(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getUsername(), entity.getPassword(), entity.getDateOfBirth(), entity.getSalary(), entity.getIsDeleted());
    }
}