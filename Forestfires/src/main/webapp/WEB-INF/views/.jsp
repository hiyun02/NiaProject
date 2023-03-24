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
<%@ page import="kopo.poly.util.CmmUtil" %>
<%@ page import="kopo.poly.dto.TemporaryDTO" %>

<%
    List<TemporaryDTO> mList = (List<TemporaryDTO>) request.getAttribute("rList");

    if (mList == null) {
        mList = new ArrayList<TemporaryDTO>();

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
                    <span class="app-brand-text demo menu-text fw-bolder ms-2">Sneat</span>
                </a>

                <a href="javascript:void(0);" class="layout-menu-toggle menu-link text-large ms-auto d-block d-xl-none">
                    <i class="bx bx-chevron-left bx-sm align-middle"></i>
                </a>
            </div>

            <div class="menu-inner-shadow"></div>

            <ul class="menu-inner py-1">
                <!-- Dashboard -->
                <li class="menu-item active">
                    <a href="/index" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-home-circle"></i>
                        <div data-i18n="Analytics">Dashboard</div>
                    </a>
                </li>

                <!-- Layouts -->
                <li class="menu-item">
                    <a href="javascript:void(0);" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-layout"></i>
                        <div data-i18n="Layouts">Layouts</div>
                    </a>

                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="layouts-without-menu.html" class="menu-link">
                                <div data-i18n="Without menu">Without menu</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="layouts-without-navbar.html" class="menu-link">
                                <div data-i18n="Without navbar">Without navbar</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="layouts-container.html" class="menu-link">
                                <div data-i18n="Container">Container</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="layouts-fluid.html" class="menu-link">
                                <div data-i18n="Fluid">Fluid</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="layouts-blank.html" class="menu-link">
                                <div data-i18n="Blank">Blank</div>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="menu-header small text-uppercase">
                    <span class="menu-header-text">Pages</span>
                </li>
                <li class="menu-item">
                    <a href="javascript:void(0);" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-dock-top"></i>
                        <div data-i18n="Account Settings">Account Settings</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="pages-account-settings-account.html" class="menu-link">
                                <div data-i18n="Account">Account</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="pages-account-settings-notifications.html" class="menu-link">
                                <div data-i18n="Notifications">Notifications</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="pages-account-settings-connections.html" class="menu-link">
                                <div data-i18n="Connections">Connections</div>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="menu-item">
                    <a href="javascript:void(0);" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-lock-open-alt"></i>
                        <div data-i18n="Authentications">Authentications</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="auth-login-basic.html" class="menu-link" target="_blank">
                                <div data-i18n="Basic">Login</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="auth-register-basic.html" class="menu-link" target="_blank">
                                <div data-i18n="Basic">Register</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="auth-forgot-password-basic.html" class="menu-link" target="_blank">
                                <div data-i18n="Basic">Forgot Password</div>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="menu-item">
                    <a href="javascript:void(0);" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-cube-alt"></i>
                        <div data-i18n="Misc">Misc</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="pages-misc-error.html" class="menu-link">
                                <div data-i18n="Error">Error</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="pages-misc-under-maintenance.html" class="menu-link">
                                <div data-i18n="Under Maintenance">Under Maintenance</div>
                            </a>
                        </li>
                    </ul>
                </li>
                <!-- Components -->
                <li class="menu-header small text-uppercase"><span class="menu-header-text">Components</span></li>
                <!-- Cards -->
                <li class="menu-item">
                    <a href="cards-basic.html" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-collection"></i>
                        <div data-i18n="Basic">Cards</div>
                    </a>
                </li>
                <!-- User interface -->
                <li class="menu-item">
                    <a href="javascript:void(0)" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-box"></i>
                        <div data-i18n="User interface">User interface</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="ui-accordion.html" class="menu-link">
                                <div data-i18n="Accordion">Accordion</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-alerts.html" class="menu-link">
                                <div data-i18n="Alerts">Alerts</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-badges.html" class="menu-link">
                                <div data-i18n="Badges">Badges</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-buttons.html" class="menu-link">
                                <div data-i18n="Buttons">Buttons</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-carousel.html" class="menu-link">
                                <div data-i18n="Carousel">Carousel</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-collapse.html" class="menu-link">
                                <div data-i18n="Collapse">Collapse</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-dropdowns.html" class="menu-link">
                                <div data-i18n="Dropdowns">Dropdowns</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-footer.html" class="menu-link">
                                <div data-i18n="Footer">Footer</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-list-groups.html" class="menu-link">
                                <div data-i18n="List Groups">List groups</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-modals.html" class="menu-link">
                                <div data-i18n="Modals">Modals</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-navbar.html" class="menu-link">
                                <div data-i18n="Navbar">Navbar</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-offcanvas.html" class="menu-link">
                                <div data-i18n="Offcanvas">Offcanvas</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-pagination-breadcrumbs.html" class="menu-link">
                                <div data-i18n="Pagination &amp; Breadcrumbs">Pagination &amp; Breadcrumbs</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-progress.html" class="menu-link">
                                <div data-i18n="Progress">Progress</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-spinners.html" class="menu-link">
                                <div data-i18n="Spinners">Spinners</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-tabs-pills.html" class="menu-link">
                                <div data-i18n="Tabs &amp; Pills">Tabs &amp; Pills</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-toasts.html" class="menu-link">
                                <div data-i18n="Toasts">Toasts</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-tooltips-popovers.html" class="menu-link">
                                <div data-i18n="Tooltips & Popovers">Tooltips &amp; popovers</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="ui-typography.html" class="menu-link">
                                <div data-i18n="Typography">Typography</div>
                            </a>
                        </li>
                    </ul>
                </li>

                <!-- Extended components -->
                <li class="menu-item">
                    <a href="javascript:void(0)" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-copy"></i>
                        <div data-i18n="Extended UI">Extended UI</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="extended-ui-perfect-scrollbar.html" class="menu-link">
                                <div data-i18n="Perfect Scrollbar">Perfect scrollbar</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="extended-ui-text-divider.html" class="menu-link">
                                <div data-i18n="Text Divider">Text Divider</div>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="menu-item">
                    <a href="icons-boxicons.html" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-crown"></i>
                        <div data-i18n="Boxicons">Boxicons</div>
                    </a>
                </li>

                <!-- Forms & Tables -->
                <li class="menu-header small text-uppercase"><span class="menu-header-text">Forms &amp; Tables</span>
                </li>
                <!-- Forms -->
                <li class="menu-item">
                    <a href="javascript:void(0);" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-detail"></i>
                        <div data-i18n="Form Elements">Form Elements</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="forms-basic-inputs.html" class="menu-link">
                                <div data-i18n="Basic Inputs">Basic Inputs</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="forms-input-groups.html" class="menu-link">
                                <div data-i18n="Input groups">Input groups</div>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="menu-item">
                    <a href="javascript:void(0);" class="menu-link menu-toggle">
                        <i class="menu-icon tf-icons bx bx-detail"></i>
                        <div data-i18n="Form Layouts">Form Layouts</div>
                    </a>
                    <ul class="menu-sub">
                        <li class="menu-item">
                            <a href="form-layouts-vertical.html" class="menu-link">
                                <div data-i18n="Vertical Form">Vertical Form</div>
                            </a>
                        </li>
                        <li class="menu-item">
                            <a href="form-layouts-horizontal.html" class="menu-link">
                                <div data-i18n="Horizontal Form">Horizontal Form</div>
                            </a>
                        </li>
                    </ul>
                </li>
                <!-- Tables -->
                <li class="menu-item">
                    <a href="tables-basic.html" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-table"></i>
                        <div data-i18n="Tables">Tables</div>
                    </a>
                </li>
                <!-- Misc -->
                <li class="menu-header small text-uppercase"><span class="menu-header-text">Misc</span></li>
                <li class="menu-item">
                    <a
                            href="https://github.com/themeselection/sneat-html-admin-template-free/issues"
                            target="_blank"
                            class="menu-link"
                    >
                        <i class="menu-icon tf-icons bx bx-support"></i>
                        <div data-i18n="Support">Support</div>
                    </a>
                </li>
                <li class="menu-item">
                    <a
                            href="https://themeselection.com/demo/sneat-bootstrap-html-admin-template/documentation/"
                            target="_blank"
                            class="menu-link"
                    >
                        <i class="menu-icon tf-icons bx bx-file"></i>
                        <div data-i18n="Documentation">Documentation</div>
                    </a>
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
                    <div class="navbar-nav align-items-center">
                        <div class="nav-item d-flex align-items-center">
                            <i class="bx bx-search fs-4 lh-0"></i>
                            <input
                                    type="text"
                                    class="form-control border-0 shadow-none"
                                    placeholder="Search..."
                                    aria-label="Search..."
                            />
                        </div>
                    </div>
                    <!-- /Search -->

                    <ul class="navbar-nav flex-row align-items-center ms-auto">
                        <!-- Place this tag where you want the button to render. -->
                        <li class="nav-item lh-1 me-3">
                            <a
                                    class="github-button"
                                    href="https://github.com/themeselection/sneat-html-admin-template-free"
                                    data-icon="octicon-star"
                                    data-size="large"
                                    data-show-count="true"
                                    aria-label="Star themeselection/sneat-html-admin-template-free on GitHub"
                            >Star</a
                            >
                        </li>

                        <!-- User -->
                        <li class="nav-item navbar-dropdown dropdown-user dropdown">
                            <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);"
                               data-bs-toggle="dropdown">
                                <div class="avatar avatar-online">
                                    <img src="/assets/img/avatars/1.png" alt class="w-px-40 h-auto rounded-circle"/>
                                </div>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-end">
                                <li>
                                    <a class="dropdown-item" href="#">
                                        <div class="d-flex">
                                            <div class="flex-shrink-0 me-3">
                                                <div class="avatar avatar-online">
                                                    <img src="/assets/img/avatars/1.png" alt
                                                         class="w-px-40 h-auto rounded-circle"/>
                                                </div>
                                            </div>
                                            <div class="flex-grow-1">
                                                <span class="fw-semibold d-block">John Doe</span>
                                                <small class="text-muted">Admin</small>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <div class="dropdown-divider"></div>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="#">
                                        <i class="bx bx-user me-2"></i>
                                        <span class="align-middle">My Profile</span>
                                    </a>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="#">
                                        <i class="bx bx-cog me-2"></i>
                                        <span class="align-middle">Settings</span>
                                    </a>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="#">
                        <span class="d-flex align-items-center align-middle">
                          <i class="flex-shrink-0 bx bx-credit-card me-2"></i>
                          <span class="flex-grow-1 align-middle">Billing</span>
                          <span class="flex-shrink-0 badge badge-center rounded-pill bg-danger w-px-20 h-px-20">4</span>
                        </span>
                                    </a>
                                </li>
                                <li>
                                    <div class="dropdown-divider"></div>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="auth-login-basic.html">
                                        <i class="bx bx-power-off me-2"></i>
                                        <span class="align-middle">Log Out</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
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
                        <div class="col-lg-8 mb-4 order-0">
                            <div class="card">
                                <div class="d-flex align-items-end row">
                                    <div class="col-sm-7">
                                        <div class="card-body">
                                            <h5 id="h5" class="card-title text-primary">원하시는 구호물자 구매처를 우측에서 선택해주세요.
                                            </h5>
                                            <p id="pText" class="mb-4">
                                                업체명 :
                                                <br/>
                                                품목명 :
                                                <br/>
                                                연락처 :
                                                <br/>
                                                주소 :
                                            </p>
                                        </div>
                                    </div>
                                    <div class="col-sm-5 text-center text-sm-left">
                                        <div class="card-body pb-0 px-0 px-md-4">
                                            <img
                                                    src="/assets/img/illustrations/man-with-laptop-light.png"
                                                    height="140"
                                                    alt="View Badge User"
                                                    data-app-dark-img="illustrations/man-with-laptop-dark.png"
                                                    data-app-light-img="illustrations/man-with-laptop-light.png"
                                            />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 order-1">
                            <div class="row">
                                <div class="col-lg-6 col-md-12 col-6 mb-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="card-title d-flex align-items-start justify-content-between">
                                                <div class="avatar flex-shrink-0">
                                                    <img
                                                            src="/assets/img/icons/unicons/chart-success.png"
                                                            alt="chart success"
                                                            class="rounded"
                                                    />
                                                </div>
                                                <div class="dropdown">
                                                    <button
                                                            class="btn p-0"
                                                            type="button"
                                                            id="cardOpt3"
                                                            data-bs-toggle="dropdown"
                                                            aria-haspopup="true"
                                                            aria-expanded="false"
                                                    >
                                                        <i class="bx bx-dots-vertical-rounded"></i>
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end"
                                                         aria-labelledby="cardOpt3">
                                                        <a class="dropdown-item" href="javascript:void(0);">View
                                                            More</a>
                                                        <a class="dropdown-item" href="javascript:void(0);">Delete</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <span class="fw-semibold d-block mb-1">Profit</span>
                                            <h3 class="card-title mb-2">$12,628</h3>
                                            <small class="text-success fw-semibold"><i class="bx bx-up-arrow-alt"></i>
                                                +72.80%</small>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-12 col-6 mb-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="card-title d-flex align-items-start justify-content-between">
                                                <div class="avatar flex-shrink-0">
                                                    <img
                                                            src="/assets/img/icons/unicons/wallet-info.png"
                                                            alt="Credit Card"
                                                            class="rounded"
                                                    />
                                                </div>
                                                <div class="dropdown">
                                                    <button
                                                            class="btn p-0"
                                                            type="button"
                                                            id="cardOpt6"
                                                            data-bs-toggle="dropdown"
                                                            aria-haspopup="true"
                                                            aria-expanded="false"
                                                    >
                                                        <i class="bx bx-dots-vertical-rounded"></i>
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end"
                                                         aria-labelledby="cardOpt6">
                                                        <a class="dropdown-item" href="javascript:void(0);">View
                                                            More</a>
                                                        <a class="dropdown-item" href="javascript:void(0);">Delete</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <span>Sales</span>
                                            <h3 class="card-title text-nowrap mb-1">$4,679</h3>
                                            <small class="text-success fw-semibold"><i class="bx bx-up-arrow-alt"></i>
                                                +28.42%</small>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Total Revenue -->
                        <div class="col-12 col-lg-8 order-2 order-md-3 order-lg-2 mb-4">
                            <div id="map" style="width:100%;height:350px;"></div>

                            <script type="text/javascript"
                                    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5d3b6787dfab0b9aebf37f542b61c877&libraries=services"></script>

                            <script>
                                var mapContainer = document.getElementById('map');
                                var mapOption = {
                                    center: new daum.maps.LatLng(37.450701, 126.570667),
                                    level: 3
                                };

                                if (navigator.geolocation) {

                                    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
                                    navigator.geolocation.getCurrentPosition(function (position) {

                                        var lat = position.coords.latitude, // 위도
                                            lon = position.coords.longitude; // 경도

                                        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
                                            message = '<div style="padding:5px;">현위치</div>'; // 인포윈도우에 표시될 내용입니다

                                        // 마커와 인포윈도우를 표시합니다
                                        displayMarker(locPosition, message);

                                    });

                                } else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다

                                    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),
                                        message = 'geolocation을 사용할수 없어요..'

                                    displayMarker(locPosition, message);
                                }


                                var map = new daum.maps.Map(mapContainer, mapOption);

                                var geocoder = new daum.maps.services.Geocoder();
                                var listData = [
                                    <% for(TemporaryDTO mDTO : mList) { %>

                                    '<%=CmmUtil.nvl(mDTO.getT_addr())%>',

                                    <%}%>
                                ];

                                var listname = [
                                    <% for(TemporaryDTO mDTO : mList) { %>

                                    '<%=CmmUtil.nvl(mDTO.getT_name())%>',

                                    <%}%>


                                ];

                                listData.forEach(function (addr, index) {
                                    geocoder.addressSearch(addr, function (result, status) {
                                        if (status === daum.maps.services.Status.OK) {
                                            var coords = new daum.maps.LatLng(result[0].y, result[0].x);

                                            var marker = new daum.maps.Marker({
                                                map: map,
                                                position: coords
                                            });
                                            var infowindow = new daum.maps.InfoWindow({
                                                content: '<div style="width:150px;text-align:center;padding:6px 0;">' + listname[index] + '</div>',
                                                disableAutoPan: true
                                            });

                                        }
                                        kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
                                        kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
                                    });
                                });


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


                                //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ


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

                            </script>


                        </div>


                        <!--/ Total Revenue -->
                        <div class="col-12 col-md-8 col-lg-4 order-3 order-md-2">
                            <div class="row">
                                <div class="col-6 mb-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="card-title d-flex align-items-start justify-content-between">
                                                <div class="avatar flex-shrink-0">
                                                    <img src="/assets/img/icons/unicons/paypal.png" alt="Credit Card"
                                                         class="rounded"/>
                                                </div>
                                                <div class="dropdown">
                                                    <button
                                                            class="btn p-0"
                                                            type="button"
                                                            id="cardOpt4"
                                                            data-bs-toggle="dropdown"
                                                            aria-haspopup="true"
                                                            aria-expanded="false"
                                                    >
                                                        <i class="bx bx-dots-vertical-rounded"></i>
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end"
                                                         aria-labelledby="cardOpt4">
                                                        <a class="dropdown-item" href="javascript:void(0);">View
                                                            More</a>
                                                        <a class="dropdown-item" href="javascript:void(0);">Delete</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <span class="d-block mb-1">Payments</span>
                                            <h3 class="card-title text-nowrap mb-2">$2,456</h3>
                                            <small class="text-danger fw-semibold"><i class="bx bx-down-arrow-alt"></i>
                                                -14.82%</small>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-6 mb-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="card-title d-flex align-items-start justify-content-between">
                                                <div class="avatar flex-shrink-0">
                                                    <img src="/assets/img/icons/unicons/cc-primary.png"
                                                         alt="Credit Card" class="rounded"/>
                                                </div>
                                                <div class="dropdown">
                                                    <button
                                                            class="btn p-0"
                                                            type="button"
                                                            id="cardOpt1"
                                                            data-bs-toggle="dropdown"
                                                            aria-haspopup="true"
                                                            aria-expanded="false"
                                                    >
                                                        <i class="bx bx-dots-vertical-rounded"></i>
                                                    </button>
                                                    <div class="dropdown-menu" aria-labelledby="cardOpt1">
                                                        <a class="dropdown-item" href="javascript:void(0);">View
                                                            More</a>
                                                        <a class="dropdown-item" href="javascript:void(0);">Delete</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <span class="fw-semibold d-block mb-1">Transactions</span>
                                            <h3 class="card-title mb-2">$14,857</h3>
                                            <small class="text-success fw-semibold"><i class="bx bx-up-arrow-alt"></i>
                                                +28.14%</small>
                                        </div>
                                    </div>
                                </div>
                                <!-- </div>
                <div class="row"> -->
                                <div class="col-12 mb-4">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="d-flex justify-content-between flex-sm-row flex-column gap-3">
                                                <div class="d-flex flex-sm-column flex-row align-items-start justify-content-between">
                                                    <div class="card-title">
                                                        <h5 class="text-nowrap mb-2">Profile Report</h5>
                                                        <span class="badge bg-label-warning rounded-pill">Year 2021</span>
                                                    </div>
                                                    <div class="mt-sm-auto">
                                                        <small class="text-success text-nowrap fw-semibold"
                                                        ><i class="bx bx-chevron-up"></i> 68.2%</small
                                                        >
                                                        <h3 class="mb-0">$84,686k</h3>
                                                    </div>
                                                </div>
                                                <div id="profileReportChart"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <!-- Order Statistics -->

                        <!--/ Order Statistics -->
                        <div class="col-12 col-lg-8 order-2 order-md-3 order-lg-2 mb-4">
                            <div class="card">
                                <div class="row row-bordered g-0">
                                    <div class="col-md-8">
                                        <h5 class="card-header m-0 me-2 pb-3">Total Revenue</h5>
                                        <div id="totalRevenueChart" class="px-2"></div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="card-body">
                                            <div class="text-center">
                                                <div class="dropdown">
                                                    <button
                                                            class="btn btn-sm btn-outline-primary dropdown-toggle"
                                                            type="button"
                                                            id="growthReportId"
                                                            data-bs-toggle="dropdown"
                                                            aria-haspopup="true"
                                                            aria-expanded="false"
                                                    >
                                                        2022
                                                    </button>
                                                    <div class="dropdown-menu dropdown-menu-end"
                                                         aria-labelledby="growthReportId">
                                                        <a class="dropdown-item" href="javascript:void(0);">2021</a>
                                                        <a class="dropdown-item" href="javascript:void(0);">2020</a>
                                                        <a class="dropdown-item" href="javascript:void(0);">2019</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="growthChart"></div>
                                        <div class="text-center fw-semibold pt-3 mb-2">62% Company Growth</div>

                                        <div class="d-flex px-xxl-4 px-lg-2 p-4 gap-xxl-3 gap-lg-1 gap-3 justify-content-between">
                                            <div class="d-flex">
                                                <div class="me-2">
                                                    <span class="badge bg-label-primary p-2"><i
                                                            class="bx bx-dollar text-primary"></i></span>
                                                </div>
                                                <div class="d-flex flex-column">
                                                    <small>2022</small>
                                                    <h6 class="mb-0">$32.5k</h6>
                                                </div>
                                            </div>
                                            <div class="d-flex">
                                                <div class="me-2">
                                                    <span class="badge bg-label-info p-2"><i
                                                            class="bx bx-wallet text-info"></i></span>
                                                </div>
                                                <div class="d-flex flex-column">
                                                    <small>2021</small>
                                                    <h6 class="mb-0">$41.2k</h6>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Transactions -->
                        <div class="col-md-6 col-lg-4 order-2 mb-4">
                            <div class="card h-100">
                                <div class="card-header d-flex align-items-center justify-content-between">
                                    <h5 class="card-title m-0 me-2">구호물자 구매처 목록</h5>
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
                                        <script type="text/javascript">
                                            var positions = [
                                                <%
                                                       for (int i = 0; i <mList.size(); i++) {
                                                           TemporaryDTO gDTO = mList.get(i);
                                                   %>

                                                {
                                                    "name" : "<%=gDTO.getT_name()%>",
                                                    "kind" : "<%=gDTO.getT_pernum()%>",
                                                    "addr" : "<%=gDTO.getT_addr()%>",
                                                }<%if(i!=mList.size()-1) {%>
                                                ,<%}%>

                                                <%}%>
                                            ];
                                        </script>
                                        <%
                                            for (int i = 0; i < 5; i++) {

                                                TemporaryDTO gDTO = mList.get(i);
                                        %>
                                        <li onclick="showInfo(positions[<%=i%>])" class="d-flex mb-4 pb-1">
                                            <div class="avatar flex-shrink-0 me-3">
                                                <img src="/assets/img/icons/unicons/chart.png" alt="User"
                                                     class="rounded"/>
                                            </div>
                                            <div class="d-flex w-100 flex-wrap align-items-center justify-content-between gap-2">
                                                <div class="me-2">
                                                    <small class="text-muted d-block mb-1"><%=gDTO.getT_addr()%>
                                                    </small>
                                                    <h6 class="mb-0"><%=gDTO.getT_name()%>
                                                    </h6>
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

                <!-- Footer -->
                <footer class="content-footer footer bg-footer-theme">
                    <div class="container-xxl d-flex flex-wrap justify-content-between py-2 flex-md-row flex-column">
                        <div class="mb-2 mb-md-0">
                            ©
                            <script>
                                document.write(new Date().getFullYear());
                            </script>
                            , made with ❤️ by
                            <a href="https://themeselection.com" target="_blank" class="footer-link fw-bolder">ThemeSelection</a>
                        </div>
                        <div>
                            <a href="https://themeselection.com/license/" class="footer-link me-4" target="_blank">License</a>
                            <a href="https://themeselection.com/" target="_blank" class="footer-link me-4">More
                                Themes</a>

                            <a
                                    href="https://themeselection.com/demo/sneat-bootstrap-html-admin-template/documentation/"
                                    target="_blank"
                                    class="footer-link me-4"
                            >Documentation</a
                            >

                            <a
                                    href="https://github.com/themeselection/sneat-html-admin-template-free/issues"
                                    target="_blank"
                                    class="footer-link me-4"
                            >Support</a
                            >
                        </div>
                    </div>
                </footer>
                <!-- / Footer -->

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
<script type="text/javascript">
    function showInfo(infoJson) {

        console.log(infoJson);

        $('#h5').empty();
        $('#h5').append('선택하신 구호식품 구매처의 정보입니다.');
        $('#h5').append('<br/>');

        $('#pText').empty();
        $('#pText').append("대피소명 : ");
        $('#pText').append(infoJson.name);
        $('#pText').append("<br/>");
        $('#pText').append("가용인원수 : ");
        $('#pText').append(infoJson.kind);
        $('#pText').append("<br/>");
        $('#pText').append("주소 : ");
        $('#pText').append(infoJson.addr);
        $('#pText').append("<br/>");
    }
</script>
</body>
</html>