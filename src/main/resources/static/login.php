<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">

</head>
<body>

<?php
// 날짜 계산
$today = new DateTime();
$month = $today->format('m');
$day = $today->format('d');

// 데이터
$bizId = 'daourecycle'; // 고객사 아이디로 변경.
$monthDay = $month.$day;
$url = 'https://bizapi.callmix.co.kr/biz050/BZV100'; // 연동요청할 url로 변경하여 사용. (ex. BZV100, BZC100...)

/*
* sha256 암호화 방식, 암호화 코드, 연동 세부사항은 사업팀 별도로 전달
*/
$encipherCode = 'eb49b67112818a1322b57ca2151f54fff16debc1e8486f2933cf264ef4510f41'; // 고객사 암호화 코드로 변경
$secureCode = hash('sha256', makeSecureCode()); // [비즈콜믹스]_연동규격서_세부사항 참고


// 업로드 폼 전송 (ajax로 파일 업로드)
$ch = curl_init();

$data = array(
'bizId' => $bizId,
'monthDay' => $monthDay,
'secureCode' => $secureCode,
'selGbn' => '1',
'reqCnt' => '10',
'seqNo' => '0',
);

// ssl 인증여부 끄기
curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, false);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);

curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

$response = curl_exec($ch);

if($response === false) {
echo 'Curl error: ' . curl_error($ch);
} else {
echo $response;
}

curl_close($ch);

// 아래 함수는 고객사 비노출
function makeSecureCode() {
global $bizId;
global $monthDay;
global $encipherCode;

return $bizId.$monthDay.$encipherCode;
}


?>
</body>
</html>

