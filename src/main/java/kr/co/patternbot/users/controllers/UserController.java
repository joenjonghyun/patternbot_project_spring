package kr.co.patternbot.users.controllers;

import io.swagger.annotations.*;
import kr.co.patternbot.auth.domains.Messenger;
import kr.co.patternbot.users.domains.User;
import kr.co.patternbot.users.domains.UserDTO;
import kr.co.patternbot.users.repositories.UserRepository;
import kr.co.patternbot.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "users") //외부에서 users가 있는 단어만 출입시킴
@RestController
@RequestMapping("/users") //루트경로
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final ModelMapper modelMapper;
    private final UserRepository repository;

    @PostMapping("/login")
    @ApiOperation(value ="${UserController.login}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something Wrong"),
            @ApiResponse(code = 422, message = "유효하지 않은 아이디 / 비밀번호")
    })
    public ResponseEntity<UserDTO> login(@ApiParam("Login User") @RequestBody UserDTO user) {
        return ResponseEntity.ok(service.login(user));
    }

    @GetMapping("/logout")
    public ResponseEntity<Messenger> logout() {
        return ResponseEntity.ok(service.logout());
    }


    // Embeded Methods
    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/findAll/sort")
    public ResponseEntity<List<User>> findAll(Sort sort) {
        return ResponseEntity.ok(service.findAll(sort));
    }

    @GetMapping("/findAll/pageable")
    public ResponseEntity<Page<User>>findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/count")
    public ResponseEntity<Messenger> count() {
        return ResponseEntity.ok(service.count());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> delete(@RequestBody UserDTO user) {
        return ResponseEntity.ok(service.delete(user));
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Messenger> deleteAll() {
        return ResponseEntity.ok(service.deleteAll());
    }


    @PostMapping("/join")
    @ApiOperation(value = "${UserController.join}")
    @ApiResponses(value={
            @ApiResponse(code=400, message = "Something Wrong"),
            @ApiResponse(code=403, message = "승인거절"),
            @ApiResponse(code=422, message = "중복된 ID")
    })
    public ResponseEntity<Messenger> save(@ApiParam("Join User") @RequestBody UserDTO user) {
        System.out.println("회원가입 정보: "+user.toString());
        return ResponseEntity.ok(service.save(user));
    }

    @GetMapping("/findById") //{userid}왜 없앴는지
    public ResponseEntity<Optional<User>> findById(@PathVariable UserDTO userDTO) {
        return ResponseEntity.ok(service.findById(userDTO));
    }

    @PostMapping("/findUsername") @ResponseBody //뜻한번물어보고가자자
   public ResponseEntity<String> findUsername(@RequestBody UserDTO user) {
        return ResponseEntity.ok(service.findUsername(user).getUsername());
    }
    @GetMapping("findByUsername") @ResponseBody
    public ResponseEntity<Optional<User>> findByUsername(@RequestBody String username) {
        return ResponseEntity.ok(service.findByUsername(username));
    }


    @GetMapping("/existsById/{userid}")
    public ResponseEntity<Messenger> existsById(@PathVariable String userid) {
        return ResponseEntity.ok(service.existsById(userid));
    }
    @PatchMapping(value = "/update") @ResponseBody
    public ResponseEntity<Integer> partialUpdate(@RequestBody final UserDTO userDTO) {
        return ResponseEntity.ok(service.partialUpdate(userDTO));
    }

    @PostMapping(value = "/findPw")
    public void findPwPOST(@RequestBody UserDTO user, HttpServletResponse response) throws Exception{
        System.out.println("아이디 : " + user.getUsername());
        System.out.println("email : " + user.getEmail());
        service.findPw(response, user);
    }


}
