var App = function () {
    var _checkboxMaster;
    var _checkbox;

    var _idArray;

    /**
     * 初始化icheck
     */
    var handlerInitCheckbox = function () {
        // 激活 iCheck
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });

        //获取控制端CheckBox
        _checkboxMaster = $('input[type="checkbox"].minimal.icheck_master');

        //获取全部CheckBox
        _checkbox = $('input[type="checkbox"].minimal');
    };

    /**
     * Checkbox全选功能
     */
    var handlerCheckboxAll = function () {
        _checkboxMaster.on("ifClicked", function (e) {
            // 当前状态已选中，点击后应取消选择
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            }

            // 当前状态未选中，点击后应全选
            else {
                _checkbox.iCheck("check");
            }
        });
    };

    /**
     * 批量删除
     */
    var handlerDeleteMulti = function (url) {
        _idArray = [];
        //将选中元素的id放入数组中
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id !== "undefine" && $(this).is(":checked")) {
                _idArray.push(_id);
            }
        });

        if (_idArray.length === 0) {
            $("#modal-message").html("您还没有选择任何数据，请至少选择一个");
        }
        else {
            $("#modal-message").html("您确定删除数据项吗？");
        }
        $("#modal-default").modal("show");

        $("#btnModalOK").bind("click", function () {
            del();
        });

        function del() {
            if (_idArray.length === 0) {
                $("#modal-default").modal("hide");
            }
            else {
                $.ajax({
                    "url": url,
                    "type": "POST",
                    "data": {"ids": _idArray.toString()},
                    "dataType": "JSON",
                    "success": function (data) {
                        //删除成功
                        if (data.status === 200) {
                            window.location.reload();
                        }
                    }
                });
            }
        }
    };

    return {
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        getCheckbox:function () {
            return _checkbox;
        },

        deleteMulti:function (url) {
            handlerDeleteMulti(url);
        }
    }

};

$(document).ready(function () {
    App.init();
});