
-- 如果存在，删除表
DROP TABLE IF EXISTS `classroom`;
-- 如果不存在，建表
CREATE TABLE IF NOT EXISTS `classroom` (
    `classNo` varchar (20) not null ,
     `className` varchar (50) default null ,
     `school` varchar (50) default null ,
     primary key (`classNo`)
) ENGINE =InnoDB DEFAULT CHARSET =utf8;


