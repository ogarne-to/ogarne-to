insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_SUPERADMIN');

insert into user (username, password, fullname, enabled, role_id, fbid) values ('admin', '***REMOVED***','admin',true, 1, 123456789);

insert into category (name, displayName) values ('przyklad', 'przykład');


insert into page (slug, title, description, body, menuPosition) values ('home', 'home', 'This is homepage', 'This is your homepage', 0);



