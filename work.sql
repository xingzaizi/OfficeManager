/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.60 : Database - work
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`work` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `work`;

/*Table structure for table `approvalstate` */

DROP TABLE IF EXISTS `approvalstate`;

CREATE TABLE `approvalstate` (
  `approval_state_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报销状态id',
  `approval_state_name` varchar(200) DEFAULT NULL COMMENT '报销状态名称',
  PRIMARY KEY (`approval_state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='审批状态表\r\n';

/*Data for the table `approvalstate` */

insert  into `approvalstate`(`approval_state_id`,`approval_state_name`) values (1,'新创建'),(2,'待审批'),(3,'审批中'),(4,'已审批'),(5,'已付款'),(6,'已打回'),(7,'已存档'),(8,'已通过'),(9,'已拒绝');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `department_name` varchar(200) DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='部门信息表\r\n';

/*Data for the table `department` */

insert  into `department`(`department_id`,`department_name`) values (1,'开发部'),(2,'人事部'),(3,'财务部'),(4,'总经理');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `employee_name` varchar(200) DEFAULT NULL COMMENT '员工姓名',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `contact` varchar(200) DEFAULT NULL COMMENT '联系方式',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `dep_id` int(11) DEFAULT NULL COMMENT '所属部门(外键部门id)',
  `position_id` int(11) DEFAULT NULL COMMENT '所在职位(外键职位id)',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='员工信息表\r\n';

/*Data for the table `employee` */

insert  into `employee`(`employee_id`,`employee_name`,`password`,`contact`,`email`,`dep_id`,`position_id`) values (1,'张三','123','13512345678','zs@qq.com',1,1),(2,'李四','123','13512345678','ls@qq.com',1,2),(3,'王五','123','13512345678','ww@qq.com',2,3),(4,'赵六','123','13512345678','zl@qq.com',3,5),(5,'蟹老板','123','16621356064','boss@qq.com',4,4),(6,'王思聪','123','13512345678','xiaozhang@qq.com',3,6),(7,'阿香','123','13512345678','ax@qq.com',1,1),(8,'阿开','123','13512345678','ak@qq.com',1,1);

/*Table structure for table `expenditure` */

DROP TABLE IF EXISTS `expenditure`;

CREATE TABLE `expenditure` (
  `expenditure_id` varchar(200) DEFAULT NULL COMMENT '报销单号',
  `total_money` float DEFAULT NULL COMMENT '总金额',
  `create_date` date DEFAULT NULL COMMENT '填报时间',
  `reason` varchar(200) DEFAULT NULL COMMENT '事由',
  `create_by` int(11) DEFAULT NULL COMMENT '填写人(外键员工id)',
  `dispose_by` int(11) DEFAULT NULL COMMENT '待处理人(外键员工id)',
  `approval_state_id` int(11) DEFAULT NULL COMMENT '报销状态(外键审批状态id)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报销信息表\r\n';

/*Data for the table `expenditure` */

insert  into `expenditure`(`expenditure_id`,`total_money`,`create_date`,`reason`,`create_by`,`dispose_by`,`approval_state_id`) values ('201906221046204',1963,'2019-06-22','出差',1,0,5),('201906221046420',3516,'2019-07-22','公司福利',1,0,5),('201906221047180',2000,'2019-06-22','项目结算',7,0,9),('201906221047591',3868,'2019-06-22','项目奖金',8,0,5),('201906221048527',2901,'2019-06-22','高温福利',8,0,5),('201906221049532',3500,'2019-06-22','真的是项目结算的钱呢 ',2,0,5),('201906221058198',6000,'2019-06-22','奖励',3,4,3),('201906221059049',12000,'2019-06-22','员工关怀',3,5,2),('201906221059414',14500,'2019-06-22','我是老板我要钱',5,5,2),('201906221433283',22,'2019-06-22','1',1,0,1),('201906221516179',6000,'2019-06-22','222',1,0,5),('201906221613268',999,'2019-06-22','出差',1,0,5);

/*Table structure for table `expendituredetail` */

DROP TABLE IF EXISTS `expendituredetail`;

CREATE TABLE `expendituredetail` (
  `expenditure_detail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报销详细id',
  `comment` varchar(200) DEFAULT NULL COMMENT '项目说明',
  `money` float DEFAULT NULL COMMENT '项目金额',
  `prove_image` varchar(200) DEFAULT NULL COMMENT '凭据截图',
  `expenditure_id` varchar(200) DEFAULT NULL COMMENT '报销单号(外键报销信息id)',
  PRIMARY KEY (`expenditure_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='报销详细信息表\r\n';

/*Data for the table `expendituredetail` */

insert  into `expendituredetail`(`expenditure_detail_id`,`comment`,`money`,`prove_image`,`expenditure_id`) values (26,'报销车费',611,'201906221046036.jpg','201906221046204'),(27,'报销餐费',1352,'201906221046192.jpg','201906221046204'),(28,'奖金',3516,'201906221046412.jpg','201906221046420'),(29,'项目奖金',2000,'201906221047180.jpg','201906221047180'),(30,'奖金',3468,'201906221047422.jpg','201906221047591'),(31,'补贴',400,'201906221047588.jpg','201906221047591'),(32,'高温补贴',600,'201906221048278.jpg','201906221048527'),(33,'高温加班费',2301,'201906221048520.jpg','201906221048527'),(34,'项目奖金',3500,'201906221049518.jpg','201906221049532'),(35,'招人奖励',6000,'201906221058197.jpg','201906221058198'),(36,'关怀金额',12000,'201906221059031.jpg','201906221059049'),(37,'老板要钱',14500,'201906221059388.jpg','201906221059414'),(38,'1',22,'201906221433275.jpg','201906221433283'),(39,'222',6000,'201906221516175.jpg','201906221516179'),(40,'222',666,'201906221613246.jpg','201906221613268'),(41,'2',333,'201906221614238.jpg','201906221613268');

/*Table structure for table `leaverecord` */

DROP TABLE IF EXISTS `leaverecord`;

CREATE TABLE `leaverecord` (
  `leave_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请假记录id',
  `start_date` date DEFAULT NULL COMMENT '开始时间',
  `end_date` date DEFAULT NULL COMMENT '结束时间',
  `leave_days` int(11) DEFAULT NULL COMMENT '请假天数',
  `reason` varchar(200) DEFAULT NULL COMMENT '请假事由',
  `leave_by` int(11) DEFAULT NULL COMMENT '请假人(外键员工id)',
  `dispose_by` int(11) DEFAULT NULL COMMENT '待处理人(外键员工id)',
  `approval_state_id` int(11) DEFAULT NULL COMMENT '请假审批状态(外键审批状态id)',
  PRIMARY KEY (`leave_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2072 DEFAULT CHARSET=utf8 COMMENT='请假记录表\r\n';

/*Data for the table `leaverecord` */

insert  into `leaverecord`(`leave_id`,`start_date`,`end_date`,`leave_days`,`reason`,`leave_by`,`dispose_by`,`approval_state_id`) values (2070,'2019-06-22','2019-06-23',1,'家事',1,2,2),(2071,'2019-06-22','2019-06-25',3,'www',1,NULL,4);

/*Table structure for table `position` */

DROP TABLE IF EXISTS `position`;

CREATE TABLE `position` (
  `position_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职位编号',
  `position_name` varchar(200) DEFAULT NULL COMMENT '职位名称',
  `dep_id` int(11) DEFAULT NULL COMMENT '部门编号(外键部门id)',
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='职位信息表\r\n';

/*Data for the table `position` */

insert  into `position`(`position_id`,`position_name`,`dep_id`) values (1,'普通员工',1),(2,'研发经理',1),(3,'人事经理',2),(4,'总经理',4),(5,'财务',3),(6,'出纳',3);

/*Table structure for table `reviewrecord` */

DROP TABLE IF EXISTS `reviewrecord`;

CREATE TABLE `reviewrecord` (
  `review_id` int(200) NOT NULL AUTO_INCREMENT COMMENT '审查记录id',
  `review_date` date DEFAULT NULL COMMENT '审查时间',
  `review_idea` varchar(200) DEFAULT NULL COMMENT '审查意见',
  `order_id` varchar(200) DEFAULT NULL COMMENT '报销/请假id(外键)',
  `emp_id` int(11) DEFAULT NULL COMMENT '处理人(外键员工id)',
  `review_state_id` int(11) DEFAULT NULL COMMENT '审查状态(外键审查状态id)',
  PRIMARY KEY (`review_id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8 COMMENT='审查记录表\r\n';

/*Data for the table `reviewrecord` */

insert  into `reviewrecord`(`review_id`,`review_date`,`review_idea`,`order_id`,`emp_id`,`review_state_id`) values (10,'2019-06-18','家事重要，通过','2067',2,1),(11,'2019-06-18','ok','2067',3,1),(12,'2019-06-18','想想吧','2068',5,3),(13,'2019-06-18','我支持你！','2069',5,1),(14,'2019-06-18','ok','2069',3,1),(24,'2019-06-21','太贵了','201906211508362',2,2),(25,'2019-06-21','那就信你一次','201906211508362',2,1),(26,'2019-06-22','','201906220945554',2,1),(27,'2019-06-22','好的','201906220946326',2,1),(28,'2019-06-22','ok','201906211508362',4,1),(29,'2019-06-22','ok','201906211510449',4,1),(30,'2019-06-22','ok','201906211617441',4,1),(31,'2019-06-22','ok','201906220945554',4,1),(32,'2019-06-22','ok','201906220946326',4,1),(33,'2019-06-22','ok','201906221039565',4,1),(34,'2019-06-22','','201906211508362',6,1),(35,'2019-06-22','','201906211510449',6,1),(36,'2019-06-22','','201906211617441',6,1),(37,'2019-06-22','','201906220945554',6,1),(38,'2019-06-22','','201906220946326',6,1),(39,'2019-06-22','','201906221039565',6,1),(40,'2019-06-22','ojbk','201906221046204',2,1),(41,'2019-06-22','ojbk','201906221046420',2,1),(42,'2019-06-22','ojbk','201906221047180',2,1),(43,'2019-06-22','ojbk','201906221047591',2,1),(44,'2019-06-22','ojbk','201906221048527',2,1),(45,'2019-06-22','好的','201906221046204',4,1),(46,'2019-06-22','好的','201906221046420',4,1),(47,'2019-06-22','钱太多了','201906221047180',4,3),(48,'2019-06-22','好的','201906221047591',4,1),(49,'2019-06-22','好的','201906221048527',4,1),(50,'2019-06-22','','201906221049532',4,2),(51,'2019-06-22','那就相信你一次','201906221049532',4,1),(52,'2019-06-22','','201906221046204',6,1),(53,'2019-06-22','','201906221046420',6,1),(54,'2019-06-22','','201906221047591',6,1),(55,'2019-06-22','','201906221048527',6,1),(56,'2019-06-22','','201906221049532',6,1),(57,'2019-06-22','','201906221516179',2,1),(58,'2019-06-22','','201906221058198',5,1),(59,'2019-06-22','','201906221516179',5,1),(60,'2019-06-22','','201906221516179',4,1),(61,'2019-06-22','','201906221516179',6,1),(62,'2019-06-22','打回','201906221613268',2,2),(63,'2019-06-22','','201906221613268',2,1),(64,'2019-06-22','','201906221613268',4,1),(65,'2019-06-22','','201906221613268',6,1),(66,'2019-06-22','通过','2071',2,1),(67,'2019-06-22','','2071',3,1);

/*Table structure for table `reviewstate` */

DROP TABLE IF EXISTS `reviewstate`;

CREATE TABLE `reviewstate` (
  `review_state_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '审查状态id',
  `review_state_result` varchar(200) DEFAULT NULL COMMENT '审查结果',
  PRIMARY KEY (`review_state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='审查状态表\r\n';

/*Data for the table `reviewstate` */

insert  into `reviewstate`(`review_state_id`,`review_state_result`) values (1,'通过'),(2,'打回'),(3,'拒绝');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
