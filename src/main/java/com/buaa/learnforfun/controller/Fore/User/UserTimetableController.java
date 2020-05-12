package com.buaa.learnforfun.controller.Fore.User;

import com.buaa.learnforfun.controller.BaseController;
import com.buaa.learnforfun.entity.Timetable;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前台用户日程控制器
 */
@RestController
@RequestMapping("/api/user/timetable")
public class UserTimetableController extends BaseController {

    /**
     * 获取个人日程列表
     *
     * @param userId
     * @return
     */
    @ApiOperation(value = "获取个人日程列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "学号/工号", required = true, dataType = "string"),
    })
    @GetMapping("{userId}")
    public List<Timetable> getUserTimetableById(@PathVariable String userId) {
        return timetableService.findTimetable(userId);
    }

    /**
     * 添加一条日程
     *
     * @param timetable
     * @return need:userId,content,deadline
     * response:
     * string=="success",添加成功刷新页面;
     * string=="error"||502,添加失败友好提示;
     */
    @ApiOperation(
            value = "添加一条日程",
            notes = "need:userId,content,deadline\n" +
                    "     * response:\n" +
                    "     * string==\"success\",添加成功刷新页面;\n" +
                    "     * string==\"error\"||502,添加失败友好提示;"
    )
    @PostMapping("add")
    public String addTimetable(@RequestBody Timetable timetable) {
        timetableService.create(timetable);
        return "success";
    }

    /**
     * 删除一条日程
     *
     * @param timetableId
     * @return need:timetable.id
     * response:
     * string=="success",已删除请刷新页面;
     * string=="error"||502,删除失败友好提示;
     */
    @ApiOperation(
            value = "删除一条日程",
            notes = "need:timetable.id\n" +
                    "     * response:\n" +
                    "     * string==\"success\",已删除请刷新页面;\n" +
                    "     * string==\"error\"||502,删除失败友好提示;"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "timetableId", value = "日程id", required = true, dataType = "long"),
    })
    @GetMapping("delete/{timetableId}")
    public String deleteTimetableById(@PathVariable long timetableId) {
        return timetableService.deleteTimetable(timetableId);
    }

    /**
     * 修改一条日程
     *
     * @param timetable
     * @return need:id,userId,content,deadline
     * response:
     * string=="success",修改成功刷新页面;
     * string=="error"||502,修改失败友好提示;
     */
    @ApiOperation(
            value = "修改一条日程",
            notes = "need:id,userId,content,deadline\n" +
                    "     * response:\n" +
                    "     * string==\"success\",修改成功刷新页面;\n" +
                    "     * string==\"error\"||502,修改失败友好提示;"
    )
    @PostMapping("modify")
    public String modifyTimetable(@RequestBody Timetable timetable) {
        return timetableService.modifyTimetable(timetable);
    }

}
