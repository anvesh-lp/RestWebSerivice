insert into User_details
values (1001, current_date(), 'anvesh');
insert into User_details
values (1002, current_date(), 'Vamshi');
insert into User_details
values (1003, current_date(), 'Mani');
insert into User_details
values (1004, current_date(), 'Kavya');
insert into User_details
values (1005, current_date(), 'Ganesh');
insert into User_details
values (1006, current_date(), 'Nandhan');

insert into post (id, description, user_id)
values (1, 'first post', 1001);
insert into post (id, description, user_id)
values (2, 'second post', 1001);
insert into post (id, description, user_id)
values (3, 'third post', 1001);
insert into post (id, description, user_id)
values (4, 'first post', 1002);
insert into post (id, description, user_id)
values (5, 'second post', 1002);