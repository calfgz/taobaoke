package com.calf.api;

import com.calf.entity.Category;
import com.calf.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类别API控制类
 *
 * @author calf
 * @create 2017-03-15 14:33
 */
@Api(value = "类别接口", tags = "category", description = "类别接口")
@RestController
@RequestMapping("/api/categorys")
public class CategoryApiController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取类别列表", notes = "获取所有类别列表")
    @GetMapping
    public List<Category> getList() {
        return  categoryService.findAll();
    }

    @ApiOperation(value = "创建类别接口", notes = "根据所传类别名创建类别")
    @ApiImplicitParam(name = "name", value = "类别名", required = true, dataType = "String")
    @PostMapping
    public String create(@RequestBody String name) {
        categoryService.create(name);
        return "success";
    }

    @ApiOperation(value = "获取类别详细信息", notes = "根据类别id获取类别详细信息")
    @ApiImplicitParam(name = "id", value = "类别id", required = true, dataType = "Long")
    @GetMapping(value = "/{id}")
    public Category findById(@PathVariable long id) {
        return  categoryService.findById(id);
    }

    @ApiOperation(value = "更新类别详细信息", notes = "根据url的id来指定更新对象，并根据传过来的类别信息来更新类别详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "类别id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "category", value = "类别实体类category", required = true, dataType = "Category")
    })
    @PutMapping("/{id}")
    public String update(@PathVariable long id, @RequestBody Category category) {
        Category cate = categoryService.findById(id);
        if (cate != null) {
            cate.setName(category.getName());
            categoryService.update(cate);
        }
        return "success";
    }

    @ApiOperation(value = "删除类别信息", notes = "根据url的id来指定删除类别对象")
    @ApiImplicitParam(name = "id", value = "类别id", required = true, dataType = "Long")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        categoryService.delete(id);
        return "success";
    }
}
