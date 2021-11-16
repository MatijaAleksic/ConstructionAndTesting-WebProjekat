package Backend.src.main.java.kts.restaurant_application.helper;

public interface MapperInterface<T,U> {

    T toEntity(U dto);

    U toDto(T entity);
}
