<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑相片信息</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">相片信息管理</li>
                        <li class="breadcrumb-item active">编辑相片信息</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">相片信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6">
                                        <label>相册编号</label>
                                        <input id="odd" name="odd" class="form-control"
                                               placeholder="相册编号" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>相册名称</label>
                                        <input id="xcname" name="xcname" class="form-control"
                                               placeholder="相册名称" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>相册封面</label>
                                        <img id="imgPhotoImg" src="" width="100" height="100">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>相册主人</label>
                                        <input id="yonghuId" name="yonghuId" class="form-control"
                                               placeholder="相册主人" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>图片数量</label>
                                        <input id="number" name="number" class="form-control"
                                               placeholder="图片数量" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>创建时间</label>
                                        <input id="chuanjianTime" name="chuanjianTime" class="form-control"
                                               placeholder="创建时间" readonly>
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="xiangcheId" name="xiangcheId" type="hidden">
                                    <div class="form-group col-md-6">
                                        <label>相片名称</label>
                                        <input id="xpname" name="xpname" class="form-control"
                                               placeholder="相片名称">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>拍摄地点</label>
                                        <input id="paishedidian" name="paishedidian" class="form-control"
                                               placeholder="拍摄地点">
                                    </div>
                                   <div class="form-group col-md-6">
                                       <label>相片</label>
                                       <img id="xpimgPhotoImg" src="" width="100" height="100">
                                       <input name="file" type="file" id="xpimgPhotoupload"
                                              class="form-control-file">
                                       <input name="xpimgPhoto" id="xpimgPhoto-input" type="hidden">
                                   </div>
                                    <div class="form-group col-md-6">
                                        <label>相片拍摄人</label>
                                        <input id="paisheren" name="paisheren" class="form-control"
                                               placeholder="相片拍摄人">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>相片大小</label>
                                        <input id="xpsize" name="xpsize" class="form-control"
                                               placeholder="相片大小">
                                    </div>
                                   <div class="form-group col-md-6">
                                       <label>相片分类</label>
                                       <select id="fenleiTypesSelect" name="fenleiTypes" class="form-control">
                                       </select>
                                   </div>
                                   <div class="form-group  col-md-6">
                                       <label>相片描述</label>
                                       <input id="xiangpianContentupload" name="file" type="file">
                                       <script id="xiangpianContentEditor" type="text/plain"
                                               style="width:100%;height:230px"></script>
                                       <script type = "text/javascript" >
                                       //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                       //相见文档配置属于你自己的编译器
                                       var xiangpianContentUe = UE.getEditor('xiangpianContentEditor', {
                                           toolbars: [
                                               [
                                                   'undo', //撤销
                                                   'bold', //加粗
                                                   'redo', //重做
                                                   'underline', //下划线
                                                   'horizontal', //分隔线
                                                   'inserttitle', //插入标题
                                                   'cleardoc', //清空文档
                                                   'fontfamily', //字体
                                                   'fontsize', //字号
                                                   'paragraph', //段落格式
                                                   'inserttable', //插入表格
                                                   'justifyleft', //居左对齐
                                                   'justifyright', //居右对齐
                                                   'justifycenter', //居中对
                                                   'justifyjustify', //两端对齐
                                                   'forecolor', //字体颜色
                                                   'fullscreen', //全屏
                                                   'edittip ', //编辑提示
                                                   'customstyle', //自定义标题
                                               ]
                                           ]
                                       });
                                       </script>
                                       <input type="hidden" name="xiangpianContent" id="xiangpianContent-input">
                                   </div>
                                <div class="form-group col-md-12 mb-3">
                                    <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                    <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
</script><script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "xiangpian";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var fenleiTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var xiangcheOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

        $('#xpimgPhotoupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                var photoUrl= baseUrl + 'file/download?fileName=' + data.result.file;
                document.getElementById('xpimgPhotoImg').setAttribute('src',photoUrl);
                document.getElementById('xpimgPhoto-input').setAttribute('value',photoUrl);
            }
        });


        $('#xiangpianContentupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                UE.getEditor('xiangpianContentEditor').execCommand('insertHtml', '<img src=\"' + baseUrl + 'upload/' + data.result.file + '\" width=900 height=560>');
            }
        });


    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
           if($("#xiangcheId") !=null){
               var xiangcheId = $("#xiangcheId").val();
               if(xiangcheId == null || xiangcheId =='' || xiangcheId == 'null'){
                   alert("相册编号不能为空");
                   return;
               }
           }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                successMes = '添加成功';
            }
            httpJson("xiangpian/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addxiangpian');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        function fenleiTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=fenlei_types", "GET", {}, (res) => {
                if(res.code == 0){
                    fenleiTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function xiangcheSelect() {
            //填充下拉框选项
            http("xiangche/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    xiangcheOptions = res.data.list;
                }
            });
        }

        function xiangcheSelectOne(id) {
            http("xiangche/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                xiangcheShowImg();
                xiangcheDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationFenleitypesSelect(){
            var fenleiTypesSelect = document.getElementById('fenleiTypesSelect');
            if(fenleiTypesSelect != null && fenleiTypesOptions != null  && fenleiTypesOptions.length > 0 ){
                for (var i = 0; i < fenleiTypesOptions.length; i++) {
                    fenleiTypesSelect.add(new Option(fenleiTypesOptions[i].indexName,fenleiTypesOptions[i].codeIndex));
                }
            }
        }

    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
        function initializationxiangcheSelect() {
            var xiangcheSelect = document.getElementById('xiangcheSelect');
            if(xiangcheSelect != null && xiangcheOptions != null  && xiangcheOptions.length > 0 ) {
                for (var i = 0; i < xiangcheOptions.length; i++) {
                        xiangcheSelect.add(new Option(xiangcheOptions[i].name, xiangcheOptions[i].id));
                }

                $("#xiangcheSelect").change(function(e) {
                        xiangcheSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->

        var fenleiTypesSelect = document.getElementById("fenleiTypesSelect");
        if(fenleiTypesSelect != null && fenleiTypesOptions != null  && fenleiTypesOptions.length > 0 ) {
            for (var i = 0; i < fenleiTypesOptions.length; i++) {
                if (fenleiTypesOptions[i].codeIndex == ruleForm.fenleiTypes) {//下拉框value对比,如果一致就赋值汉字
                        fenleiTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var xiangcheSelect = document.getElementById("xiangcheSelect");
            if(xiangcheSelect != null && xiangcheOptions != null  && xiangcheOptions.length > 0 ) {
                for (var i = 0; i < xiangcheOptions.length; i++) {
                    if (xiangcheOptions[i].id == ruleForm.xiangcheId) {//下拉框value对比,如果一致就赋值汉字
                        xiangcheSelect.options[i+1].selected = true;
                        $("#xiangcheSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
        if (ruleForm.xiangpianContent != null && ruleForm.xiangpianContent != 'null' && ruleForm.xiangpianContent != '') {

            var xiangpianContentUeditor = UE.getEditor('xiangpianContentEditor');
            xiangpianContentUeditor.ready(function () {
                var mes = '' + ruleForm.xiangpianContent;
                xiangpianContentUeditor.setContent(mes);
            });
        }
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
        var xiangpianContentEditor =UE.getEditor('xiangpianContentEditor');
        if (xiangpianContentEditor.hasContents()) {
                $('#xiangpianContent-input').attr('value', xiangpianContentEditor.getPlainTxt());
        }
    }
    //数字检查
        <!-- 当前表的数字检查 -->

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addxiangpian');
        window.location.href = "../xiangche/list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                xiangcheId: "required",
                xpname: "required",
                paishedidian: "required",
                xpimgPhoto: "required",
                paisheren: "required",
                xpsize: "required",
                fenleiTypes: "required",
                xiangpianContent: "required",
            },
            messages: {
                xiangcheId: "相册编号不能为空",
                xpname: "相片名称不能为空",
                paishedidian: "拍摄地点不能为空",
                xpimgPhoto: "相片不能为空",
                paisheren: "相片拍摄人不能为空",
                xpsize: "相片大小不能为空",
                fenleiTypes: "相片分类不能为空",
                xiangpianContent: "相片描述不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addxiangpian = window.sessionStorage.getItem("addxiangpian");
        if (addxiangpian != null && addxiangpian != "" && addxiangpian != "null") {
            window.sessionStorage.removeItem('addxiangpian');
            //注册表单验证
            $(validform());
            $('#submitBtn').text('新增');
            xiangcheSelectOne(window.sessionStorage.getItem('xiangcheId'));

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("xiangpian/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        xiangcheDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#xiangcheId").val(ruleForm.xiangcheId);
        $("#xpname").val(ruleForm.xpname);
        $("#paishedidian").val(ruleForm.paishedidian);
        $("#paisheren").val(ruleForm.paisheren);
        $("#xpsize").val(ruleForm.xpsize);
        $("#xiangpianContent").val(ruleForm.xiangpianContent);

    }
    <!--  级联表的数据回显  -->
    function xiangcheDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#xiangcheId").val(ruleForm.id);

        $("#odd").val(ruleForm.odd);
        $("#xcname").val(ruleForm.xcname);
        $("#yonghuId").val(ruleForm.yonghuId);
        $("#number").val(ruleForm.number);
        $("#chuanjianTime").val(ruleForm.chuanjianTime);//把时间戳转换为日期带时分秒格式
        $("#xiangcheContent").val(ruleForm.xiangcheContent);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->
        $("#xpimgPhotoImg").attr("src",ruleForm.xpimgPhoto);

        <!--  级联表的图片  -->
        xiangcheShowImg();
    }


    <!--  级联表的图片  -->

    function xiangcheShowImg() {
        $("#imgPhotoImg").attr("src",ruleForm.imgPhoto);
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            fenleiTypesSelect();
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            xiangcheSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationFenleitypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationxiangcheSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') != '管理员') {
            $('#jifen').attr('readonly', 'readonly');
            //$('#money').attr('readonly', 'readonly');
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>