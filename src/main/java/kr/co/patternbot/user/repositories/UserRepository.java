package kr.co.patternbot.user.repositories;

import kr.co.patternbot.user.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

//섞이지 말라고 커스텀 작업
interface UserCustomRepository{
    // 000. 사용자의 비밀번호와 이메일을 수정하시오
    @Modifying
    @Query(value = "")
    void update(User user);

    @Query(value = "")
    String login(User user);
}


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
