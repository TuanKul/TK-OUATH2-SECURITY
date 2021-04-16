INSERT INTO public.role_entity
(role_id, desciption, user_name)
VALUES('TINTUC', 'Tin tuc', 'tuanthai');
INSERT INTO public.role_entity
(role_id, desciption, user_name)
VALUES('XEMPHIM', 'Xem Phim', 'tuanthai');
INSERT INTO public.role_entity
(role_id, desciption, user_name)
VALUES('CHUABIET', 'Chua biet', 'tuanthai');
INSERT INTO public.role_entity
(role_id, desciption, user_name)
VALUES('NONO', 'No no', 'ami');

INSERT INTO public.oauth_client_details
(client_id, access_token_validity, additional_information, authorities, authorized_grant_types, autoapprove, client_secret, refresh_token_validity, resource_ids, "scope", web_server_redirect_uri)
VALUES('tk_user_role', 30000, '{}', 'noname', 'password', 'false', '$2a$10$ZloNY/N4gBqyFQNSZwSDmegu82VM6VvBZ32xgJPS/b.dGfrksRdyy', '-1', 'tk_user_role_id', 'tk_user_role', 'aaaa');

INSERT INTO public.user_entity
(user_name, created_by, created_date, email, enabled, full_name, "password", phone, updated_by, updated_date)
VALUES('tuanthai', NULL, NULL, 'thaithanhtuan43@gmail.com', 1, NULL, '$2a$10$ZloNY/N4gBqyFQNSZwSDmegu82VM6VvBZ32xgJPS/b.dGfrksRdyy', '0938380039', NULL, NULL);
INSERT INTO public.user_entity
(user_name, created_by, created_date, email, enabled, full_name, "password", phone, updated_by, updated_date)
VALUES('ami', NULL, NULL, 'a', 1, NULL, '$2a$10$ZloNY/N4gBqyFQNSZwSDmegu82VM6VvBZ32xgJPS/b.dGfrksRdyy', '123123123123', NULL, NULL);
