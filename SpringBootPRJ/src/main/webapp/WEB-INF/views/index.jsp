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
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%
    String resultYn = CmmUtil.nvl((String) request.getAttribute("resultYn"));
    List<Map<String, String>> rList = (List<Map<String, String>>) request.getAttribute("rList");
    if (rList == null) {
        rList = new ArrayList<>();
    }

    String todayDegree = "";
    String std = "";
    String location = "";

    if (rList.size() > 0) {
        Map<String, String> today = rList.get(0);

        std = today.get("std");
        location = today.get("doname") + " " + today.get("sigun");

        if (!today.get("d1").equals("0")) {
            todayDegree = "낮음";
        } else if (!today.get("d2").equals("0")) {
            todayDegree = "다소 높음";
        } else if (!today.get("d3").equals("0")) {
            todayDegree = "높음";
        } else {
            todayDegree = "매우 높음";
        }

    }

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
                        <h2 class="mb-1" style="text-align: center; color: #696cff">산불 예보 및 위험 지수</h2>
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
                                <h5 class="card-title text-primary">산불 위험지수 : <%=todayDegree%>
                                </h5>
                                <p class="mb-4">
                                    현재 지역 : <%=location%>
                                    <br/>
                                    산불위험예보지수 표준편차 : <%=std%>
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
                            var container = document.getElementById('map');
                            var options = {
                                center: new kakao.maps.LatLng(33.450701, 126.570667),
                                level: 4
                            };

                            var map = new kakao.maps.Map(container, options);
                            // 주소-좌표 변환 객체를 생성합니다
                            var geocoder = new kakao.maps.services.Geocoder();

                            var infowindow = new kakao.maps.InfoWindow({zindex: 1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다

                            var marker;
                            var locPosition;
                            //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

                                // 주소로 좌표를 검색합니다
                                geocoder.addressSearch('서울특별시 강서구 우장산로10길 112', function (result, status) {

                                    // 정상적으로 검색이 완료됐으면
                                    if (status === kakao.maps.services.Status.OK) {

                                        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                                        console.log(result);
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
                                    }
                                });


                                // 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
                                searchAddrFromCoords(map.getCenter(), displayCenterInfo);

                            console.log("<%=resultYn%>");

                            <%if(resultYn.equals("")) {%>
                            alert("위치를 기반으로 산불위험예보를 조회합니다.")
                            location.href = "/forcast?address=" + "서울특별시 강서구";
                            <%}%>

                                // 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
                                kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
                                    searchDetailAddrFromCoords(mouseEvent.latLng, function (result, status) {
                                        if (status === kakao.maps.services.Status.OK) {
                                            var detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
                                            detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';

                                            var content = '<div class="bAddr">' +
                                                '<span class="title">법정동 주소정보</span>' +
                                                detailAddr +
                                                '</div>';

                                            // 마커를 클릭한 위치에 표시합니다
                                            marker.setPosition(mouseEvent.latLng);
                                            marker.setMap(map);

                                            // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                                            infowindow.setContent(content);
                                            infowindow.open(map, marker);
                                        }
                                    });
                                });

                                // 중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
                                kakao.maps.event.addListener(map, 'idle', function () {
                                    searchAddrFromCoords(map.getCenter(), displayCenterInfo);
                                });

                                function searchAddrFromCoords(coords, callback) {
                                    // 좌표로 행정동 주소 정보를 요청합니다
                                    geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);

                                }

                                function searchAddrFromCurrentPoint(data, callback) {
                                    // 좌표로 행정동 주소 정보를 요청합니다
                                    geocoder.coord2RegionCode(data.getLng(), data.getLat(), callback);

                                }

                                function searchDetailAddrFromCoords(coords, callback) {
                                    // 좌표로 법정동 상세 주소 정보를 요청합니다
                                    geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
                                }

                                // 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
                                function displayCenterInfo(result, status) {
                                    console.log("displayCenterInfo start");
                                    if (status === kakao.maps.services.Status.OK) {
                                        var infoDiv = document.getElementById('centerAddr');

                                        console.log("status ok");
                                        for (var i = 0; i < result.length; i++) {
                                            // 행정동의 region_type 값은 'H' 이므로
                                            if (result[i].region_type === 'H') {
                                                infoDiv.innerHTML = result[i].address_name;
                                                break;
                                            }
                                        }
                                    }
                                }
                        </script>


                        <!-- Transactions -->
                        <div class="col-md-6 col-lg-4 order-2 mb-4">
                            <div class="card h-100">
                                <div class="card-header d-flex align-items-center justify-content-between">
                                    <h5 class="card-title m-0 me-2">산불위험예보지수</h5>
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
                                            if (resultYn.equals("Y")) {
                                                for (int i = 1; i < 9; i++) {
                                                    Map<String, String> map = rList.get(i);

                                                    if (!map.get("d1").equals("0")) {
                                                        todayDegree = "낮음";
                                                    } else if (!map.get("d2").equals("0")) {
                                                        todayDegree = "다소 높음";
                                                    } else if (!map.get("d3").equals("0")) {
                                                        todayDegree = "높음";
                                                    } else {
                                                        todayDegree = "매우 높음";
                                                    }

                                                    map.put("degree", todayDegree);

                                        %>
                                        <li class="d-flex mb-4 pb-1">
                                            <div class="avatar flex-shrink-0 me-3">
                                                <img src="/assets/img/icons/unicons/chart.png" alt="User"
                                                     class="rounded"/>
                                            </div>
                                            <div class="d-flex w-100 flex-wrap align-items-center justify-content-between gap-2">
                                                <div class="me-2">
                                                    <small class="text-muted d-block mb-1">일자 : <%=map.get("analdate")%>
                                                        시</small>
                                                    <h6 class="mb-0"><%=map.get("degree")%>
                                                    </h6>
                                                </div>
                                                <div class="user-progress d-flex align-items-center gap-1">
                                                    <h6 class="mb-0">+<%=map.get("std")%>
                                                    </h6>
                                                    <span class="text-muted">표준편차</span>
                                                </div>
                                            </div>
                                        </li>
                                        <%
                                                }
                                            }
                                        %>

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