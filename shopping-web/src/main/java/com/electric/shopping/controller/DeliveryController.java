package com.electric.shopping.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.electric.shopping.util.KdniaoTrackQueryAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @author guoshuai.li
 * @date 2018-04-21 20:27:41
 * @desc 快递相关
 */
@Controller
public class DeliveryController {
    /**
     * 跳转至首页
     * @param request
     * @param model
     * @param channelId：频道ID
     * @return
     */
    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(HttpServletRequest request, Model model) {
        return "index";
    }
    @RequestMapping(value = "/findNo")
    @ResponseBody
    public JSONObject findNo(String No){
        JSONObject js = new JSONObject();
        try {
            String result = KdniaoTrackQueryAPI.getOrderTracesByJson(No);
            System.out.printf(result);
            JSONObject json = JSONObject.parseObject(result);
            if("true".equals(json.getString("Success"))){
                js.put("code",200);
                List<HashMap> carsList = JSON.parseArray(json.getString("Traces"), HashMap.class);
                js.put("list",carsList);
            }else{
                js.put("code",111);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return js;
    }
}
