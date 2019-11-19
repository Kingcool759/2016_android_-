<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"  charset=utf-8" />
<title>products_list</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(images/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
td.fenye{ padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9}
</style>
</head>
<body>
<!--main_top-->
<form action="cakeServlet_houtai"></form>
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：蛋糕管理</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form method="post" action="">
	         <span>蛋糕</span>
	         <input type="text" name="" value="" class="text-word">
	         <input name="" type="button" value="查询" class="text-but">
	         </form>
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="add_cake.html" target="mainFrame" onFocus="this.blur()" class="add">新添</a></td>
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright">编号</th>
        <th align="center" valign="middle" class="borderright">名称</th>
        <th align="center" valign="middle" class="borderright">口味</th>
        <th align="center" valign="middle" class="borderright">尺寸</th>
        <th align="center" valign="middle" class="borderright">价格</th>
        <th align="center" valign="middle" class="borderright">图片URL</th>
        <th align="center" valign="middle">操作</th>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">1</td>
        <td align="center" valign="middle" class="borderright borderbottom">美刀刀蛋糕</td>
        <td align="center" valign="middle" class="borderright borderbottom">芝士口味</td>
        <td align="center" valign="middle" class="borderright borderbottom">20英寸</td>
        <td align="center" valign="middle" class="borderright borderbottom">￥298</td>
        <td align="center" valign="middle" class="borderright borderbottom">http://www.baidu.***</td>
        <td align="center" valign="middle" class="borderbottom"><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
      </tr>
      <tr class="bggray" onMouseOut="this.style.backgroundColor='#f9f9f9'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">2</td>
        <td align="center" valign="middle" class="borderright borderbottom">雪域牛乳芝士蛋糕</td>
        <td align="center" valign="middle" class="borderright borderbottom">雪域口味</td>
        <td align="center" valign="middle" class="borderright borderbottom">13英寸</td>
        <td align="center" valign="middle" class="borderright borderbottom">￥198</td>
        <td align="center" valign="middle" class="borderright borderbottom">http://www.baidu.***</td>
        <td align="center" valign="middle" class="borderbottom"><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">3</td>
        <td align="center" valign="middle" class="borderright borderbottom">提拉米苏乐脆蛋糕</td>
        <td align="center" valign="middle" class="borderright borderbottom">慕斯口味</td>
        <td align="center" valign="middle" class="borderright borderbottom">13英寸</td>
        <td align="center" valign="middle" class="borderright borderbottom">￥168</td>
        <td align="center" valign="middle" class="borderright borderbottom">http://www.baidu.***</td>
        <td align="center" valign="middle" class="borderbottom"><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
      </tr>
      <tr class="bggray" onMouseOut="this.style.backgroundColor='#f9f9f9'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">4</td>
        <td align="center" valign="middle" class="borderright borderbottom">辣么巧流心蛋糕</td>
        <td align="center" valign="middle" class="borderright borderbottom">巧克力味</td>
        <td align="center" valign="middle" class="borderright borderbottom">巧克力味</td>
        <td align="center" valign="middle" class="borderright borderbottom">￥198</td>
        <td align="center" valign="middle" class="borderright borderbottom">http://www.baidu.***</td>
        <td align="center" valign="middle" class="borderbottom"><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">5</td>
        <td align="center" valign="middle" class="borderright borderbottom">草莓拿破仑蛋糕</td>
        <td align="center" valign="middle" class="borderright borderbottom">鲜果口味</td>
        <td align="center" valign="middle" class="borderright borderbottom">13英寸</td>
        <td align="center" valign="middle" class="borderright borderbottom">￥198</td>
        <td align="center" valign="middle" class="borderright borderbottom">http://www.baidu.***</td>
        <td align="center" valign="middle" class="borderbottom"><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
      </tr>
      <tr class="bggray" onMouseOut="this.style.backgroundColor='#f9f9f9'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">6</td>
        <td align="center" valign="middle" class="borderright borderbottom">数字蛋糕</td>
        <td align="center" valign="middle" class="borderright borderbottom">冰淇淋味</td>
        <td align="center" valign="middle" class="borderright borderbottom">13英寸</td>
        <td align="center" valign="middle" class="borderright borderbottom">￥198</td>
        <td align="center" valign="middle" class="borderright borderbottom">http://www.baidu.***</td>
        <td align="center" valign="middle" class="borderbottom"><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">7</td>
        <td align="center" valign="middle" class="borderright borderbottom">原味千层蛋糕</td>
        <td align="center" valign="middle" class="borderright borderbottom">奶油口味</td>
        <td align="center" valign="middle" class="borderright borderbottom">13英寸</td>
        <td align="center" valign="middle" class="borderright borderbottom">￥198</td>
        <td align="center" valign="middle" class="borderright borderbottom">http://www.baidu.***</td>
        <td align="center" valign="middle" class="borderbottom"><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
      </tr>
      <tr class="bggray" onMouseOut="this.style.backgroundColor='#f9f9f9'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">8</td>
        <td align="center" valign="middle" class="borderright borderbottom">海盐乳酪芝士蛋糕</td>
        <td align="center" valign="middle" class="borderright borderbottom">芝士口味</td>
        <td align="center" valign="middle" class="borderright borderbottom">13英寸</td>
        <td align="center" valign="middle" class="borderright borderbottom">￥198</td>
        <td align="center" valign="middle" class="borderright borderbottom">http://www.baidu.***</td>
        <td align="center" valign="middle" class="borderbottom"><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">9</td>
        <td align="center" valign="middle" class="borderright borderbottom">阿尔蒙麦香蛋糕</td>
        <td align="center" valign="middle" class="borderright borderbottom">慕斯口味</td>
        <td align="center" valign="middle" class="borderright borderbottom">13英寸</td>
        <td align="center" valign="middle" class="borderright borderbottom">￥198</td>
        <td align="center" valign="middle" class="borderright borderbottom">http://www.baidu.***</td>
        <td align="center" valign="middle" class="borderbottom"><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span><a href="add.html" target="mainFrame" onFocus="this.blur()" class="add">删除</a></td>
      </tr>
    </table></td>
    </tr>
  <tr>
    <td align="left" valign="top" class="fenye">9 条数据 1/1 页&nbsp;&nbsp;<a href="products_list.jsp" target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;<a href="products_list.jsp" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;<a href="products_list2.jsp" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;<a href="products_list2.jsp" target="mainFrame" onFocus="this.blur()">尾页</a></td>
  </tr>
</table>
</body>
</html>