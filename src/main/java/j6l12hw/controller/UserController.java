package j6l12hw.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import j6l12hw.dto.UserDto;
import j6l12hw.service.UserService;

@Controller
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
@Secured({"ROLE_SUPER_ADMIN", "ROLE_ADMIN"})
public class UserController {

    private final UserService userService;

    @GetMapping()
    @Secured({"ROLE_SUPER_ADMIN", "ROLE_ADMIN"})
    public String showUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/showAll";
    }

    @GetMapping("/{id}")
    @Secured({"ROLE_SUPER_ADMIN", "ROLE_ADMIN"})
    public String showUsers(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "users/show";
    }

    @GetMapping("/new")
    @Secured({"ROLE_SUPER_ADMIN"})
    public String addUsers(@ModelAttribute("user") UserDto userDto) {
        return "users/new";
    }

    @PostMapping()
    @Secured({"ROLE_SUPER_ADMIN"})
    public String createUser(@ModelAttribute("user") UserDto userDto) {
        userService.save(userDto);
        return "users/showAll";
    }

    @DeleteMapping("/{id}")
    @Secured({"ROLE_SUPER_ADMIN"})
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "users/showAll";
    }

    @PatchMapping("/{id}")
    @Secured({"ROLE_SUPER_ADMIN"})
    public String updateUser(@ModelAttribute("user") UserDto userDto, @PathVariable("id") int id) {
        userDto.setId(id);
        userService.save(userDto);
        return "users/showAll";
    }

}
