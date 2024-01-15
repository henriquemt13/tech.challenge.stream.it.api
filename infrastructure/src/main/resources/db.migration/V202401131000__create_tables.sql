create
sequence user_table_seq;

CREATE TABLE user_table (
    id                      BIGINT             NOT NULL PRIMARY KEY DEFAULT NEXTVAL(
    'user_table_seq'),
    username                VARCHAR(100)       NOT NULL UNIQUE,
    created_at              timestamp          NOT NULL DEFAULT current_timestamp,
);


create
sequence category_seq;

CREATE TABLE category (
    id                      BIGINT             NOT NULL PRIMARY KEY DEFAULT NEXTVAL(
    'category_seq'),
    name                    VARCHAR(30)        NOT NULL UNIQUE,
    created_at              timestamp          NOT NULL DEFAULT current_timestamp,
);

create
sequence video_seq;

CREATE TABLE video (
    id                      BIGINT             NOT NULL PRIMARY KEY DEFAULT NEXTVAL(
    'video_seq'),
    video_name              VARCHAR(50)        NOT NULL UNIQUE,
    video_description       VARCHAR(150)       NOT NULL UNIQUE,
    uploader_user_id        BIGINT             NOT NULL UNIQUE,
    created_at              timestamp          NOT NULL DEFAULT current_timestamp,
);


create
sequence video_categories_seq;

CREATE TABLE video_categories (
    id                      BIGINT             NOT NULL PRIMARY KEY DEFAULT NEXTVAL(
    'video_categories_seq'),
    video_id                BIGINT            NOT NULL,
    category_id             BIGINT             NOT NULL,
    created_at              timestamp          NOT NULL DEFAULT current_timestamp,
);


create
sequence user_categories_seq;

CREATE TABLE user_categories (
    id                      BIGINT             NOT NULL PRIMARY KEY DEFAULT NEXTVAL(
    'user_categories_seq'),
    user_id                 BIGINT             NOT NULL,
    category_id             BIGINT             NOT NULL,
    created_at              timestamp          NOT NULL DEFAULT current_timestamp,
);

create
sequence like_table_seq;

CREATE TABLE like_table (
    id                      BIGINT             NOT NULL PRIMARY KEY DEFAULT NEXTVAL(
    'like_table_seq'),
    video_id                BIGINT             NOT NULL,
    user_id                 BIGINT             NOT NULL,
    like_option             VARCHAR(7),
    created_at              timestamp          NOT NULL DEFAULT current_timestamp,
);

create
sequence viewing_history_seq;

CREATE TABLE viewing_history (
    id                      BIGINT             NOT NULL PRIMARY KEY DEFAULT NEXTVAL(
    'viewing_history_seq'),
    user_id                 BIGINT            NOT NULL,
    video_id                BIGINT             NOT NULL,
    created_at              timestamp          NOT NULL DEFAULT current_timestamp,
);