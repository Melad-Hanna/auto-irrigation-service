-- liquibase formatted sql
-- changeset Melad:create_schema

CREATE TABLE IF NOT EXISTS plot
(
    id                bigint unsigned        NOT NULL AUTO_INCREMENT,
    label             character varying(100) NOT NULL,
    area              decimal(8, 2)          NOT NULL,

    created_date      timestamp              NOT NULL,
    modified_date     timestamp              NOT NULL,
    created_by        character varying(100) NOT NULL,
    modified_by       character varying(100) NOT NULL,
    marked_as_deleted boolean                NOT NULL DEFAULT false,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS crop
(
    id                bigint unsigned        NOT NULL AUTO_INCREMENT,
    name              character varying(25)  NOT NULL UNIQUE,

    created_date      timestamp              NOT NULL,
    modified_date     timestamp              NOT NULL,
    created_by        character varying(100) NOT NULL,
    modified_by       character varying(100) NOT NULL,
    marked_as_deleted boolean                NOT NULL DEFAULT false,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS time_slot
(
    id                bigint unsigned        NOT NULL AUTO_INCREMENT,
    time              time                   NOT NULL UNIQUE,
    is_active         boolean                NOT NULL DEFAULT true,

    created_date      timestamp              NOT NULL,
    modified_date     timestamp              NOT NULL,
    created_by        character varying(100) NOT NULL,
    modified_by       character varying(100) NOT NULL,
    marked_as_deleted boolean                NOT NULL DEFAULT false,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS plot_crop
(
    id                bigint unsigned        NOT NULL AUTO_INCREMENT,
    plot_id           bigint unsigned        NOT NULL,
    crop_id           bigint unsigned        NOT NULL,

    created_date      timestamp              NOT NULL,
    modified_date     timestamp              NOT NULL,
    created_by        character varying(100) NOT NULL,
    modified_by       character varying(100) NOT NULL,
    marked_as_deleted boolean                NOT NULL DEFAULT false,
    PRIMARY KEY (id),
    CONSTRAINT plot_crop_plot_id_fk FOREIGN KEY (plot_id) REFERENCES plot (id),
    CONSTRAINT plot_crop_plot_id_fk FOREIGN KEY (crop_id) REFERENCES crop (id)
);

CREATE TABLE IF NOT EXISTS plot_config
(
    id                 bigint unsigned        NOT NULL AUTO_INCREMENT,
    plot_crop_id       bigint unsigned        NOT NULL,
    time_slot_id       bigint unsigned        NOT NULL,
    water_liter_amount integer                NOT NULL,

    created_date       timestamp              NOT NULL,
    modified_date      timestamp              NOT NULL,
    created_by         character varying(100) NOT NULL,
    modified_by        character varying(100) NOT NULL,
    marked_as_deleted  boolean                NOT NULL DEFAULT false,
    PRIMARY KEY (id),
    CONSTRAINT plot_config_plot_crop_id_fk FOREIGN KEY (plot_crop_id) REFERENCES plot_crop (id),
    CONSTRAINT plot_config_time_slot_id_fk FOREIGN KEY (time_slot_id) REFERENCES time_slot (id)
);

CREATE TABLE IF NOT EXISTS plot_irrigation
(
    id                bigint unsigned        NOT NULL AUTO_INCREMENT,
    plot_config_id    bigint unsigned        NOT NULL,
    date              date                   NOT NULL,
    status            character varying(50),

    created_date      timestamp              NOT NULL,
    modified_date     timestamp              NOT NULL,
    created_by        character varying(100) NOT NULL,
    modified_by       character varying(100) NOT NULL,
    marked_as_deleted boolean                NOT NULL DEFAULT false,
    PRIMARY KEY (id),
    CONSTRAINT plot_irrigation_plot_config_id_fk FOREIGN KEY (plot_config_id) REFERENCES plot_config (id)
);
