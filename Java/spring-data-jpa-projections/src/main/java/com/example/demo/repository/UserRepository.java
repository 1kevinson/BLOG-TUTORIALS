package com.example.demo.repository;

import com.example.demo.entity.User;
import com.example.demo.projections.UserDto;
import com.example.demo.projections.UserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u.username, u.email FROM public.users u " +
                   "WHERE u.email LIKE ('%' || :emailServer || '.com%') ",
           nativeQuery = true)
    List<UserView> fetchUsersByEmailServer(@Param("emailServer") String emailServer);

    UserView findByEmailLike(String email);

    UserDto findByUsername(String username);

    <T> T findByLastName(String lastName, Class<T> type);
}
