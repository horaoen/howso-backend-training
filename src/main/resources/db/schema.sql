create table t_org_info
(
    id              bigint auto_increment comment '主键'
        primary key,
    org_code        varchar(150)                          null comment '组织机构编码',
    org_name        varchar(150)                          null comment '机构名称',
    org_level       int                                   null comment '组织级别',
    org_parent_code varchar(150)                          null comment '上级机构标识',
    enterp_type     int                                   null comment '组织机构状态',
    org_status      int                                   null comment '组织类别',
    org_change      int                                   null comment '排序字段',
    org_relation    int                                   null comment '地区级别',
    org_remarks     int                                   null comment '地区标识',
    create_time     datetime    default CURRENT_TIMESTAMP null comment '创建时间',
    create_user     varchar(50) default '1'               null comment '创建人',
    update_time     datetime    default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '修改时间',
    update_user     varchar(50)                           null comment '修改人',
    delete_mark     tinyint(1)  default 0                 null comment '删除标记',
    org_sort        varchar(10)                           null,
    constraint uk_org_code
        unique (org_code)
)
    comment '组织机构' charset = utf8;

create table t_user
(
    id            bigint auto_increment comment '主键'
        primary key,
    user_code     varchar(100)                          null comment '用户编码',
    user_name     varchar(100)                          null comment '用户名',
    emp_no        varchar(30)                           null comment '工号',
    user_rank     varchar(2)                            null comment '职级',
    user_nature   varchar(2)                            null comment '人员性质',
    user_level    varchar(2)                            null comment '人员层级',
    sort_no       varchar(20)                           null comment '排序',
    org_code      varchar(64)                           null comment '所属组织编码',
    create_date   varchar(32)                           null comment '创建日期',
    sex           varchar(10)                           null comment '性别',
    birthday      varchar(32)                           null comment '生日',
    native_place  varchar(64)                           null comment '籍贯',
    identity_card  varchar(32)                          null comment '身份证',
    degree        varchar(32)                           null comment '学历',
    finish_school varchar(100)                          null comment '毕业院校',
    mobile        varchar(32)                           null comment '手机',
    email         varchar(100)                          null comment '邮箱',
    service_code  varchar(64)                           null comment '服务机构编码',
    manage_area   varchar(4000)                         null comment '管理区域',
    service_area  varchar(4000)                         null comment '服务区域',
    corp_code     varchar(200)                          null comment '所属企业',
    status        int                                   null comment '状态',
    create_time   datetime    default CURRENT_TIMESTAMP null comment '创建时间',
    create_user   varchar(50) default '1'               null comment '创建人',
    update_time   datetime    default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '修改时间',
    update_user   varchar(50)                           null comment '修改人',
    delete_mark   tinyint(1)  default 0                 null comment '删除标记'
)
    comment '用户表' charset = utf8;

create index idx_user_code
    on t_user (user_code);


