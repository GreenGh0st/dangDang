<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<link href="css/sousuo.css" rel="stylesheet" type="text/css"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 30px">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-plus"></span>注册
                </div>
                <div class="panel-body">
                    <form action="check_reg.jsp" method="POST" name="registerForm">
                        <div class="form-group">
                            用户名 <input type="text"
                                       class="form-control" name="name" placeholder="请输入用户名"
                                       autofocus="autofocus">
                        </div>
                        <div class="form-group">
                            密码 <input type="password"
                                      class="form-control" name="pwd" placeholder="请输入密码">
                        </div>
                        <div class="form-group">
                            重复密码 <input type="password"
                                        class="form-control" name="repwd" placeholder="请重复密码">
                        </div>
                        <div class="form-group">
                            姓名 <input type="text"
                                        class="form-control" name="realname" placeholder="请输入姓名">
                        </div>

                        <div class="form-group">
                            性别
                            <div class="sexDiv">
                            男<input type="radio" name="gender" class="selectSex" value="男" />
                            女<input type="radio" name="gender" class="selectSex" value="女" />
                            </div>
                        </div>
                        <div class="form-group">
                            邮箱 <input type="text"
                                        class="form-control" name="email" placeholder="请输入邮箱">
                        </div>
                        <div class="form-group">
                            手机号 <input type="text"
                                        class="form-control" name="tel" placeholder="请输入手机号">
                        </div>
                        <div class="form-group">
                            地址 <input type="text"
                                        class="form-control" name="address" placeholder="请输入地址">
                        </div>
                        <button type="submit" class="btn btn-primary"
                                onclick="return checkForm()">注册
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
<script type="text/javascript">
    function checkForm() {
        var name = registerForm.name.value;
        var pwd = registerForm.pwd.value;
        var repwd = registerForm.repwd.value;
        var realname = registerForm.realname.value;
        var gender = registerForm.gender.value;
        var email = registerForm.email.value;
        var tel = registerForm.tel.value;
        var address = registerForm.address.value;
        //alert(name + pwd + repwd);
        if (name == "" || name == null) {
            alert("请输入用户名");
            registerForm.name.focus();
            return false;
        } else if (pwd == "" || pwd == null) {
            alert("请输入密码");
            registerForm.pwd.focus();
            return false;
        } else if (repwd == "" || repwd == null) {
            alert("请输入重复密码");
            registerForm.repwd.focus();
            return false;
        } else if (pwd != repwd) {
            alert("两次密码输入不一致，请重新输入!");
            registerForm.repwd.focus();
            return false;
        } else if (realname == "" || realname == null) {
            alert("请输入姓名");
            registerForm.realname.focus();
            return false;
        } else if (gender == "" || gender == null) {
            alert("请输入性别“男”或“女”");
            registerForm.gender.focus();
            return false;
        } else if (email == "" || email == null) {
            alert("请输入邮箱");
            registerForm.email.focus();
            return false;
        } else if (tel == "" || tel == null) {
            alert("请输入手机号");
            registerForm.tel.focus();
            return false;
        } else if (address == "" || address == null) {
            alert("请输入地址");
            registerForm.address.focus();
            return false;

            alert('注册成功！');
            return true;
        }
    }
</script>
</body>
</html>