DROP SCHEMA IF EXISTS `CourseCatalog`;

CREATE SCHEMA `CourseCatalog`;

use `CourseCatalog`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `instructor_detail`;

CREATE TABLE `instructor_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `bio` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

insert into instructor_detail(position, phone, email, location, bio)
values('Associate Professor of Mathematics', '444-5555', 'email@gmail', '999 Everett Tower, Mail Stop 345', 'bio goes here'),
values('Associate Professor of Mathematics', '234-7643', 'email@gmail', '234 Everett Tower, Mail Stop 455', 'bio goes here'),
values('Associate Professor of Physics', '444-2134', 'email@gmail', '3456 Norther Tower, Mail Stop 345', 'bio goes here'),
values('Associate Professor of Physics', '897-5555', 'email@gmail', '999 Everett Tower, Mail Stop 345', 'bio goes here'),
values('Chair', '234-5555', 'email@gmail', '999 Everett Tower, Mail Stop 345', 'bio goes here'),
values('Graduate Teaching Assistant', '444-5555', 'email@gmail', '999 Everett Tower, Mail Stop 345', 'bio goes here'),
values('Graduate Teaching Assistant', '444-5555', 'email@gmail', '999 Everett Tower, Mail Stop 345', 'bio goes here'),
values('Professor of Mathematics ', '444-5555', 'email@gmail', '999 Everett Tower, Mail Stop 345', 'bio goes here'),
values('Professor of Chemistry ', '444-5555', 'email@gmail', '999 Everett Tower, Mail Stop 345', 'bio goes here'),
values('Professor of Biology ', '444-5555', 'email@gmail', '999 Everett Tower, Mail Stop 345', 'bio goes here');





DROP TABLE IF EXISTS `instructor`;

CREATE TABLE `instructor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `instructor_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`instructor_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`)
  REFERENCES `instructor_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

insert into instructor(first_name, last_name, department)
values('Sergio', 'Flynn', 'Mathematics'),
values('Journey', 'Flynn', 'Physics'),
values('Jamir', 'Howard', 'Chemistry'),
values('Sergio', 'Mcguire', 'Chemistry'),
values('Brandon', 'Bond', 'Mathematics'),
values('Maximilian', 'Rosario', 'Biology'),
values('Tiana', 'Maxwell', 'Biology'),
values('Sergio', 'Flynn', 'Mathematics'),
values('Colby', 'Lam', 'Mathematics');





DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` varchar(128) DEFAULT NULL,
  `title` varchar(128) DEFAULT NULL,
  `description` varchar(128) DEFAULT NULL,
  `credit_hours` varchar(128) DEFAULT NULL,
  `department` varchar(128) DEFAULT NULL,
  `instructor_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),

  UNIQUE KEY `TITLE_UNIQUE` (`title`),

  KEY `FK_INSTRUCTOR_idx` (`instructor_id`),

  CONSTRAINT `FK_INSTRUCTOR`
  FOREIGN KEY (`instructor_id`)
  REFERENCES `instructor` (`id`)

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;


insert into course(course_id, title, description, credit_hours, department)
values('MATH101', 'Foundations of Mathematics', 'course description here', '3', 'Mathematics'),
values('MATH201', 'Algebra 1', 'course description here', '3', 'Mathematics'),
values('MATH205', 'Algebra 2', 'course description here', '3', 'Mathematics'),
values('MATH404', 'Differential Equations', 'course description here', '3', 'Mathematics'),
values('CHM101', 'Intro to Chem', 'course description here', '4', 'Chemistry'),
values('CHM300', 'Organic Chemistry 1', 'course description here', '4', 'Chemistry'),
values('CHM301', 'Organic Chemistry 2', 'course description here', '4', 'Chemistry'),
values('BIO100', 'Intro To Bio', 'course description here', '2', 'Biology'),
values('PHL300', 'Big Questions', 'course description here', '2', 'Philosophy'),
values('FRH500', 'Advanced French Conversation', 'course description here', '3', 'French'),
values('FRH460', 'French in Action', 'course description here', '3', 'French'),
values('PHY700', 'Electromagnetism 1', 'course description here', '4', 'Physics'),
values('PHY500', 'Physics 2', 'course description here', '3', 'Physics'),
values('MATH1001', 'Post Grad Math', 'course description here', '5', 'Mathematics'),








