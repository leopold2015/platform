package com.mgh.controller;

import com.mgh.domain.Communicate;
import com.mgh.domain.Topic;
import com.mgh.domain.User;
import com.mgh.serviceManager.CommunicateManager;
import com.mgh.serviceManager.TopicManager;
import com.mgh.serviceManager.UserManager;
import com.mgh.util.session.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by mgh on 2017/4/24.
 */
@Controller
@RequestMapping(value = "/topic")
public class TopicController extends BaseController {
    @Autowired
    private TopicManager topicManager;
    @Autowired
    private CommunicateManager communicateManager;

    @RequestMapping(value = "/createTopic")
    @ResponseBody
    public Map<String,Object> createTopic(@RequestParam("topic_content") String topic_content){
        topicManager.createTopic(topic_content);
        return generateSuccessMsg("话题创建成功！");
    }

    @RequestMapping(value="/showTopicByUser_id")
    @ResponseBody
    public Map<String,Object> showTopicByUser_id(){
        List<Topic> topics = topicManager.showTopicByUser_id(SessionUtils.getCurrentUser().getUser_id());
        Map successMsg = generateSuccessMsg("查询成功！");
        successMsg.put("topics",topics);
        return successMsg;
    }

    @RequestMapping(value="/showAllTopics")
    @ResponseBody
    public Map<String,Object> showAllTopics(){
        List<Topic> topics = topicManager.showAllTopics();
        Map successMsg = generateSuccessMsg("查询成功！");
        successMsg.put("topics",topics);
        return successMsg;
    }

    @RequestMapping(value="/deleteTopicByTopic_id")
    @ResponseBody
    public Map<String,Object> deleteTopicByTopic_id(@RequestParam("topic_id") int topic_id){
        topicManager.deleteTopicByTopic_id(topic_id);
        return generateSuccessMsg("删除成功！");
    }

    @RequestMapping(value="/showTopicByTopic_id")
    @ResponseBody
    public ModelAndView showTopicByTopic_id(@RequestBody int topic_id){
        List<Communicate> communicates = communicateManager.selectCommunicateByTopic_id(topic_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("communicates",communicates);
        mav.setViewName("/pages/topic/topicDetail.html");
        return modelAndView;
    }
}
