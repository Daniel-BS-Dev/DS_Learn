INSERT INTO tb_user (name, email, password) VALUES ('Alex','alex@gmail.com', '12234');
INSERT INTO tb_user (name, email, password) VALUES ('Daniel','daniel@gmail.com', '12234');
INSERT INTO tb_user (name, email, password) VALUES ('Ana','ana@gmail.com', '12234');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1,1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2,1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2,2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3,2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3,3);
