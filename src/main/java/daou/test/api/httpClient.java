package daou.test.api;


import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * daou.test.api
 *
 * @DATE 2023-03-22
 * @Author daou
 * @Version 1.0
 */
public class httpClient {

    private static final String LINEFEED = "\r\n";
    private static final String DOUBLE_HYPHEN = "--";
    private static final String QUTATE = "\"";

    public static void main( String args[]) throws Exception {
        post("https://bizapi.callmix.co.kr/biz050/BZV100", "aa");
    }

    // GET


    // POST
    public static void post(String uri, String data) throws Exception {

        BigInteger randomNumber = new BigInteger(256, new Random());
        StringBuilder boundary = new StringBuilder().append(randomNumber);

        HttpClient client = HttpClient.newHttpClient();

        Map<Object, Object> formData = new HashMap<>();
        formData.put("bizId", "daourecycle");
        formData.put("monthDay", "0322");
        formData.put("secureCode", "0e7d11cdb490b91bed868f0d53b6619686a6db1b3a06e1a73be430a10a6371c8");
        formData.put("selGbn", "1");
        formData.put("reqCnt", "500");
        formData.put("seqNo", "0");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .setHeader("Content-Type", "multipart/form-data; boundary=" + boundary)
                .POST(multipartToByte(formData,boundary.toString()))
                .build();

        // 결과
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
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
                Path filePath = (Path)data.getValue();
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

}
