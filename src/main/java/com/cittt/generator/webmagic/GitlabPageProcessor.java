package com.cittt.generator.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashMap;
import java.util.Map;

public class GitlabPageProcessor implements PageProcessor {
    //init global variable
    private Site site;

    public GitlabPageProcessor(Map<String, String> cookies) {
        Site site = Site.me().setRetryTimes(3).setSleepTime(100);
        for (Map.Entry e : cookies.entrySet()) {
            site.addCookie(String.valueOf(e.getKey()), String.valueOf(e.getValue()));
        }
        this.site = site;
    }

    @Override
    public void process(Page page) {
        page.getHtml().toString();
        System.out.println("666666>>>>>>>>>>>>>>>>>>");

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Map<String, String> cookies = new HashMap<>();
        cookies.put("JSESSIONID", "35DFE56C7B99759408E4D04099AFE116");
        cookies.put("x-token", "8378d18912ab4f4ba5067ba97d7f54c0");
        cookies.put("Hm_lpvt_81159ad58fbecc2d27d9d510ca516684","1529841919");
        cookies.put("Hm_lvt_81159ad58fbecc2d27d9d510ca516684","1529840653,1529840956");
        Spider.create(new GitlabPageProcessor(cookies)).addUrl("http://www.xiaoyaoji.cn/doc/1dmNrGSn1M").thread(1).run();
    }
}
