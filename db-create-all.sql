create table caidan (
  id                            bigint auto_increment not null,
  title                         varchar(255) comment '菜单标题',
  scope                         double comment '菜单打分',
  person_numb                   integer comment '菜单点餐次数',
  img_src                       varchar(255) comment '菜单图片路径',
  constraint pk_caidan primary key (id)
) comment='菜单';

