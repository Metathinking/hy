<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar-wrapper">
    <div class="container-fluid">
        <nav class="navbar navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/manager/userManager/list.html">${siteInfo.name}——后台管理</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li ng-class="{active:nav.index==1}"><a href="${pageContext.request.contextPath}/manager/product/upload">网站管理</a></li>
                        <li ng-class="{active:nav.index==2}"><a href="${pageContext.request.contextPath}/manager/product/list">商品管理</a></li>
                        <%--<li ng-class="{active:nav.index==4}"><a href="${pageContext.request.contextPath}/manager/email/send.html">邮件管理</a></li>--%>
                        <%--<li ng-class="{active:nav.index==5}"><a href="${pageContext.request.contextPath}/manager/siteInfo/edit.html">网站设置</a></li>--%>
                        <li ng-class="{active:nav.index==6}"><a href="${pageContext.request.contextPath}/">查看首页</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <li class=""><a href="${pageContext.request.contextPath}/adminLogin/logout">退出</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
