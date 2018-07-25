<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<title>left</title>
<style type="text/css">
   body{
     margin: 0px;
     background-color: #00AE72;
     font-family: 华文中宋;
   }
   div{
       margin-left: 0px;
   }
   .c1{
      list-style-type: none;
      font-size: 22px;
      margin-top: 24px;
   }
   a{
     text-decoration: none;
   }
</style>
    <script src="${_plugins}/jmenu/Js/prototype.lite.js" type="text/javascript"></script>
    <script src="${_plugins}/jmenu/Js/moo.fx.js" type="text/javascript"></script>
    <script src="${_plugins}/jmenu/Js/moo.fx.pack.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="${_plugins}/jmenu/Style/skin.css" />
    <script type="text/javascript">
        window.onload = function () {
            var contents = document.getElementsByClassName('content');
            var toggles = document.getElementsByClassName('type');

            var myAccordion = new fx.Accordion(
            toggles, contents, {opacity: true, duration: 400}
            );
            myAccordion.showThisHideOpen(contents[0]);
            for(var i=0; i<document .getElementsByTagName("a").length; i++){
                var dl_a = document.getElementsByTagName("a")[i];
                    dl_a.onfocus=function(){
                        this.blur();
                    };
            }
        };
    </script>
</head>
<body>
  <div>
      <table style=" width:100%; height:280px;cellpadding:0; cellspacing:0; bgcolor:#EEF2FB">
        <tr>
            <td style="width:182px; valign:top">
                <div id="container">
                  <c:forEach var="p" items="${menu}">
                    <h1 class="type"><a href="javascript:void(0)">${p.key.name}</a></h1>
                    <div class="content">
                        <ul class="RM">
                          <c:forEach var="s" items="${p.value}"> 
                            <li><a href="${_cxt}/${s.url}" target="main">${s.name}</a></li>
                          </c:forEach>
                        </ul>
                    </div>
                  </c:forEach>
                </div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>







