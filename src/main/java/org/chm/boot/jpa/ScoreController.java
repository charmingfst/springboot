package org.chm.boot.jpa;

import org.chm.boot.jpa.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by charming on 2017/7/3.
 */
@RestController
@RequestMapping("/score")
public class ScoreController {
    private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);
    @Autowired
    private IScoreDao scoreService;

    @RequestMapping("/scoreList")
    public List<Course> getScoreList(){
        // 测试更新数据库
        System.out.println("//测试更新数据库");
        logger.info("更新的行数：" + scoreService.updateScoreById(88.8f, 1));
////        scoreService.delete(23);
//
        return scoreService.getList();
    }
    @RequestMapping("/test")
    public String test()
    {
        return "index";
    }
}
