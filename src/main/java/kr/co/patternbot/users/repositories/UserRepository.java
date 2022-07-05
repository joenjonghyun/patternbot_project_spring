package kr.co.patternbot.users.repositories;

import kr.co.patternbot.users.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//섞이지 말라고 커스텀 작업
interface UserCustomRepository{
    // 000. 사용자의 비밀번호와 이메일을 수정하시오


    @Query(value = "select u.username from User u where u.name = :name and u.email = :email")
    String findUsername(@Param("name") String name, @Param("email") String email);

}

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {
    Optional<User> findByUsername(String username);


}
