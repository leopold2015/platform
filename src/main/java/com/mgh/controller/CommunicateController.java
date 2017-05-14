package com.mgh.controller;

import com.mgh.domain.Communicate;
import com.mgh.serviceManager.CommunicateManager;
import com.mgh.util.session.SessionUtils;
import com.mgh.util.store.StoreNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
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
    public Map<String,Object> sendCommunicate(@RequestParam("communicate_content") String communicate_content){
        communicateManager.insertCommunicate(communicate_content);
        return generateSuccessMsg("发送成功！");
    }

    @RequestMapping(value="/deleteCommunicate")
    @ResponseBody
    public Map<String,Object> deleteCommunicate(@RequestParam("communicate_id") int communicate_id){
        communicateManager.deleteCommunicateByCommunicate_id(communicate_id);
        return generateSuccessMsg("删除成功！");
    }

    @RequestMapping(value="/selectCommunicateByTopic_id")
    @ResponseBody
    public Map<String,Object> selectCommunicateByTopic_id(){
        List<Communicate> communicates = communicateManager.selectCommunicateByTopic_id(StoreNumber.getNumber());
        Map<String,Object> successMsg = generateSuccessMsg("查询成功！");
        successMsg.put("communicates",communicates);
        return successMsg;
    }
}
