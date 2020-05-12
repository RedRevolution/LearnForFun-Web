# 趣学

一款面向北航本科的群组学习软件

 点击这里通往用户端：https://github.com/RedRevolution/LearnForFun-WeChatApp



![整体视图](assets/整体视图.png)

数据库设计

> 添加索引后面再考虑

```mysql
drop database learnforfun;
create database learnforfun;
use learnforfun;
```

学生用户

```mysql
create table tbl_user_info(
    id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    open_id varchar(32) NOT NULL COMMENT '微信授权的用户唯一ID',
    user_id varchar(16) NOT NULL COMMENT '学号/工号',
    user_name varchar(16) NOT NULL COMMENT '姓名',
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
# 用户登录操作较为频繁
ALTER TABLE tbl_user_info ADD UNIQUE INDEX idx (open_id);
```

日程

> 删除某条日程记录的时候根据自增主键id去删除
>
> 定期删除记录：根据系统时间和deadline字段判断

```mysql
create table tbl_user_timetable(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    user_id varchar(16) NOT NULL COMMENT '学号/工号',
	content varchar(256) NOT NULL COMMENT '日程内容',
    deadline datetime NOT NULL COMMENT '截止时间',
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
# 查看日程的操作较为频繁
ALTER TABLE tbl_user_timetable ADD INDEX idx (user_id);
```

课程

> 授课老师：xxx，xxx，...      或者      xxx，等
>
> 上课时间地点格式：(周数/星期/节数/地点)(...)(...) 
>
> 如: (2-7/日/3,4/沙河J502)(...) 
>
> 用括号进行分组

```mysql
create table tbl_course_info(
	id bigint(20) NOT NULL AUTO_INCREMENT,
    course_code varchar(16) NOT NULL COMMENT '课程代码',
    course_name varchar(16) NOT NULL COMMENT '课程名',
    teacher_name varchar(16) NOT NULL COMMENT '授课教师',
    class_info varchar(128) NOT NULL COMMENT '上课时间及地点',
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
# 经常查询课程的信息
ALTER TABLE tbl_course_info ADD INDEX idx (course_code);
```

```
B2F080110, 经济管理(全汉语), 学院路校区, [主任务]单 伟,李亚帅◇[1-5周]星期二第3,4节◇F227,[6-8周]星期二第3,4节◇(一)301,[9-16周]星期二第3,4节◇(一)301◇选课要求:◇◇, 
B2E333060, 体育（6）【游泳1】, 学院路校区, [主任务]姚建军◇[1-17周]星期一第6节◇, 
B2H513060, 博雅课程（文化素质拓展）(6)(全汉语), 学院路校区, 王嘉凯◇[1-16周]◇, 
B3J063610, 学科技术前沿讲座(全汉语), 学院路校区, 李 波◇[1-9周]星期四第1,2节◇主M302, 
B3J062420, 实践与展示(2)(全汉语), 学院路校区, 纪一鹏◇[1-16周]不排课◇, 
B3I063210, 计算机网络(全汉语), 学院路校区, 罗洪斌◇[1-9周]星期二第1,2节◇(一)301,[1-9周]星期四第3,4节◇(一)301, 
B3I064120, 计算机科学方法论(全汉语), 学院路校区, 杨建磊◇[1-16周]星期一第3,4节◇主319,[11周]星期日第3,4节◇主319,[9周]星期日第3,4节◇主319, 
B3I063220, 计算机网络实验(全汉语), 学院路校区, 谷云超◇[5-14周]星期二第6,7,8,9节◇, 
B3J063710, 计算机网络安全技术(全汉语), 学院路校区, 李 巍◇[1-16周]星期一第8,9节◇主219, 
B3I063130, 软件工程(全汉语), 学院路校区, 欧阳元新,王德庆◇[1-16周]星期五第3,4节◇F207]

[1-17周]星期一第6节
[1-5周]星期二第3,4节
F227,[6-8周]星期二第3,4节
(一)301,[9-16周]星期二第3,4节
[1-16周]
[1-16周]不排课
(一)301
""
[5-14周]星期二第6,7,8,9节
```

选课情况

```mysql
create table tbl_select_course(
	id bigint(20) NOT NULL AUTO_INCREMENT,
    student_id varchar(16) NOT NULL COMMENT '学号',
    course_code varchar(16) NOT NULL COMMENT '课程代码',
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
# 经常查询学生的选课情况
ALTER TABLE tbl_select_course ADD INDEX idx (student_id);
```

系统/反馈

> 消息源：00000000，表示该消息是系统消息，由后台发布，所有用户可见
>
> 消息源：其他，表示该消息是用户的反馈意见，由用户发布，后台可见
>
> 定期删除记录：create_by字段判断

```mysql
create table sys_message(
	id bigint(20) NOT NULL AUTO_INCREMENT,
    user_id varchar(16) NOT NULL COMMENT '消息源',
    content varchar(256) NOT NULL COMMENT '消息内容',
    create_by datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
ALTER TABLE sys_message ADD INDEX idx (user_id);
```

群组

> 群组ID在创建群组时生成，格式：Q20200502134117373291	[QI]创建时间创建人ID
>
> 若为个人兴趣小组则课程代码处为空

```mysql
create table tbl_group_info(
    id bigint(20) NOT NULL AUTO_INCREMENT,
	group_id varchar(32) NOT NULL COMMENT '群组ID',
	group_name varchar(16) NOT NULL COMMENT '群组名',
    group_owner_id varchar(16) NOT NULL COMMENT '创建人ID',
    group_owner_name varchar(16) NOT NULL COMMENT '创建人姓名',
	group_introd varchar(256) NOT NULL DEFAULT '' COMMENT '群组介绍',
    course_code varchar(16) NOT NULL DEFAULT '' COMMENT '课程代码',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
# 经常查询群组的情况
ALTER TABLE tbl_group_info ADD INDEX idx (group_id);
```

用户群组关系表

```mysql
create table tbl_user_group(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    user_id varchar(16) NOT NULL COMMENT '学号/工号',
    group_id varchar(32) NOT NULL COMMENT '群组ID',
    is_administrator tinyint(1) NOT NULL DEFAULT '0' COMMENT '1为管理员,0为成员',
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
# 经常查询用户加入了哪些群组
ALTER TABLE tbl_user_group ADD INDEX idx (user_id);
```

分享

> 分享ID：K20200502134117373291  类型[KR]分享时间分享人ID
>
> 可按点赞数排序

```mysql
create table tbl_group_share(
	id bigint(20) NOT NULL AUTO_INCREMENT,
    share_id varchar(32) NOT NULL COMMENT '分享ID',
	group_id varchar(32) NOT NULL COMMENT '群组ID',
    group_name varchar(16) NOT NULL COMMENT '群组名',
    user_id varchar(16) NOT NULL COMMENT '分享人ID',
    user_name varchar(16) NOT NULL COMMENT '分享人姓名',
	topic varchar(64) NOT NULL COMMENT '主题',
    likes_num int(4) NOT NULL DEFAULT '0' COMMENT '点赞数',
    comment_num int(4) NOT NULL DEFAULT '0' COMMENT '评论数',
	content varchar(5000) NOT NULL COMMENT '知识内容/资源链接',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
# 经常查看分享内容
ALTER TABLE tbl_group_share ADD INDEX idx (share_id);
```

收藏列表

```mysql
create table tbl_user_collect(
	id bigint(20) NOT NULL AUTO_INCREMENT,
    user_id varchar(16) NOT NULL COMMENT '学号/工号',
    share_id varchar(32) NOT NULL COMMENT '分享ID',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
# 经常自己的收藏列表
ALTER TABLE tbl_user_collect ADD INDEX idx (user_id);
```

评论列表

```mysql
create table tbl_share_comment(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    share_id varchar(32) NOT NULL COMMENT '分享ID',
    user_id varchar(16) NOT NULL COMMENT '评论人ID',
    user_name varchar(16) NOT NULL COMMENT '评论人姓名',
    content varchar(256) NOT NULL COMMENT '评论内容',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
ALTER TABLE tbl_share_comment ADD INDEX idx (share_id);
```

群组消息

> 根据消息时间定期清理

```mysql
create table tbl_group_message(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    group_id varchar(32) NOT NULL COMMENT '群组ID',
	user_id varchar(16) NOT NULL COMMENT '发言人学号/工号',
    user_name varchar(16) NOT NULL COMMENT '发言人姓名',
	content varchar(256) NOT NULL COMMENT '发言内容',
	create_by datetime DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '发言时间',
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
ALTER TABLE tbl_group_message ADD INDEX idx (group_id);
```

群组公告

```mysql
create table tbl_group_notice(
    id bigint(20) NOT NULL AUTO_INCREMENT,
	group_id varchar(32) NOT NULL COMMENT '群组ID',
	user_id varchar(16) NOT NULL COMMENT '发布公告者学号/工号',
    user_name varchar(16) NOT NULL COMMENT '发布公告者姓名',
	content varchar(256) NOT NULL COMMENT '公告内容',
    create_by datetime DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '发布时间',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
ALTER TABLE tbl_group_notice ADD INDEX idx (group_id);
```

