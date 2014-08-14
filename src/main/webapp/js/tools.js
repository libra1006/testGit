/**
 * 
 */
// 加载地区数据
var locationData = null;
function loadLocationData() {
    $.ajax({
        async: false,
        url: "loadLocationData",
        type: "Post",
        success: function(data, result) {
            var dataString = JSON.stringify(data);
            locationData = $.parseJSON(dataString)
        }
    });
}

// 加载学校数据
var schoolData = null;
function loadSchoolData() {
    $.ajax({
        async: false,
        url: "loadSchoolData",
        type: "Post",
        success: function(data, result) {
            var dataString = JSON.stringify(data);
            schoolData = $.parseJSON(dataString)
        }
    });
}




// 设置学校下拉框
function setSchoolSelect(currentSchoolId, schoolLocationElement, schoolElement) {
    // 设置地区下拉框
    setSingleLocationSelectByParrentId("0", schoolLocationElement);
    
    // 若当前学校为空
    if (currentSchoolId == "-1") {
        $(schoolLocationElement).val("-1");
        
        $(schoolElement).empty();
        $(schoolElement).append("<option value='-1'>请选择</option>");
        $(schoolElement).val("-1");
    }
    // 若当前学校非空
    else {
        var locationId = null;
        for (var i = 0; i < schoolData.length; i++) {
            if (schoolData[i].id == currentSchoolId) {
                locationId = schoolData[i].parrentLocation.id;
                break;
            }
        }
        setSingleSchoolSelectByParrentId(locationId, schoolElement);
        
        $(schoolLocationElement).val(locationId);
        $(schoolElement).val(currentSchoolId);
    }
    
    // 监听地区下拉框
    $(schoolLocationElement).change(
        function() {
            var locationId = $(schoolLocationElement).val();
            if (locationId == "-1") {
                $(schoolElement).empty();
                $(schoolElement).append("<option value='-1'>请选择</option>");
            }
            else {
                setSingleSchoolSelectByParrentId(locationId, schoolElement);
            }
            $(schoolElement).val("-1");
        }
    );
}


function setLocationSelect(currentLocationId, provinceElement, cityElement, areaElement) {
    // 若当前地区为空
    if (currentLocationId == "-1") {
        setSingleLocationSelectByParrentId("0", provinceElement);
        $(cityElement).empty();
        $(cityElement).append("<option value='-1'>请选择</option>");
        
        $(provinceElement).val("-1");
        $(cityElement).val("-1");
        
        $(areaElement).hide();
    }
    // 若当前地区非空
    else {
        var currentLocation = null;
        for (var i = 0; i < locationData.length; i++) {
            if (locationData[i].id == currentLocationId) {
                currentLocation = locationData[i];
                break;
            }
        }
        var parrentId = currentLocation.parrentLocation.id;
        // 当前地区为省级
        if (parrentId == "0") {
            setSingleLocationSelectByParrentId("0", provinceElement);
            setSingleLocationSelectByParrentId(currentLocationId, cityElement);
            
            $(provinceElement).val(currentLocationId);
            $(cityElement).val("-1");
            
            $(areaElement).hide();
        }
        else {
            var grandParrentId = currentLocation.parrentLocation.parrentLocation.id;
            // 当前地区为市级
            if (grandParrentId == "0") {
                setSingleLocationSelectByParrentId("0", provinceElement);
                setSingleLocationSelectByParrentId(parrentId, cityElement);
                setSingleLocationSelectByParrentId(currentLocationId, areaElement);
                
                $(provinceElement).val(parrentId);
                $(cityElement).val(currentLocationId);
                $(areaElement).val("-1");
                
                $(areaElement).show();
            }
            // 当前地区为区级
            else {
                setSingleLocationSelectByParrentId("0", provinceElement);
                setSingleLocationSelectByParrentId(grandParrentId, cityElement);
                setSingleLocationSelectByParrentId(parrentId, areaElement);
                
                $(provinceElement).val(grandParrentId);
                $(cityElement).val(parrentId);
                $(areaElement).val(currentLocationId);
                
                $(areaElement).show();
            }
        }
    }
    
    
    // 监听省下拉框
    $(provinceElement).change(
        function() {
            var provinceId = $(provinceElement).val();
            if (provinceId == "-1") {
                $(cityElement).empty();
                $(cityElement).append("<option value='-1'>请选择</option>");
                
                $(cityElement).val("-1");
                
                $(areaElement).hide();
            }
            else {
                setSingleLocationSelectByParrentId(provinceId, cityElement);
                $(cityElement).val("-1");
                
                $(areaElement).hide();
            }
        }
    );
    
    // 监听市下拉框
    $(cityElement).change(
        function() {
            var cityId = $(cityElement).val();
            if (cityId == "-1") {
                $(areaElement).hide();
            }
            else {
                setSingleLocationSelectByParrentId(cityId, areaElement);
                $(areaElement).val("-1");
                
                $(areaElement).show();
            }
        }
    );
}



// 设置单个学校下拉框
function setSingleSchoolSelectByParrentId(parrentId, schoolElement) {
    $(schoolElement).empty();
    $(schoolElement).append("<option value='-1'>请选择</option>");
    for (var i = 0; i < schoolData.length; i++) {
        if (schoolData[i].parrentLocation.id == parrentId) {
            $(schoolElement).append(
                    "<option value='"+ schoolData[i].id + "'>" + schoolData[i].name + "</option>");
        }
    }
    $(schoolElement).val("-1");
}

// 设置单个地址下拉框
function setSingleLocationSelectByParrentId(parrentId, locationElement) {
    $(locationElement).empty();
    $(locationElement).append("<option value='-1'>请选择</option>");
    for (var i = 0; i < locationData.length; i++) {
        if (locationData[i].parrentLocation != null && locationData[i].parrentLocation.id == parrentId) {
            $(locationElement).append(
                    "<option value='"+ locationData[i].id + "'>" + locationData[i].name + "</option>");
        }
    }
    $(locationElement).val("-1");
}



