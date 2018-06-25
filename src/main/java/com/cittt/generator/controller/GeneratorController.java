package com.cittt.generator.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import com.alibaba.fastjson.JSONObject;
import com.cittt.generator.vo.ReqParamVO;
import com.cittt.generator.vo.ResParamVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GeneratorController {
    @RequestMapping("/generator")
    public String generator(HttpServletRequest request ) {

        String para = request.getParameter("requestArgs");
        JSONArray jsonArray = JSON.parseArray(para);
        List<ReqParamVO> reqlist = new ArrayList<>();
        for (Object o : jsonArray) {
            JSONObject json = (JSONObject) o;
            ReqParamVO vo = JSON.parseObject(json.toJSONString(), ReqParamVO.class);
            reqlist.add(vo);
        }

        List<ResParamVO> reslist = new ArrayList<>();
        String respara = request.getParameter("responseArgs");
        JSONArray resArray = JSON.parseArray(respara);
        for (Object o : resArray) {
            JSONObject json = (JSONObject) o;
            ResParamVO vo = JSON.parseObject(json.toJSONString(), ResParamVO.class);
            reslist.add(vo);
        }
        String url = request.getParameter("url");
        return "ok";
    }

}
