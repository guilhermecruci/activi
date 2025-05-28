package sptech.school.activi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActiviController {

    @GetMapping("/quiz")
    public String verificaResposta(@RequestParam int resposta) {
        return (resposta == 4)
                ? "👏 Mandou bem! 4 é a resposta certa."
                : "🤔 Quase! A soma de 2 + 2 é 4.";
    }
}
