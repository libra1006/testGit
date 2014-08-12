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
});