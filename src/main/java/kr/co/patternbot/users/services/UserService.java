package kr.co.patternbot.users.services;

import kr.co.patternbot.auth.domains.Messenger;
import kr.co.patternbot.users.domains.User;
import kr.co.patternbot.users.domains.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO login(UserDTO user);

    List<User> findAll();

    List<User> findAll(Sort sort);

    Page<User> findAll(Pageable pageable);

    Messenger count();

    //Messenger update(User user);

    Messenger delete(UserDTO user);

    Messenger deleteAll();

    Messenger save(UserDTO user);

    Optional<User> findById(UserDTO userDTO);

    Messenger existsById(String userid);

    // custom

    Optional<User> findByUsername(String username);

    Messenger logout();

    UserDTO findUsername(UserDTO user);

    //이메일발송
    public void sendEmail(UserDTO user, String div) throws Exception;

    //비밀번호찾기
    public void findPw(HttpServletResponse resp, UserDTO user) throws Exception;

    int partialUpdate(UserDTO userDTO);

}
