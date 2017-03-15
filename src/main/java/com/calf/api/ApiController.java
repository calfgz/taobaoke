package com.calf.api;

import com.calf.entity.User;
import com.calf.exception.JsonException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * API控制类
 *
 * @author calf
 * @create 2017-03-10 17:29
 */
@Api(value = "用户接口", description = "用户API", basePath = "user", tags = "tag")
@RestController
@RequestMapping("/api/users")
public class ApiController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value = "获取用户列表", notes = "notes")
    @GetMapping(value = "")
    public List<User> getUserList() {
        List<User> list = new ArrayList<>(users.values());
        return list;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping(value = "")
    public String postUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @PutMapping(value = "/{id}")
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        if (u != null) {
            u.setAccount(user.getAccount());
            u.setName(user.getName());
            users.put(id, u);
            return "success";
        } else {
            return  "fail";
        }
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}")
    public String delUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }

    @GetMapping("/error")
    public String error() throws JsonException{
        throw new JsonException("json error");
        //return "error";
    }
}
