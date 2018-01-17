package com.zyf.test.爬虫.webmagic;

import com.zyf.common.数据库操作.ebean.EbeanUtil;
import io.ebean.EbeanServer;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

public class 运行 implements PageProcessor {

    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    private static int size = 0;// 共抓取到的文章数量

    private List<菜谱实体> caiDans = new ArrayList<>();

    @Override
    public Site getSite() {
        return site;
    }


    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {

        Selectable titles = page.getHtml().xpath("p[@class='name']//a//text()");
        Selectable scopes = page.getHtml().xpath("p[@class='stats']//span[1]//text()");
        Selectable personNumbs = page.getHtml().xpath("p[@class='stats']//span[2]//text()");
        Selectable imgSrcs = page.getHtml().xpath("a[@class='image-link']//img//@src");

        List<String> titleList = titles.all();
        List<String> scopeList = scopes.all();
        List<String> personNumbList = personNumbs.all();
        List<String> imgSrcList = imgSrcs.all();

        for (int i = 0; i < titleList.size(); i++) {
            String title = titleList.get(i);
            String scope = scopeList.get(i);
            String personNumb = personNumbList.get(i);
            String imgSrc = imgSrcList.get(i);
            // 用类来存抓取到的数据，方便存入数据库
            菜谱实体 caiDan = new 菜谱实体();
            caiDan.setTitle(title);
            caiDan.setScope(Double.parseDouble(scope));
            caiDan.setPersonNumb(Integer.parseInt(personNumb));
            caiDan.setImgSrc(imgSrc);
            // 把对象输出控制台
            caiDans.add(caiDan);
            EbeanServer ebean = EbeanUtil.getEbean("db", "com.zyf.test.爬虫.webmagic");
            ebean.save(caiDan);
        }
        size++;// 文章数量加1
    }

    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        运行 myProcessor = new 运行();
        Spider.create(myProcessor)
                .addUrl("http://www.xiachufang.com/recipe_list/93660/")
                .thread(5)
                .run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了" + size + "条记录");
        for (菜谱实体 title : myProcessor.caiDans) {
            System.out.println(title);
        }
    }


}