package com.github.Yasenia.flea_school.server.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.Yasenia.flea_school.server.entity.Location;
import com.github.Yasenia.flea_school.server.entity.School;
import com.github.Yasenia.flea_school.server.service.ICommonService;


@Controller
@SessionAttributes(value = { "user" })
public class AjaxAction {
    @Autowired
    private ICommonService commonService;

    public static final String FIND_LOCATION_BY_PARRENT_ID_ACTION = "/findLoactionByParrentId";
    public static final String FIND_SCHOOL_BY_PARRENT_ID_ACTION = "/findSchoolByParrentId";
    public static final String LOAD_LOCATION_DATA_ACTION = "/loadLocationData";
    public static final String LOAD_SCHOOL_DATA_ACTION = "/loadSchoolData";
    
    @RequestMapping(value = FIND_LOCATION_BY_PARRENT_ID_ACTION, method = RequestMethod.POST)
    @ResponseBody 
    public List<Location> findLocationByParrentId(@RequestParam("parrentId") Integer parrent_id) {
        List<Location> locationList = commonService.findLocationByParrentId(parrent_id);
        return locationList;
    }
    
    @RequestMapping(value = FIND_SCHOOL_BY_PARRENT_ID_ACTION, method = RequestMethod.POST)
    @ResponseBody 
    public List<School> findSchoolByParrentId(@RequestParam("parrentId") Integer parrent_id) {
        List<School> schoolList = commonService.findSchoolByParrentId(parrent_id);
        return schoolList;
    }
    
    @RequestMapping(value = LOAD_LOCATION_DATA_ACTION, method = RequestMethod.POST) 
    @ResponseBody
    public List<Location> loadLocationData() {
        List<Location> locationList = commonService.findAllLocation();
        return locationList;
    }
    
    @RequestMapping(value = LOAD_SCHOOL_DATA_ACTION, method = RequestMethod.POST) 
    @ResponseBody
    public List<School> loadSchoolData() {
        List<School> schoolList = commonService.findAllSchool();
        return schoolList;
    }
}
