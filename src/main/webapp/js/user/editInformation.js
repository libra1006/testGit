/**
 * 
 */
$(document).ready(function() {
    // 设置地区下拉框数据
    setLoactionSelect(0, "#locationSelect");
    
    $("#locationSelect").change(
        function() {
            var parrentId = $("#locationSelect").val();
            if (parrentId != "-1") {
                setSchoolSelect(parrentId, "#schoolSelect");
            }
            $("#schoolSelect").val("-1");
        }
    )
    
    setLoactionSelect(0, "#provinceSelect");
    $("#areaSelect").hide();
    
    $("#provinceSelect").change(
        function() {
            var parrentId = $("#provinceSelect").val();
            if (parrentId != "-1") {
                setLoactionSelect(parrentId, "#citySelect");
            }
            $("#citySelect").val("-1");
            $("#areaSelect").empty();
            $("#areaSelect").hide();
        }
    )
    
    $("#citySelect").change(
        function() {
            var parrentId = $("#citySelect").val();
            if (parrentId != "-1") {
                setLoactionSelect(parrentId, "#areaSelect");
                $("#areaSelect").show();
            }
            else {
                $("#areaSelect").empty();
                $("#areaSelect").hide();
            }
            $("#areaSelect").val("-1");
        }
    )
});


