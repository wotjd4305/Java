package com.daou.test.api;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * com.test.api
 *
 * @DATE 2023-03-22
 * @Author daou
 * @Version 1.0
 */

/**
 Java 8 버전 이상에서 사용할 수 있습니다.
 Java 8에서 추가된 클래스 LocalDate와 DateTimeFormatter를 사용합니다.
 */

public class ApiTestRestTemplate {

    // 데이터
    private static final String bizId = "daourecycle"; //TODO : 고객사 아이디로 변경
    private static final String monthDay = LocalDate.now().format(DateTimeFormatter.ofPattern("MMdd"));
    private static final String url = "https://bizapi.callmix.co.kr/biz050/BZV100"; //TODO : 연동요청할 url로 변경하여 사용. (ex. BZV100, BZC100...)
    private static final String encipherCode = "eb49b67112818a1322b57ca2151f54fff16debc1e8486f2933cf264ef4510f41"; //TODO : 고객사 암호화 코드로 변경

    public static void main(String args[]) throws Exception {
        /*
         * sha256 암호화 방식, 암호화 코드, 연동 세부사항은 사업팀 별도로 전달
         * TODO : 사업팀에서 전달 받은 secureCode 생성방식 확인
         */
        String secureCode = encryptSHA256(makeSecureCode()); // [비즈콜믹스]_연동규격서_세부사항 참고

        MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();
        formData.add("bizId", bizId);
        formData.add("monthDay", monthDay);
        formData.add("secureCode", secureCode);
        formData.add("selGbn", "1");
        formData.add("reqCnt", "500");
        formData.add("seqNo", "0");

        postMultipartForm(url, formData);
    }

    public static void postMultipartForm(String url, MultiValueMap<String, Object> formData) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<Object> requestEntity = new HttpEntity<>(formData, headers);

        // 결과
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
        System.out.println("Response Status: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody());
    }

    public static String encryptSHA256(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // 고객사 비노출
    public static String makeSecureCode() {
        return bizId + monthDay + encipherCode;
    }
}
