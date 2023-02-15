-- psql -h 183.129.217.214 -p 20080 -u postgres > init.sql
--先删除库
drop database if exists authdb;
drop user if exists auth;

--创建数据库
create database authdb;
--创建用户名称
create user auth with password 'Abc123++';

--更换数据库所有者
alter database authdb owner to auth;

--切换数据库
\connect authdb

--设置编码格式
set client_encoding to 'UTF-8';

--创建uuid扩展
create extension "uuid-ossp";

/**
 * 创建uuid方法
 */
create or replace function uuid_generate()
    returns varchar as $$
declare
uuid_string varchar;
begin
    /** get uuid info **/
select uuid_generate_v4() into uuid_string;
/** replace all - in uuid info**/
uuid_string := replace(uuid_string, '-', '');
return uuid_string;
end;
$$ language plpgsql;

--表数初始化
drop table if exists tb_client_info;
drop table if exists tb_user;
drop table if exists tb_user_info;
drop table if exists tb_role;
drop table if exists tb_user_role;
drop table if exists tb_upm_resource;
drop table if exists tb_upm_auth;

--client info
create table tb_client_info(
    id varchar(64) primary key,
    client_id varchar(64) not null,
    client_secret varchar(128) not null,
    redirect_url varchar(256) not null,
    scope varchar(128) not null,
    create_time timestamp with time zone,
    update_time timestamp with time zone
);
comment on table tb_client_info is '授权资源服务列表';
comment on column tb_client_info.id is '唯一键';
comment on column tb_client_info.client_id is '资源服务器id';
comment on column tb_client_info.client_secret is '资源服务器密钥';
comment on column tb_client_info.redirect_url is '重定向url';
comment on column tb_client_info.scope is '作用域';
comment on column tb_client_info.create_time is '创建时间';
comment on column tb_client_info.update_time is '更新时间';
create index idx_tb_client_info_client_id on tb_client_info(client_id);
alter table tb_client_info owner to auth;

--创建用户信息表
create table tb_user(
    id varchar(64) primary key default uuid_generate(),
    username varchar(64) not null,
    password varchar(128),
    on_line integer default 0,
    ip_address varchar(64),
    is_lock	integer default 0,
    is_delete integer default 0,
    create_time timestamp without time zone,
    update_time timestamp without time zone
);
comment on table tb_user is '用户信息表';
comment on column tb_user.id is '唯一键';
comment on column tb_user.username is '用户名';
comment on column tb_user.password is '密码';
comment on column tb_user.on_line is '是否在线,0：不在线;1：在线';
comment on column tb_user.ip_address is 'ip地址';
comment on column tb_user.is_lock is '账户锁定，0：未锁定;1：锁定';
comment on column tb_user.is_delete is '是否删除表示位置,0：正常使用;1：已删除';
comment on column tb_user.create_time is '创建时间';
comment on column tb_user.update_time is '更新时间';
create index idx_tb_user_username on tb_user(username);
alter table tb_user owner to auth;

--用户信息表
create table tb_user_info(
    id varchar(64) primary key default uuid_generate(),
    user_id varchar(64) not null,
    name varchar(64),
    phone varchar(64),
    email varchar(64),
    address varchar(128),
    description varchar(128),
    create_time timestamp without time zone,
    update_time timestamp without time zone
);
comment on table tb_user_info is '用户信息详情表';
comment on column tb_user_info.id is '唯一键';
comment on column tb_user_info.user_id is '用户id';
comment on column tb_user_info.name is '姓名';
comment on column tb_user_info.phone is '手机号码';
comment on column tb_user_info.email is '邮箱地址';
comment on column tb_user_info.address is '地址信息';
comment on column tb_user_info.description is '描述信息';
comment on column tb_user_info.create_time is '创建时间';
comment on column tb_user_info.update_time is '更新时间';
alter table tb_user_info owner to auth;

--用户角色表
create table tb_role(
    id varchar(64) primary key default uuid_generate(),
    role_name varchar(64) not null,
    role_code varchar(64) not null,
    role_type integer not null,
    create_user varchar(64) not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone
);
comment on table tb_role is '用户角色表';
comment on column tb_role.id is '唯一键';
comment on column tb_role.role_name is '角色名';
comment on column tb_role.role_code is '角色编码';
comment on column tb_role.role_type is '角色类型,1：系统用户;2：管理员;3：普通用户';
comment on column tb_role.create_user is '创建用户';
comment on column tb_role.create_time is '创建时间';
comment on column tb_role.update_time is '更新时间';
alter table tb_role owner to auth;

--用户角色关系表
create table tb_user_role(
    id varchar(64) primary key default uuid_generate(),
    user_id varchar(64) not null,
    role_id varchar(64) not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone
);
comment on table tb_user_role is '用户角色关系表';
comment on column tb_user_role.id is '唯一键';
comment on column tb_user_role.user_id is '用户id';
comment on column tb_user_role.role_id is '角色id';
comment on column tb_user_role.create_time is '创建时间';
comment on column tb_user_role.update_time is '更新时间';
alter table tb_user_role owner to auth;

--资源详情表
create table tb_upm_resource(
    id varchar(64) primary key default uuid_generate(),
    resource_id varchar(64) not null,
    resource_name varchar(64) not null,
    resource_type varchar(64) not null,
    is_delete integer not null,
    create_time timestamp without time zone,
    update_time timestamp without time zone
);
comment on table tb_upm_resource is '资源详情表';
comment on column tb_upm_resource.id is '唯一键';
comment on column tb_upm_resource.resource_id is '资源id';
comment on column tb_upm_resource.resource_name is '资源名称';
comment on column tb_upm_resource.resource_type is '资源类型';
comment on column tb_upm_resource.is_delete is '是否删除,0：未删除,1：已删除';
comment on column tb_upm_resource.create_time is '创建时间';
comment on column tb_upm_resource.update_time is '更新时间';
create index idx_tb_upm_resource_resource_id on tb_upm_resource(resource_id);
alter table tb_upm_resource owner to auth;

--资源权限表
create table tb_upm_auth(
     id varchar(64) primary key default uuid_generate(),
     resource_id varchar(64) not null,
     resource_type integer,
     user_id varchar(64) not null,
     role_id varchar(64) not null,
     op_user varchar(64) not null,
     create_time timestamp without time zone,
     update_time timestamp without time zone
);
comment on table tb_upm_auth is '资源详情表';
comment on column tb_upm_auth.id is '唯一键';
comment on column tb_upm_auth.resource_id is '资源id';
comment on column tb_upm_auth.resource_type is '资源类型';
comment on column tb_upm_auth.user_id is '用户id';
comment on column tb_upm_auth.role_id is '角色id';
comment on column tb_upm_auth.op_user is '操作用户id';
comment on column tb_upm_auth.create_time is '创建时间';
comment on column tb_upm_auth.update_time is '更新时间';
create index idx_tb_upm_auth_resource_id on tb_upm_auth(resource_id);
create index idx_tb_upm_auth_role_id on tb_upm_auth(role_id);
alter table tb_upm_auth owner to auth;