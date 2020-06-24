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
    <link rel="stylesheet" href="./css/student.css">
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
                    <span class="name"></span>
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
                            <li class="match">申请比赛</li>
                            <li class="record">申请记录</li>
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
                                <p>年级</p>
                                <p>专业</p>
                                <p>资料号</p>
                            </div>
                            <div class="check_state">
                                <p>111</p>
                                <p>张三</p>
                                <p>0</p>
                                <p>女</p>
                                <p>电子</p>
                                <p>二</p>
                                <p>通信</p>
                                <p>001</p>
                            </div>
                            <button class="modify">修改</button>
                        </div>
                        <div class="tab2">
                            <div class="application">
                                <p><span>比赛类型:</span><input type="text" class="match_type"></p>
                                <p><span>比赛名字:</span><input type="text" class="match_name"></p>
                                <p><span>比赛时间:</span><input type="text" class="match_time"></p>
                                <button class="match_apply">申请</button>
                            </div>
                        </div>
                        <div class="tab3">
                            <table border="0" cellspacing='0' cellpadding='0'>
                                <thead>
                                    <tr>
                                        <th>比赛类型</th>
                                        <th>比赛时间</th>
                                        <th>比赛具体名称</th>
                                        <th>审批状态</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                        <div class="tab4">
                            <div>
                                <form enctype="multipart/form-data" method="post" target="posthere" action="./user/upload">
                                    　<input type="file" id="upload" name="file" />
                                     <input name="sto" value="" class="file_name"/>
                                    　<input type="submit" value="上传" class="submit" />
                                </form>
                            </div>
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
                    <p>年级:<input type="text" class="input5"></p>
                    <p>专业:<input type="text" class="input6"></p>
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
<script src="./js/student.js"></script>

</html>