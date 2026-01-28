CREATE SCHEMA news_portal;
SET SEARCH_PATH TO news_portal;

CREATE TABLE users
(
    id       UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name     TEXT NOT NULL,
    email    TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL
);

CREATE TABLE channel
(
    id                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    author_id          UUID REFERENCES users,
    name               TEXT NOT NULL,
    moderated_by       UUID REFERENCES users,
    creation_time      BIGINT           DEFAULT EXTRACT(EPOCH FROM NOW()),
    last_modified_time BIGINT           DEFAULT EXTRACT(EPOCH FROM NOW())
);

CREATE TYPE news_categories AS ENUM ('policy', 'economy', 'sport');

CREATE TABLE news
(
    id                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    author_id          UUID REFERENCES users,
    title              TEXT NOT NULL,
    content            TEXT NOT NULL,
    category           news_categories,
    channel_id         UUID REFERENCES channel,
    moderated_by       UUID REFERENCES users,
    creation_time      BIGINT           DEFAULT EXTRACT(EPOCH FROM NOW()),
    last_modified_time BIGINT           DEFAULT EXTRACT(EPOCH FROM NOW())
);

CREATE TABLE comment
(
    user_id            UUID REFERENCES users,
    news_id            UUID REFERENCES news,
    PRIMARY KEY (user_id, news_id),
    text               TEXT NOT NULL,
    moderated_by       UUID REFERENCES users,
    creation_time      BIGINT DEFAULT EXTRACT(EPOCH FROM NOW()),
    last_modified_time BIGINT DEFAULT EXTRACT(EPOCH FROM NOW())
);

CREATE TABLE reaction
(
    news_id       UUID REFERENCES news,
    user_id       UUID REFERENCES users,
    PRIMARY KEY (news_id, user_id),
    type          TEXT CHECK (type IN ('like', 'dislike', 'happy', 'sad')),
    creation_time BIGINT DEFAULT EXTRACT(EPOCH FROM NOW())
);

CREATE TABLE moderator
(
    user_id    UUID REFERENCES users,
    channel_id UUID REFERENCES channel,
    PRIMARY KEY (user_id, channel_id)
);


CREATE FUNCTION news_edited() RETURNS trigger AS
$news_edited$
BEGIN
    NEW.last_modified_time := EXTRACT(EPOCH FROM NOW());
END;
$news_edited$ LANGUAGE plpgsql;

CREATE TRIGGER news_edited
    AFTER UPDATE
    ON news
    FOR EACH ROW
EXECUTE FUNCTION news_edited();


CREATE FUNCTION comment_edited() RETURNS trigger AS
$comment_edited$
BEGIN
    NEW.last_modified_time := EXTRACT(EPOCH FROM NOW());
END;
$comment_edited$ LANGUAGE plpgsql;

CREATE TRIGGER comment_edited
    AFTER UPDATE
    ON news
    FOR EACH ROW
EXECUTE FUNCTION comment_edited();


CREATE FUNCTION channel_edited() RETURNS trigger AS
$channel_edited$
BEGIN
    NEW.last_modified_time := EXTRACT(EPOCH FROM NOW());
END;
$channel_edited$ LANGUAGE plpgsql;

CREATE TRIGGER channel_edited
    AFTER UPDATE
    ON news
    FOR EACH ROW
EXECUTE FUNCTION channel_edited();