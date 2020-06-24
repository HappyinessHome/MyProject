<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"  import="java.util.List,java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>学校管理系统</title>
    <link rel="stylesheet" href="./css/index.css">
    <link rel="stylesheet" href="./css/measure.css">
    <link rel="stylesheet" href="./css/teacher.css">
</head>

<body>
    <div>
        <header>
            <div>
                <div class="header_left">
                    <span>学校管理系统</span>
                </div>
                <div class="header-right">
                    <span class="day"></span>
                    <span>|</span>
                    <span class="time"></span>
                </div>
            </div>
        </header>
        <nav>
            <div>
                <div class="nav_right">
                    <img src="./images/person.png" alt="" class="person">
                    <span class="name">张三</span>
                    <span class="line">|</span>
                    <span class="quit">退出</span>
                    <span class="line">|</span>
                    <span class="fit">设置</span>
                </div>
            </div>
        </nav>

        
        <div class="data_base">
            <div>
                <div class="section clearfloat">
                    <div class="section_left _left">
                        <ul>
                            <li class="information bg_color">个人信息</li>
                            <li class="record">审批记录</li>
                            <li class="summary">比赛总结资料</li>
                        </ul>
                    </div>
                    <div class="section_right _right">
                        <div class="tab1">
                            <div class="check_name">
                                <p>学号</p>
                                <p>姓名</p>
                                <p>年龄</p>  
                                <p>性别</p>
                                <p>学院</p>
                                <p>资料号</p>
                            </div>
                            <div class="check_state">
                                <p>111</p>
                                <p>张三</p>
                                <p>0</p>
                                <p>女</p>
                                <p>电子</p>
                                <p>001</p>
                            </div>
                            <button class="modify">修改</button>
                        </div>
                        <div class="tab3">
                            <table border="0" cellspacing='0' cellpadding='0'>
                                <thead>
                                    <tr>
                                        <th>比赛具体名称</th>
                                        <th>比赛时间</th>
                                        <th>申请人</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                        <div class="tab4">
                            <table border="0" cellspacing='0' cellpadding='0'>
                                <thead>
                                    <tr>
                                        <th>上传人</th>
                                        <th>文件名</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="modify_information">
            <div class="modify_box">
                <p>姓名:<input type="text" class="input1"></p>
                <p>年龄:<input type="text" class="input2"></p>
                <p>性别:<input type="text" class="input3"></p>
                <p>学院:<input type="text" class="input4"></p>
                <button class="cancel">取消</button>
                <button class="determine">确定</button>
            </div>
        </div>



        <!-- 删除 -->
        <div class="delect">
            <div class="delect_people">
                <div class="delect_People">
                    <p>是否删除</p>
                    <span class="yes">确定</span>
                    <span class="cancel">取消</span>
                </div>
            </div>
        </div>


        <!-- 退出 -->
        <div class="return">
            <div class="return_select">
                <div>
                    <p>是否确认退出</p>
                    <span>确认</span>
                    <span>取消</span>
                </div>
            </div>
        </div>

        <div class="setUp_password">
            <div class="cover_password">
                <div class="cover_passWord">
                    <div class="pass_entry">
                        <span>修改密码：</span><input type="password" class="one_password"><br><br>
                        <span>确认密码：</span><input type="password" class="two_password"><span
                            class="hide_pass">请输入相同密码</span><br>
                        <button class="pass_addtrue">确定</button>
                        <button class="pass_cancel">取消</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="exception">
            <div class="system_exception">
                <div class="systemException">
                    <div>
                        <p>登陆超时，请重新登录</p>
                        <button class="return_turn">确定</button>
                    </div>
                </div>
            </div>
        </div>
</body>
<script src="./js/jquery-1.7.1.min.js"></script>
<script src="./js/mea_loading.js"></script>
<script src="./js/time.js"></script>
<script src="./js/teacher.js"></script>

</html>