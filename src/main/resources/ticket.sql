insert ignore ticket(ticket_id, reservation_id, leg_id, airline_id, flight_id, departure_weekday, departure_date, price, waitlist_status)
values('t1','r1','0','UA','7','20191201','2019-12-01','300','N/A'),
('t2','r2','0','UA','7','20191201','2019-12-01','650','N/A'),
('t3','r3','0','UA','7','20191201','2019-12-01','1000','N/A'),
('t4','r4','0','KA','2','20191127','2019-11-27','800','N/A'),
('t5','r5','0','KA','2','20191127','2019-11-27','1700','N/A'),
('t6','r6','0','KA','2','20191127','2019-11-27','3400','N/A'),
('t7','r7','0','KA','2','20191127','2019-11-27','860','waitlisted'),
('t8','r8','0','KA','2','20191127','2019-11-27','1760','N/A'),
('t9','r9','0','KA','2','20191127','2019-11-27','3460','N/A'),
('t10','r10','0','UA','9','20191202','2019-12-02','250','N/A'),
('t11','r11','0','UA','9','20191202','2019-12-02','500','N/A'),
('t12','r12','0','UA','9','20191202','2019-12-02','1000','N/A'),
('t13','r13','0','UA','9','20191202','2019-12-02','350','waitlisted'),
('t14','r14','0','UA','9','20191202','2019-12-02','700','N/A'),
('t15','r15','0','UA','9','20191202','2019-12-02','1200','N/A'),
('t16','r16','0','UA','33','20200104','2020-01-04','200','waitlisted'),
('t17','r17','0','UA','33','20200104','2020-01-04','450','N/A'),
('t18','r18','0','UA','33','20200104','2020-01-04','700','N/A'),
('t19','r19','1','UA','9','20191202','2019-12-02','130','N/A'),
('t20','r19-1','0','UA','11','20191203','2019-12-03','150','waitlisted'),
('t21','r20','1','UA','9','20191202','2019-12-02','100','N/A'),
('t22','r20-1','0','UA','11','20191203','2019-12-03','120','waitlisted'),
('t23','r21','1','UA','9','20191202','2019-12-02','100','N/A'),
('t24','r21-1','0','UA','11','20191203','2019-12-03','70','waitlisted')
;