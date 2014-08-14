$(document).ready(function() {
    // 获取当前用户信息
    var sex = $("#sexValue").val();
    var schoolId = $("#schoolIdValue").val();
    var locationId = $("#locationIdValue").val();
    
    if (sex == 0) {
        $("input:radio[name='sex']:eq(0)").prop("checked", true);
    }
    else {
        $("input:radio[name='sex']:eq(1)").prop("checked", true);
    }

    loadLocationData();
    loadSchoolData();
    
    setSchoolSelect(schoolId, "#schoolLocationSelect", "#schoolSelect");
    setLocationSelect(locationId, "#provinceSelect", "#citySelect", "#areaSelect");
});