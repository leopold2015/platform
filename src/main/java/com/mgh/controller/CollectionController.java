package com.mgh.controller;


import com.mgh.domain.Collection;
import com.mgh.domain.Communicate;
import com.mgh.serviceManager.CollectionManager;
import com.mgh.util.session.SessionUtils;
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
@RequestMapping(value="/collection")
public class CollectionController extends BaseController {

    @Autowired
    private CollectionManager collectionManager;

    @RequestMapping(value="/insertCollection")
    @ResponseBody
    public Map<String,Object> insertCollection(@RequestParam("communicate_id") int communicate_id){
        collectionManager.insertCollection(communicate_id);
        return generateSuccessMsg("添加成功！");
    }


    @RequestMapping(value="/deleteCollection")
    @ResponseBody
    public Map<String,Object> deleteCollection(@RequestParam("communicate_id") int communicate_id){
        collectionManager.deleteCollection(SessionUtils.getCurrentUser().getUserId(),communicate_id);
        return generateSuccessMsg("删除成功！");
    }
}
