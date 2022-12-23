<%--
  Created by IntelliJ IDEA.
  User: daehy
  Date: 2022-12-21
  Time: 오후 8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="kopo.poly.dto.hospitalDTO" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%@ page import="kopo.poly.util.DistanceUtil" %>

<%
    String locateYn = (CmmUtil.nvl((String) request.getAttribute("locateYn")));
    String lat = (CmmUtil.nvl((String) request.getAttribute("lat")));
    String lon = (CmmUtil.nvl((String) request.getAttribute("lon")));

    List<hospitalDTO> pList = (List<hospitalDTO>) session.getAttribute("hList");
    if (pList == null) {
        pList = new ArrayList<hospitalDTO>();
    }

    if (locateYn.equals("Y")) {
        pList = DistanceUtil.sortByLatLonH(pList, Double.parseDouble(lat), Double.parseDouble(lon));
    }

%>

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html
        lang="en"
        class="light-style layout-menu-fixed"
        dir="ltr"
        data-theme="theme-default"
        data-assets-path="/assets/"
        data-template="vertical-menu-template-free"
>
<head>
    <meta charset="utf-8"/>
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />

    <title>Dashboard - Analytics | Sneat - Bootstrap 5 HTML Admin Template - Pro</title>

    <meta name="description" content=""/>

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="/assets/img/favicon/favicon.ico"/>

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet"
    />

    <!-- Icons. Uncomment required icon fonts -->
    <link rel="stylesheet" href="/assets/vendor/fonts/boxicons.css"/>

    <!-- Core CSS -->
    <link rel="stylesheet" href="/assets/vendor/css/core.css" class="template-customizer-core-css"/>
    <link rel="stylesheet" href="/assets/vendor/css/theme-default.css" class="template-customizer-theme-css"/>
    <link rel="stylesheet" href="/assets/css/demo.css"/>

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css"/>

    <link rel="stylesheet" href="/assets/vendor/libs/apex-charts/apex-charts.css"/>

    <!-- Page CSS -->

    <!-- Helpers -->
    <script src="/assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="/assets/js/config.js"></script>
    <script src="/js/jquery.min.js"></script>
    <style>
        .title {
            font-weight: bold;
            display: block;
        }

        .hAddr {
            position: absolute;
            left: 10px;
            top: 10px;
            border-radius: 2px;
            background: #fff;
            background: rgba(255, 255, 255, 0.8);
            z-index: 1;
            padding: 5px;
        }

        #centerAddr {
            display: block;
            margin-top: 2px;
            font-weight: normal;
        }

        .bAddr {
            padding: 5px;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
        }
    </style>
</head>

<body>
<!-- Layout wrapper -->
<div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">
        <!-- Menu -->

        <aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme">
            <div class="app-brand demo">
                <a href="/index" class="app-brand-link">
              <span class="app-brand-logo demo">

              </span>
                    <span class="app-brand-text demo menu-text fw-bolder ms-2">산불대응 서비스</span>
                </a>

                <a href="javascript:void(0);" class="layout-menu-toggle menu-link text-large ms-auto d-block d-xl-none">
                    <i class="bx bx-chevron-left bx-sm align-middle"></i>
                </a>
            </div>

            <div class="menu-inner-shadow"></div>

            <ul class="menu-inner py-1">
                <!-- Dashboard -->
                <li class="menu-item active">
                    <a href="index" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-home-circle"></i>
                        <div data-i18n="Analytics">평상시 산불 정보 데이터</div>
                    </a>
                </li>

                <!-- Layouts -->
                <li class="menu-item">
                    <a href="" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-layout"></i>
                        <div data-i18n="Layouts">산불발생 긴급 데이터</div>
                    </a>

                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="goods" class="menu-link">
                                <div data-i18n="Without menu">구호물자 구매처 찾기</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="hospital" class="menu-link">
                                <div data-i18n="Without navbar">긴급 의료기관 찾기</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="Temporary" class="menu-link">
                                <div data-i18n="Without navbar">긴급대피소 찾기</div>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </aside>
        <!-- / Menu -->


        <!-- Layout container -->
        <div class="layout-page">
            <!-- Navbar -->

            <nav
                    class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
                    id="layout-navbar"
            >
                <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
                    <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
                        <i class="bx bx-menu bx-sm"></i>
                    </a>
                </div>

                <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
                    <!-- Search -->

                    <!-- /Search -->

                    <td class="py-3">
                        <h2 class="mb-1" style="text-align: center; color: #696cff">긴급 의료기관 찾기</h2>
                    </td>

                    <!-- User -->

                    <!--/ User -->
                    </ul>
                </div>
            </nav>

            <!-- / Navbar -->

            <!-- Content wrapper -->
            <div class="content-wrapper">
                <!-- Content -->


                <div class="container-xxl flex-grow-1 container-p-y">


                    <div class="row">
                        <div class="col-md-12 mb-4">
                            <div class="card" style="padding-left: 50px;">
                                <br>
                                <h5 id="h5" class="card-title text-primary">원하시는 위치의 의료기관을 우측에서 선택해주세요.
                                </h5>
                                <p id="pText" class="mb-4">
                                    분류 :
                                    <br/>
                                    이름 :
                                    <br/>
                                    연락처 :
                                    <br/>
                                    주소 :
                                    <br/>
                                    거리 :
                                </p>
                            </div>
                        </div>


                        <div class="col-md">

                            <div id="map" class="card h-100"
                                 style="width:100%;height:100%;;"></div>


                        </div>

                        <script type="text/javascript"
                                src="//dapi.kakao.com/v2/maps/sdk.js?appkey=74740f16248eafd5fd5664fbf82bac98&libraries=services"></script>

                        <script>


                            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                                mapOption = {
                                    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                                    level: 3 // 지도의 확대 레벨
                                };

                            var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

                            var geocoder = new kakao.maps.services.Geocoder();

                            // 주소로 좌표를 검색합니다
                            geocoder.addressSearch('서울특별시 강서구 우장산로10길 112', function (result, status) {

                                // 정상적으로 검색이 완료됐으면
                                if (status === kakao.maps.services.Status.OK) {
                                    console.log(result);
                                    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

                                    // 결과값으로 받은 위치를 마커로 표시합니다
                                    var marker = new kakao.maps.Marker({
                                        map: map,
                                        position: coords
                                    });

                                    // 인포윈도우로 장소에 대한 설명을 표시합니다
                                    var infowindow = new kakao.maps.InfoWindow({
                                        content: '<div style="width:150px;text-align:center;padding:6px 0;">현위치</div>'
                                    });
                                    infowindow.open(map, marker);

                                    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                                    map.setCenter(coords);

                                    // HTML5의 geolocation으로 사용할 수 있는지 확인합니다
                                    console.log("locateYn : <%=locateYn%>")
                                    <%if(locateYn.equals("")){%>
                                    alert("현위치를 기반으로 의료시설을 탐색합니다.");
                                    location.href = "/locate?lat=" + result[0].y + "&lon=" + result[0].x+"&page=indexHospital";
                                    <%}%>
                                }
                            });
                            //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ


                            // 마커를 표시할 위치와 title 객체 배열입니다
                            var positions = [
                                <%
                                                  for (int i = 0; i <pList.size(); i++) {
                                                      hospitalDTO mDTO = pList.get(i);

                                                      if (mDTO == null) {
                                                          mDTO = new hospitalDTO();
                                                      }

                                              %>

                                {
                                    content: '<%=CmmUtil.nvl(mDTO.getH_name())%>',
                                    latlng: new kakao.maps.LatLng(<%=CmmUtil.nvl(mDTO.getH_lon())%>, <%=CmmUtil.nvl(mDTO.getH_lat())%>),
                                    info: {
                                        "name": "<%=mDTO.getH_name()%>",
                                        "kind": "<%=mDTO.getH_kind()%>",
                                        "tell": "<%=mDTO.getH_tel()%>",
                                        "addr": "<%=mDTO.getH_adr()%>",
                                        "dist": "<%=Math.round(mDTO.getH_dis()*100)/100.00%>km"
                                    }
                                }
                                <%if(i!=pList.size()-1) {%>
                                , <%}%>

                                <%}%>
                            ];

                            for (var i = 0; i < positions.length; i++) {
                                // 마커를 생성합니다
                                var marker = new kakao.maps.Marker({
                                    map: map, // 마커를 표시할 지도
                                    position: positions[i].latlng // 마커의 위치
                                });

                                // 마커에 표시할 인포윈도우를 생성합니다
                                var infowindow = new kakao.maps.InfoWindow({
                                    content: positions[i].content // 인포윈도우에 표시할 내용
                                });

                                // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
                                // 이벤트 리스너로는 클로저를 만들어 등록합니다
                                // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
                                // 마커에 클릭이벤트를 등록합니다
                                kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
                                kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
                            }

                            // 인포윈도우를 표시하는 클로저를 만드는 함수입니다
                            function makeOverListener(map, marker, infowindow) {
                                return function () {
                                    infowindow.open(map, marker);
                                };
                            }

                            // 인포윈도우를 닫는 클로저를 만드는 함수입니다
                            function makeOutListener(infowindow) {
                                return function () {
                                    infowindow.close();
                                };
                            }


                            //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
                            // 지도에 마커와 인포윈도우를 표시하는 함수입니다
                            function displayMarker(locPosition, message) {

                                // 마커를 생성합니다
                                var marker = new kakao.maps.Marker({
                                    map: map,
                                    position: locPosition
                                });

                                var iwContent = message, // 인포윈도우에 표시할 내용
                                    iwRemoveable = true;

                                // 인포윈도우를 생성합니다
                                var infowindow = new kakao.maps.InfoWindow({
                                    content: iwContent,
                                    removable: iwRemoveable
                                });

                                // 인포윈도우를 마커위에 표시합니다
                                infowindow.open(map, marker);

                                // 지도 중심좌표를 접속위치로 변경합니다
                                map.setCenter(locPosition);
                            }

                            function showInfo(infoJson) {

                                console.log(infoJson);

                                $('#h5').empty();
                                $('#h5').append('선택하신 의료기관의 정보입니다.');
                                $('#h5').append('<br/>');

                                $('#pText').empty();
                                $('#pText').append("분류 : ");
                                $('#pText').append(infoJson.kind);
                                $('#pText').append("<br/>");
                                $('#pText').append("이름 : ");
                                $('#pText').append(infoJson.name);
                                $('#pText').append("<br/>");
                                $('#pText').append("연락처 : ");
                                $('#pText').append(infoJson.tell);
                                $('#pText').append("<br/>");
                                $('#pText').append("주소 : ");
                                $('#pText').append(infoJson.addr);
                                $('#pText').append("<br/>");
                                $('#pText').append("거리 : ");
                                $('#pText').append(infoJson.dist);
                                $('#pText').append("<br/>");
                            }

                        </script>


                        <!-- Transactions -->
                        <div class="col-md-6 col-lg-4 order-2 mb-4">
                            <div class="card h-100">
                                <div class="card-header d-flex align-items-center justify-content-between">
                                    <h5 class="card-title m-0 me-2">근거리 의료기관 리스트</h5>
                                    <div class="dropdown">
                                        <button
                                                class="btn p-0"
                                                type="button"
                                                id="transactionID"
                                                data-bs-toggle="dropdown"
                                                aria-haspopup="true"
                                                aria-expanded="false"
                                        >
                                            <i class="bx bx-dots-vertical-rounded"></i>
                                        </button>
                                        <div class="dropdown-menu dropdown-menu-end" aria-labelledby="transactionID">
                                            <a class="dropdown-item" href="javascript:void(0);">Last 28 Days</a>
                                            <a class="dropdown-item" href="javascript:void(0);">Last Month</a>
                                            <a class="dropdown-item" href="javascript:void(0);">Last Year</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <ul class="p-0 m-0">
                                        <%
                                            for (int i = 0; i < 5; i++) {

                                                hospitalDTO hDTO = pList.get(i);
                                        %>

                                        <li id="<%=i%>" onclick="showInfo(positions[<%=i%>].info)"
                                            class="d-flex mb-4 pb-1">
                                            <div class="avatar flex-shrink-0 me-3">
                                                <img src="/assets/img/icons/unicons/chart.png" alt="User"
                                                     class="rounded"/>
                                            </div>
                                            <div class="d-flex w-100 flex-wrap align-items-center justify-content-between gap-2">
                                                <div class="me-2">
                                                    <h6 class="mb-0"><%=hDTO.getH_name()%>
                                                    </h6>
                                                </div>
                                                <div class="user-progress d-flex align-items-center gap-1">
                                                    <h6 class="mb-0"><%=hDTO.getH_dis()%>
                                                    </h6>
                                                    <span class="text-muted">Km</span>
                                                </div>
                                            </div>
                                        </li>
                                        <%}%>

                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!--/ Transactions -->
                    </div>
                </div>
                <!-- / Content -->


                <div class="content-backdrop fade"></div>
            </div>
            <!-- Content wrapper -->
        </div>
        <!-- / Layout page -->
    </div>

    <!-- Overlay -->
    <div class="layout-overlay layout-menu-toggle"></div>
</div>
<!-- / Layout wrapper -->


<!-- Core JS -->
<!-- build:js assets/vendor/js/core.js -->
<script src="/assets/vendor/libs/jquery/jquery.js"></script>
<script src="/assets/vendor/libs/popper/popper.js"></script>
<script src="/assets/vendor/js/bootstrap.js"></script>
<script src="/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

<script src="/assets/vendor/js/menu.js"></script>
<!-- endbuild -->

<!-- Vendors JS -->
<script src="/assets/vendor/libs/apex-charts/apexcharts.js"></script>

<!-- Main JS -->
<script src="/assets/js/main.js"></script>

<!-- Page JS -->
<script src="/assets/js/dashboards-analytics.js"></script>

<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>
</html>