CREATE SCHEMA tp_twitter;

CREATE TABLE tp_twitter.roles
(
    role_id     SERIAL PRIMARY KEY ,
    role_name   VARCHAR(30) UNIQUE
);

INSERT INTO tp_twitter.roles VALUES
    (1, 'ADMIN'),
    (2, 'LOGGED'),
    (3, 'BANNED');

CREATE TABLE tp_twitter.users
(
    user_id     SERIAL PRIMARY KEY,
    login       VARCHAR (50),
    email       VARCHAR (100),
    password    VARCHAR (50),
    role        INTEGER NOT NULL DEFAULT 2 REFERENCES tp_twitter.roles(role_id)
);

CREATE TABLE tp_twitter.posts(
    post_id     SERIAL PRIMARY KEY,
    user_id     INTEGER REFERENCES tp_twitter.users(user_id),
    title       VARCHAR (50),
    content     VARCHAR (1000)
);

CREATE TABLE tp_twitter.comments(
    comment_id  SERIAL PRIMARY KEY ,
    post_id     INTEGER REFERENCES tp_twitter.posts(post_id),
    user_id     INTEGER REFERENCES tp_twitter.users(user_id),
    comment_date        TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    content     VARCHAR (500)
);

CREATE TABLE tp_twitter.likes(
    like_id     SERIAL PRIMARY KEY ,
    user_id     INTEGER REFERENCES tp_twitter.users(user_id),
    post_id     INTEGER REFERENCES tp_twitter.posts(post_id)
);

CREATE TABLE tp_twitter.subscriptions(
    subscription_id SERIAL PRIMARY KEY ,
    user_id         INTEGER REFERENCES tp_twitter.users(user_id),
    subscriber_id   INTEGER REFERENCES tp_twitter.users(user_id),
    is_accepted     BOOLEAN
);

CREATE TABLE tp_twitter.tags(
    tag_id      INTEGER PRIMARY KEY ,
    tag_name    VARCHAR (50) UNIQUE
);

INSERT INTO tp_twitter.tags VALUES
    (1, 'ПОЛИТОТА'),
    (2, 'КОТИКИ'),
    (3, 'СТАТЬИ');

CREATE TABLE tp_twitter.posts_tags(
    post_tags_id    SERIAL PRIMARY KEY ,
    post_id         INTEGER REFERENCES tp_twitter.posts(post_id),
    tag_id          INTEGER REFERENCES tp_twitter.tags(tag_id)
);