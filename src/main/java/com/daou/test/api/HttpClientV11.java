package com.daou.test.api;


import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * com.test.api
 *
 * @DATE 2023-03-22
 * @Author daou
 * @Version 1.0
 */

/**
 * Java의 HttpClient는 Java 11부터 사용 가능합니다.
 * Java 11부터는 HttpClient가 java.net.HttpURLConnection과 java.net.HttpClient를 대체하고 있습니다.
 * 이전 버전에서는 Apache HttpComponents, OkHttp, Retrofit 등과 같은 다른 HTTP 클라이언트 라이브러리를 사용해야합니다.
 */

public class HttpClientV11 {

    private static final String LINEFEED = "\r\n";
    private static final String DOUBLE_HYPHEN = "--";
    private static final String QUTATE = "\"";

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

        Map<Object, Object> formData = new HashMap<>();
        formData.put("bizId", bizId);
        formData.put("monthDay", monthDay);
        formData.put("secureCode", secureCode);
        formData.put("selGbn", "1");
        formData.put("reqCnt", "500");
        formData.put("seqNo", "0");

        post(url, formData);
    }

    // POST
    public static void post(String uri, Map<Object, Object> formData) throws Exception {

        BigInteger randomNumber = new BigInteger(256, new Random());
        StringBuilder boundary = new StringBuilder().append(randomNumber);

        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .setHeader("Content-Type", "multipart/form-data; boundary=" + boundary)
                .POST(multipartToByte(formData, boundary.toString()))
                .build();

        // 결과
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response Status : " + response.statusCode());
        System.out.println("Response Body : " + response.body());
    }

    private static HttpRequest.BodyPublisher multipartToByte(Map<Object, Object> map, String boundary) throws IOException {
        List<byte[]> byteArrays = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Object, Object> data : map.entrySet()) {
            stringBuilder.setLength(0);
            stringBuilder.append(DOUBLE_HYPHEN)
                    .append(boundary)
                    .append(LINEFEED);

            if (data.getValue() instanceof Path) {
                Path filePath = (Path) data.getValue();
                String mimeType = Files.probeContentType(filePath);
                byte[] fileByte = Files.readAllBytes(filePath);

                stringBuilder.append("Content-Disposition: form-data; name=")
                        .append(QUTATE)
                        .append(data.getKey())
                        .append(QUTATE)
                        .append("; filename= ")
                        .append(QUTATE)
                        .append(data.getValue())
                        .append(QUTATE)
                        .append(LINEFEED)
                        .append("Content-Type: ")
                        .append(mimeType)
                        .append(LINEFEED)
                        .append(LINEFEED);

                byteArrays.add(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
                byteArrays.add(fileByte);
                byteArrays.add(LINEFEED.getBytes(StandardCharsets.UTF_8));
            } else {
                stringBuilder.append("Content-Disposition: form-data; name=")
                        .append(QUTATE)
                        .append(data.getKey())
                        .append(QUTATE)
                        .append(";")
                        .append(LINEFEED)
                        .append(LINEFEED)
                        .append(data.getValue())
                        .append(LINEFEED);
                byteArrays.add(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
            }
        }

        stringBuilder.setLength(0);
        stringBuilder.append(DOUBLE_HYPHEN)
                .append(boundary)
                .append(DOUBLE_HYPHEN);
        byteArrays.add(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));

        return HttpRequest.BodyPublishers.ofByteArrays(byteArrays);
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
