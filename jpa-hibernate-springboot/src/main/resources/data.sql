insert into course (ID,NAME) values (10001L,'Hibernate 5.0.0')
insert into course (ID,NAME) values (10002L,'Spring 5.0.0')
insert into course (ID,NAME) values (10003L,'Spring Boot 2.0.0')
insert into course (ID,NAME) values (10004L,'Core Java 10.0.0')
insert into course (ID,NAME) values (10005L,'Servelt 3.0.0')
insert into course (ID,NAME) values (10006L,'JSP 3.0.0')

insert into passport (ID,NUMBER) values (30001L,'IN10001')
insert into passport (ID,NUMBER) values (30002L,'IN10002')
insert into passport (ID,NUMBER) values (30003L,'IN10003')
insert into passport (ID,NUMBER) values (30004L,'IN10004')
insert into passport (ID,NUMBER) values (30005L,'IN10005')
insert into passport (ID,NUMBER) values (30006L,'IN10006')



insert into student (ID,NAME,PASSPORT_ID)   values (20001L,'Suresh',30006L)
insert into student (ID,NAME,PASSPORT_ID)  values (20002L,'Abinash',30004L)
insert into student (ID,NAME,PASSPORT_ID)  values (20003L,'Bikash',30003L)
insert into student (ID,NAME,PASSPORT_ID)   values (20004L,'Chetan',30005L)
insert into student (ID,NAME,PASSPORT_ID)  values (20005L,'Diensh',30001L)
insert into student (ID,NAME,PASSPORT_ID)  values (20006L,'Ganesh',30002L)





insert into review (ID,RATING,DESCRIPTION,COURSE_ID) values (40001L,'1','very Bad',10001L)
insert into review (ID,RATING,DESCRIPTION,COURSE_ID)  values (40002L,'2','Bad',10002L)
insert into review (ID,RATING,DESCRIPTION,COURSE_ID) values (40003L,'3','Average',10002L)
insert into review (ID,RATING,DESCRIPTION,COURSE_ID) values (40004L,'4','above Average',10003L)
insert into review (ID,RATING,DESCRIPTION,COURSE_ID) values (40005L,'5','Good',10004L)


INSERT INTO STUDENT_COURSE (STUDENT_ID,COURSE_ID) VALUES (20001L,10001L)
INSERT INTO STUDENT_COURSE (STUDENT_ID,COURSE_ID) VALUES (20001L,10001L)
INSERT INTO STUDENT_COURSE (STUDENT_ID,COURSE_ID) VALUES (20001L,10001L)
INSERT INTO STUDENT_COURSE (STUDENT_ID,COURSE_ID) VALUES (20002L,10001L)
INSERT INTO STUDENT_COURSE (STUDENT_ID,COURSE_ID) VALUES (20003L,10003L)



					