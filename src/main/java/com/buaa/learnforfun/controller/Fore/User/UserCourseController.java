package com.buaa.learnforfun.controller.Fore.User;

import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.entity.Course;
import com.buaa.learnforfun.entity.Share;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 前台用户课表控制器
 */
@RestController
@RequestMapping("/api/user/course")
public class UserCourseController extends BaseController {
    /**
     * 导入个人课表
     *
     * @param userId
     * @return
     * pre:输入正确的统一身份认证账号和密码，导入课表需要30s左右的处理时间,
     * 用户短期内只能进行一次导入课表的操作，否则会受到教务网站ip攻击检测,
     * response:
     * 课表中如果有未记录到数据库中的课程，会自动创建相关记录
     * string==success,导入课表成功，可调用查看个人课表接口;
     * string==failure||502,导入失败请提醒用户短时间内不进行该操作;
     */
    @ApiOperation(
            value = "导入个人课表",
            notes = "pre:输入正确的统一身份认证账号和密码，导入课表需要30s左右的处理时间,\n" +
                    "     * 用户短期内只能进行一次导入课表的操作，否则会受到教务网站ip攻击检测,\n" +
                    "     * response:\n" +
                    "     * 课表中如果有未记录到数据库中的课程，会自动创建相关记录\n" +
                    "     * string==success,导入课表成功，可调用查看个人课表接口;\n" +
                    "     * string==failure||502,导入失败请提醒用户短时间内不进行该操作;"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "学号/工号", required = true, dataType = "string"),
            @ApiImplicitParam(name = "usr", value = "统一身份认证账号", required = true, dataType = "string"),
            @ApiImplicitParam(name = "pwd", value = "统一身份认证密码", required = true, dataType = "string"),
    })
    @GetMapping("{userId}/{usr}/{pwd}")
    public String importCourseTable(@PathVariable String userId,@PathVariable String usr,@PathVariable String pwd) {
        return courseTableService.importCourseTable(userId,usr,pwd);
    }

    /**
     * 查看个人课表
     *
     * @param userId
     * @return
     * response:
     * course.teacherName:
     * 授课老师：xxx，xxx，...      或者      xxx，等;
     * course.classInfo：(周数/星期/节数/地点)(...)(...);
     * 如: (2-7/日/3,4/沙河校区J502)(...),用括号进行分组;
     */
    @ApiOperation(
            value = "查看个人课表",
            notes = "response:\n" +
                    "     * course.teacherName:\n" +
                    "     * 授课老师：xxx，xxx，...      或者      xxx，等;\n" +
                    "     * course.classInfo：(周数/星期/节数/地点)(...)(...);\n" +
                    "     * 如: (2-7/日/3,4/沙河校区J502)(...),用括号进行分组;"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "学号/工号", required = true, dataType = "string"),
    })
    @GetMapping("{userId}")
    public List<Course> getCourseTable(@PathVariable String userId) {
        return courseTableService.getCourseTable(userId);
    }

}
