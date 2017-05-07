package com.mgh.controller;

import com.mgh.domain.Communicate;
import com.mgh.serviceManager.CommunicateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by mgh on 2017/4/24.
 */
@Controller
@RequestMapping(value="/communicate")
public class CommunicateController extends BaseController {
    @Autowired
    private CommunicateManager communicateManager;


    @RequestMapping(value="/sendCommunicate")
    @ResponseBody
    public Map<String,Object> sendCommunicate(@RequestParam("communicate") Communicate communicate){
        communicateManager.insertCommunicate(communicate);
        return generateSuccessMsg("发送成功！");
    }

    @RequestMapping(value="/deleteCommunicate")
    @ResponseBody
    public Map<String,Object> deleteCommunicate(@RequestParam("communicate_id") int communicate_id){
        communicateManager.deleteCommunicateByCommunicate_id(communicate_id);
        return generateSuccessMsg("删除成功！");
    }

}
