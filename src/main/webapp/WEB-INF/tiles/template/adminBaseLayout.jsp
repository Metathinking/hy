<%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2017/3/20.0020
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>${siteInfo.name}</title>
    <link rel="shortcut icon" href="${siteInfo.icon}"/>
    <!-- Css files -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/jquery.mmenu.css" rel="stylesheet">
    <link href="/resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="/resources/css/climacons-font.css" rel="stylesheet">
    <link href="/resources/css/style.min.css" rel="stylesheet">
    <link href="/resources/css/add-ons.min.css" rel="stylesheet">

    <link href="/resources/plugins/xcharts/css/xcharts.min.css" rel=" stylesheet">
    <link href="/resources/plugins/fullcalendar/css/fullcalendar.css" rel="stylesheet">
    <link href="/resources/plugins/morris/css/morris.css" rel="stylesheet">
    <link href="/resources/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
    <link href="/resources/plugins/jvectormap/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
    <!-- start: JavaScript-->
    <script src="/resources/js/angular-1.5.0.js"></script>
    <script src="/resources/js/main.js"></script>
    <script src="/resources/js/angular-file-upload.min.js"></script>
    <!--[if !IE]>-->
    <script src="/resources/js/jquery-2.1.1.min.js"></script>
    <!--<![endif]-->
    <!--[if IE]>
    <script src="/resources/js/jquery-1.11.1.min.js"></script>

    <![endif]-->
    <!--[if !IE]>-->
    <script type="text/javascript">
        window.jQuery || document.write("<script src='/resources/js/jquery-2.1.1.min.js'>" + "<" + "/script>");
    </script>
    <!--<![endif]-->
    <!--[if IE]>
    <script type="text/javascript">
        window.jQuery || document.write("<script src='/resources/js/jquery-1.11.1.min.js'>"+"<"+"/script>");
    </script>

    <![endif]-->
    <script src="/resources/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <!-- page scripts -->
    <script src="/resources/plugins/jquery-ui/js/jquery-ui-1.10.4.min.js"></script>
    <script src="/resources/plugins/touchpunch/jquery.ui.touch-punch.min.js"></script>
    <script src="/resources/plugins/moment/moment.min.js"></script>
    <script src="/resources/plugins/fullcalendar/js/fullcalendar.min.js"></script>
    <!--[if lte IE 8]>
    <script language="javascript" type="text/javascript" src="/resources/plugins/excanvas/excanvas.min.js"></script>
    <![endif]-->
    <script src="/resources/plugins/flot/jquery.flot.min.js"></script>
    <script src="/resources/plugins/flot/jquery.flot.pie.min.js"></script>
    <script src="/resources/plugins/flot/jquery.flot.stack.min.js"></script>
    <script src="/resources/plugins/flot/jquery.flot.resize.min.js"></script>
    <script src="/resources/plugins/flot/jquery.flot.time.min.js"></script>
    <script src="/resources/plugins/flot/jquery.flot.spline.min.js"></script>
    <script src="/resources/plugins/xcharts/js/xcharts.min.js"></script>
    <script src="/resources/plugins/autosize/jquery.autosize.min.js"></script>
    <script src="/resources/plugins/placeholder/jquery.placeholder.min.js"></script>
    <script src="/resources/plugins/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/resources/plugins/datatables/js/dataTables.bootstrap.min.js"></script>
    <script src="/resources/plugins/raphael/raphael.min.js"></script>
    <script src="/resources/plugins/morris/js/morris.min.js"></script>
    <script src="/resources/plugins/jvectormap/js/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="/resources/plugins/jvectormap/js/jquery-jvectormap-world-mill-en.js"></script>
    <script src="/resources/plugins/jvectormap/js/gdp-data.js"></script>
    <script src="/resources/plugins/gauge/gauge.min.js"></script>
    <!-- theme scripts -->
    <script src="/resources/js/SmoothScroll.js"></script>
    <script src="/resources/js/jquery.mmenu.min.js"></script>
    <script src="/resources/js/core.min.js"></script>
    <script src="/resources/plugins/d3/d3.min.js"></script>

    <!-- inline scripts related to this page -->
    <script src="/resources/js/pages/index.js"></script>
    <!-- end: JavaScript-->
    <script>
        var context = "${context}";
    </script>
</head>
<body ng-app="app">
<!-- start: Header -->
<div class="navbar" role="navigation">
    <div class="container-fluid">
        <ul class="nav navbar-nav navbar-actions navbar-left">
            <li class="visible-md visible-lg"><a href="#" id="main-menu-toggle"><i class="fa fa-th-large"></i></a>
            </li>
            <li class="visible-xs visible-sm"><a href="#" id="sidebar-menu"><i class="fa fa-navicon"></i></a>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown visible-md visible-lg">
                <a href="#" class="dropdown-toggle" ><img class="user-avatar" src="/resources/images/head.jpg" alt="user-mail">${ADMIN.name}</a>
            </li>
            <li><a href="/adminLogin/logout"><i class="fa fa-power-off"></i></a></li>
        </ul>

    </div>

</div>
<!-- end: Header -->

<!-- start: content -->
<div class="container-fluid content">
    <div class="row">
        <!-- start: left-nav -->
        <div class="sidebar ">

            <div class="sidebar-collapse">
                <div class="sidebar-header t-center">
                    <span>wxfindyou<i
                            class="fa fa-space-shuttle fa-3x blue"></i></span>
                </div>
                <div class="sidebar-menu">
                    <ul class="nav nav-sidebar">
                        <c:if test="${ADMIN.powers.SITE_HOME}">
                            <li><a href="/admin/home"><i class="fa fa-laptop"></i><span class="text">网站管理</span></a>
                            </li>
                        </c:if>
                        <c:if test="${ADMIN.powers.USER_MANAGER}">
                            <li>
                                <a href="/admin/userManager/list"><i class="fa fa-file-text"></i><span class="text">用户管理</span></a>
                            </li>
                        </c:if>

                        <c:if test="${ADMIN.powers.SITE_SETTING}">
                            <li>
                                <a href="#"><i class="fa fa-list-alt"></i><span class="text">网站设置</span> <span
                                        class="fa fa-angle-down pull-right"></span></a>
                                <ul class="nav sub">
                                    <li><a href="/admin/siteInfo/edit"><i class="fa fa-indent"></i><span class="text">基础信息</span></a>
                                    </li>
                                    <li><a href="/admin/siteSetting/edit"><i class="fa fa-tags"></i><span
                                            class="text">网站设置</span></a></li>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${ADMIN.powers.POWER_MANAGER}">
                            <li><a href="/admin/manager/edit"><i class="fa fa-table"></i><span class="text">权限管理</span></a></li>
                        </c:if>
                        <c:if test="${ADMIN.powers.LOGIN_LOG}">
                            <li><a href="/admin/managerLoginLog/list"><i class="fa fa-life-bouy"></i><span class="text">登录日志</span></a></li>
                        </c:if>

                    </ul>
                </div>
            </div>
            <div class="sidebar-footer">
                <div class="sidebar-brand">
                    wxfindyou
                </div>
            </div>

        </div>
        <!-- end : left-nav -->

        <!-- start: right-content -->
        <div class="main">
            <tiles:insertAttribute name="content"/>
        </div>
        <!-- end :right-content -->
    </div>
</div>
<!-- end: content -->
</body>
</html>

