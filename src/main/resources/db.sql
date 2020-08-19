create database if not exists db_accounting character set utf8 collate utf8_general_ci;
use db_accounting;

create table if not exists tb_user(
	user_id INT primary key auto_increment,
	phone_num VARCHAR(30) NOT NULL UNIQUE,
	gmt_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	#只能有一个DEFAULT CURRENT_TIMESTAMP除非加上后面的ON UPDATE CURRENT_TIMESTAMP
	#mysql会默认将表中的第一个timestamp字段（且设置了NOT NULL）隐式设置DEFAULAT CURRENT_TIMESTAMP
	gmt_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)DEFAULT CHARSET=utf8;

insert into tb_user(phone_num) values(18100176473);

create table if not exists t_project(
	project_id INT primary key auto_increment,
	name VARCHAR(30) NOT NULL,
	repo VARCHAR(50) NOT NULL,
	branch VARCHAR(30) NOT NULL,
	cur_version VARCHAR(10),
	build_status INT(1) DEFAULT 1,
	integrate_status INT(1) DEFAULT 1,
	descr VARCHAR(100),
	gmt_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	gmt_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)DEFAULT CHARSET=utf8;

create table if not exists t_module_build(
	module_build_id INT PRIMARY KEY auto_increment,
	module_id int NOT NULL,
	module_name VARCHAR(30) NOT NULL,
	build_num int NOT NULL,
	build_status INT(1) DEFAULT 1,
	version VARCHAR(10) NOT NULL,
	message VARCHAR(100),
	gmt_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (module_id) REFERENCES t_module(module_id) ON DELETE CASCADE
)DEFAULT CHARSET=utf8;

create table if not exists t_project_build(
	project_build_id INT PRIMARY KEY auto_increment,
	project_id int NOT NULL,
	project_name VARCHAR(30) NOT NULL,
	build_num int NOT NULL,
	build_status INT(1) DEFAULT 1,
	type INT(1) DEFAULT 1,
  download_url VARCHAR(100),
	message VARCHAR(100),
	gmt_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (project_id) REFERENCES t_project(project_id) ON DELETE CASCADE
)DEFAULT CHARSET=utf8;

create table if not exists t_project_module(
	id INT primary key auto_increment,
	project_id int,
	module_build_id int,
	type int,
	FOREIGN KEY (project_id) REFERENCES t_project(project_id) ON DELETE CASCADE,
	FOREIGN KEY (module_build_id) REFERENCES t_module_build(module_build_id) ON DELETE CASCADE
)DEFAULT CHARSET=utf8;