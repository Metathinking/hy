<%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2017/7/19.0019
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="baidu-site-verification" content="YmnCpEh7KA"/>
    <meta name="keywords" content="${siteInfo.keywords}"/>
    <meta name="description" content="${siteInfo.description}"/>
    <title>${siteInfo.name}</title>
    <link rel="shortcut icon" href="${siteInfo.icon}"/>
    <script src="/resources/js/jquery-2.1.1.min.js"></script>
    <script src="/resources/js/angular-1.5.0.min.js"></script>

    <link rel="stylesheet" href="/resources/css/bootstrap-front.min.css" media="screen">
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/custom.css">
</head>
<body id="home" ng-app="app" ng-controller="mainController" data-spy="scroll" data-target="#navbar" data-offset="0">
<div class="navbar navbar-default navbar-fixed-top navbar-transparent">
    <div class="container">
        <div class="navbar-header">
            <a href="/" class="navbar-brand"><span style="font-weight:500;">${siteInfo.name}</span></a>
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
            <ul class="nav navbar-nav">
                <li>
                    <a href="http://www.launchingnext.com/browse/">Browse</a>
                </li>
                <li>
                    <a href="http://www.launchingnext.com/trending/">Trending</a>
                </li>
                <li>
                    <a href="http://www.launchingnext.com/tips/">Tips</a>
                </li>
                <li>
                    <a href="http://www.launchingnext.com/blog/">Blog</a>
                </li>
                <li>
                    <a href="https://twitter.com/launchingnext"><i class="fa fa-twitter" style="font-size:1.4em;"></i></a>
                </li>
                <li>
                    <a href="https://www.facebook.com/Launching-Next-1638177256452477/"><i class="fa fa-facebook-official" style="font-size:1.4em;"></i></a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%--<li><a href="http://www.launchingnext.com/submit/"><i class="fa fa-plus-circle"></i> &nbsp;Submit a Startup</a></li>--%>

                    <c:if test="${USER==null}">
                    <li>
                        <a href="/to_login/weixin">登录</a>
                    </li>
                    </c:if>
                    <c:if test="${USER!=null}">
                        <li> <a href="/uc/${USER.openid}" >${USER.nickname}</a></li>
                        <li><a href="/logout">退出</a></li>
                    </c:if>

            </ul>
        </div>
    </div>
</div>
<div class="splash">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">

                <h1>茫茫人海中，只为——找到你</h1>

                <div id="mc_embed_signup">
                    <form action="//minisprout.us2.list-manage.com/subscribe/post?u=681a11824da8fc5774cadb40f&amp;id=8ed9c8eafb" method="post" id="mc-embedded-subscribe-form" name="mc-embedded-subscribe-form" class="validate" target="_blank" novalidate>
                        <label for="mce-EMAIL" style="padding-bottom:4px;">Get the best new startups delivered to your inbox daily!</label>
                        <div class="input-append">
                            <input type="email" value="" name="EMAIL" class="form-control" id="mce-EMAIL" placeholder="email address" required style="width:250px;float:center;font-size:15px;height:43px;color: #555;border: 1px solid #ccc;border-radius: 4px;padding: 0px 0px 0px 10px;	display:inline-block; ">

                            <div style="position: absolute; left: -5000px;"><input type="text" name="b_681a11824da8fc5774cadb40f_8ed9c8eafb" tabindex="-1" value=""></div>
                            <input type="submit" value="Subscribe" name="subscribe" id="mc-embedded-subscribe" class="btn btn-default" style="background-color: #fd5443;float: center;height: 43px;font-size: 15px;color: #fff;border:0px;display: inline-block;">
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<div class="section-preview">
    <div class="container">
        <div style="width:100%;-webkit-border-radius: 10px;-moz-border-radius: 10px;border-radius: 10px;border:1px solid #C2C2C2;background-color:#FFFFFF;padding:15px;text-align:center;margin-bottom:2em;font-size:1.2em;"><span style="font-weight:800;"><i class="fa fa-star" style="color:#f39c12;"></i> NEW! <a href="http://www.hypeurls.com/" target="_blank">Hype URLs</a></span> automatically discovers new startups &amp; apps going viral. <i class="fa fa-rocket" style="color:#FF5252;"></i> <a href="http://www.hypeurls.com/" target="_blank" style="font-weight:800;text-decoration:underline;"> Visit Hype URLs &raquo;</a></div>
        <div class="row" style="margin-bottom:20px;margin-left:0px;"><p><span class="group_day"><i class="fa fa-star" style="color:#f39c12;"></i> Newest</span> <span class="group_date">Startups</span></p></div>
        <div class="row">
<c:forEach items="${list}" var="item">
            <div class="col-lg-3 col-sm-4 col-xs-6">
                <div class="preview">
                    <div class="image">
                        <a href="/get/${item.openid}" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'vidonado']);">
                            <img src="${item.headimgurl}"
                                 class="img-responsive" alt="https://vidonado.com/">
                        </a>
                    </div>
                    <div class="options">
                        <h3>${item.nickname}</h3>
                        <p class="p-introduction">${item.introduction}Connecting amazing talent with amazing companiesConnecting amazing talent with amazing companiesConnecting amazing talent with amazing companiesConnecting amazing talent with amazing companies</p>
                        <%--<div class="btn-group"><a class="btn btn-info" href="/s/vidonado/29043/">More Info</a></div>--%>
                        <div class="btn-group"><a class="btn btn-success" href="https://vidonado.com/" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'vidonado']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                    </div>
                </div>
            </div>
</c:forEach>
            <!--------------------------------------->
            <div class="col-lg-3 col-sm-4 col-xs-6">
            <div class="preview">
                <div class="image">
                    <a href="https://tradifyhq.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'tradify']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/77db3ada86a6c59b4fa5fc43a2c8cd8e/png/?url=https%3A%2F%2Ftradifyhq.com&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="https://tradifyhq.com">
                    </a>
                </div>
                <div class="options">
                    <h3>Tradify</h3>
                    <p>Job Management Software for Tradespeople</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/tradify/29039/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="https://tradifyhq.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'tradify']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-3 col-sm-4 col-xs-6">
            <div class="preview">
                <div class="image">
                    <a href="http://primohiring.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'primo-hiring-']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/56b079d9061ec512782f03ed698ba51b/png/?url=http%3A%2F%2Fprimohiring.com&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="http://primohiring.com">
                    </a>
                </div>
                <div class="options">
                    <h3>Primo Hiring</h3>
                    <p>Connecting amazing talent with amazing companies</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/primo-hiring-/29037/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="http://primohiring.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'primo-hiring-']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-3 col-sm-4 col-xs-6">
            <div class="preview">
                <div class="image">
                    <a href="http://emailmagpie.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'emailmagpie']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/946295c741d064787907b7e57492a0be/png/?url=http%3A%2F%2Femailmagpie.com&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="http://emailmagpie.com">
                    </a>
                </div>
                <div class="options">
                    <h3>EmailMagpie</h3>
                    <p>The simple email finder service. It find business leads for you, so you don't have to.</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/emailmagpie/28994/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="http://emailmagpie.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'emailmagpie']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="http://apiq.io" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'apiq']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/a96f44b98c5f80290c0f9a4df88dbdb8/png/?url=http%3A%2F%2Fapiq.io&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="http://apiq.io">
                    </a>
                </div>
                <div class="options">
                    <h3>APIQ</h3>
                    <p>Simple and powerful CMS for developers and agencies</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/apiq/28993/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="http://apiq.io" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'apiq']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="https://www.breakdown-notes.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'breakdown-notes']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/410ad032fd175f8633bf4d74d6bdf851/png/?url=https%3A%2F%2Fwww.breakdown-notes.com&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="https://www.breakdown-notes.com">
                    </a>
                </div>
                <div class="options">
                    <h3>Breakdown Notes</h3>
                    <p>Create notes, diagrams and mindmaps in your browser</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/breakdown-notes/28992/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="https://www.breakdown-notes.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'breakdown-notes']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="http://www.zipwhip.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'zipwhip']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/0d641e8dad159b80cfb245d23f21988f/png/?url=http%3A%2F%2Fwww.zipwhip.com&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="http://www.zipwhip.com">
                    </a>
                </div>
                <div class="options">
                    <h3>Zipwhip</h3>
                    <p class="p-introduction">Text Messaging for your Existing Business Phone Number</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/zipwhip/28944/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="http://www.zipwhip.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'zipwhip']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="http://smartfinance.pro" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'smart-finance']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/094c68492146a990bc37b69ec35b1302/png/?url=http%3A%2F%2Fsmartfinance.pro&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="http://smartfinance.pro">
                    </a>
                </div>
                <div class="options">
                    <h3>Smart Finance</h3>
                    <p class="p-introduction">Smart Finance for iOS - quickly create and manage personal financial plan with minimum efforts to see free funds for potential investments or purchases</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/smart-finance/28935/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="http://smartfinance.pro" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'smart-finance']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="https://www.helpwith.co/" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'helpwith']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/157c54dc6ab182d84bcaadfbaf24ac96/png/?url=https%3A%2F%2Fwww.helpwith.co%2F&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="https://www.helpwith.co/">
                    </a>
                </div>
                <div class="options">
                    <h3>HelpWith</h3>
                    <p>Learn skills from experienced people in your community! Offer your skills for free, trade, or an hou</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/helpwith/28933/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="https://www.helpwith.co/" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'helpwith']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="http://tripplannera.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'tripplannera']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/e980b0ad9e2282603993bf3257bfcf21/png/?url=http%3A%2F%2Ftripplannera.com&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="http://tripplannera.com">
                    </a>
                </div>
                <div class="options">
                    <h3>TripPlannera</h3>
                    <p>Plan your trip within minutes!</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/tripplannera/28932/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="http://tripplannera.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'tripplannera']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="https://thestartupway.website/" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'thestartupway']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/396e46110898851aa963989f59c68df4/png/?url=https%3A%2F%2Fthestartupway.website%2F&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="https://thestartupway.website/">
                    </a>
                </div>
                <div class="options">
                    <h3>TheStartupWay</h3>
                    <p>Verify your startup ideas using landing pages</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/thestartupway/28931/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="https://thestartupway.website/" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'thestartupway']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="https://work.grytics.com/features/" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'grytics-for-facebook-workplace-']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/efb2d17f2422987c952d10eed1c0cf25/png/?url=https%3A%2F%2Fwork.grytics.com%2Ffeatures%2F&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="https://work.grytics.com/features/">
                    </a>
                </div>
                <div class="options">
                    <h3>Grytics for Facebook Workplace</h3>
                    <p>Get Insights of your Workplace Groups, Posts & Employees !</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/grytics-for-facebook-workplace-/28928/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="https://work.grytics.com/features/" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'grytics-for-facebook-workplace-']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="https://www.oneqstn.com/imessageapp" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'oneqstn-imessage']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/e5a7570b58b8404ae1a7ed2b900b8377/png/?url=https%3A%2F%2Fwww.oneqstn.com%2Fimessageapp&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="https://www.oneqstn.com/imessageapp">
                    </a>
                </div>
                <div class="options">
                    <h3>OneQstn iMessage</h3>
                    <p>Super Simple iMessage Surveys</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/oneqstn-imessage/28919/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="https://www.oneqstn.com/imessageapp" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'oneqstn-imessage']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="https://perfectpage.io" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'perfectpage-io']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/fd15b31608fb6340a62e69e5e2af866a/png/?url=https%3A%2F%2Fperfectpage.io&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="https://perfectpage.io">
                    </a>
                </div>
                <div class="options">
                    <h3>PerfectPage.io</h3>
                    <p>Finally – a website dashboard for the rest of us.</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/perfectpage-io/28909/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="https://perfectpage.io" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'perfectpage-io']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="http://boldleads.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'boldleads-com']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/2c7f4e9f8dba0cc647fa7386aa0a8925/png/?url=http%3A%2F%2Fboldleads.com&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="http://boldleads.com">
                    </a>
                </div>
                <div class="options">
                    <h3>boldleads.com</h3>
                    <p>Automated lead generation and lead nurturing for real estate pros.</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/boldleads-com/28902/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="http://boldleads.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'boldleads-com']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="http://friendtainer.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'friendtainer']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/825bb814a55a4934e123e58ae8c20cba/png/?url=http%3A%2F%2Ffriendtainer.com&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="http://friendtainer.com">
                    </a>
                </div>
                <div class="options">
                    <h3>Friendtainer</h3>
                    <p>Get reminded to meet with friends</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/friendtainer/28901/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="http://friendtainer.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'friendtainer']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="https://bookauthority.org" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'bookauthority']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/2a5eeb70b079db95e52aad100778c94e/png/?url=https%3A%2F%2Fbookauthority.org&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="https://bookauthority.org">
                    </a>
                </div>
                <div class="options">
                    <h3>BookAuthority</h3>
                    <p>The Best Business Books Recommended By Experts</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/bookauthority/28900/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="https://bookauthority.org" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'bookauthority']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="http://geteversleep.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'eversleep']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/cd64622e871da9670359bb499c271c79/png/?url=http%3A%2F%2Fgeteversleep.com&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="http://geteversleep.com">
                    </a>
                </div>
                <div class="options">
                    <h3>EverSleep</h3>
                    <p>EverSleep: The Only 5-in-1 Sleep Tracker</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/eversleep/28898/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="http://geteversleep.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'eversleep']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="http://www.sharetribe.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'sharetribe']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/e32533b20a46f348ad175ac4f6193cc3/png/?url=http%3A%2F%2Fwww.sharetribe.com&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="http://www.sharetribe.com">
                    </a>
                </div>
                <div class="options">
                    <h3>Sharetribe</h3>
                    <p>The easiest way to create an online marketplace</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/sharetribe/28897/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="http://www.sharetribe.com" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'sharetribe']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="https://www.wilderness-now.com/" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'wilderness-now']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/2dea7cd1c98fd0baaea6b078581a00da/png/?url=https%3A%2F%2Fwww.wilderness-now.com%2F&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="https://www.wilderness-now.com/">
                    </a>
                </div>
                <div class="options">
                    <h3>Wilderness Now</h3>
                    <p>First platform for unique UK only travel activities</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/wilderness-now/28896/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="https://www.wilderness-now.com/" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'wilderness-now']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div><div class="col-lg-4 col-sm-6">
            <div class="preview">
                <div class="image">
                    <a href="http://my4.io/" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'my4']);"><img src="https://api.url2png.com/v6/P320EB815A7574F/e0b9c898232e72f10345a6cd60ac591d/png/?url=http%3A%2F%2Fmy4.io%2F&force=false&fullpage=false&thumbnail_max_width=600&viewport=1280x1024" class="img-responsive" alt="http://my4.io/">
                    </a>
                </div>
                <div class="options">
                    <h3>My4</h3>
                    <p>Sports Betting Just Got Social</p>
                    <div class="btn-group"><a class="btn btn-info" href="/s/my4/28891/">More Info</a></div>
                    <div class="btn-group"><a class="btn btn-success" href="http://my4.io/" target="_blank" rel="nofollow" onclick="_gaq.push(['_trackEvent', 'Click', 'my4']);">Visit &nbsp;&nbsp;<i class="fa fa-external-link"></i></a></div>
                </div>
            </div>
        </div>
        </div>
        <div class="row">
            <div class="col-lg-4"> </div>
            <div class="col-lg-4">
                <ul class="pager">
                    <li>1 through 21 </li><li class="next"><a href="/21/">Next →</a></li> </ul>
            </div>
            <div class="col-lg-4"> </div>
        </div>
        <div id="slidebox">
            <a class="close"></a>
            <h2>Get the best new startups right in your Twitter feed</h2>
            <a href="https://twitter.com/launchingnext" class="btn btn-danger" style="text-align:center;" target="_blank"><i class="fa fa-twitter"></i> &nbsp;&nbsp;&nbsp;FOLLOW US »</a>
        </div>
    </div>
</div>
<div class="section-footer">
    <div class="container">
        <footer id="footer">
            <div class="row">
                <div class="col-lg-12">
                    <ul class="list-unstyled">
                        <li class="pull-right"><a href="#top">Back to top</a></li>
                        <li><a href="/submit/">Add your startup</a></li>
                        <li><a href="/advertise/">Promote</a></li>
                        <li><a href="/privacy/">Privacy</a></li>
                        <li><a href="https://twitter.com/launchingnext">@LaunchingNext</a></li>
                        <li><a href="/">New startups</a></li>
                    </ul>
                </div>
                <a href="/submit/" class="btn btn-success">Promote Your Startup for $49</a>
            </div>
            <div class="row" style="margin-top:50px;">
                <div class="col-lg-9">
                    <p><span style="font-weight:300;font-size:2.3em;color:#fff;">Launching</span> <span style="font-weight:700;font-size:2.3em;color:#fff;">Next</span></a></p>
                    <p>Copyright &copy; 2013 - 2017. All rights retained by their respective owners.</p>
                    <p>Home to more than 5,000 new startups, startup ideas and great business ideas. We showcase startups to our thousands of readers.</p>
                </div>
                <div class="col-lg-3"></div>
                <h4>Let's Keep in Touch</h4>
                <ul>
                    <li><a href="https://twitter.com/launchingnext" target="_blank" rel="nofollow"><i class="fa fa-twitter-square"></i> Twitter</a></li>
                    <li><a href="https://www.facebook.com/Launching-Next-1638177256452477/" target="_blank" rel="nofollow"><i class="fa fa-facebook-official"></i> Facebook</a></li>
                    <li><a href="http://www.launchingnext.com/rss.php" target="_blank" rel="nofollow"><i class="fa fa-rss-square"></i> RSS</a></li>
                </ul>
            </div>
        </footer>
    </div>
</div>

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->
<script type="text/rocketscript">

	  var _gaq = _gaq || [];
	  _gaq.push(['_setAccount', 'UA-36080571-1']);
	  _gaq.push(['_trackPageview']);

	  (function() {
	    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
	    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	  })();

	</script>
<script type="text/rocketscript">
	  window.fbAsyncInit = function() {
	    FB.init({
	      appId      : '1763776390521009',
	      xfbml      : true,
	      version    : 'v2.5'
	    });
	  };

	  (function(d, s, id){
	     var js, fjs = d.getElementsByTagName(s)[0];
	     if (d.getElementById(id)) {return;}
	     js = d.createElement(s); js.id = id;
	     js.src = "//connect.facebook.net/en_US/sdk.js";
	     fjs.parentNode.insertBefore(js, fjs);
	   }(document, 'script', 'facebook-jssdk'));
	</script>
</body>
</html>
<script>
    angular.module("app", [])
            .controller("mainController", function ($scope, $http) {
                $scope.select=function(item){
                    $scope.selectSearchType=item;
                };
                $scope.search=function () {
                    $scope.gotoPage(1);
                };
                $scope.prePage=function () {
                    if(${pageQuery.index==1}){
                        return;
                    }
                    $scope.gotoPage(${pageQuery.index-1>0?pageQuery.index-1:1})
                };
                $scope.nextPage=function () {
                    if(${pageQuery.index==pageQuery.pageCount}){
                        return;
                    }
                    $scope.gotoPage(${pageQuery.index+1<pageQuery.pageCount?pageQuery.index+1:pageQuery.pageCount})
                }
                $scope.gotoPage=function(index){
                    window.location.href="/home?searchType="+$scope.selectSearchType.value+"&name="+$scope.searchName+"&index="+index;
                }
            });
</script>