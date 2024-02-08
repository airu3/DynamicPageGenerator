package com.example.demo;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ChatController {

    @GetMapping("/new-chat")
    public String newChat(HttpServletRequest request) {
        // UUIDを生成
        String uuid = UUID.randomUUID().toString();
        
        // UUIDをセッションに保存することもできます
        request.getSession().setAttribute("uuid", uuid);
        
        // 生成されたUUIDをパスとしてリダイレクト
        return "redirect:/chat/" + uuid;
    }
    
    // UUIDに基づいてページを表示するエンドポイント
    @GetMapping("/chat/{uuid}")
    public String chatPage(@PathVariable("uuid") String uuid, Model model) {
        // モデルにUUIDを追加
        model.addAttribute("uuid", uuid);
        
        // ここで実際のページを表示するためのロジックを記述
        return "chatPage"; // 例えば、"chatPage"はThymeleafテンプレートの名前です
    }
}
