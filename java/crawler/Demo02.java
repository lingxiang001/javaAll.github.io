package crawler;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class Demo02 extends BreadthCrawler {
    volatile static int count=0;
    public Demo02(String crawlerPath,boolean autoParse){
        super(crawlerPath,autoParse);
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        if(page.matchUrl("http://blog.csdn.net/.*/article/details/.*")){
            String url=page.url();
            String seeNum=page.select("div[class=blog_list_b clearfix]").html();
            String title=page.select("div[class=article_title]").first().text();
            String author=page.select("div[id=blog_userface]").first().text();
            String taglib=page.select("span[class=link_categories]>a").text();
            ++count;
            StringBuffer sb=new StringBuffer("").append(url+"#").append(title+"#").append(author+"#").append(taglib+"#").append(seeNum);
            System.out.println(seeNum+title);
            //FileUtils.me.saveFile(sb.toString()+" ");
        }
        
    }

    @Override
    protected void afterParse(Page page, CrawlDatums next) {
        int depth;
        if(page.meta("depth")== null){
            depth=1;
        }else{
            depth=Integer.valueOf(page.meta("depth"));
        }
        depth++;
       for(CrawlDatum ca:next){
           ca.meta("depth", depth+"");
       }
    }
    
  
    

    public static void main(String[] args){
        Demo02 crawler=new Demo02("crawler",true);
        for(int i=1;i<2;i++){
            crawler.addSeed(new CrawlDatum("http://blog.csdn.net/?&page="+i).meta("depth","1"));
        }
        crawler.addRegex("http://blog.csdn.net/.*/article/details/.*");
        crawler.setThreads(30);
        try {
            crawler.start(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
       System.out.println("count= "+count);
    }
     

}
