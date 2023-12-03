package com.nhclub.keyrena.domain.auth.kakaocontroller;

import com.nhclub.keyrena.domain.auth.kakaoservice.KakaoService;
import com.nhclub.keyrena.domain.auth.model.dto.KakaoDto;
import com.nhclub.keyrena.domain.auth.model.dto.MsgDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("kakao")
public class KakaoController {

    private final KakaoService kakaoService;

    @GetMapping("/callback")
    public ResponseEntity<MsgDto> callback(HttpServletRequest request) throws Exception {
        KakaoDto kakaoInfo = kakaoService.getKakaoInfo(request.getParameter("code"));

        return ResponseEntity.ok()
                .body(new MsgDto("Success", kakaoInfo));
    }

}