package kosta.boot.board.config.utils;

import org.springframework.http.HttpMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public class UiUtils {

    private String path;

    public UiUtils(String path) {
        this.path = path;
    }

    public String forward() {
        return path;
    }

    public static UiUtils showMessageWithRedirect(
            @RequestParam(value = "message", required = false) String message,
            @RequestParam(value = "redirectUri", required = false) String redirectUri,
            @RequestParam(value = "method", required = false) HttpMethod httpMethod,
            @RequestParam(value = "params", required = false) Map<String, Object> params,
            Model model) {
        model.addAttribute("message", message);
        model.addAttribute("redirectUri", redirectUri);
        model.addAttribute("httpMethod", httpMethod);
        model.addAttribute("params", params);
        return new UiUtils("board/utils/message-redirect");
    }



}
