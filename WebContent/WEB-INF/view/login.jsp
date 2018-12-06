<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Work flat</title>

<!-- VENDOR CSS -->
	<link rel="stylesheet" href="Public/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="Public/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="Public/vendor/linearicons/style.css">
	<link rel="stylesheet" href="Public/vendor/chartist/css/chartist-custom.css">	
<script type="text/javascript">
        
        
        
        if(window.top!==window.self){window.top.location=window.location};
 </script>
</head>
<body>
	<div id="container">
		<div class="row" style="background:#2b333e;color:lightgray;height:60px;border-bottom:1px lightgray dashed;vertical-align:middle; ">
                <i class="glyphicon glyphicon-home" style="font-size:18px;"></i>&nbsp;&nbsp;&nbsp;&nbsp;
				<small>企业网站后台管理入口</small>

		</div>

		<div class="row" style="background:#2b333e;height:640px;padding-top:50px;border-bottom:1px lightgray dashed;">
			<div class="col-md-5 col-md-offset-4" 
				style="border: thin white dashed;margin-top:25px;padding:10px;color:lightgray;">


				<form role="form" action="" method="post">
					<table class="table table-condensed">
						<tr>
							<td>
							<span class="glyphicon glyphicon-user">
							   欢迎登录
							</span>
							</td>
							<td class="error">
                              ${error}
                           </td>  	
						</tr>
                        
  					
						<tr>
							<td class="text-right">名称</td>
							<td><input type="text" name="username" id="name"
								class="form-control" placeholder="请输入名称" /></td>
						</tr>

						<tr>
							<td class="text-right">密码</td>
							<td><input type="password" name="password" id="password"
								class="form-control" placeholder="请输入密码" />
							</td>
						</tr>

                    
						<tr>
							<td></td>
							<td class="text-right">

								<button type="submit" class="btn btn-primary btn-sx">
									登录
								</button>
							</td>
						</tr>
					</table>

				</form>
			</div>
		</div>

		<div class="row text-center" style="height:5px;padding-top:5px;color:lightgray;">
			
			<h5>&copy;版权所有 2016-2022</h5>

		</div>
	</div>
</body>
</html>