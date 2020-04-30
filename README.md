# 趣学

一款面向北航本科的群组学习软件

 点击这里通往用户端：https://github.com/RedRevolution/LearnForFun-WeChatApp



![整体视图](assets/整体视图.png)

数据库设计

> 添加索引后面再考虑

```mysql
create database learnforfun;
use learnforfun;
```

学生用户

```mysql
create table tbl_user_info(
    id int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
    wechat_account_id varchar(30) NOT NULL COMMENT '微信账号',
    user_id int(10) NOT NULL COMMENT '学号/工号',
    user_name varchar(10) NOT NULL COMMENT '姓名',
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

日程

> 定期删除记录：根据系统时间和deadline字段判断

```mysql
create table tbl_timetable_info(
    id int(10) NOT NULL AUTO_INCREMENT,
    user_id int(10) NOT NULL COMMENT '学号/工号',
	content varchar(50) NOT NULL COMMENT '日程内容',
    deadline datetime NOT NULL COMMENT '截止时间',
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

课程

> 上课时间地点格式：(周数/星期/节数/地点)(...)(...) 
>
> 如: (2-7/7/3,4/沙河J502)(...) 
>
> 用括号进行分组

```mysql
create table tbl_course_info(
	id int(10) NOT NULL AUTO_INCREMENT,
    course_code varchar(12) NOT NULL COMMENT '课程代码',
    course_name varchar(20) NOT NULL COMMENT '课程名',
    teacher_name varchar(10) NOT NULL COMMENT '授课教师(多位老师用:xxx等)',
    class_info varchar(100) NOT NULL COMMENT '上课时间及地点',
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

选课情况

```mysql
create table tbl_select_course_info(
	id int(10) NOT NULL AUTO_INCREMENT,
    student_id int(10) NOT NULL COMMENT '学号',
    course_code varchar(20) NOT NULL COMMENT '课程代码',
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

系统消息

> 定期删除记录：create_by字段判断

```mysql
create table sys_message(
	id int(10) NOT NULL AUTO_INCREMENT,
    content varchar(200) NOT NULL COMMENT '消息内容',
    create_by datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

群组

> 群组ID：[OI]创建人ID/创建时间	如：O17373291/20200521213252
>
> O表示官方课程群组，I 表示个人兴趣小组
>
> 群组ID在创建群组时生成
>
> 若为个人兴趣小组则课程代码处为空

```mysql
create table tbl_group_info(
    id int(10) NOT NULL AUTO_INCREMENT,
	group_id varchar(30) NOT NULL COMMENT '群组ID',
	group_name varchar(20) NOT NULL COMMENT '群组名',
    group_owner_id int(10) NOT NULL COMMENT '创建者学号/工号',
    group_owner_name int(10) NOT NULL COMMENT '创建者姓名',
	group_introd varchar(50) NOT NULL DEFAULT '' COMMENT '群组介绍',
    course_code varchar(12) NOT NULL DEFAULT '' COMMENT '课程代码',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

用户群组关系表

```mysql
create table tbl_user_group_info(
    id int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
    user_id int(10) NOT NULL COMMENT '学号/工号',
    group_id varchar(30) NOT NULL COMMENT '群组ID',
    is_administrator tinyint(1) NOT NULL DEFAULT '0' COMMENT '1为管理员,0为成员',
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

知识分享

> 知识分享ID：分享人ID/创建时间

```mysql
create table tbl_knowledge_share(
	id int(10) NOT NULL AUTO_INCREMENT,
    knowledge_share_id varchar(30) NOT NULL COMMENT '知识分享ID',
	group_id varchar(30) NOT NULL COMMENT '群组ID',
	user_id int(10) NOT NULL COMMENT '学号/工号',
    user_name varchar(10) NOT NULL COMMENT '分享人姓名',
	title varchar(20) NOT NULL COMMENT '标题',
	content varchar(5000) NOT NULL COMMENT '内容',
	likes_num int(4) NOT NULL COMMENT '点赞数',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

收藏列表

```mysql
create table tbl_user_collect(
	id int(10) NOT NULL AUTO_INCREMENT,
    knowledge_share_id varchar(30) NOT NULL COMMENT '知识分享ID',
	user_id int(10) NOT NULL COMMENT '学号/工号',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

评论列表

```mysql
create table tbl_comment(
    id int(10) NOT NULL AUTO_INCREMENT,
    knowledge_share_id varchar(30) NOT NULL COMMENT '知识分享ID',
    user_id int(10) NOT NULL COMMENT '评论人学号/工号',
    user_name varchar(10) NOT NULL COMMENT '评论人姓名',
    content varchar(200) NOT NULL COMMENT '评论内容',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

资料分享

```mysql
create table tbl_resource_share(
    id int(10) NOT NULL AUTO_INCREMENT,
    group_id varchar(30) NOT NULL COMMENT '群组ID',
	user_id int(10) NOT NULL COMMENT '分享人学号/工号',
    user_name varchar(10) NOT NULL COMMENT '分享人姓名',
	title varchar(20) NOT NULL COMMENT '分享主题',
    introd varchar(50) NOT NULL DEFAULT '分享内容简介',
	link varchar(256) NOT NULL COMMENT '资源链接',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

群组消息

> 根据消息时间定期清理

```mysql
create table tbl_group_message(
    id int(10) NOT NULL AUTO_INCREMENT,
    group_id varchar(30) NOT NULL COMMENT '群组ID',
	user_id int(10) NOT NULL COMMENT '发言人学号/工号',
    user_name varchar(10) NOT NULL COMMENT '发言人名字',
	content varchar(100) NOT NULL COMMENT '发言内容',
	create_by datetime DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '发言时间',
    primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

```

群组公告

```mysql
create table tbl_group_notice(
    id int(10) NOT NULL AUTO_INCREMENT,
	group_id varchar(30) NOT NULL COMMENT '群组ID',
	user_id int(10) NOT NULL COMMENT '发布公告者学号/工号',
    user_name varchar(10) NOT NULL COMMENT '发布公告者姓名',
	content varchar(500) NOT NULL COMMENT '公告内容',
    create_by datetime DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '发布时间',
	primary key(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

