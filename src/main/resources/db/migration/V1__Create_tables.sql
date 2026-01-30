create schema if not exists news_portal;

create table if not exists news_portal.users
(
    id                 uuid primary key default uuid_generate_v4(),
    name               text not null,
    email              text not null unique,
    password           text not null,
    moderated_by       uuid references news_portal.users,
    creation_time      bigint,
    last_modified_time bigint
);

create table if not exists news_portal.channel
(
    id                 uuid primary key default uuid_generate_v4(),
    authorId           uuid references news_portal.users,
    name               text not null,
    moderated_by       uuid references news_portal.users,
    creation_time      bigint,
    last_modified_time bigint
);

create type news_portal.news_categories as enum ('policy', 'economy', 'sport');

create table if not exists news_portal.news
(
    id                 uuid primary key default gen_random_uuid(),
    authorId           uuid references news_portal.users,
    title              text not null,
    content            text not null,
    category           news_categories,
    channel_id         uuid references news_portal.channel,
    moderated_by       uuid references news_portal.users,
    creation_time      bigint,
    last_modified_time bigint
);

create table if not exists news_portal.comment
(
    user_id            uuid references news_portal.users,
    newsId             uuid references news_portal.news,
    primary key (user_id, newsId),
    text               text not null,
    moderated_by       uuid references news_portal.users,
    creation_time      bigint,
    last_modified_time bigint
);

create type news_portal.reaction_types as enum ('like', 'dislike', 'happy', 'sad');

create table if not exists news_portal.reaction
(
    newsId             uuid references news_portal.news,
    user_id            uuid references news_portal.users,
    primary key (newsId, user_id),
    type               reaction_types,
    moderated_by       uuid references news_portal.users,
    creation_time      bigint,
    last_modified_time bigint
);

create table if not exists news_portal.moderator
(
    user_id            uuid references news_portal.users,
    channel_id         uuid references news_portal.channel,
    primary key (user_id, channel_id),
    moderated_by       uuid references news_portal.users,
    creation_time      bigint,
    last_modified_time bigint
);

create function news_portal.set_creation_time() returns trigger as
$set_creation_time$
begin
    new.creation_time := extract(epoch from now()) * 1000;
    new.last_modified_time := new.creation_time;
    return new;
end
$set_creation_time$ language plpgsql;



create function news_portal.update_last_modified_time() returns trigger as
$update_last_modified_time$
begin
    new.last_modified_time := extract(epoch from now()) * 1000;
    return new;
end;
$update_last_modified_time$ language plpgsql;




create trigger set_users_creation_time
    before insert
    on news_portal.users
    for each row
execute function news_portal.set_creation_time();

create trigger update_users_last_modified_time
    before update
    on news_portal.users
    for each row
execute function news_portal.update_last_modified_time();



create trigger set_channel_creation_time
    before insert
    on news_portal.channel
    for each row
execute function news_portal.set_creation_time();

create trigger update_channel_last_modified_time
    before update
    on news_portal.channel
    for each row
execute function news_portal.update_last_modified_time();



create trigger set_news_creation_time
    before insert
    on news_portal.news
    for each row
execute function news_portal.set_creation_time();

create trigger update_news_last_modified_time
    before update
    on news_portal.news
    for each row
execute function news_portal.update_last_modified_time();



create trigger set_comment_creation_time
    before insert
    on news_portal.comment
    for each row
execute function news_portal.set_creation_time();

create trigger update_comment_last_modified_time
    before update
    on news_portal.comment
    for each row
execute function news_portal.update_last_modified_time();



create trigger set_reaction_creation_time
    before insert
    on news_portal.reaction
    for each row
execute function news_portal.set_creation_time();

create trigger update_reaction_last_modified_time
    before update
    on news_portal.reaction
    for each row
execute function news_portal.update_last_modified_time();



create trigger set_moderator_creation_time
    before insert
    on news_portal.moderator
    for each row
execute function news_portal.set_creation_time();

create trigger update_moderator_last_modified_time
    before update
    on news_portal.moderator
    for each row
execute function news_portal.update_last_modified_time();