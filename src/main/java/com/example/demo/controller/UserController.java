package com.example.demo.controller; // Pastikan ini SAMA dengan struktur folder Anda

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // Inisialisasi list agar tidak NullPointerException
    private final List<User> userList = new ArrayList<>();

    @GetMapping("/")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        // Ganti NIM sesuai NIM Anda
        if ("admin".equals(username) && "20230140220".equals(password)) {
            return "redirect:/home";
        }
        model.addAttribute("error", "Username atau Password salah!");
        return "login";
    }

    @GetMapping("/home")
    public String showHome(Model model) {
        // Pastikan attribute name "users" sama dengan yang dipanggil di home.html
        model.addAttribute("users", userList);
        return "home";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/form")
    public String processForm(@ModelAttribute("user") User user) {
        if (user != null) {
            userList.add(user);
        }
        // Ini akan memanggil method showHome di atas
        return "redirect:/home";
    }
}