<%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2017/3/23.0023
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <div class="col-lg-12">
        <h3 class="page-header"><i class="fa fa-table"></i>首页</h3>
    </div>
</div>
<script>

</script>
<div class="row">
    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
        <div class="panel panel-default calendar">
            <div class="calendar-small"></div>
            <div class="list">
                <ul>
                    <%--<li>--%>
                        <%--<label class="custom-checkbox-item">--%>
                            <%--<input class="custom-checkbox" type="checkbox"/>--%>
                            <%--<span class="custom-checkbox-mark"></span>--%>
                            <%--<span class="custom-checkbox-desc">Lunch With Clients</span>--%>
                            <%--<i class="fa fa-thumbs-o-up"></i>--%>
                        <%--</label>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<label class="custom-checkbox-item">--%>
                            <%--<input class="custom-checkbox" type="checkbox"/>--%>
                            <%--<span class="custom-checkbox-mark"></span>--%>
                            <%--<span class="custom-checkbox-desc">Meeting With All Staff</span>--%>
                            <%--<i class="fa fa-space-shuttle"></i>--%>
                        <%--</label>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<label class="custom-checkbox-item">--%>
                            <%--<input class="custom-checkbox" type="checkbox"/>--%>
                            <%--<span class="custom-checkbox-mark"></span>--%>
                            <%--<span class="custom-checkbox-desc">Factory Birthday</span>--%>
                            <%--<i class="fa fa-star-half-o"></i>--%>
                        <%--</label>--%>
                    <%--</li>--%>
                </ul>
                <div class="row">
                    <div class="col-xs-6">
                        <button type="button" class="btn btn-success btn-block">Accept</button>
                    </div><!--/col-->
                    <div class="col-xs-6">
                        <button type="button" class="btn btn-default btn-block">Discard</button>
                    </div><!--/col-->
                </div><!--/row-->
                <%--<div class="row">--%>
                <%--<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">--%>
                <%--<div class="panel panel-default">--%>
                <%--<div class="panel-heading">--%>
                <%--<h2><i class="fa fa-retweet red"></i><strong>Interacting With Points</strong></h2>--%>
                <%--<div class="panel-actions">--%>
                <%--<a href="charts-xcharts.html#" class="btn-setting"><i class="fa fa-rotate-right"></i></a>--%>
                <%--<a href="charts-xcharts.html#" class="btn-minimize"><i class="fa fa-chevron-up"></i></a>--%>
                <%--<a href="charts-xcharts.html#" class="btn-close"><i class="fa fa-times"></i></a>--%>
                <%--</div>--%>
                <%--</div>--%>
                <%--<div class="panel-body">--%>
                <%--<figure class="demo" id="example4" style="height: 300px"></figure>--%>
                <%--</div>--%>
                <%--</div>--%>

                <%--</div><!--/col-->--%>
                <%--</div>--%>
            </div>
        </div>
    </div>

    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
        <jsp:useBean id="dateValue" class="java.util.Date"/>
        <c:forEach items="${growRecordList}" var="item">
            <jsp:setProperty name="dateValue" property="time" value="${item.startTime}"/>
            <%--<fmt:formatDate value="${dateValue}" pattern="MM/dd/yyyy HH:mm"/>--%>
            <fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd"  type="both" dateStyle="long" timeStyle="long"/> 增加${item.count}<br/>
        </c:forEach>
    </div>
</div>
