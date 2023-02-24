package kosta.springjsp.web;

import kosta.springjsp.domain.email.Email;
import kosta.springjsp.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/emails")
@RequiredArgsConstructor
public class EmailController {

    private final ItemService itemService;

    @GetMapping
    public String emails(Model model){

        List<Email> emails =  itemService.findItems();

        log.info("");

        model.addAttribute("emails", emails);
        return "email-list";

    }


}
