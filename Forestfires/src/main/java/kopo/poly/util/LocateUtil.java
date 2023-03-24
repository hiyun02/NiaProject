package kopo.poly.util;

public class LocateUtil {

    public static String getSidoCode(String sido) {

        String result = "";

        if (sido.equals("서울특별시")) {
            result = "11";
        }else if (sido.equals("부산광역시")){
            result = "26";
        }else if (sido.equals("대구광역시")){
            result = "27";
        }else if (sido.equals("인천광역시")){
            result = "28";
        }else if (sido.equals("광주광역시")){
            result = "29";
        }else if (sido.equals("대전광역시")){
            result = "30";
        }else if (sido.equals("울산광역시")){
            result = "31";
        }else if (sido.equals("세종특별자치시")){
            result = "36";
        }else if (sido.equals("경기도")){
            result = "41";
        }else if (sido.equals("강원도")){
            result = "42";
        }else if (sido.equals("충청북도")){
            result = "43";
        }else if (sido.equals("충청남도")){
            result = "44";
        }else if (sido.equals("전라북도")){
            result = "45";
        }else if (sido.equals("전라남도")){
            result = "46";
        }else if (sido.equals("경상북도")){
            result = "47";
        }else if (sido.equals("경상남도")){
            result = "48";
        }else if (sido.equals("제주특별자치도")){
            result = "50";
        }

        return result;
    }

    public static String getSigunguCode(String sigungu) {

        String result = "";

        if (sigungu.contains("서울특별시 강남구")){
            result = "11680";
        }else if (sigungu.contains("서울특별시 강동구")){
            result = "11740";
        }else if (sigungu.contains("서울특별시 강북구")){
            result = "11305";
        }else if (sigungu.contains("서울특별시 강서구")){
            result = "11500";
        }else if (sigungu.contains("서울특별시 관악구")){
            result = "11620";
        }else if (sigungu.contains("서울특별시 광진구")){
            result = "11215";
        }else if (sigungu.contains("서울특별시 구로구")){
            result = "11530";
        }else if (sigungu.contains("서울특별시 금천구")){
            result = "11545";
        }else if (sigungu.contains("서울특별시 노원구")){
            result = "11350";
        }else if (sigungu.contains("서울특별시 도봉구")){
            result = "11320";
        }else if (sigungu.contains("서울특별시 동대문구")){
            result = "11230";
        }else if (sigungu.contains("서울특별시 동작구")){
            result = "11590";
        }else if (sigungu.contains("서울특별시 마포구")){
            result = "11440";
        }else if (sigungu.contains("서울특별시 서대문구")){
            result = "11410";
        }else if (sigungu.contains("서울특별시 서초구")){
            result = "11650";
        }else if (sigungu.contains("서울특별시 성동구")){
            result = "11200";
        }else if (sigungu.contains("서울특별시 성북구")) {
            result = "11290";
        }else if (sigungu.contains("서울특별시 송파구")){
            result = "11710";
        }else if (sigungu.contains("서울특별시 양천구")){
            result = "11470";
        }else if (sigungu.contains("서울특별시 영등포구")){
            result = "11560";
        }else if (sigungu.contains("서울특별시 용산구")){
            result = "11170";
        }else if (sigungu.contains("서울특별시 은평구")){
            result = "11380";
        }else if (sigungu.contains("서울특별시 종로구")){
            result = "11110";
        }else if (sigungu.contains("서울특별시 중구")){
            result = "11140";
        }else if (sigungu.contains("서울특별시 중랑구")){
            result = "11260";
        }else if (sigungu.contains("부산광역시 강서구")){
            result = "26440";
        }else if (sigungu.contains("부산광역시 금정구")){
            result = "26410";
        }else if (sigungu.contains("부산광역시 기장군")){
            result = "26710";
        }else if (sigungu.contains("부산광역시 남구")){
            result = "26290";
        }else if (sigungu.contains("부산광역시 동구")){
            result = "26170";
        }else if (sigungu.contains("부산광역시 동래구")){
            result = "26260";
        }else if (sigungu.contains("부산광역시 부산진구")){
            result = "26230";
        }else if (sigungu.contains("부산광역시 북구")){
            result = "26320";
        }else if (sigungu.contains("부산광역시 사상구")) {
            result = "26530";
        }else if (sigungu.contains("부산광역시 사하구")){
            result = "26380";
        }else if (sigungu.contains("부산광역시 서구")){
            result = "26140";
        }else if (sigungu.contains("부산광역시 수영구")){
            result = "26500";
        }else if (sigungu.contains("부산광역시 연제구")){
            result = "26470";
        }else if (sigungu.contains("부산광역시 영도구")){
            result = "26200";
        }else if (sigungu.contains("부산광역시 중구")){
            result = "26110";
        }else if (sigungu.contains("부산광역시 해운대구")){
            result = "26350";
        }else if (sigungu.contains("대구광역시 남구")){
            result = "27200";
        }else if (sigungu.contains("대구광역시 달서구")){
            result = "27290";
        }else if (sigungu.contains("대구광역시 달성군")){
            result = "27710";
        }else if (sigungu.contains("대구광역시 동구")){
            result = "27140";
        }else if (sigungu.contains("대구광역시 북구")){
            result = "27230";
        }else if (sigungu.contains("대구광역시 서구")){
            result = "27170";
        }else if (sigungu.contains("대구광역시 수성구")){
            result = "27260";
        }else if (sigungu.contains("대구광역시 중구")){
            result = "27110";
        }else if (sigungu.contains("인천광역시 강화군")){
            result = "28710";
        }else if (sigungu.contains("인천광역시 계양구")){
            result = "28245";
        }else if (sigungu.contains("인천광역시 남동구")){
            result = "28200";
        }else if (sigungu.contains("인천광역시 동구")){
            result = "28140";
        }else if (sigungu.contains("인천광역시 미추홀구")){
            result = "28177";
        }else if (sigungu.contains("인천광역시 부평구")){
            result = "28237";
        }else if (sigungu.contains("인천광역시 서구")){
            result = "28260";
        }else if (sigungu.contains("인천광역시 연수구")){
            result = "28185";
        }else if (sigungu.contains("인천광역시 옹진군")){
            result = "28720";
        }else if (sigungu.contains("인천광역시 중구")){
            result = "28110";
        }else if (sigungu.contains("광주광역시 광산구")){
            result = "29200";
        }else if (sigungu.contains("광주광역시 남구")){
            result = "29155";
        }else if (sigungu.contains("광주광역시 동구")){
            result = "29110";
        }else if (sigungu.contains("광주광역시 북구")){
            result = "29170";
        }else if (sigungu.contains("광주광역시 서구")){
            result = "29140";
        }else if (sigungu.contains("대전광역시 대덕구")){
            result = "30230";
        }else if (sigungu.contains("대전광역시 동구")){
            result = "30110";
        }else if (sigungu.contains("대전광역시 서구")) {
            result = "30170";
        }else if (sigungu.contains("대전광역시 유성구")) {
            result = "30200";
        }else if (sigungu.contains("대전광역시 중구")) {
            result = "30140";
        }else if (sigungu.contains("울산광역시 남구")) {
            result = "31140";
        }else if (sigungu.contains("울산광역시 동구")) {
            result = "31170";
        }else if (sigungu.contains("울산광역시 북구")) {
            result = "31200";
        }else if (sigungu.contains("울산광역시 울주군")) {
            result = "31710";
        }else if (sigungu.contains("울산광역시 중구")) {
            result = "31110";
        }else if (sigungu.contains("세종특별자치시")) {
            result = "36110";
        }else if (sigungu.contains("경기도 가평군")) {
            result = "41820";
        }else if (sigungu.contains("경기도 고양시 덕양구")) {
            result = "41281";
        }else if (sigungu.contains("경기도 고양시 일산동구")) {
            result = "41285";
        }else if (sigungu.contains("경기도 고양시 일산서구")) {
            result = "41287";
        }else if (sigungu.contains("경기도 과천시")) {
            result = "41290";
        }else if (sigungu.contains("경기도 광명시")) {
            result = "41210";
        }else if (sigungu.contains("경기도 광주시")) {
            result = "41610";
        }else if (sigungu.contains("경기도 구리시")) {
            result = "41310";
        }else if (sigungu.contains("경기도 군포시")) {
            result = "41410";
        }else if (sigungu.contains("경기도 김포시")) {
            result = "41570";
        }else if (sigungu.contains("경기도 남양주시")) {
            result = "41360";
        }else if (sigungu.contains("경기도 동두천시")) {
            result = "41250";
        }else if (sigungu.contains("경기도 부천시")) {
            result = "41190";
        }else if (sigungu.contains("경기도 성남시 분당구")) {
            result = "41135";
        }else if (sigungu.contains("경기도 성남시 수정구")) {
            result = "41131";
        }else if (sigungu.contains("경기도 성남시 중원구")) {
            result = "41133";
        }else if (sigungu.contains("경기도 수원시 권선구")) {
            result = "41113";
        }else if (sigungu.contains("경기도 수원시 영통구")) {
            result = "41117";
        }else if (sigungu.contains("경기도 수원시 장안구")) {
            result = "41111";
        }else if (sigungu.contains("경기도 수원시 팔달구")) {
            result = "41115";
        }else if (sigungu.contains("경기도 시흥시")) {
            result = "41390";
        }else if (sigungu.contains("경기도 안산시 단원구")) {
            result = "41273";
        }else if (sigungu.contains("경기도 안산시 상록구")) {
            result = "41271";
        }else if (sigungu.contains("경기도 안성시")) {
            result = "41550";
        }else if (sigungu.contains("경기도 안양시 동안구")) {
            result = "41173";
        }else if (sigungu.contains("경기도 안양시 만안구")) {
            result = "41171";
        }else if (sigungu.contains("경기도 양주시")) {
            result = "41630";
        }else if (sigungu.contains("경기도 양평군")) {
            result = "41830";
        }else if (sigungu.contains("경기도 여주시")) {
            result = "41670";
        }else if (sigungu.contains("경기도 연천군")) {
            result = "41800";
        }else if (sigungu.contains("경기도 오산시")) {
            result = "41370";
        }else if (sigungu.contains("경기도 용인시 기흥구")) {
            result = "41463";
        }else if (sigungu.contains("경기도 용인시 수지구")) {
            result = "41465";
        }else if (sigungu.contains("경기도 용인시 처인구")) {
            result = "41461";
        }else if (sigungu.contains("경기도 의왕시")) {
            result = "41430";
        }else if (sigungu.contains("경기도 의정부시")) {
            result = "41150";
        }else if (sigungu.contains("경기도 이천시")) {
            result = "41500";
        }else if (sigungu.contains("경기도 파주시")) {
            result = "41480";
        }else if (sigungu.contains("경기도 평택시")) {
            result = "41220";
        }else if (sigungu.contains("경기도 포천시")) {
            result = "41650";
        }else if (sigungu.contains("경기도 하남시")) {
            result = "41450";
        }else if (sigungu.contains("경기도 화성시")) {
            result = "41590";
        }else if (sigungu.contains("강원도 강릉시")) {
            result = "42150";
        }else if (sigungu.contains("강원도 고성군")) {
            result = "42820";
        }else if (sigungu.contains("강원도 동해시")) {
            result = "42170";
        }else if (sigungu.contains("강원도 삼척시")) {
            result = "42230";
        }else if (sigungu.contains("강원도 속초시")) {
            result = "42210";
        }else if (sigungu.contains("강원도 양구군")) {
            result = "42800";
        }else if (sigungu.contains("강원도 양양군")) {
            result = "42830";
        }else if (sigungu.contains("강원도 영월군")) {
            result = "42750";
        }else if (sigungu.contains("강원도 원주시")) {
            result = "42130";
        }else if (sigungu.contains("강원도 인제군")) {
            result = "42810";
        }else if (sigungu.contains("강원도 정선군")) {
            result = "42770";
        }else if (sigungu.contains("강원도 철원군")) {
            result = "42780";
        }else if (sigungu.contains("강원도 춘천시")) {
            result = "42110";
        }else if (sigungu.contains("강원도 태백시")) {
            result = "42190";
        }else if (sigungu.contains("강원도 평창군")) {
            result = "42760";
        }else if (sigungu.contains("강원도 홍천군")) {
            result = "42720";
        }else if (sigungu.contains("강원도 화천군")) {
            result = "42790";
        }else if (sigungu.contains("강원도 횡성군")) {
            result = "42730";
        }else if (sigungu.contains("충청북도 괴산군")) {
            result = "43760";
        }else if (sigungu.contains("충청북도 단양군")) {
            result = "43800";
        }else if (sigungu.contains("충청북도 보은군")) {
            result = "43720";
        }else if (sigungu.contains("충청북도 영동군")) {
            result = "43740";
        }else if (sigungu.contains("충청북도 옥천군")) {
            result = "43730";
        }else if (sigungu.contains("충청북도 음성군")) {
            result = "43770";
        }else if (sigungu.contains("충청북도 제천시")) {
            result = "43150";
        }else if (sigungu.contains("충청북도 증평군")) {
            result = "43745";
        }else if (sigungu.contains("충청북도 진천군")) {
            result = "43750";
        }else if (sigungu.contains("충청북도 청주시 상당구")) {
            result = "43111";
        }else if (sigungu.contains("충청북도 청주시 서원구")) {
            result = "43112";
        }else if (sigungu.contains("충청북도 청주시 청원구")) {
            result = "43114";
        }else if (sigungu.contains("충청북도 청주시 흥덕구")) {
            result = "43113";
        }else if (sigungu.contains("충청북도 충주시")) {
            result = "43130";
        }else if (sigungu.contains("충청남도 계룡시")) {
            result = "44250";
        }else if (sigungu.contains("충청남도 공주시")) {
            result = "44150";
        }else if (sigungu.contains("충청남도 금산군")) {
            result = "44710";
        }else if (sigungu.contains("충청남도 논산시")) {
            result = "44230";
        }else if (sigungu.contains("충청남도 당진시")) {
            result = "44270";
        }else if (sigungu.contains("충청남도 보령시")) {
            result = "44180";
        }else if (sigungu.contains("충청남도 부여군")) {
            result = "44760";
        }else if (sigungu.contains("충청남도 서산시")) {
            result = "44210";
        }else if (sigungu.contains("충청남도 서천군")) {
            result = "44770";
        }else if (sigungu.contains("충청남도 아산시")) {
            result = "44200";
        }else if (sigungu.contains("충청남도 예산군")) {
            result = "44810";
        }else if (sigungu.contains("충청남도 천안시 동남구")) {
            result = "44131";
        }else if (sigungu.contains("충청남도 천안시 서북구")) {
            result = "44133";
        }else if (sigungu.contains("충청남도 청양군")) {
            result = "44790";
        }else if (sigungu.contains("충청남도 태안군")) {
            result = "44825";
        }else if (sigungu.contains("충청남도 홍성군")) {
            result = "44800";
        }else if (sigungu.contains("전라북도 고창군")) {
            result = "45790";
        }else if (sigungu.contains("전라북도 군산시")) {
            result = "45130";
        }else if (sigungu.contains("전라북도 김제시")) {
            result = "45210";
        }else if (sigungu.contains("전라북도 남원시")) {
            result = "45190";
        }else if (sigungu.contains("전라북도 무주군")) {
            result = "45730";
        }else if (sigungu.contains("전라북도 부안군")) {
            result = "45800";
        }else if (sigungu.contains("전라북도 순창군")) {
            result = "45770";
        }else if (sigungu.contains("전라북도 완주군")) {
            result = "45710";
        }else if (sigungu.contains("전라북도 익산시")) {
            result = "45140";
        }else if (sigungu.contains("전라북도 임실군")) {
            result = "45750";
        }else if (sigungu.contains("전라북도 장수군")) {
            result = "45740";
        }else if (sigungu.contains("전라북도 전주시 덕진구")) {
            result = "45113";
        }else if (sigungu.contains("전라북도 전주시 완산구")) {
            result = "45111";
        }else if (sigungu.contains("전라북도 정읍시")) {
            result = "45180";
        }else if (sigungu.contains("전라북도 진안군")) {
            result = "45720";
        }else if (sigungu.contains("전라북도 강화군")) {
            result = "46810";
        }else if (sigungu.contains("전라남도 강진군")) {
            result = "46810";
        }else if (sigungu.contains("전라남도 고흥군")) {
            result = "46770";
        }else if (sigungu.contains("전라남도 곡성군")) {
            result = "46720";
        }else if (sigungu.contains("전라남도 광양시")) {
            result = "46230";
        }else if (sigungu.contains("전라남도 구례군")) {
            result = "46730";
        }else if (sigungu.contains("전라남도 나주시")) {
            result = "46170";
        }else if (sigungu.contains("전라남도 담양군")) {
            result = "46710";
        }else if (sigungu.contains("전라남도 목포시")) {
            result = "46110";
        }else if (sigungu.contains("전라남도 무안군")) {
            result = "46840";
        }else if (sigungu.contains("전라남도 보성군")) {
            result = "46780";
        }else if (sigungu.contains("전라남도 순천시")) {
            result = "46150";
        }else if (sigungu.contains("전라남도 신안군")) {
            result = "46910";
        }else if (sigungu.contains("전라남도 여수시")) {
            result = "46130";
        }else if (sigungu.contains("전라남도 영광군")) {
            result = "46870";
        }else if (sigungu.contains("전라남도 영암군")) {
            result = "46830";
        }else if (sigungu.contains("전라남도 완도군")) {
            result = "46890";
        }else if (sigungu.contains("전라남도 장성군")) {
            result = "46880";
        }else if (sigungu.contains("전라남도 장흥군")) {
            result = "46800";
        }else if (sigungu.contains("전라남도 진도군")) {
            result = "46900";
        }else if (sigungu.contains("전라남도 함평군")) {
            result = "46860";
        }else if (sigungu.contains("전라남도 해남군")) {
            result = "46820";
        }else if (sigungu.contains("전라남도 화순군")) {
            result = "46790";
        }else if (sigungu.contains("경상북도 경산시")) {
            result = "46790";
        }else if (sigungu.contains("경상북도 경주시")) {
            result = "47130";
        }else if (sigungu.contains("경상북도 고령군")) {
            result = "47830";
        }else if (sigungu.contains("경상북도 구미시")) {
            result = "47190";
        }else if (sigungu.contains("경상북도 군위군")) {
            result = "47720";
        }else if (sigungu.contains("경상북도 김천시")) {
            result = "47150";
        }else if (sigungu.contains("경상북도 문경시")) {
            result = "47280";
        }else if (sigungu.contains("경상북도 봉화군")) {
            result = "47920";
        }else if (sigungu.contains("경상북도 상주시")) {
            result = "47250";
        }else if (sigungu.contains("경상북도 성주군")) {
            result = "47840";
        }else if (sigungu.contains("경상북도 안동시")) {
            result = "47170";
        }else if (sigungu.contains("경상북도 영덕군")) {
            result = "47770";
        }else if (sigungu.contains("경상북도 영양군")) {
            result = "47760";
        }else if (sigungu.contains("경상북도 영주시")) {
            result = "47210";
        }else if (sigungu.contains("경상북도 영천시")) {
            result = "47230";
        }else if (sigungu.contains("경상북도 예천군")) {
            result = "47900";
        }else if (sigungu.contains("경상북도 울릉군")) {
            result = "47940";
        }else if (sigungu.contains("경상북도 울진군")) {
            result = "47930";
        }else if (sigungu.contains("경상북도 의성군")) {
            result = "47730";
        }else if (sigungu.contains("경상북도 청도군")) {
            result = "47820";
        }else if (sigungu.contains("경상북도 청송군")) {
            result = "47750";
        }else if (sigungu.contains("경상북도 칠곡군")) {
            result = "47850";
        }else if (sigungu.contains("경상북도 포항시 남구")) {
            result = "47111";
        }else if (sigungu.contains("경상북도 포항시 북구")) {
            result = "47113";
        }else if (sigungu.contains("경상남도 거제시")) {
            result = "48310";
        }else if (sigungu.contains("경상남도 거창군")) {
            result = "48880";
        }else if (sigungu.contains("경상남도 고성군")) {
            result = "48820";
        }else if (sigungu.contains("경상남도 김해시")) {
            result = "48250";
        }else if (sigungu.contains("경상남도 남해군")) {
            result = "48840";
        }else if (sigungu.contains("경상남도 밀양시")) {
            result = "48270";
        }else if (sigungu.contains("경상남도 사천시")) {
            result = "48240";
        }else if (sigungu.contains("경상남도 산청군")) {
            result = "48860";
        }else if (sigungu.contains("경상남도 양산시")) {
            result = "48330";
        }else if (sigungu.contains("경상남도 의령군")) {
            result = "48720";
        }else if (sigungu.contains("경상남도 진주시")) {
            result = "48170";
        }else if (sigungu.contains("경상남도 창녕군")) {
            result = "48740";
        }else if (sigungu.contains("경상남도 창원시 마산합포구")) {
            result = "48125";
        }else if (sigungu.contains("경상남도 창원시 마산회원구")) {
            result = "48127";
        }else if (sigungu.contains("경상남도 창원시 성산구")) {
            result = "48123";
        }else if (sigungu.contains("경상남도 창원시 의창구")) {
            result = "48121";
        }else if (sigungu.contains("경상남도 창원시 진해구")) {
            result = "48129";
        }else if (sigungu.contains("경상남도 통영시")) {
            result = "48220";
        }else if (sigungu.contains("경상남도 하동군")) {
            result = "48850";
        }else if (sigungu.contains("경상남도 함안군")) {
            result = "48730";
        }else if (sigungu.contains("경상남도 함양군")) {
            result = "48870";
        }else if (sigungu.contains("경상남도 합천군")) {
            result = "48890";
        }else if (sigungu.contains("제주특별자치도 서귀포시")) {
            result = "50130";
        }else if (sigungu.contains("제주특별자치도 제주시")) {
            result = "50110";
        }

        return result;
    }
}
