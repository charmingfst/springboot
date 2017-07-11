package org.chm.boot.jpa;

import org.chm.boot.jpa.entity.Cat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by charming on 2017/7/3.
 */
@RestController
@RequestMapping("/cat")
public class CatController {

    @Resource
    private CatService catService;
    /**
     * 保存数据
     * @return
     */
    @RequestMapping("/save")
    public String save() {
        Cat cat = new Cat();
        //cat.setId(1); // 通过MySQL主键自增长策略生成
        cat.setCatName("hello kitty");
        cat.setCatAge(26);
        catService.save(cat);
        return "save ok";
    }
    /**
     * 删除数据
     */
    @RequestMapping("/delete")
    public String delete() {
        catService.delete(1);
        return "delete ok";
    }
    /**
     * 查询数据
     */
    @RequestMapping("/getAll")
    public Iterable<Cat> getAll() {

        return catService.getAll();
    }

}
