package com.la.apigatewayappserver.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.la.apigatewayappserver.models.User;
import org.springframework.data.repository.CrudRepository;

//public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> findByUsername(String username);
//}
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByUsername(String username);
}
