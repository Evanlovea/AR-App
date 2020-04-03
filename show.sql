create table `scan_info`(
  `scan_id` int not null auto_increment,
  `scan_name` varchar(64) not null comment '区域名称',
  `scan_type` int not null comment '类目编号',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key(`scan_id`),
    unique key `uqe_scan_type` (`scan_type`)
)comment '扫描区域划分类目表';
create table `location_info`(
  `location_id` varchar(32) not null comment '位置ID',
  `location_name` varchar(64) not null comment '位置名称',
  `location_latitude` decimal(8) not null comment '经度',
  `location_longitude` decimal(8) not null comment '纬度',
  `location_altitude` decimal(8) not null comment '高度',
  `location_description` varchar(512) comment '位置描述',
  `location_picture` varchar(512) comment '位置二维图像',
  `panoramic_link` varchar(512) comment '全景外链',
  `scan_type` int not null comment '类目编号',
  `person_type` int not null comment '该位置的人员',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key(`location_id`),
  unique key `uqe_person_type` (`person_type`),
  foreign key (`scan_type`) references `scan_info`(`scan_type`) on delete cascade on update cascade
)comment '位置信息详情表';

create table `person_info`(
  `person_id` varchar(32) not null comment '人员ID',
  `person_type` int not null comment '该位置的人员',
  `person_name` varchar(32) not null comment '姓名',
  `person_age` tinyint(3)  comment '年龄',
  `person_sex` char(2)   comment '性别',
  `person_responsibility` varchar(32) comment '职责',
  `person_phone` varchar(32) comment '联系方式',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key(`person_id`),
  foreign key (`person_type`) references `location_info`(`person_type`) on delete cascade on update cascade
)comment '人员信息表';
