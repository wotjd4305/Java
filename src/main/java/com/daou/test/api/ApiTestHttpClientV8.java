package com.daou.test.api;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * com.test.api
 *
 * @DATE 2023-03-29
 * @Author daou
 * @Version 1.0
 */

/**
 * 아래 소스는 Java 8부터 사용 가능합니다.
 * Apache HttpComponents HTTP 클라이언트 라이브러리를 사용해야합니다.
 * 따라서, 아래 의존성을 추가해야합니다.
 * TODO : org.apache.httpcomponents:httpclient, org.apache.httpcomponents:httpmime 의존성 추가
 *
 * 아래 주석은 의존성 추가는 링크 입니다.
 * 사용버전은 둘다 4.5.13을 사용하였습니다.참고 부탁드립니다.
 * httpmime - https://mvnrepository.com/artifact/org.apache.httpcomponents/httpmime
 * httpclient - https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient
 */

public class ApiTestHttpClientV8 {

    // 데이터
    private static final String bizId = "daourecycle"; //TODO : 고객사 아이디로 변경
    private static final String monthDay = LocalDate.now().format(DateTimeFormatter.ofPattern("MMdd"));
    private static final String url = "https://bizapi.callmix.co.kr/biz050/BZV100"; //TODO : 연동요청할 url로 변경하여 사용. (ex. BZV100, BZC100...)
    private static final String encipherCode = "eb49b67112818a1322b57ca2151f54fff16debc1e8486f2933cf264ef4510f41"; //TODO : 고객사 암호화 코드로 변경

    public static void main(String args[]) throws Exception {
        /*
         * sha256 암호화 방식, 암호화 코드, 연동 세부사항(makeSecureCode 함수 로직)은 사업팀 별도로 전달
         * TODO : 사업팀에서 전달 받은 secureCode 생성방식 확인
         */
        String secureCode = encryptSHA256(makeSecureCode());

        // 멀티파트(form-data) 엔티티 생성
        HttpEntity httpEntity = MultipartEntityBuilder.create()
                .addTextBody("bizId", bizId)
                .addTextBody("monthDay", monthDay)
                .addTextBody("secureCode", secureCode)
                .addTextBody("selGbn", "1")
                .addTextBody("reqCnt", "500")
                .addTextBody("seqNo", "0")
                .build();

        post(httpEntity);
    }

    // POST
    public static void post(HttpEntity httpEntity) throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost request = new HttpPost(url);
        request.setEntity(httpEntity);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            System.out.println("Response Status : " + response.getStatusLine().getStatusCode());

            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println("Response Body : " + responseBody);
        }
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
