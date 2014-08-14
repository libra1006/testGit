package com.github.Yasenia.flea_school.server;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.Yasenia.flea_school.server.entity.School;
import com.github.Yasenia.flea_school.server.service.ICommonService;

public class JSONTest extends SpringBaseTest{
    @Autowired
    private ICommonService commonService;
    
    @Test
    public void test() {
        ObjectMapper om = new ObjectMapper();
        List<School> schoolList = commonService.findAllSchool();
        
        try {
            String json = om.writeValueAsString(schoolList);
            System.out.println(json);
            System.out.println(json.length());
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
