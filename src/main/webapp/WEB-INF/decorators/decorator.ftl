<!DOCTYPE html>
<html>
<head>
    <title>
        <sitemesh:write property="title"/>
    </title>
    <sitemesh:write property='head'/>
</head>
<body>
	<h1>这是模板页内容</h1>
	<h2>模板页参数获取成功,证明模板页被springmvc正确渲染:${param}</h2>
	<h3>目标页面内容 start</h3>
	<sitemesh:write property='body'/>
	<h3>目标页面内容 end</h3>
	<sitemesh:write property="foot"/>
</body>
</html>