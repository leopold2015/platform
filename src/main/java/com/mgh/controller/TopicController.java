package com.mgh.controller;

import com.mgh.domain.Topic;
import com.mgh.domain.User;
import com.mgh.serviceManager.TopicManager;
import com.mgh.util.session.SessionUtils;
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
@RequestMapping(value = "/topic")
public class TopicController extends BaseController {
    @Autowired
    private TopicManager topicManager;

    @RequestMapping(value = "/createTopic")
    @ResponseBody
    public Map<String,Object> createTopic(@RequestParam("topic") Topic topic){
        topicManager.createTopic(topic);
        return generateSuccessMsg("话题创建成功！");
    }

    @RequestMapping(value="/showTopicByUser_id")
    @ResponseBody
    public Map<String,Object> showTopicByUser_id(){
        List<Topic> topics = topicManager.showTopicByUser_id(SessionUtils.getCurrentUser().getUserId());
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
}
