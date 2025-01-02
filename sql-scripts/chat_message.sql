USE 'umbrella'

DROP TABLE IF EXISTS 'chat_message';

create table chat_message (id INT not null AUTO_INCREMENT, username VARCHAR(255), content VARCHAR(255), PRIMARY KEY (id));