# 趣学

一款面向北航本科的群组学习软件

 点击这里通往用户端：https://github.com/RedRevolution/LearnForFun-WeChatApp



![整体视图](assets/整体视图.png)

数据库设计

用户

```mysql
create table student(
	user_id int(10) NOT NULL AUTO_INCREMENT,
    wechat_id varchar(30) NOT NULL,
    student_id int(10) NOT NULL,
    student_name varchar(10) NOT NULL,
    primary key(user_id),
	constraint tt foreign key(user_id) references timetable(user_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8;
select * from student;
```

日程

```mysql
create table timetable(
    tt_id int(15) NOT NULL AUTO_INCREMENT,
    wechat_id int(10) NOT NULL,
	content varchar(50) NOT NULL,
    deadline datetime DEFAULT NULL,
    primary key(timetable_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8;
```

课程

```mysql
create table course(
	c_id int(4) NOT NULL AUTO_INCREMENT,
    course_no varchar(20) NOT NULL,
    course_name varchar(20) NOT NULL,
    teacher_name varchar(10) NOT NULL,
    classlocation varchar(20) NOT NULL,
    classtime varchar(20) DEFAULT NULL,
    primary key(c_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8;
```

选课情况

```mysql
create table selectCourse(
	sc_id int(10) NOT NULL AUTO_INCREMENT,
    student_id int(10) NOT NULL,
    course_no varchar(20) NOT NULL,
    primary key(sc_id),
    constraint sid foreign key(student_id) references student(student_id);
    constraint cno foreign key(course_no) references course(course_no);
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8;
```

系统消息

```mysql
create table sysmessage(
	ssm_id int(5) NOT NULL AUTO_INCREMENT,
    sys_messge_id int(5) NOT NULL,
    content varchar(50) NOT NULL,
    primary key(ssm_id),
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8;
```

群组

```mysql
create table group(
	group_id int(10) NOT NULL AUTO_INCREMENT,
	group_name varchar(20) NOT NULL,
	course_no int(10) NOT NULL,
	course_name varchar(20) NOT NULL,
	teacher_name varchar(10) NOT NULL,
	course_introd var(50) NOT NULL,
	PEIMARY KEY(group_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

知识分享

```mysql
create table knowledgeShare(
	ks_id int(10) NOT NULL AUTO_INCREMENT,
	group_id int(10) NOT NULL,
	student_id int(10) NOT NULL,
	title varchar(20) NOT NULL,
	content varchar(1000) NOT NULL,
	like_num int(4) NOT NULL,
	PEIMARY KEY(ks_id),
	CONSTRAINT gid FOREIGN KEY(group_id) REFERENCES group(group_id),
	CONSTRAINT sid FOREIGN KEY(student_id) REFERENCES student(student_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

```

评论

```mysql
create table comment(
	comment_id int(20) NOT NULL AUTO_INCREMENT,
	ks_id int(10) NOT NULL,
	student_id int(10) NOT NULL,
	content varchar(50) NOT NULL,
	PEIMARY KEY(comment_id),
	CONSTRAINT ksid FOREIGN KEY(ks_id) REFERENCES knowledgeShare(ks_id),
	CONSTRAINT sid FOREIGN KEY(student_id) REFERENCES student(student_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

```

资料分享

```mysql
create table materialShare(
	material_id int(10) NOT NULL AUTO_INCREMENT,
	student_id int(10) NOT NULL,
	title  varchar(20) NOT NULL,
	link varchar(100) NOT NULL,
	PEIMARY KEY(material_id),
	CONSTRAINT sid FOREIGN KEY(student_id) REFERENCES student(student_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

```

群组消息

```mysql
create table groupMessage(
	gm_id int(20) NOT NULL AUTO_INCREMENT,
	student_id int(10) NOT NULL,
	group_id int(10) NOT NULL,
	content varchar(50) NOT NULL,
	PEIMARY KEY(material_id),
	CONSTRAINT sid FOREIGN KEY(student_id) REFERENCES student(student_id),
	CONSTRAINT gid FOREIGN KEY(group_id) REFERENCES group(group_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

```

公告

```mysql
create table notice(
	notice_id int(10) NOT NULL AUTO_INCREMENT,
	group_id int(10) NOT NULL,
	content varchar(100),
	PEIMARY KEY(notice_id),
	CONSTRAINT gid FOREIGN KEY(group_id) REFERENCES group(group_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

```

